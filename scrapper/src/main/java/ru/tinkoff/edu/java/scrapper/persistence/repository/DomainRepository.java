package ru.tinkoff.edu.java.scrapper.persistence.repository;

import org.springframework.stereotype.Repository;
import ru.tinkoff.edu.java.scrapper.exceptions.repository.BadEntityException;
import ru.tinkoff.edu.java.scrapper.exceptions.repository.DuplicateUniqueFieldException;
import ru.tinkoff.edu.java.scrapper.persistence.entity.DomainData;

import java.util.List;

@Repository
public interface DomainRepository {
    void add(DomainData domainData) throws BadEntityException, DuplicateUniqueFieldException;
    void remove(long id);
    void remove(String name);
    List<DomainData> findAll();
}
