package com.ruoyi.goods.service;

import com.ruoyi.goods.domain.Goods;
import java.util.List;

/**
 * 商品(goods)Service接口
 * 
 * @author PeiEn1321
 * @date 2019-09-09
 */
public interface IGoodsService 
{
    /**
     * 查询商品(goods)
     * 
     * @param goodId 商品(goods)ID
     * @return 商品(goods)
     */
    public Goods selectGoodsById(Long goodId);

    /**
     * 查询商品(goods)列表
     * 
     * @param goods 商品(goods)
     * @return 商品(goods)集合
     */
    public List<Goods> selectGoodsList(Goods goods);

    /**
     * 新增商品(goods)
     * 
     * @param goods 商品(goods)
     * @return 结果
     */
    public int insertGoods(Goods goods);

    /**
     * 修改商品(goods)
     * 
     * @param goods 商品(goods)
     * @return 结果
     */
    public int updateGoods(Goods goods);

    /**
     * 批量删除商品(goods)
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGoodsByIds(String ids);

    /**
     * 删除商品(goods)信息
     * 
     * @param goodId 商品(goods)ID
     * @return 结果
     */
    public int deleteGoodsById(Long goodId);
}
