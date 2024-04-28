import React from 'react';
import './Todos.css'; // Import CSS file for styling

export function Todos({ todos, refreshToDoList }) {
  return (
    <div className="todos-container">
      {todos.map(todo => (
        <div key={todo.id} className="todo-item">
          <h2 className="todo-title">{todo.title}</h2>
          <p className="todo-description">{todo.description}</p>
          <div className="todo-actions">
            {todo.completed ? (
              <p className="todo-status">Done</p>
            ) : (
              <button
                className="todo-button complete"
                onClick={async () => {
                  const resp = await fetch(
                    `http://localhost:8080/auth/updateTodo?todoId=${todo.id}`,
                    {
                      method: 'PUT',
                      headers: {
                        'Content-Type': 'application/json',
                      },
                      body: JSON.stringify({ completed: true }), // Send completed as true in the request body
                    }
                  );
                  if (resp.ok) {
                    refreshToDoList();
                  }
                }}
              >
                Mark as Complete
              </button>
            )}
            <button
              className="todo-button delete"
              onClick={async () => {
                const resp = await fetch(
                  `http://localhost:8080/auth/deleteTodo?todoId=${todo.id}`,
                  {
                    method: 'DELETE',
                    headers: {
                      'Content-Type': 'application/json',
                    }
                  }
                );
                if (resp.ok) {
                  refreshToDoList();
                }
              }}
            >
              Delete Task
            </button>
          </div>
        </div>
      ))}
    </div>
  );
}
