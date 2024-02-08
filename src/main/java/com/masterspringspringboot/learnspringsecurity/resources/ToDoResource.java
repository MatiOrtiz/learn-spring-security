package com.masterspringspringboot.learnspringsecurity.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoResource {

    private static final List<ToDo> TODOS_LIST= List.of(new ToDo("admin", "toDo1"), new ToDo("admin", "toDo2"));
    Logger logger= LoggerFactory.getLogger(getClass());

    @GetMapping("/todos")
    public List<ToDo> retrieveAllToDos(){
        return TODOS_LIST;
    }

    @GetMapping("/users/{username}/todos")
    public ToDo retrieveToDosForSpecificUser(@PathVariable String username){
        return TODOS_LIST.get(0);
    }
    @PostMapping("/users/{username}/todos")
    public void createToDoForSpecificUser(@PathVariable String username, @RequestBody ToDo toDo){
        logger.info("Create {} for {}");
    }
}

record ToDo(String user, String description){};