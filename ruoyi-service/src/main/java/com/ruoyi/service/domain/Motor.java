package com.ruoyi.service.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 远程控制表 motor
 * 
 * @author å± é¡
 * @date 2019-04-09
 */
public class Motor extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 操作记录id */
	private Integer oid;
	/** 开始时间 */
	private Date startTime;
	/** 结束时间 */
	private Date endTime;
	/** 运行时间 */
	private Date duration;
	/** 设备名称 */
	private String dName;

	public void setOid(Integer oid) 
	{
		this.oid = oid;
	}

	public Integer getOid() 
	{
		return oid;
	}
	public void setStartTime(Date startTime) 
	{
		this.startTime = startTime;
	}

	public Date getStartTime() 
	{
		return startTime;
	}
	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}

	public Date getEndTime() 
	{
		return endTime;
	}
	public void setDuration(Date duration) 
	{
		this.duration = duration;
	}

	public Date getDuration() 
	{
		return duration;
	}
	public void setDName(String dName) 
	{
		this.dName = dName;
	}

	public String getDName() 
	{
		return dName;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("oid", getOid())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("duration", getDuration())
            .append("dName", getDName())
            .toString();
    }
}
