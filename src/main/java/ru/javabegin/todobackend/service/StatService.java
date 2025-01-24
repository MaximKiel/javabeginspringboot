package ru.javabegin.todobackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javabegin.todobackend.entity.Stat;
import ru.javabegin.todobackend.repository.StatRepository;

@Service
@Transactional
public class StatService {
    private final StatRepository repository;

    public StatService(StatRepository repository) {
        this.repository = repository;
    }

    public Stat findStat(String email) {
        return repository.findByUserEmail(email);
    }
}
