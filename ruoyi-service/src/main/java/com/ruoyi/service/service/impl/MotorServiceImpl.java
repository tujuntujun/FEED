package com.ruoyi.service.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.service.mapper.MotorMapper;
import com.ruoyi.service.domain.Motor;
import com.ruoyi.service.service.IMotorService;
import com.ruoyi.common.core.text.Convert;

/**
 * 远程控制 服务层实现
 * 
 * @author å± é¡
 * @date 2019-04-09
 */
@Service
public class MotorServiceImpl implements IMotorService 
{
	@Autowired
	private MotorMapper motorMapper;

	/**
     * 查询远程控制信息
     * 
     * @param oid 远程控制ID
     * @return 远程控制信息
     */
    @Override
	public Motor selectMotorById(Integer oid)
	{
	    return motorMapper.selectMotorById(oid);
	}
	
	/**
     * 查询远程控制列表
     * 
     * @param motor 远程控制信息
     * @return 远程控制集合
     */
	@Override
	public List<Motor> selectMotorList(Motor motor)
	{
	    return motorMapper.selectMotorList(motor);
	}
	
    /**
     * 新增远程控制
     * 
     * @param motor 远程控制信息
     * @return 结果
     */
	@Override
	public int insertMotor(Motor motor)
	{
	    return motorMapper.insertMotor(motor);
	}
	
	/**
     * 修改远程控制
     * 
     * @param motor 远程控制信息
     * @return 结果
     */
	@Override
	public int updateMotor(Motor motor)
	{
	    return motorMapper.updateMotor(motor);
	}

	/**
     * 删除远程控制对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMotorByIds(String ids)
	{
		return motorMapper.deleteMotorByIds(Convert.toStrArray(ids));
	}

	/**
	 * 展示时间最近的十条运行记录
	 * @author 张超 teavamc
	 * @date 2019/4/15
	 * @param []
	 * @return java.util.List<java.util.HashMap>
	 */
	@Override
	public List<HashMap> topTenByTime(){
		return motorMapper.topTenByTime();
	}

	@Override
	public List<HashMap> allTime(){
		return motorMapper.allTime();
	}

	@Override
	public List<HashMap> dayTime(){
		return motorMapper.dayTime();
	}

	@Override
	public String startTime(){
		return motorMapper.startTime();
	}

    @Override
    public String endTime(){
        return motorMapper.endTime();
    }

	@Override
	public List<HashMap> DallTime(){
		return motorMapper.DallTime();
	}

	@Override
	public List<HashMap> DdayTime(){
		return motorMapper.DdayTime();
	}

	@Override
	public String DstartTime(){
		return motorMapper.DstartTime();
	}

	@Override
	public String DendTime(){
		return motorMapper.DendTime();
	}

	@Override
	public List<HashMap> CallTime(){
		return motorMapper.CallTime();
	}

	@Override
	public List<HashMap> CdayTime(){
		return motorMapper.CdayTime();
	}

	@Override
	public String CstartTime(){
		return motorMapper.CstartTime();
	}

	@Override
	public String CendTime(){
		return motorMapper.CendTime();
	}

	@Override
	public List<HashMap> TallTime(){
		return motorMapper.TallTime();
	}

	@Override
	public List<HashMap> TdayTime(){
		return motorMapper.TdayTime();
	}

	@Override
	public String TstartTime(){
		return motorMapper.TstartTime();
	}

	@Override
	public String TendTime(){
		return motorMapper.TendTime();
	}


}
