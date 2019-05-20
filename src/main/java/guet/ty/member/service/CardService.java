package guet.ty.member.service;

import guet.ty.member.entity.Card;
import guet.ty.member.entity.Chargeinfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface CardService {
    void saveCard(Card card);

    Card getCard(String memberPhone);

    void editCard(Card saveCard);

    //会员充值
    void saveCharge(Chargeinfo chargeinfo);

    //会员卡会员根据等级展示
    List<Card> getCardByGrade(Integer grade);
    //消费
    public void CardConsumption(String cardId, BigDecimal money);
}
