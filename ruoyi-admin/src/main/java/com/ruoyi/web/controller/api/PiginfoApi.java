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
    @ApiOperation(value = "查询传感器中最近二十条数据")
    public ApiRes recentTwentyByTime(){
        return ApiResService.convertList(pigstyinfoService.recentTwentyByTime());
    }

}
