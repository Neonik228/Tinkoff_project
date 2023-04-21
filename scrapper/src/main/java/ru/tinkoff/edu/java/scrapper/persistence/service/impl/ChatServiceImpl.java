package ru.tinkoff.edu.java.scrapper.persistence.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.java.scrapper.exceptions.repository.DuplicateUniqueFieldException;
import ru.tinkoff.edu.java.scrapper.persistence.entity.ChatData;
import ru.tinkoff.edu.java.scrapper.persistence.repository.repository.ChatRepository;
import ru.tinkoff.edu.java.scrapper.persistence.service.ChatService;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatRepository;
    @Override
    public void register(Long tgChatId) {
        ChatData chatData = ChatData.builder()
                                              .id(tgChatId)
                                              .build();
        try {
            chatRepository.add(chatData);
        } catch (DuplicateKeyException e) {
            throw new DuplicateUniqueFieldException("Пользователь с таким id уже существует");
        }
    }

    @Override
    public void unregister(Long tgChatId) {
        chatRepository.remove(tgChatId);
    }
}