import qs from 'qs'
import axios from 'axios'
import { Message, Loading } from 'element-ui'

// create an axios instance
// create an axios instance
const service = axios.create({
    baseURL: "http://129.28.184.11:8081/mining-interface", // 
    // baseURL: "http://localhost:2001/", // 
    withCredentials: true, // send cookies when cross-domain requests
    timeout: 30000 // request timeout
})

let loadingInstance = null
// request interceptor
service.interceptors.request.use(
    config => {
        loadingInstance = Loading.service({
            fullscreen: true,
            background: 'rgba(0,0,0,0.5)'
        })

        config.data = qs.stringify(config.data)
        config.headers['Content-Type'] = 'application/x-www-form-urlencoded'
        return config
    },
    error => {
        console.log(error) // for debug
        return (error)
    }
)

// response interceptor
service.interceptors.response.use(
    response => {
        if (loadingInstance) {
            loadingInstance.close()
        }

        if (response.data.returnCode == 0) {
            let data = response.data.resultCon
            return data;
        } else {
            let msg = response.data.returnMsg;
            let s = msg?msg:'异常错误:获取errorMsg异常.';
            Message.error(s)
            throw new Error()
        }
    },
    error => {
        console.log("访问发生异常错误,没有获取到返回信息.");
        if (loadingInstance) {
            loadingInstance.close()
        }
        return Promise.reject(error.response)
    }
)

export default service
