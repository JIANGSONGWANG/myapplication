package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BusBlog;

/**
 * 博客Service接口
 * 
 * @author ruoyi
 * @date 2023-04-25
 */
public interface IBusBlogService 
{

    public List<String> selectBlogCountByDate(BusBlog queryParam);
    /**
     * 查询博客
     * 
     * @param id 博客主键
     * @return 博客
     */
    public BusBlog selectBusBlogById(Long id);

    /**
     * 查询博客列表
     * 
     * @param busBlog 博客
     * @return 博客集合
     */
    public List<BusBlog> selectBusBlogList(BusBlog busBlog);

    /**
     * 新增博客
     * 
     * @param busBlog 博客
     * @return 结果
     */
    public int insertBusBlog(BusBlog busBlog);

    /**
     * 修改博客
     * 
     * @param busBlog 博客
     * @return 结果
     */
    public int updateBusBlog(BusBlog busBlog);

    /**
     * 批量删除博客
     * 
     * @param ids 需要删除的博客主键集合
     * @return 结果
     */
    public int deleteBusBlogByIds(Long[] ids);

    /**
     * 删除博客信息
     * 
     * @param id 博客主键
     * @return 结果
     */
    public int deleteBusBlogById(Long id);
}
