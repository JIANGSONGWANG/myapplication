package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.mapper.BusBlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.BusBlog;
import com.ruoyi.system.service.IBusBlogService;

/**
 * 博客Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-25
 */
@Service
public class BusBlogServiceImpl implements IBusBlogService
{
    @Autowired
    private BusBlogMapper busBlogMapper;

    @Override
    public List<String> selectBlogCountByDate(BusBlog queryParam){
        return busBlogMapper.selectBlogCountByDate(queryParam);
    };
    /**
     * 查询博客
     * 
     * @param id 博客主键
     * @return 博客
     */
    @Override
    public BusBlog selectBusBlogById(Long id)
    {
        return busBlogMapper.selectBusBlogById(id);
    }

    /**
     * 查询博客列表
     * 
     * @param busBlog 博客
     * @return 博客
     */
    @Override
    public List<BusBlog> selectBusBlogList(BusBlog busBlog)
    {
        return busBlogMapper.selectBusBlogList(busBlog);
    }

    /**
     * 新增博客
     * 
     * @param busBlog 博客
     * @return 结果
     */
    @Override
    public int insertBusBlog(BusBlog busBlog)
    {
        return busBlogMapper.insertBusBlog(busBlog);
    }

    /**
     * 修改博客
     * 
     * @param busBlog 博客
     * @return 结果
     */
    @Override
    public int updateBusBlog(BusBlog busBlog)
    {
        return busBlogMapper.updateBusBlog(busBlog);
    }

    /**
     * 批量删除博客
     * 
     * @param ids 需要删除的博客主键
     * @return 结果
     */
    @Override
    public int deleteBusBlogByIds(Long[] ids)
    {
        return busBlogMapper.deleteBusBlogByIds(ids);
    }

    /**
     * 删除博客信息
     * 
     * @param id 博客主键
     * @return 结果
     */
    @Override
    public int deleteBusBlogById(Long id)
    {
        return busBlogMapper.deleteBusBlogById(id);
    }
}
