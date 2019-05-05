package guet.ty.member.service;

import guet.ty.member.entity.Card;

public interface CardService {
    void saveCard(Card card);

    Card getCard(String memberPhone);

    void editCard(Card saveCard);
}
