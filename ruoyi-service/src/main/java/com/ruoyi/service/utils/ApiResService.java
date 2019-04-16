package com.ruoyi.service.utils;

import com.ruoyi.service.domain.ApiRes;

import java.util.List;

/**
 * @author 张超 teavamc
 * @Description: API的实现类
 * @ClassName ApiResService
 * @date 2019/4/15 17:15
 **/
public class ApiResService {

    /**
        * 将其他业务中的List<HashMap(JavaBean)>进行统一封装成API-JSON数据
        * @author 张超 teavamc
        * @date 2019/4/15
        * @param [list]
        * @return com.ruoyi.service.domain.ApiRes
        */
    public static ApiRes convertList(List list){
        ApiRes res = new ApiRes();
        if(list!=null&&!list.isEmpty()){
            res = res.success("已查询到"+list.size()+"条数据");
            res.put("data",list);
            res.put("data_size",list.size());
        }else {
            res = res.error("数据获取失败");
        }
        return res;
    }

    /**
        * 将其他业务中的HashMap(JavaBean)进行统一封装成API-JSON数据
        * @author 张超 teavamc
        * @date 2019/4/15
        * @param [obj]
        * @return com.ruoyi.service.domain.ApiRes
        */
    public static ApiRes convertBean(Object obj){
        ApiRes res = new ApiRes();
        if(obj!=null){
            res = res.success("已查询到1条数据");
            res.put("data",obj);
        }else {
            res = res.error("数据获取失败");
        }
        return res;
    }
}
