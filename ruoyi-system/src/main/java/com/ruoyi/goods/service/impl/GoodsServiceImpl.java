package com.ruoyi.goods.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.GoodsMapper;
import com.ruoyi.goods.domain.Goods;
import com.ruoyi.goods.service.IGoodsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品(goods)Service业务层处理
 * 
 * @author PeiEn1321
 * @date 2019-09-09
 */
@Service
public class GoodsServiceImpl implements IGoodsService 
{
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 查询商品(goods)
     * 
     * @param goodId 商品(goods)ID
     * @return 商品(goods)
     */
    @Override
    public Goods selectGoodsById(Long goodId)
    {
        return goodsMapper.selectGoodsById(goodId);
    }

    /**
     * 查询商品(goods)列表
     * 
     * @param goods 商品(goods)
     * @return 商品(goods)
     */
    @Override
    public List<Goods> selectGoodsList(Goods goods)
    {
        return goodsMapper.selectGoodsList(goods);
    }

    /**
     * 新增商品(goods)
     * 
     * @param goods 商品(goods)
     * @return 结果
     */
    @Override
    public int insertGoods(Goods goods)
    {
        return goodsMapper.insertGoods(goods);
    }

    /**
     * 修改商品(goods)
     * 
     * @param goods 商品(goods)
     * @return 结果
     */
    @Override
    public int updateGoods(Goods goods)
    {
        return goodsMapper.updateGoods(goods);
    }

    /**
     * 删除商品(goods)对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGoodsByIds(String ids)
    {
        return goodsMapper.deleteGoodsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品(goods)信息
     * 
     * @param goodId 商品(goods)ID
     * @return 结果
     */
    public int deleteGoodsById(Long goodId)
    {
        return goodsMapper.deleteGoodsById(goodId);
    }
}
