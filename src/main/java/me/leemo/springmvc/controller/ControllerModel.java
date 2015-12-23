package me.leemo.springmvc.controller;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Leemo on 15-12-22.
 * 控制器层返回前端json的统一格式
 */
public class ControllerModel {
    public enum StandardCodeMsg {
        // 成功
        SUCCESS("200-000", "成功"),
        // 参数问题
        PARAM_ERROR("001-000", "参数问题"),
        PARAM_LACK("001-001", "参数问题-缺少参数"),
        PARAM_FORMAT("001-002", "参数问题-格式有误"),
        PARAM_RANGE("001-003", "参数问题-参数范围"),
        // 返回数据问题
        RETURN_DATA_ERROR("004-000", "返回数据问题"),
        RETURN_DATA_NULL("004-001", "返回数据问题-查询数据不存在"),
        // 内部问题，请联系管理员
        INNER_BUG("004-001", "内部问题，请联系管理员"),;
        private String code;
        private String msg;
        private StandardCodeMsg(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }


    private boolean flag;
    private String code;
    private String msg;
    private Map<String, Object> data = new HashMap<>();

    public boolean isFlag() {
        return flag;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public ControllerModel(StandardCodeMsg standardCodeMsg, String msg) {
        this.setInfo(standardCodeMsg, msg);
    }

    public ControllerModel() {
        this.setInfo(StandardCodeMsg.SUCCESS, "");
    }

    public void setInfo(StandardCodeMsg standardCodeMsg, String msg){
        this.flag = standardCodeMsg == StandardCodeMsg.SUCCESS;
        this.code = standardCodeMsg.code;
        this.msg = MessageFormat.format("{0}: {1}", standardCodeMsg.msg, msg);
    }
}
