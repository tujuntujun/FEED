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

    @GetMapping(value = "/allTime")
    @CrossOrigin
    @ApiOperation(value = "展示风扇1总运行次数")
    public ApiRes allTime(){
        return ApiResService.convertList(motorService.allTime());
    }

    @GetMapping(value = "/dayTime")
    @CrossOrigin
    @ApiOperation(value = "展示风扇1每日运行时间")
    public ApiRes dayTime(){
        return ApiResService.convertList(motorService.dayTime());
    }

    @GetMapping(value = "/startTime")
    @CrossOrigin
    @ApiOperation(value = "展示风扇1开始时间")
    public ApiRes startTime(){
        return ApiResService.convertBean(motorService.startTime());
    }

    @GetMapping(value = "/endTime")
    @CrossOrigin
    @ApiOperation(value = "展示风扇1结束时间")
    public ApiRes endTime(){
        return ApiResService.convertBean(motorService.endTime());
    }

    @GetMapping(value = "/TallTime")
    @CrossOrigin
    @ApiOperation(value = "展示风扇2总运行次数")
    public ApiRes TallTime(){
        return ApiResService.convertList(motorService.TallTime());
    }

    @GetMapping(value = "/TdayTime")
    @CrossOrigin
    @ApiOperation(value = "展示风扇2每日运行时间")
    public ApiRes TdayTime(){
        return ApiResService.convertList(motorService.TdayTime());
    }

    @GetMapping(value = "/TstartTime")
    @CrossOrigin
    @ApiOperation(value = "展示风扇2开始时间")
    public ApiRes TstartTime(){
        return ApiResService.convertBean(motorService.TstartTime());
    }

    @GetMapping(value = "/TendTime")
    @CrossOrigin
    @ApiOperation(value = "展示风扇2结束时间")
    public ApiRes TendTime(){
        return ApiResService.convertBean(motorService.TendTime());
    }

    @GetMapping(value = "/DallTime")
    @CrossOrigin
    @ApiOperation(value = "展示刮粪板总运行次数")
    public ApiRes DallTime(){
        return ApiResService.convertList(motorService.DallTime());
    }

    @GetMapping(value = "/DdayTime")
    @CrossOrigin
    @ApiOperation(value = "展示刮粪板每日运行时间")
    public ApiRes DdayTime(){
        return ApiResService.convertList(motorService.DdayTime());
    }

    @GetMapping(value = "/DstartTime")
    @CrossOrigin
    @ApiOperation(value = "展示刮粪板开始时间")
    public ApiRes DstartTime(){
        return ApiResService.convertBean(motorService.DstartTime());
    }

    @GetMapping(value = "/DendTime")
    @CrossOrigin
    @ApiOperation(value = "展示刮粪板结束时间")
    public ApiRes DendTime(){
        return ApiResService.convertBean(motorService.DendTime());
    }

    @GetMapping(value = "/CallTime")
    @CrossOrigin
    @ApiOperation(value = "展示窗帘总运行次数")
    public ApiRes CallTime(){
        return ApiResService.convertList(motorService.CallTime());
    }

    @GetMapping(value = "/CdayTime")
    @CrossOrigin
    @ApiOperation(value = "展示窗帘每日运行时间")
    public ApiRes CdayTime(){
        return ApiResService.convertList(motorService.CdayTime());
    }

    @GetMapping(value = "/CstartTime")
    @CrossOrigin
    @ApiOperation(value = "展示窗帘开始时间")
    public ApiRes CstartTime(){
        return ApiResService.convertBean(motorService.CstartTime());
    }

    @GetMapping(value = "/CendTime")
    @CrossOrigin
    @ApiOperation(value = "展示窗帘结束时间")
    public ApiRes CendTime(){
        return ApiResService.convertBean(motorService.CendTime());
    }

    @GetMapping(value = "/button")
    @CrossOrigin
    @ApiOperation(value = "按钮")
    public void button(){
        System.out.print("按钮已触发");
    }
}
