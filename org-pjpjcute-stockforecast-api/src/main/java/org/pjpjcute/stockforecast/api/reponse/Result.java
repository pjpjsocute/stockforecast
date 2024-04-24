package org.pjpjcute.stockforecast.api.reponse;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */

import java.io.Serializable;
import java.util.Objects;

public class Result<T> implements Serializable {
    private static final long    serialVersionUID  = 6808480779584216205L;
    private static final Integer SUCCESS_RESP_CODE = 0;
    private static final Integer ERROR_RESP_CODE   = -1;
    public static final String   TRACE_ID          = "traceId";
    public static final String   SUCCESS           = "success";
    public static final String   SUCCESS_CODE      = "000000";
    private Integer              respCode;
    private String               errorCode;
    private String               respMsg;
    private String               traceId;
    private T                    data;

    public Result() {
        this.respCode = SUCCESS_RESP_CODE;
        this.errorCode = null;
        this.respMsg = null;
        this.data = null;
        this.traceId = null;
    }

    private Result(Integer respCode, String errorCode, String respMsg, T data) {
        this.respCode = respCode;
        this.errorCode = errorCode;
        this.respMsg = respMsg;
        this.data = data;
        this.traceId = null;
    }

    public Integer getRespCode() {
        return this.respCode;
    }

    public void setRespCode(Integer respCode) {
        this.respCode = respCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getRespMsg() {
        return this.respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public static <T> Result<T> error(String errorCode, String respMsg, T data) {
        return new Result(ERROR_RESP_CODE, errorCode, respMsg, data);
    }

    public static Result<?> error(String errorCode, String respMsg) {
        return new Result(ERROR_RESP_CODE, errorCode, respMsg, (Object)null);
    }

    public static <T> Result<T> success(T result) {
        return new Result(SUCCESS_RESP_CODE, "000000", "success", result);
    }

    public boolean successful() {
        return Objects.equals(SUCCESS_RESP_CODE, this.respCode) && Objects.nonNull(this.data);
    }

    public static <T> boolean successful(Result<T> result) {
        return Objects.nonNull(result) && Objects.equals(SUCCESS_RESP_CODE, result.getRespCode());
    }

    public static <T> boolean successfulData(Result<T> result) {
        return successful(result) && Objects.nonNull(result.getData());
    }
}