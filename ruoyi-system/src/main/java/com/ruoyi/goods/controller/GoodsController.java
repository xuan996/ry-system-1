package com.ruoyi.web.controller.goods;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.goods.domain.Goods;
import com.ruoyi.goods.service.IGoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * 商品(goods)Controller
 * 
 * @author PeiEn1321
 * @date 2019-09-09
 */
@Controller
@RequestMapping("/goods/goods")
public class GoodsController extends BaseController
{
    private String prefix = "goods/goods";

    @Autowired
    private IGoodsService goodsService;

    @RequiresPermissions("goods:goods:view")
    @GetMapping()
    public String goods()
    {
        return prefix + "/goods";
    }

    /**
     * 查询商品(goods)列表
     */
    @RequiresPermissions("goods:goods:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Goods goods)
    {
        startPage();
        List<Goods> list = goodsService.selectGoodsList(goods);
        return getDataTable(list);
    }

    /**
     * 导出商品(goods)列表
     */
    @RequiresPermissions("goods:goods:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Goods goods)
    {
        List<Goods> list = goodsService.selectGoodsList(goods);
        ExcelUtil<Goods> util = new ExcelUtil<Goods>(Goods.class);
        return util.exportExcel(list, "goods");
    }

    /**
     * 新增商品(goods)
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品(goods)
     */
    @RequiresPermissions("goods:goods:add")
    @Log(title = "商品(goods)", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("picture") MultipartFile file, HttpServletRequest request) throws IOException {
        String filePath = Global.getUploadPath();
        Goods goods = new Goods();
        goods.setCategoryId(Long.valueOf(request.getParameter("categoryId")));
        goods.setGoodName(request.getParameter("goodName"));
        goods.setOriginalPrice(Double.valueOf(request.getParameter("originalPrice")));
        goods.setMembersPrice(Double.valueOf(request.getParameter("membersPrice")));
        goods.setGoodInventory(Long.valueOf(request.getParameter("goodInventory")));
        goods.setGoodsWeight(Long.valueOf(request.getParameter("goodsWeight")));
        goods.setSales(Long.valueOf(request.getParameter("sales")));
        goods.setStatus(request.getParameter("status"));


        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, file);
        goods.setPicture(fileName);
        return toAjax(goodsService.insertGoods(goods));
    }

    /**
     * 修改商品(goods)
     */
    @GetMapping("/edit/{goodId}")
    public String edit(@PathVariable("goodId") Long goodId, ModelMap mmap)
    {
        Goods goods = goodsService.selectGoodsById(goodId);
        mmap.put("goods", goods);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品(goods)
     */
    @RequiresPermissions("goods:goods:edit")
    @Log(title = "商品(goods)", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Goods goods)
    {
        return toAjax(goodsService.updateGoods(goods));
    }

    /**
     * 删除商品(goods)
     */
    @RequiresPermissions("goods:goods:remove")
    @Log(title = "商品(goods)", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(goodsService.deleteGoodsByIds(ids));
    }
}
