package cn.zl.pojo;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/3/22 10:13
 * @des 返回前端的数据封装类
 */
public class ResultBean {
    /**
     * 返回处理结果码
     */
    private String result;
    /**
     * 返回处理信息
     */
    private String message;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
