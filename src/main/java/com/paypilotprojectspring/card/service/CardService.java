package com.paypilotprojectspring.card.service;

import com.paypilotprojectspring.card.dto.CardDTO;
import com.paypilotprojectspring.card.mapper.CardMapper;
import com.paypilotprojectspring.card.model.Card;
import com.paypilotprojectspring.card.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public List<CardDTO> getAllCards() {
        return cardRepository.findAll().stream()
                .map(cardMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public CardDTO getCardById(Long id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found!"));
        return cardMapper.entityToDto(card);
    }

    public CardDTO createCard(CardDTO cardDTO) {
        Card card = cardMapper.dtoToEntity(cardDTO);
        card = cardRepository.save(card);
        return cardMapper.entityToDto(card);
    }

    public CardDTO updateCard(Long id, CardDTO cardDTO) {
        Card existingCard = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found!"));
        existingCard.setCardNumber(cardDTO.getCardNumber());
        existingCard.setCardholderName(cardDTO.getCardholderName());
        existingCard.setExpiryDate(cardDTO.getExpiryDate());
        existingCard.setBankId(cardDTO.getBankId());
        existingCard.setBalance(cardDTO.getBalance());
        existingCard.setCreditLimit(cardDTO.getCreditLimit());
        existingCard.setCardType(cardDTO.getCardType());
        existingCard = cardRepository.save(existingCard);
        return cardMapper.entityToDto(existingCard);
    }

    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }
}
