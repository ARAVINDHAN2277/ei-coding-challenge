# ei-coding-challenge
Coding exercises for the Educational Initiatives
# Educational Initiatives - Coding Challenge Submission

This repository contains the solutions for the two coding exercises provided as part of the interview process. Both solutions are implemented in Java, built with Maven, and are structured to adhere to the standards mentioned in the problem description, including SOLID principles, the use of design patterns, and best practices for code organization.

---
## 📂 Project Structure

The repository is organized into two main folders, one for each exercise:

-   **/Exercise1_DesignPatterns**: A Maven project containing six runnable examples, each demonstrating a fundamental software design pattern with a real-world use case.
-   **/Exercise2_ClassroomManager**: A complete, terminal-based Maven application for managing virtual classrooms, students, and assignments.

---
## 🚀 How to Set Up and Run

Both projects are standard Maven projects and are best run using an IDE like IntelliJ IDEA or Eclipse.

### Exercise 1: Design Patterns Demo

1.  Open your IDE (e.g., IntelliJ).
2.  Go to **File -> Open...** and select the **`Exercise1_DesignPatterns`** folder from this repository.
3.  The IDE will automatically recognize it as a Maven project and set it up.
4.  To run any of the six pattern examples, navigate to its demo file (e.g., `src/main/java/com/designpatterns/creational/factory/FactoryDemo.java`), right-click on the file, and select **Run**.

### Exercise 2: Virtual Classroom Manager

1.  Open your IDE (e.g., IntelliJ).
2.  Go to **File -> Open...** and select the **`Exercise2_ClassroomManager/VirtualClassroomManager`** folder.
3.  The IDE will set up the Maven project.
4.  Navigate to the main application file: `src/main/java/com/edtech/classroom/main/Main.java`.
5.  Right-click on the `Main.java` file and select **Run 'Main.main()'**.
6.  The interactive terminal application will start in your IDE's run console, ready to accept commands.

---
## ⌨️ Commands for Exercise 2 (Virtual Classroom Manager)

The application accepts the following commands. Arguments that contain spaces (like assignment details) are fully supported.

| Command                                             | Description                                        |
| :-------------------------------------------------- | :------------------------------------------------- |
| `add_classroom <ClassName>`                         | Creates a new virtual classroom.                   |
| `add_student <StudentID> <ClassName>`               | Enrolls a student in a specific classroom.         |
| `schedule_assignment <ClassName> <AssignmentDetails>` | Schedules a new assignment for a class.            |
| `submit_assignment <StudentID> <ClassName> <Details>` | Marks an assignment as submitted by a student.     |
| `list_classrooms`                                   | Lists the names of all created classrooms.         |
| `list_students <ClassName>`                         | Lists all students enrolled in a specific class.   |
| `list_assignments <ClassName>`                      | Lists all assignments scheduled for a specific class. |
| `assignment_status <ClassName> <Details>`           | Shows which students have submitted an assignment. |
| `remove_classroom <ClassName>`                      | Deletes a classroom.                               |
| `exit`                                              | Shuts down the application.                        |

---
## 💡 Key Design Decisions & Features

-   **Design Patterns**:
    -   **Exercise 2** is built on the **Facade Pattern** (`VirtualClassroomManager`) to provide a simple and clean interface to the system, and the **Factory Pattern** (`EntityFactory`) to decouple object creation from the main logic.
    -   **Exercise 1** demonstrates the **Factory, Singleton, Facade, Adapter, Strategy,** and **Command** patterns to showcase a broad understanding of creational, structural, and behavioral patterns.
-   **SOLID Principles**: The code is structured to follow SOLID principles.
    -   **Single Responsibility Principle (SRP)**: Classes are separated by concern (e.g., UI, business logic, data models, logging).
    -   **Dependency Inversion Principle (DIP)**: High-level modules depend on abstractions (interfaces like `IClassroomManager` and `ILogger`) rather than concrete implementations, promoting modularity and testability.
-   **Gold Standards**:
    -   **Logging**: A decoupled logging mechanism is included to track application events and errors.
    -   **Exception Handling**: Custom, specific exceptions are used to handle errors gracefully without crashing the application.
    -   **Performance**: The application uses a `HashMap` for storing and retrieving classrooms, ensuring highly efficient (O(1)) lookups.
