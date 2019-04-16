package com.ruoyi.service.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 传感器数据表 pigstyinfo
 * 
 * @author å± é¡
 * @date 2019-04-09
 */
public class Pigstyinfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 数据id */
	private Integer id;
	/** 日志id */
	private Integer logId;
	/** 设备名称 */
	private String dName;
	/** 接收时间 */
	private Date recTime;
	/** 温度值 */
	private Integer temV;
	/** 湿度值 */
	private Integer rhV;
	/** 光照强大 */
	private Float lightV;
	/** 氨气浓度值 */
	private Float agV;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setLogId(Integer logId) 
	{
		this.logId = logId;
	}

	public Integer getLogId() 
	{
		return logId;
	}
	public void setDName(String dName) 
	{
		this.dName = dName;
	}

	public String getDName() 
	{
		return dName;
	}
	public void setRecTime(Date recTime) 
	{
		this.recTime = recTime;
	}

	public Date getRecTime() 
	{
		return recTime;
	}
	public void setTemV(Integer temV) 
	{
		this.temV = temV;
	}

	public Integer getTemV() 
	{
		return temV;
	}
	public void setRhV(Integer rhV) 
	{
		this.rhV = rhV;
	}

	public Integer getRhV() 
	{
		return rhV;
	}
	public void setLightV(Float lightV) 
	{
		this.lightV = lightV;
	}

	public Float getLightV() 
	{
		return lightV;
	}
	public void setAgV(Float agV) 
	{
		this.agV = agV;
	}

	public Float getAgV() 
	{
		return agV;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("logId", getLogId())
            .append("dName", getDName())
            .append("recTime", getRecTime())
            .append("temV", getTemV())
            .append("rhV", getRhV())
            .append("lightV", getLightV())
            .append("agV", getAgV())
            .toString();
    }
}
