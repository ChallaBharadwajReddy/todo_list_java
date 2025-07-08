package com.example.todo_app.services;

import java.beans.JavaBean;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.todo_app.Dao.Query;

import com.example.todo_app.Dao.Todo;
@Service
@JavaBean
public class TodoService {

    @Autowired
    private Query query;

    @Cacheable(value = "todoList")
    public List<Todo> get_list(){
        return query.getAllDeleteFalse();
    }

    @CacheEvict(value = "todoList", allEntries = true)
    public String add_todo(Todo todo){
        try{
            query.saveTodo(todo);
            return "Success" ;
        }
        catch(Error err){
            return "Error adding todo";
        }
    }

    @CacheEvict(value = "todoList", allEntries = true)
    public String edit_todo(Todo todo){
        try{
            Optional<Todo> existingTodoOpt = query.getTodoById(todo.getId());

            if (existingTodoOpt.isPresent()) {
                Todo existingTodo = existingTodoOpt.get();
                existingTodo.setTodo(todo.todo);
                query.saveTodo(existingTodo);
                return "Success";
            } else {
                return "Todo not found";
            }
        }
        catch(Error err){
            return "Error editing todo";
        }

    }

    @CacheEvict(value = "todoList", allEntries = true)
    public String Delete_todo(String id){
        try{
            Optional<Todo> existingTodoOpt = query.getTodoById(id);

            if (existingTodoOpt.isPresent()) {
                Todo existingTodo = existingTodoOpt.get();
                existingTodo.setDelete();
                query.saveTodo(existingTodo);
                return "Success";
            } else {
                return "Todo not found";
            }
        }
        catch(Error err){
            return "Error deleting todo";
        }
    }
}
