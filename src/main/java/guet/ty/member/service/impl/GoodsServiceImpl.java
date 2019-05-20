package guet.ty.member.service.impl;

import guet.ty.member.dao.GoodsMapper;
import guet.ty.member.entity.Goods;
import guet.ty.member.entity.GoodsExample;
import guet.ty.member.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Transactional
    @Override
    public void saveGoods(Goods goods) {
        goodsMapper.insertSelective(goods);
    }

    @Transactional
    @Override
    public List<Goods> getGoodsList(Long goodsId, String goodsName, BigDecimal goodsPoints) {

        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        if(goodsId!=null) criteria.andGoodsIdEqualTo(goodsId);

        if(goodsName != null && !goodsName.trim().equals("")){
            criteria.andGoodsNameLike("%"+goodsName+"%");
        }

        if(goodsPoints!=null) {
            criteria.andGoodsPointsLessThanOrEqualTo(goodsPoints);
        }

        List<Goods> goods = goodsMapper.selectByExample(example);

        return goods;
    }

    @Transactional
    @Override
    public Goods getGoods(Long goodsId) {
        return goodsMapper.selectByPrimaryKey(goodsId);
    }

    @Transactional
    @Override
    public void editGoods(Goods record) {
        goodsMapper.updateByPrimaryKeySelective(record);
    }


}
