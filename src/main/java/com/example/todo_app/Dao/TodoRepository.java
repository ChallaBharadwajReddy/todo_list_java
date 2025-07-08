package com.example.todo_app.Dao;
import java.util.*;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {
    List <Todo> findAllByidAndDeleteFalse(String id);
    Optional<Todo> findByidAndDeleteFalse(String id);
    List<Todo> findAllByDeleteFalse();
}