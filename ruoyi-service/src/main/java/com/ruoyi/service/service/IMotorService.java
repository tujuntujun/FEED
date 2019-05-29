package com.ruoyi.service.service;

import com.ruoyi.service.domain.Motor;

import java.util.HashMap;
import java.util.List;

/**
 * 远程控制 服务层
 * 
 * @author å± é¡
 * @date 2019-04-09
 */
public interface IMotorService 
{
	/**
     * 查询远程控制信息
     * 
     * @param oid 远程控制ID
     * @return 远程控制信息
     */
	public Motor selectMotorById(Integer oid);
	
	/**
     * 查询远程控制列表
     * 
     * @param motor 远程控制信息
     * @return 远程控制集合
     */
	public List<Motor> selectMotorList(Motor motor);
	
	/**
     * 新增远程控制
     * 
     * @param motor 远程控制信息
     * @return 结果
     */
	public int insertMotor(Motor motor);
	
	/**
     * 修改远程控制
     * 
     * @param motor 远程控制信息
     * @return 结果
     */
	public int updateMotor(Motor motor);
		
	/**
     * 删除远程控制信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMotorByIds(String ids);

	/**
	 * 展示时间最近的十条运行记录
	 * @author 张超 teavamc
	 * @date 2019/4/15
	 * @param []
	 * @return java.util.List<java.util.HashMap>
	 */
	public List<HashMap> topTenByTime();

	public List<HashMap> allTime();

	public List<HashMap> dayTime();

	public String startTime();

    public String endTime();

	public List<HashMap> DdayTime();

	public String DstartTime();

	public String DendTime();

	public List<HashMap> DallTime();

	public List<HashMap> CdayTime();

	public String CstartTime();

	public String CendTime();

	public List<HashMap> CallTime();

	public List<HashMap> TallTime();

	public List<HashMap> TdayTime();

	public String TstartTime();

	public String TendTime();
	
}
