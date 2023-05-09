package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.BusBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.IndusMapper;
import com.ruoyi.system.domain.Indus;
import com.ruoyi.system.service.IIndusService;

/**
 * indusService业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
@Service
public class IndusServiceImpl implements IIndusService 
{
    @Autowired
    private IndusMapper indusMapper;

    @Override
    public List<String> selectIndusCountByDate(Indus queryParam){
        return indusMapper.selectIndusCountByDate(queryParam);
    };
    @Override
    public List<String> selectIndusCountByDateByNode(Indus queryParam){
        return indusMapper.selectIndusCountByDateByNode(queryParam);
    };

    @Override
    public List<String> selectIndusCountByDateByDevice(Indus queryParam){
        return indusMapper.selectIndusCountByDateByDevice(queryParam);
    };

    /**
     * 查询indus
     * 
     * @param ID indus主键
     * @return indus
     */
    @Override
    public Indus selectIndusByID(Long ID)
    {
        return indusMapper.selectIndusByID(ID);
    }

    /**
     * 查询indus列表
     * 
     * @param indus indus
     * @return indus
     */
    @Override
    public List<Indus> selectIndusList(Indus indus)
    {
        return indusMapper.selectIndusList(indus);
    }

    /**
     * 新增indus
     * 
     * @param indus indus
     * @return 结果
     */
    @Override
    public int insertIndus(Indus indus)
    {
        return indusMapper.insertIndus(indus);
    }

    /**
     * 修改indus
     * 
     * @param indus indus
     * @return 结果
     */
    @Override
    public int updateIndus(Indus indus)
    {
        return indusMapper.updateIndus(indus);
    }

    /**
     * 批量删除indus
     * 
     * @param IDs 需要删除的indus主键
     * @return 结果
     */
    @Override
    public int deleteIndusByIDs(Long[] IDs)
    {
        return indusMapper.deleteIndusByIDs(IDs);
    }

    /**
     * 删除indus信息
     * 
     * @param ID indus主键
     * @return 结果
     */
    @Override
    public int deleteIndusByID(Long ID)
    {
        return indusMapper.deleteIndusByID(ID);
    }
}
