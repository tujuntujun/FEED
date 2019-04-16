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
import com.ruoyi.service.domain.Pigstyinfo;
import com.ruoyi.service.service.IPigstyinfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 传感器数据 信息操作处理
 * 
 * @author å± é¡
 * @date 2019-04-09
 */
@Controller
@RequestMapping("/service/pigstyinfo")
public class PigstyinfoController extends BaseController
{
    private String prefix = "service/pigstyinfo";
	
	@Autowired
	private IPigstyinfoService pigstyinfoService;
	
	@RequiresPermissions("service:pigstyinfo:view")
	@GetMapping()
	public String pigstyinfo()
	{
	    return prefix + "/pigstyinfo";
	}
	
	/**
	 * 查询传感器数据列表
	 */
	@RequiresPermissions("service:pigstyinfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Pigstyinfo pigstyinfo)
	{
		startPage();
        List<Pigstyinfo> list = pigstyinfoService.selectPigstyinfoList(pigstyinfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出传感器数据列表
	 */
	@RequiresPermissions("service:pigstyinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Pigstyinfo pigstyinfo)
    {
    	List<Pigstyinfo> list = pigstyinfoService.selectPigstyinfoList(pigstyinfo);
        ExcelUtil<Pigstyinfo> util = new ExcelUtil<Pigstyinfo>(Pigstyinfo.class);
        return util.exportExcel(list, "pigstyinfo");
    }
	
	/**
	 * 新增传感器数据
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存传感器数据
	 */
	@RequiresPermissions("service:pigstyinfo:add")
	@Log(title = "传感器数据", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Pigstyinfo pigstyinfo)
	{		
		return toAjax(pigstyinfoService.insertPigstyinfo(pigstyinfo));
	}

	/**
	 * 修改传感器数据
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Pigstyinfo pigstyinfo = pigstyinfoService.selectPigstyinfoById(id);
		mmap.put("pigstyinfo", pigstyinfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存传感器数据
	 */
	@RequiresPermissions("service:pigstyinfo:edit")
	@Log(title = "传感器数据", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Pigstyinfo pigstyinfo)
	{		
		return toAjax(pigstyinfoService.updatePigstyinfo(pigstyinfo));
	}
	
	/**
	 * 删除传感器数据
	 */
	@RequiresPermissions("service:pigstyinfo:remove")
	@Log(title = "传感器数据", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(pigstyinfoService.deletePigstyinfoByIds(ids));
	}
	
}
