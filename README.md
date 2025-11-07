# 📚 LibrarySystem

## 🧩 Overview
This project is a **Java console-based library management system** that allows users to **add, borrow, and return books**.  
It maintains a dynamic catalog using a `HashMap` and features robust **input validation** to ensure smooth user interaction.  
The system was developed as part of a **University of the People programming assignment** to demonstrate **object-oriented design, encapsulation, and control flow**.

---

## ⚙️ Features
- **Add new books** or increase stock for existing titles  
- **Borrow books** with quantity checks to prevent negative stock  
- **Return books** and automatically restock the catalog  
- **Validate all user inputs** (e.g., non-empty strings, positive integers)  
- Case-insensitive catalog management (`title.toLowerCase()`)  
- Graceful handling of invalid operations and menu navigation  

---

## 🧠 Concepts Used

| Concept | Description |
|----------|-------------|
| **Inner Classes** | `Book` is a private static nested class encapsulating book data |
| **Encapsulation** | Book fields are private with controlled access through methods |
| **HashMap** | Stores books using lowercase titles as keys for quick lookup |
| **Input Validation** | Loops and exceptions ensure correct input before processing |
| **Loops & Conditionals** | Used extensively for menus, validation, and stock control |
| **Exception Handling** | Prevents runtime crashes due to invalid numeric input |
| **OOP Principles** | Composition: `LibrarySystem` manages multiple `Book` instances |
| **Immutability** | Book’s `title` and `author` are declared `final` |
| **Switch Expressions (Java 14+)** | Used for cleaner and modern menu control |

---

## ▶️ How to Run

1️⃣ Open a terminal in the project directory.  
2️⃣ Compile:
```bash
javac LibrarySystem.java
```

3️⃣ Run the program:
```bash
java LibrarySystem
```

## 🏫 Educational Context

This program was developed as part of a Computer Science course at the University of the People.
It emphasizes:

OOP encapsulation and data hiding

Collection-based data management (HashMap)

Loop-based input validation and error handling

User interaction through structured console menus

The project helps students understand how to design small-scale systems with reliable data integrity.
