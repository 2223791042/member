package guet.ty.member.service.impl;

import guet.ty.member.dao.CardMapper;
import guet.ty.member.dao.ChargeinfoMapper;
import guet.ty.member.entity.Card;
import guet.ty.member.entity.CardExample;
import guet.ty.member.entity.Chargeinfo;
import guet.ty.member.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private ChargeinfoMapper chargeinfoMapper;

    @Transactional
    @Override
    public void saveCard(Card card) {
        cardMapper.insert(card);
    }

    @Override
    public Card getCard(String memberPhone) {
        return cardMapper.selectByPrimaryKey(memberPhone);
    }

    @Transactional
    @Override
    public void editCard(Card saveCard) {
        cardMapper.updateByPrimaryKeySelective(saveCard);
    }

    @Transactional
    @Override
    //会员充值
    public void saveCharge(Chargeinfo chargeinfo){
        chargeinfoMapper.insert(chargeinfo);
    }

    @Override
    //会员卡会员根据等级展示
    public List<Card> getCardByGrade(Integer grade) {
        CardExample cardExample=new CardExample();
        CardExample.Criteria criteria = cardExample.createCriteria();
        criteria.andCardGradeEqualTo(grade);
        return cardMapper.selectByExample(cardExample);
    }

    @Transactional
    @Override
    //消费
    public void CardConsumption(String cardId, BigDecimal money){
        Card card=cardMapper.selectByPrimaryKey(cardId);
        card.setCardPoints(money);
        card.setCardPayMoney(card.getCardPayMoney().add(money));
        card.setCardPayTimes(card.getCardPayTimes()+1);
        cardMapper.updateByPrimaryKey(card);
    }

}
