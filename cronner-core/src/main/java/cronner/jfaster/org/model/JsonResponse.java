package cronner.jfaster.org.model;

import java.io.Serializable;

/**
 * json 统一返回
 *
 * @author fangyanpeng
 */
public class JsonResponse implements Serializable {

    private static final long serialVersionUID = -4761871227325502579L;

    public static final Integer OK = 200;

    public static final Integer REDIRECT = 302;

    public static final Integer ERR = 500;

    public static final JsonResponse NEED_LOGIN = JsonResponse.notOk(403, "用户未登录");

    public static final JsonResponse AUTH_FAIL = JsonResponse.notOk(401, "认证失败");

    public static final JsonResponse PARAM_MISSING = JsonResponse.notOk(400, "参数缺失");

    public static final JsonResponse SERVER_ERR = JsonResponse.notOk(ERR, "服务器异常");

    /**
     * 响应码
     */
    private Integer status;

    /**
     * 错误信息
     */
    private Object err;

    /**
     * 响应数据
     */
    private Object data;

    public static JsonResponse ok(){
        JsonResponse r = new JsonResponse();
        r.status = OK;
        return r;
    }

    public static JsonResponse ok(Object data){
        JsonResponse r = new JsonResponse();
        r.status = OK;
        r.data = data;
        return r;
    }

    public static JsonResponse notOk(Object err){
        JsonResponse r = new JsonResponse();
        r.status = ERR;
        r.err = err;
        return r;
    }

    public static JsonResponse notOk(Integer status, Object err){
        JsonResponse r = new JsonResponse();
        r.status = status;
        r.err = err;
        return r;
    }

    public static JsonResponse redirect(String url){
        JsonResponse r = new JsonResponse();
        r.status = REDIRECT;
        r.data = url;
        return r;
    }

    public Integer getStatus() {
        return status;
    }

    public Object getErr() {
        return err;
    }

    public void setErr(Object err) {
        this.err = err;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean isSuccess(){
        return status.intValue() == OK.intValue();
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "status=" + status +
                ", err=" + err +
                ", data=" + data +
                '}';
    }
}