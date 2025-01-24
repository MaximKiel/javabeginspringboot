package ru.javabegin.todobackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.javabegin.todobackend.entity.Stat;

@Repository
public interface StatRepository extends CrudRepository<Stat, Long> {
    Stat findByUserEmail(String email);
}
