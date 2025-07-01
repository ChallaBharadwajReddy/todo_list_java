package com.example.todo_app;
import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

class Todo{
    public String id ;
    public String todo;

    public Todo(){

    }

    public String getId() {
        return id;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }


}

@RestController
public class Todo_list_api {

    List<Todo> todo_list = new ArrayList<>();

    // public void add_data(){
    //     todo.add("Complete project");
    //     todo.add("start studing");
    // }
    
    
    @GetMapping("/get_list")
    public List<Todo> get_list(){
        // add_data();
        return todo_list;

    }

    @PostMapping("/add_todo")
    public String add_todo(@RequestBody Todo todo){
        todo_list.add(todo);
        return "Success" ;
    }

    @PostMapping("/edit_todo")
    public String edit_todo(@RequestBody Todo new_todo){
        for(Todo item : todo_list){
            if(item.getId().equals(new_todo.id)){
                item.setTodo(new_todo.todo);
                return "Success";
            }
        }

        return "Todo not found";
    }
    
    @DeleteMapping("/delete/{id}")
    public String Delete_todo(@PathVariable String id){
        for(Todo item : todo_list){
            if(item.getId().equals(id)){
                todo_list.remove(item);
                return "Success";
            }
        }

        return "Todo not found";
    }

}
