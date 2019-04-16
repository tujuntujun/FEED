package com.ruoyi.web.controller.api;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.service.domain.ApiRes;
import com.ruoyi.service.service.impl.MotorServiceImpl;
import com.ruoyi.service.utils.ApiResService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张超 teavamc
 * @Description:监控数据的REST API接口
 * @ClassName MotorApi
 * @date 2019/4/15 16:12
 **/
@RestController
@RequestMapping("/api/motor")
@CrossOrigin
@Api(value = "生猪运行数据API接口")
public class MotorApi extends BaseController {

    @Autowired
    private MotorServiceImpl motorService;


    @GetMapping(value = "/topTenByTime")
    @CrossOrigin
    @ApiOperation(value = "展示时间最近的十条运行记录")
    public ApiRes topTenByTime(){
        return ApiResService.convertList(motorService.topTenByTime());
    }



}
