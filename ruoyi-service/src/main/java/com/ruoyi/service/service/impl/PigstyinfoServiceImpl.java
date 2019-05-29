package com.ruoyi.service.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.service.mapper.PigstyinfoMapper;
import com.ruoyi.service.domain.Pigstyinfo;
import com.ruoyi.service.service.IPigstyinfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 传感器数据 服务层实现
 * 
 * @author å± é¡
 * @date 2019-04-09
 */
@Service
public class PigstyinfoServiceImpl implements IPigstyinfoService 
{
	@Autowired
	private PigstyinfoMapper pigstyinfoMapper;

	/**
     * 查询传感器数据信息
     * 
     * @param id 传感器数据ID
     * @return 传感器数据信息
     */
    @Override
	public Pigstyinfo selectPigstyinfoById(Integer id)
	{
	    return pigstyinfoMapper.selectPigstyinfoById(id);
	}
	
	/**
     * 查询传感器数据列表
     * 
     * @param pigstyinfo 传感器数据信息
     * @return 传感器数据集合
     */
	@Override
	public List<Pigstyinfo> selectPigstyinfoList(Pigstyinfo pigstyinfo)
	{
	    return pigstyinfoMapper.selectPigstyinfoList(pigstyinfo);
	}
	
    /**
     * 新增传感器数据
     * 
     * @param pigstyinfo 传感器数据信息
     * @return 结果
     */
	@Override
	public int insertPigstyinfo(Pigstyinfo pigstyinfo)
	{
	    return pigstyinfoMapper.insertPigstyinfo(pigstyinfo);
	}
	
	/**
     * 修改传感器数据
     * 
     * @param pigstyinfo 传感器数据信息
     * @return 结果
     */
	@Override
	public int updatePigstyinfo(Pigstyinfo pigstyinfo)
	{
	    return pigstyinfoMapper.updatePigstyinfo(pigstyinfo);
	}

	/**
     * 删除传感器数据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePigstyinfoByIds(String ids)
	{
		return pigstyinfoMapper.deletePigstyinfoByIds(Convert.toStrArray(ids));
	}

	/**
	 * 查询传感器中最近二十条数据
	 * @author 张超 teavamc
	 * @date 2019/4/15
	 * @param []
	 * @return java.util.List<java.util.HashMap>
	 */
	@Override
	public List<HashMap> recentTwentyByTime(){
		return pigstyinfoMapper.recentTwentyByTime();
	}

	@Override
	public List<HashMap> recentenByTime(){
		return pigstyinfoMapper.recentenByTime();
	}

	@Override
	public List<HashMap> selectTem(){
		return pigstyinfoMapper.selectTem();
	}

	@Override
	public List<HashMap> selectAmm(){
		return pigstyinfoMapper.selectAmm();
	}
	@Override
	public List<HashMap> selectHumi(){
		return pigstyinfoMapper.selectHumi();
	}

	@Override
	public List<HashMap> selectLight(){
		return pigstyinfoMapper.selectLight();
	}

/*	@Override
	public int countAll(){
		return pigstyinfoMapper.countAll();
	}*/

	@Override
	public double prentem(){
		return pigstyinfoMapper.prentem();
	}


    @Override
    public double prenrh(){
        return pigstyinfoMapper.prenrh();
	}

	@Override
	public double prenlight(){
		return pigstyinfoMapper.prenlight();
	}

	@Override
	public double prenag(){
		return pigstyinfoMapper.prenag();
	}
}
