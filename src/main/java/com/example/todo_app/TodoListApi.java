package com.example.todo_app;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_app.Dao.Todo;
import com.example.todo_app.services.TodoService;


@RestController
public class TodoListApi {

    @Autowired
    private TodoService service;

    
    @GetMapping("/todo")
    public List<Todo> get_list(){
        // add_data();
        return service.get_list();

    }

    @PostMapping("/todo")
    public String add_todo(@RequestBody Todo todo){
        return service.add_todo(todo);
    }

    @PutMapping("/todo")
    public String edit_todo(@RequestBody Todo new_todo){

        return service.edit_todo(new_todo);
    }
    
    @DeleteMapping("/todo/{id}")
    public String Delete_todo(@PathVariable String id){
        return service.Delete_todo(id);
    }

}
