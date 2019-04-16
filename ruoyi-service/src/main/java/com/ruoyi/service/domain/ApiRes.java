package com.ruoyi.service.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @author 张超 teavamc
 * @Description:创建API的JSON
 * @ClassName ApiRes
 * @date 2019/4/15 16:43
 **/
public class ApiRes extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    /**
     * code:0 成功，code:1 失败，code:500 失败
     */
    private int code;
    /**
     * 状态信息
     */
    private String msg;
    /**
     * 时间戳
     */
    private String time;

    /*
        * 该类进行示例的时候自动添加当前的time时间戳
        * @author 张超 teavamc
        * @date 2019/4/15
        * @param []
        * @return
        */
    public ApiRes(){
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间，也可使用当前时间戳
        String date = df.format(new Date());
        this.put("time",date);
    }

    /**
        * 覆盖put方法
        * @author 张超 teavamc
        * @date 2019/4/15
        * @param [key, value]
        * @return com.ruoyi.service.domain.ApiRes
        */
    @Override
    public ApiRes put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }

    /**
        * 返回错误信息
        * @author 张超 teavamc
        * @date 2019/4/15
        * @param [code, msg]
        * @return com.ruoyi.service.domain.ApiRes
        */
    public static ApiRes error(String msg){
        ApiRes res = new ApiRes();
        res.put("code",1);
        res.put("msg",msg);
        return res;
    }

    /**
        * 返回成功信息
        * @author 张超 teavamc
        * @date 2019/4/15
        * @param [msg]
        * @return com.ruoyi.service.domain.ApiRes
        */
    public static ApiRes success(String msg){
        ApiRes res = new ApiRes();
        res.put("code",0);
        res.put("msg",msg);
        return res;
    }

}
