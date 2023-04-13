package ru.tinkoff.edu.java.scrapper.persistence.repository;

import org.springframework.stereotype.Repository;
import ru.tinkoff.edu.java.scrapper.exceptions.repository.BadEntityException;
import ru.tinkoff.edu.java.scrapper.exceptions.repository.DuplicateUniqueFieldException;
import ru.tinkoff.edu.java.scrapper.exceptions.repository.ForeignKeyNotExistsException;
import ru.tinkoff.edu.java.scrapper.persistence.entity.LinkData;

import java.util.List;

@Repository
public interface LinkRepository {
    void add(LinkData link) throws BadEntityException, ForeignKeyNotExistsException, DuplicateUniqueFieldException;
    void remove(long id);
    void remove(String link);
    List<LinkData> findAll();
}
