package com.Sourabh.ToDoApp.controller;


import com.Sourabh.ToDoApp.Dto.SignupRequest;
import com.Sourabh.ToDoApp.Entity.Todo;
import com.Sourabh.ToDoApp.Service.TodoService;
import com.Sourabh.ToDoApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private TodoService todoService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
        userService.signup(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @PostMapping("/addTodo")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo request) {
        Todo todo = todoService.createTodo(request);
        return ResponseEntity.ok(todo);
    }
    @DeleteMapping("/deleteTodo")
    public ResponseEntity<?> deleteTodo(@RequestParam long todoId) {
        try{
            todoService.deleteTodo(todoId);
            return ResponseEntity.ok("Todo Deleted");
        }
        catch(Exception e) {
            return new ResponseEntity<>("Todo Not Found", HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/updateTodo")
    public ResponseEntity<?> updateTodo(@RequestParam long todoId,@RequestBody Todo todo){
        try{
            todoService.updateTodo(todoId,todo);
            return ResponseEntity.ok("Todo updated");
        }
        catch (Exception e){
            return new ResponseEntity<>("Todo Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
