package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * indus对象 indus_ict
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
public class Indus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private String beginDate;

    //结束时间
    private String endDate;

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /** $column.columnComment */
    private Long ID;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String failureType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String indusProbe;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long indusUsage;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String nodeName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String deviceName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date timeDate;

    public void setID(Long ID) 
    {
        this.ID = ID;
    }

    public Long getID() 
    {
        return ID;
    }
    public void setFailureType(String failureType) 
    {
        this.failureType = failureType;
    }

    public String getFailureType() 
    {
        return failureType;
    }
    public void setIndusProbe(String indusProbe) 
    {
        this.indusProbe = indusProbe;
    }

    public String getIndusProbe() 
    {
        return indusProbe;
    }
    public void setIndusUsage(Long indusUsage) 
    {
        this.indusUsage = indusUsage;
    }

    public Long getIndusUsage() 
    {
        return indusUsage;
    }
    public void setNodeName(String nodeName) 
    {
        this.nodeName = nodeName;
    }

    public String getNodeName() 
    {
        return nodeName;
    }
    public void setDeviceName(String deviceName) 
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName() 
    {
        return deviceName;
    }
    public void setTimeDate(Date timeDate) 
    {
        this.timeDate = timeDate;
    }

    public Date getTimeDate() 
    {
        return timeDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ID", getID())
            .append("failureType", getFailureType())
            .append("indusProbe", getIndusProbe())
            .append("indusUsage", getIndusUsage())
            .append("nodeName", getNodeName())
            .append("deviceName", getDeviceName())
            .append("timeDate", getTimeDate())
            .toString();
    }
}
