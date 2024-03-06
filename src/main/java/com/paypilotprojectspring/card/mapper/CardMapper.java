package com.paypilotprojectspring.card.mapper;

import com.paypilotprojectspring.card.dto.CardDTO;
import com.paypilotprojectspring.card.model.Card;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public CardDTO entityToDto(Card card) {
        return CardDTO.builder()
                .id(card.getId())
                .cardNumber(card.getCardNumber())
                .cardholderName(card.getCardholderName())
                .expiryDate(card.getExpiryDate())
                .bankId(card.getBankId())
                .balance(card.getBalance())
                .creditLimit(card.getCreditLimit())
                .cardType(card.getCardType())
                .build();
    }

    public Card dtoToEntity(CardDTO dto) {
        Card card = new Card();
        card.setId(dto.getId());
        card.setCardNumber(dto.getCardNumber());
        card.setCardholderName(dto.getCardholderName());
        card.setExpiryDate(dto.getExpiryDate());
        card.setBankId(dto.getBankId());
        card.setBalance(dto.getBalance());
        card.setCreditLimit(dto.getCreditLimit());
        card.setCardType(dto.getCardType());
        return card;
    }
}
