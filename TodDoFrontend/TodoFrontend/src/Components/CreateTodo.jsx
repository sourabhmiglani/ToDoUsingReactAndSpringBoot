import React, { useState } from "react";
import "./CreateTodo.css"; // Import CSS file for styling

export function CreateTodo({ refreshTodos }) {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");

  return (
    <div className="create-todo-container">
      <input
        className="create-todo-input"
        placeholder="Title"
        type="text"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      />
      <br />
      <input
        className="create-todo-input"
        placeholder="Description"
        type="text"
        value={description}
        onChange={(e) => setDescription(e.target.value)}
      />
      <br />
      <button
        className="create-todo-button"
        onClick={async () => {
          const resp = await fetch("http://localhost:8080/auth/addTodo", {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify({ title, description, completed: false }),
          });
          setTitle("");
          setDescription("");
          if (resp.ok) {
            alert("To Do Added");
            refreshTodos();
          } else {
            alert("Database is down, try some time later!");
          }
        }}
      >
        Add ToDo
      </button>
      <br />
    </div>
  );
}
