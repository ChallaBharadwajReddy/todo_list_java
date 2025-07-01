package com.example.todo_app;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Document(collection = "todo")
class Todo{

    @Id
    public String _id;

    public String id ;
    public String todo;

    public Todo(String id, String todo){
        this.id = id;
        this.todo = todo;
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

    @Autowired
    private TodoRepository todoRepository;


    List<Todo> todo_list = new ArrayList<>();
    
    @GetMapping("/get_list")
    public List<Todo> get_list(){
        // add_data();
        return todoRepository.findAll();

    }

    @PostMapping("/add_todo")
    public String add_todo(@RequestBody Todo todo){
        todoRepository.save(todo);
        return "Success" ;
    }

    @PostMapping("/edit_todo")
    public String edit_todo(@RequestBody Todo new_todo){

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
    
    @DeleteMapping("/delete/{id}")
    public String Delete_todo(@PathVariable String id){
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
