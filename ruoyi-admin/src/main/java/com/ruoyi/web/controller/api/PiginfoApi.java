package com.ruoyi.web.controller.api;

import com.ruoyi.service.domain.ApiRes;
import com.ruoyi.service.service.IPigstyinfoService;
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
 * @Description:TODO
 * @ClassName PiginfoApi
 * @date 2019/4/15 16:12
 **/
@RestController
@RequestMapping("/api/piginfo")
@CrossOrigin
@Api(value = "生猪监控数据API接口")
public class PiginfoApi {

    @Autowired
    private IPigstyinfoService pigstyinfoService;

    @GetMapping(value = "/rc20")
    @CrossOrigin
    @ApiOperation(value = "查询传感器中最近二十条数 据")
    public ApiRes recentTwentyByTime(){
        return ApiResService.convertList(pigstyinfoService.recentTwentyByTime());
    }

    @GetMapping(value = "/rc10")
    @CrossOrigin
    @ApiOperation(value = "查询传感器中最近十条数据")
    public ApiRes recentenByTime(){
        return ApiResService.convertList(pigstyinfoService.recentenByTime());
    }

    @GetMapping(value = "/tem")
    @CrossOrigin
    @ApiOperation(value = "查询传感器中温度数据")
    public ApiRes select(){
        return ApiResService.convertList(pigstyinfoService.selectTem());
    }

    @GetMapping(value = "/humi")
    @CrossOrigin
    @ApiOperation(value = "查询传感器中湿度数据")
    public ApiRes selecthumi(){
        return ApiResService.convertList(pigstyinfoService.selectHumi());
    }

    @GetMapping(value = "/light")
    @CrossOrigin
    @ApiOperation(value = "查询传感器中光照数据")
    public ApiRes selectLight(){
        return ApiResService.convertList(pigstyinfoService.selectLight());
    }

    @GetMapping(value = "/amm")
    @CrossOrigin
    @ApiOperation(value = "查询传感器中氨气数据")
    public ApiRes selectAmm(){
        return ApiResService.convertList(pigstyinfoService.selectAmm());
    }


/*    @GetMapping(value = "/selectCount")
    @CrossOrigin
    @ApiOperation(value = "查询所有数据")
    public ApiRes countAll(){
        return ApiResService.convertBean(pigstyinfoService.countAll());
    }*/

    @GetMapping(value = "/prentem")
    @CrossOrigin
    @ApiOperation(value = "查询当前温度数据")
    public ApiRes prentem(){
        return ApiResService.convertBean(pigstyinfoService.prentem());
    }

    @GetMapping(value = "/prenrh")
    @CrossOrigin
    @ApiOperation(value = "查询当前湿度数据")
    public ApiRes prenrh(){
        return ApiResService.convertBean(pigstyinfoService.prenrh());
    }

    @GetMapping(value = "/prenlight")
    @CrossOrigin
    @ApiOperation(value = "查询当前光照数据")
    public ApiRes prenlight(){
        return ApiResService.convertBean(pigstyinfoService.prenlight());
    }

    @GetMapping(value = "/prenag")
    @CrossOrigin
    @ApiOperation(value = "查询当前氨气数据")
    public ApiRes prenag(){
        return ApiResService.convertBean(pigstyinfoService.prenag());
    }


}
