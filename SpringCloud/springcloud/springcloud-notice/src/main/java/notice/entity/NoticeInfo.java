package notice.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 通知记录表
 * </p>
 *
 * @author Lyh
 * @since 2021-05-31
 */
@TableName("notice_info")
public class NoticeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 通知id
     */
    private Integer noticeId;

    /**
     * 应用ID
     */
    private Integer appId;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 功能项CODE
     */
    private Integer functionId;

    /**
     * 功能项名称
     */
    private String functionName;

    /**
     * 通知类型
     */
    private Integer noticeType;

    /**
     * 通知内容
     */
    private String noticeCon;

    /**
     * 通知发送状态
     */
    private Integer sendType;

    /**
     * 发送时间
     */
    private LocalDateTime sendDatetime;

    /**
     * 创建时间
     */
    private LocalDateTime createDatetime;

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }
    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }
    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }
    public Integer getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }
    public String getNoticeCon() {
        return noticeCon;
    }

    public void setNoticeCon(String noticeCon) {
        this.noticeCon = noticeCon;
    }
    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }
    public LocalDateTime getSendDatetime() {
        return sendDatetime;
    }

    public void setSendDatetime(LocalDateTime sendDatetime) {
        this.sendDatetime = sendDatetime;
    }
    public LocalDateTime getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(LocalDateTime createDatetime) {
        this.createDatetime = createDatetime;
    }

    @Override
    public String toString() {
        return "NoticeInfo{" +
            "noticeId=" + noticeId +
            ", appId=" + appId +
            ", appName=" + appName +
            ", functionId=" + functionId +
            ", functionName=" + functionName +
            ", noticeType=" + noticeType +
            ", noticeCon=" + noticeCon +
            ", sendType=" + sendType +
            ", sendDatetime=" + sendDatetime +
            ", createDatetime=" + createDatetime +
        "}";
    }
}
