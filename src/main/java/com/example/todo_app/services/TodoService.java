package com.example.todo_app.services;

import java.beans.JavaBean;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.todo_app.Dao.Todo;
import com.example.todo_app.Dao.TodoRepository;

@Service
@JavaBean
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Cacheable(value = "todoList")
    public List<Todo> get_list(){
        // add_data();
        return todoRepository.findAll();
    }

    @CacheEvict(value = "todoList", allEntries = true)
    public String add_todo(Todo todo){
        todoRepository.save(todo);
        return "Success" ;
    }

    @CacheEvict(value = "todoList", allEntries = true)
    public String edit_todo(Todo new_todo){

        List<Todo> existingTodoOpt = todoRepository.findAllByid(new_todo.id);

        if (!existingTodoOpt.isEmpty()) {
            Todo existingTodo = existingTodoOpt.get(0);
            existingTodo.setTodo(new_todo.todo);
            todoRepository.save(existingTodo);
            return "Success";
        } else {
            return "Todo not found";
        }

    }

    @CacheEvict(value = "todoList", allEntries = true)
    public String Delete_todo(String id){
        List<Todo> existingTodoOpt = todoRepository.findAllByid(id);

        if (!existingTodoOpt.isEmpty()) {
            Todo existingTodo = existingTodoOpt.get(0);
            todoRepository.delete(existingTodo);
            return "Success";
        } else {
            return "Todo not found";
        }
    }
}
