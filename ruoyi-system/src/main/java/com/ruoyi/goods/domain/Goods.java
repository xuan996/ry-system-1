package com.ruoyi.goods.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品(goods)对象 goods
 * 
 * @author PeiEn1321
 * @date 2019-09-09
 */
public class Goods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品id */
    private Long goodId;

    /** 商品类别id */
    @Excel(name = "商品类别id")
    private Long categoryId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodName;

    /** 原价 */
    @Excel(name = "原价")
    private Double originalPrice;

    /** 会员价 */
    @Excel(name = "会员价")
    private Double membersPrice;

    /** 商品图片保存地址 */
    @Excel(name = "商品图片保存地址")
    private String picture;

    /** 库存 */
    @Excel(name = "库存")
    private Long goodInventory;

    /** 状态 0 上架,1下架 */
    @Excel(name = "状态 0 上架,1下架")
    private String status;

    /** 销量 */
    @Excel(name = "销量")
    private Long sales;

    /** 商品权重 */
    @Excel(name = "商品权重")
    private Long goodsWeight;

    public void setGoodId(Long goodId) 
    {
        this.goodId = goodId;
    }

    public Long getGoodId() 
    {
        return goodId;
    }
    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }
    public void setGoodName(String goodName) 
    {
        this.goodName = goodName;
    }

    public String getGoodName() 
    {
        return goodName;
    }
    public void setOriginalPrice(Double originalPrice) 
    {
        this.originalPrice = originalPrice;
    }

    public Double getOriginalPrice() 
    {
        return originalPrice;
    }
    public void setMembersPrice(Double membersPrice) 
    {
        this.membersPrice = membersPrice;
    }

    public Double getMembersPrice() 
    {
        return membersPrice;
    }
    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public String getPicture() 
    {
        return picture;
    }
    public void setGoodInventory(Long goodInventory) 
    {
        this.goodInventory = goodInventory;
    }

    public Long getGoodInventory() 
    {
        return goodInventory;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setSales(Long sales) 
    {
        this.sales = sales;
    }

    public Long getSales() 
    {
        return sales;
    }
    public void setGoodsWeight(Long goodsWeight) 
    {
        this.goodsWeight = goodsWeight;
    }

    public Long getGoodsWeight() 
    {
        return goodsWeight;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("goodId", getGoodId())
            .append("categoryId", getCategoryId())
            .append("goodName", getGoodName())
            .append("originalPrice", getOriginalPrice())
            .append("membersPrice", getMembersPrice())
            .append("picture", getPicture())
            .append("goodInventory", getGoodInventory())
            .append("status", getStatus())
            .append("sales", getSales())
            .append("goodsWeight", getGoodsWeight())
            .toString();
    }
}
