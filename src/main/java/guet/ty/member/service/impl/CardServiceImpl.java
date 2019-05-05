package guet.ty.member.service.impl;

import guet.ty.member.dao.CardMapper;
import guet.ty.member.entity.Card;
import guet.ty.member.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardMapper cardMapper;

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
}
