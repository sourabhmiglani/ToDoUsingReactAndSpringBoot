package com.Sourabh.ToDoApp.Service;

import com.Sourabh.ToDoApp.Entity.Todo;
import com.Sourabh.ToDoApp.Respository.Repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteTodo(long todoId) {
    Todo existingTodo = todoRepository.findById(todoId).orElseThrow(() -> new EntityNotFoundException("Todo Not found"));
    todoRepository.deleteById(todoId);
    }

    public void updateTodo(long todoId, Todo updatedTodo) {
        Todo existingTodo = todoRepository.findById(todoId).orElseThrow(() -> new EntityNotFoundException("Todo Not found"));
        if(updatedTodo.getTitle() != null)
        existingTodo.setTitle(updatedTodo.getTitle());
        if(updatedTodo.getDescription() != null)
        existingTodo.setDescription(updatedTodo.getDescription());
        existingTodo.setCompleted(updatedTodo.isCompleted());
        todoRepository.save(existingTodo);
    }
}