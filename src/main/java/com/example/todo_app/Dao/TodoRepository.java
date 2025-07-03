package com.example.todo_app.Dao;
import java.util.*;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {
    List <Todo> findAllByid(String id);
}