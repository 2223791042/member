package guet.ty.member.service;

import guet.ty.member.entity.Goods;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface GoodsService {

    void saveGoods(Goods goods);

    List<Goods> getGoodsList(Long goodsId, String goodsName, BigDecimal goodsPoints);

    Goods getGoods(Long goodsId);

    void editGoods(Goods record);

}
