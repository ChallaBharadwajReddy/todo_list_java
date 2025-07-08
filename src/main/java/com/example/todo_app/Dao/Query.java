package com.example.todo_app.Dao;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Query {
    @Autowired
    TodoRepository todoRepository ;

    public List<Todo> getAllDeleteFalse(){
        return todoRepository.findAllByDeleteFalse();
    }

    public Optional<Todo> getTodoById(String id){
        return todoRepository.findByidAndDeleteFalse(id);
    }

    public void saveTodo(Todo todo){
        todoRepository.save(todo);
    }
}
