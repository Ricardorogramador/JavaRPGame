# JavaRPGame

JavaRPGame is a simple turn-based RPG console game developed as a self-study project to practice and improve my Java skills. The main purpose is to learn core Java concepts, experiment with game logic, and later, integrate a database using JDBC. The game is written in English and designed primarily for personal learning and exploration.

## Purpose

This project was created for my own study and experimentation, covering topics such as:
- Object-oriented programming in Java.
- Turn-based RPG mechanics and game loop design.
- Preparation for integrating a relational database using JDBC.

## Features

- Console-based turn-based RPG gameplay.
- Basic mechanics including player and monster entities, random encounters, battles, leveling, and stats.
- All core data and logic currently managed within the codebase.
- Classes include `Player`, `Monster`, `Entity`, `Battle`, and game logic components.

**Note:** In the final version, all entities and game data will be managed directly from a PostgreSQL database.

## Planned Technologies

- **Java**: Core language for the project.
- **PostgreSQL**: All game data (players, monsters, battles, etc.) will eventually be stored and managed in a PostgreSQL database.
- **JDBC**: Java Database Connectivity for interacting with the database.
- **DBeaver Community Edition**: To design and manage the PostgreSQL database.

## Upcoming Features

- Migration of all game data management to PostgreSQL via JDBC.
- More advanced battle logic and entity management.
- Improved code structure for maintainability and extensibility.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher.
- (Future) PostgreSQL, DBeaver Community Edition.

### Running the Game

1. Clone the repository:
    ```bash
    git clone https://github.com/Ricardorogramador/JavaRPGame.git
    ```
2. Open the project in your preferred IDE (e.g. IntelliJ IDEA).
3. Compile and run the main game class.
4. Play the game in your console.

*All game data is currently managed in code. Database integration will be added in the future.*

## Code Example

Some of the main components:

```java
public class GameLoop {
    public void gameLoop() {
        // Main turn-based loop logic
    }
}

public abstract class Entity {
    // Common attributes for Player and Monster
}
```

## License

This project is open-source and free to use for observation or personal learning.

---

Thank you for checking out the project!
