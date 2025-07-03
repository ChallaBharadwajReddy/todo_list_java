package com.example.todo_app.Dao;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "todo")
public class Todo {
    
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
