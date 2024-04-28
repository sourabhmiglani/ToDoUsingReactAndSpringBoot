package com.Sourabh.ToDoApp.Respository.Repository;

import com.Sourabh.ToDoApp.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // You can define custom query methods here if needed
}