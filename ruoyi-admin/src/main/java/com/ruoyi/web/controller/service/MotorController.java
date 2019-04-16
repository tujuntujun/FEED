package com.ruoyi.web.controller.service;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.service.domain.Motor;
import com.ruoyi.service.service.IMotorService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 远程控制 信息操作处理
 * 
 * @author
 * @date 2019-04-09
 */
@Controller
@RequestMapping("/service/motor")
public class MotorController extends BaseController
{
    private String prefix = "service/motor";
	
	@Autowired
	private IMotorService motorService;
	
	@RequiresPermissions("service:motor:view")
	@GetMapping()
	public String motor()
	{
	    return prefix + "/motor";
	}
	
	/**
	 * 查询远程控制列表
	 */
	@RequiresPermissions("service:motor:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Motor motor)
	{
		startPage();
        List<Motor> list = motorService.selectMotorList(motor);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出远程控制列表
	 */
	@RequiresPermissions("service:motor:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Motor motor)
    {
    	List<Motor> list = motorService.selectMotorList(motor);
        ExcelUtil<Motor> util = new ExcelUtil<Motor>(Motor.class);
        return util.exportExcel(list, "motor");
    }
	
	/**
	 * 新增远程控制
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存远程控制
	 */
	@RequiresPermissions("service:motor:add")
	@Log(title = "远程控制", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Motor motor)
	{		
		return toAjax(motorService.insertMotor(motor));
	}

	/**
	 * 修改远程控制
	 */
	@GetMapping("/edit/{oid}")
	public String edit(@PathVariable("oid") Integer oid, ModelMap mmap)
	{
		Motor motor = motorService.selectMotorById(oid);
		mmap.put("motor", motor);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存远程控制
	 */
	@RequiresPermissions("service:motor:edit")
	@Log(title = "远程控制", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Motor motor)
	{		
		return toAjax(motorService.updateMotor(motor));
	}
	
	/**
	 * 删除远程控制
	 */
	@RequiresPermissions("service:motor:remove")
	@Log(title = "远程控制", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(motorService.deleteMotorByIds(ids));
	}
	
}
