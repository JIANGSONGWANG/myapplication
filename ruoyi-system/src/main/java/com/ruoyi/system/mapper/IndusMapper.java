package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.BusBlog;
import com.ruoyi.system.domain.Indus;

/**
 * indusMapper接口
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
public interface IndusMapper 
{
    public List<String> selectIndusCountByDate(Indus queryParam);
    public List<String> selectIndusCountByDateByNode(Indus queryParam);

    public List<String> selectIndusCountByDateByDevice(Indus queryParam);
    /**
     * 查询indus
     * 
     * @param ID indus主键
     * @return indus
     */
    public Indus selectIndusByID(Long ID);

    /**
     * 查询indus列表
     * 
     * @param indus indus
     * @return indus集合
     */
    public List<Indus> selectIndusList(Indus indus);

    /**
     * 新增indus
     * 
     * @param indus indus
     * @return 结果
     */
    public int insertIndus(Indus indus);

    /**
     * 修改indus
     * 
     * @param indus indus
     * @return 结果
     */
    public int updateIndus(Indus indus);

    /**
     * 删除indus
     * 
     * @param ID indus主键
     * @return 结果
     */
    public int deleteIndusByID(Long ID);

    /**
     * 批量删除indus
     * 
     * @param IDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteIndusByIDs(Long[] IDs);
}
