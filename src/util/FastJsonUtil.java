package util;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class FastJsonUtil {
    private int code = 1;
    private String message;
    private Object data;

    private Map<String, Object> page = new HashMap<>();

    private FastJsonUtil() {}

    public String toJSON () {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static FastJsonUtil ok(Object data) {
        FastJsonUtil vo = new FastJsonUtil();
        vo.setData(data);
        return vo;
    }

    public static FastJsonUtil err(int code, String message) {
        FastJsonUtil vo = new FastJsonUtil();
        vo.setCode(code);
        vo.setMessage(message);
        return vo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Map<String, Object> getPage() {
        return page;
    }

    public FastJsonUtil setPage(int currentPage, int pageSize, int total) {
        this.page.put("current", currentPage);
        this.page.put("size", pageSize);
        this.page.put("total", total);
        return this;
    }
}
