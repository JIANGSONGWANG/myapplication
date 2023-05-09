package com.ruoyi.system.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.BusBlog;
import com.ruoyi.system.service.IBusBlogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 博客Controller
 * 
 * @author js
 * @date 2023-04-25
 */
@RestController
@RequestMapping("/system/blog")
public class BusBlogController extends BaseController
{
    @Autowired
    private IBusBlogService busBlogService;

    /**
     * 查询博客列表
     */
//    @PreAuthorize("@ss.hasPermi('system:blog:list')")
//    @GetMapping("/list")
//    public TableDataInfo list(BusBlog busBlog)
//    {
//        startPage();
//        List<BusBlog> list = busBlogService.selectBusBlogList(busBlog);
//        return getDataTable(list);
//    }

    @PreAuthorize("@ss.hasPermi('system:blog:list')")
    @GetMapping("/list")
    public AjaxResult list(BusBlog busBlog)
    {
        BusBlog indexModel=new BusBlog();
        //构造返回数据，注意这里需要用LinkedHashMap
        Map<String,Integer> resultMap = new LinkedHashMap<String,Integer>();
        if(null!= busBlog.getBeginDate() && null!= busBlog.getEndDate()) {
            //获取请求参数，开始时间和结束时间
            indexModel.setBeginDate(busBlog.getBeginDate());
            indexModel.setEndDate(busBlog.getBeginDate());
            List<String> rangeData = new ArrayList<String>();
            //查询数据库获取指定时间内的数据
            rangeData = busBlogService.selectBlogCountByDate(busBlog);
            if (rangeData.size() >= 0) {
                // 日期格式化
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    // 起始日期
                    Date d1 = sdf.parse(busBlog.getBeginDate());
                    // 结束日期
                    Date d2 = sdf.parse(busBlog.getEndDate());
                    Date tmp = d1;
                    Calendar dd = Calendar.getInstance();
                    dd.setTime(d1);
                    while (tmp.getTime() < d2.getTime()) {
                        int dayCount = 0;
                        tmp = dd.getTime();
                        //获取查询的数据每天的档案数量
                        for (String oneDay:rangeData) {
                            Date oneDayDate = sdf.parse(oneDay);
                            if(oneDayDate.toString().equals(tmp.toString()))
                            {
                                dayCount++;
                            }
                        }
                        resultMap.put(sdf.format(tmp),dayCount);
                        // 天数加上1
                        dd.add(Calendar.DAY_OF_MONTH, 1);
                    }
                    System.out.println(resultMap);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return AjaxResult.success(resultMap);
    }


    /**
     * 导出博客列表
     */
    @PreAuthorize("@ss.hasPermi('system:blog:export')")
    @Log(title = "博客", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BusBlog busBlog)
    {
        List<BusBlog> list = busBlogService.selectBusBlogList(busBlog);
        ExcelUtil<BusBlog> util = new ExcelUtil<BusBlog>(BusBlog.class);
        util.exportExcel(response, list, "博客数据");
    }

    /**
     * 获取博客详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:blog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(busBlogService.selectBusBlogById(id));
    }

    /**
     * 新增博客
     */
    @PreAuthorize("@ss.hasPermi('system:blog:add')")
    @Log(title = "博客", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusBlog busBlog)
    {
        return toAjax(busBlogService.insertBusBlog(busBlog));
    }

    /**
     * 修改博客
     */
    @PreAuthorize("@ss.hasPermi('system:blog:edit')")
    @Log(title = "博客", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusBlog busBlog)
    {
        return toAjax(busBlogService.updateBusBlog(busBlog));
    }

    /**
     * 删除博客
     */
    @PreAuthorize("@ss.hasPermi('system:blog:remove')")
    @Log(title = "博客", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(busBlogService.deleteBusBlogByIds(ids));
    }
}
