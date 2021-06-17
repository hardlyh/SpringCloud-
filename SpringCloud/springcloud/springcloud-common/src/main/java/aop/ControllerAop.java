package aop;

import log.LogUtil;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import utils.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;


@Component
@Aspect
@Order(2)
public class ControllerAop {

    public ControllerAop() {
        LogUtil.info("ControllerAop");
    }

        // Controller层
        @Pointcut("execution(* *.controller.*.*(..))")
        public void pointCut() {
        }

        // service层
        @Pointcut("execution(* com.hipay.service.*.*(..))")
        public void pointCutService() {
        }

        // dao层
        @Pointcut("execution(* com.hipay.mapper.*.*(..))")
        public void pointCutDao() {
        }

        //	@Around(value = "pointCutService()")
        public Object aroundAdviceService(ProceedingJoinPoint pjp) throws Throwable {
            LogUtil.info("============================= Start =======================");
            LogUtil.info("CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
            LogUtil.info("REQUEST ARGS : " + Arrays.toString(pjp.getArgs()));

            long startTime = System.currentTimeMillis();
            try {
                Object response = pjp.proceed();
                // 3.出参打印
                LogUtil.info("RESPONSE ARGS:" + String.valueOf(response));
                return response;
            } catch (Throwable e) {
                throw e;
            } finally {
                long endTime = System.currentTimeMillis();
                LogUtil.info("SPEND TIME : " + (endTime - startTime) + " ms");
                LogUtil.info("============================= End =======================");
            }
        }

        //	@Around(value = "pointCutDao()")
        public Object aroundAdviceDao(ProceedingJoinPoint pjp) throws Throwable {
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;

            // 防止不是http请求的方法，例如：scheduled
            if (ra == null || sra == null) {
                return pjp.proceed();
            }
            HttpServletRequest request = sra.getRequest();

            LogUtil.info("URL           : " + request.getRequestURL().toString());
            LogUtil.info("HTTP_METHOD   : " + request.getMethod());
            LogUtil.info("IP            : " + request.getRemoteAddr());
            LogUtil.info("CLASS_METHOD  : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
//		LogUtil.info("REQUEST ARGS  : " + Arrays.toString(pjp.getArgs()));
            LogUtil.info("REQUEST ARGS  : " + request.getQueryString());

            long startTime = System.currentTimeMillis();
            try {
                Object response = pjp.proceed();
                // 3.出参打印
                LogUtil.info("RESPONSE{}:" + String.valueOf(response));
                return response;
            } catch (Throwable e) {
                throw e;
            } finally {
                long endTime = System.currentTimeMillis();
                LogUtil.info("SPEND TIME : " + (endTime - startTime) + " ms");
            }
        }

        @Around(value = "pointCut()")
        public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
            LogUtil.info("============================= Start =======================");
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;

            // 防止不是http请求的方法，例如：scheduled
            if (ra == null || sra == null) {
                return pjp.proceed();
            }
            HttpServletRequest request = sra.getRequest();


            LogUtil.info("URL           : " + request.getRequestURL().toString());
            LogUtil.info("HTTP_Method   : " + request.getMethod());
            LogUtil.info("IP            : " + request.getRemoteAddr());
            LogUtil.info("CLASS_Method  : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
            LogUtil.info("REQUEST ARGS  : " + Arrays.toString(pjp.getArgs()));
            LogUtil.info("Request agrs  : " + request.getQueryString());
            JSONObject resultJs = new JSONObject();
            ServletUtil.getResponse().setHeader("Content-Type", "application/json;charset=UTF-8");
            long startTime = System.currentTimeMillis();
            try {
                Object response = pjp.proceed();

                if (response != null) {
                    // 出参判断,如果返回的是数字的话认为是数据为空
                    if (response instanceof Integer) {
                        if ((Integer) response == 0) {
                            resultJs.put("returnCode", 0);
                            resultJs.put("returnMsg", "成功");
                        } else {
                            resultJs.put("returnCode", 109);
                            resultJs.put("returnMsg", "数据为空");
                        }
                    }
                    // 自动添加返回值内容,根据是返回的数据不为null,如果为null的话则认为是失败
                    else if (response instanceof List) {
                        List list = (List) response;
//					if (list.size() == 0) {
//						resultJs.put("returnCode", 109);
//						resultJs.put("returnMsg", HIPayInterType.getInterType()[109]);
//					} else {
                        resultJs.put("returnCode", 0);
                        resultJs.put("returnMsg", "成功");
                        Object json = JSONObject.toJSON(response);
                        resultJs.put("resultCon", json);
//					}
                    }
                    // 直接返回String则为返回失败
                    else if (response instanceof String) {
                        resultJs.put("returnCode", 96);
                        resultJs.put("returnMsg", String.valueOf(response));
                    } else {
                        resultJs.put("returnCode", 0);
                        resultJs.put("returnMsg", "成功");
                        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(response));

                        // 如果手动返回resultcode的话则不进行处理
                        if (jsonObject.containsKey("returnCode")) {
                            resultJs = jsonObject;
                            resultJs.put("returnCode", Integer.parseInt(resultJs.get("returnCode").toString()));
                        }

                        // 将返回的数据转换为json
                        else {
                            Object json = JSONObject.toJSON(response);
                            resultJs.put("resultCon", json);
                        }
                    }
                } else {
                    resultJs.put("returnCode", 97);
                    resultJs.put("returnMsg", "出现异常");
                }

                LogUtil.info("Response args : " + resultJs.toString());
                return resultJs;
            } catch (Throwable e) {
                resultJs.put("returnCode", "2");
                resultJs.put("returnMsg", "发生异常错误");
                handleException(e);
                return resultJs;
            } finally {
                long endTime = System.currentTimeMillis();
                LogUtil.info("SPEND TIME : " + (endTime - startTime) + " ms");
                LogUtil.info("============================= End =======================");
            }
        }

        /**
         * @Description: TODO
         * @param e
         * @return
         * @author 异常处理类
         */
        public String handleException(Throwable e) {
            e.printStackTrace();
            LogUtil.error(e.toString());
            LogUtil.error("异常栈:"+org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(e));
            return "";
        }
}
