package com.example.todo_app.Dao;


import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "todo")
public class Todo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    public String _id;

    public String id ;
    public String todo;
    public boolean delete = false;

    public Todo(String todo){
        this.id = (LocalDateTime.now()).toString();
        this.todo = todo;
    }

    public String getId() {
        return id;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
    
    public void setDelete(){
        this.delete = true;
    }

    public void unsetDelete(){
        this.delete = false;
    }
}
