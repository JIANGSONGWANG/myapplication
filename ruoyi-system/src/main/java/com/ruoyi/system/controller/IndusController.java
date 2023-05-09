package com.ruoyi.system.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.BusBlog;
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
import com.ruoyi.system.domain.Indus;
import com.ruoyi.system.service.IIndusService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * indusController
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
@RestController
@RequestMapping("/system/indus")
public class IndusController extends BaseController
{
    @Autowired
    private IIndusService indusService;

    /**
     * 查询indus列表
     */
    @PreAuthorize("@ss.hasPermi('system:indus:list')")
    @GetMapping("/list")
    public TableDataInfo list(Indus indus)
    {
        startPage();
        List<Indus> list = indusService.selectIndusList(indus);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('system:blog:list')")
    @GetMapping("/list3")
    public AjaxResult list3(Indus indus)
    {
        Indus indexModel=new Indus();
        //构造返回数据，注意这里需要用LinkedHashMap
        Map<String,Integer> resultMap = new LinkedHashMap<String,Integer>();
        if(null!= indus.getBeginDate() && null!= indus.getEndDate()) {
            //获取请求参数，开始时间和结束时间
            indexModel.setBeginDate(indus.getBeginDate());
            indexModel.setEndDate(indus.getBeginDate());
            List<String> deviceData = new ArrayList<String>();

            //查询数据库获取指定时间内的数据
            deviceData = indusService.selectIndusCountByDateByDevice(indus);

            if (deviceData.size() >= 0) {
                // 日期格式化
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                //获取查询的数据每天的档案数量
                for (String oneProbe:deviceData) {
                    resultMap.put(oneProbe, resultMap.getOrDefault(oneProbe, 0) + 1);
                }
                System.out.println(resultMap);
            }
        }
        return AjaxResult.success(resultMap);
    }



    @PreAuthorize("@ss.hasPermi('system:blog:list')")
    @GetMapping("/list2")
    public AjaxResult list2(Indus indus)
    {
        Indus indexModel=new Indus();
        //构造返回数据，注意这里需要用LinkedHashMap
        Map<String,Integer> resultMap = new LinkedHashMap<String,Integer>();
        if(null!= indus.getBeginDate() && null!= indus.getEndDate()) {
            //获取请求参数，开始时间和结束时间
            indexModel.setBeginDate(indus.getBeginDate());
            indexModel.setEndDate(indus.getBeginDate());
            List<String> nodeData = new ArrayList<String>();

            //查询数据库获取指定时间内的数据
            nodeData = indusService.selectIndusCountByDateByNode(indus);

            if (nodeData.size() >= 0) {
                // 日期格式化
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                //获取查询的数据每天的档案数量
                for (String oneProbe:nodeData) {
                    resultMap.put(oneProbe, resultMap.getOrDefault(oneProbe, 0) + 1);
                }
                System.out.println(resultMap);
            }
        }
        return AjaxResult.success(resultMap);
    }

    @PreAuthorize("@ss.hasPermi('system:blog:list')")
    @GetMapping("/list1")
    public AjaxResult list1(Indus indus)
    {
        Indus indexModel=new Indus();
        //构造返回数据，注意这里需要用LinkedHashMap
        Map<String,Integer> resultMap = new LinkedHashMap<String,Integer>();
        if(null!= indus.getBeginDate() && null!= indus.getEndDate()) {
            //获取请求参数，开始时间和结束时间
            indexModel.setBeginDate(indus.getBeginDate());
            indexModel.setEndDate(indus.getBeginDate());
            List<String> probeData = new ArrayList<String>();
            //查询数据库获取指定时间内的数据
            probeData = indusService.selectIndusCountByDate(indus);
            if (probeData.size() >= 0) {
                // 日期格式化
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                //获取查询的数据每天的档案数量
                for (String oneProbe:probeData) {
                    resultMap.put(oneProbe, resultMap.getOrDefault(oneProbe, 0) + 1);
                }
                System.out.println(resultMap);
            }
        }
        return AjaxResult.success(resultMap);
    }

    /**
     * 导出indus列表
     */
    @PreAuthorize("@ss.hasPermi('system:indus:export')")
    @Log(title = "indus", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Indus indus)
    {
        List<Indus> list = indusService.selectIndusList(indus);
        ExcelUtil<Indus> util = new ExcelUtil<Indus>(Indus.class);
        util.exportExcel(response, list, "indus数据");
    }

    /**
     * 获取indus详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:indus:query')")
    @GetMapping(value = "/{ID}")
    public AjaxResult getInfo(@PathVariable("ID") Long ID)
    {
        return success(indusService.selectIndusByID(ID));
    }

    /**
     * 新增indus
     */
    @PreAuthorize("@ss.hasPermi('system:indus:add')")
    @Log(title = "indus", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Indus indus)
    {
        return toAjax(indusService.insertIndus(indus));
    }

    /**
     * 修改indus
     */
    @PreAuthorize("@ss.hasPermi('system:indus:edit')")
    @Log(title = "indus", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Indus indus)
    {
        return toAjax(indusService.updateIndus(indus));
    }

    /**
     * 删除indus
     */
    @PreAuthorize("@ss.hasPermi('system:indus:remove')")
    @Log(title = "indus", businessType = BusinessType.DELETE)
	@DeleteMapping("/{IDs}")
    public AjaxResult remove(@PathVariable Long[] IDs)
    {
        return toAjax(indusService.deleteIndusByIDs(IDs));
    }
}
