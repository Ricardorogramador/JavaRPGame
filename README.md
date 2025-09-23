# JavaRPGame

JavaRPGame is a simple turn-based RPG game designed for practice purposes. This project aims to help learn and reinforce core Java concepts, including object-oriented programming, game loops, and random events. The game is played via the console and is currently written in English.

## Purpose

This project serves as a practical exercise to:
- Strengthen Java programming skills.
- Experiment with turn-based game logic.
- Prepare for future integration with databases using JDBC.

## Features

- Console-based gameplay.
- Basic RPG mechanics: player and monster entities, battles, leveling up, and random encounters.
- Structured classes such as `Player`, `Monster`, `Battle`, `Entity`, and game logic.
- All data currently managed in code. **Note:** In the final version, all entities and game data will be managed directly from the database.

## Upcoming Features

- **PostgreSQL Database Integration**: All game data (players, monsters, battles, etc.) will be stored and managed in a PostgreSQL database.
- **JDBC**: Database access will be handled via JDBC, providing hands-on experience with SQL and Java database connectivity.
- **DBeaver Community Edition**: Used for designing and managing the PostgreSQL database.

## Technologies

- **Java** (core language for the game)
- **PostgreSQL** (planned for storing game data)
- **JDBC** (planned for database connectivity)
- **DBeaver Community Edition** (recommended for database management and queries)

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- (Future) PostgreSQL database and DBeaver Community Edition

### Running the Project

1. Clone this repository:
    ```bash
    git clone https://github.com/Ricardorogramador/JavaRPGame.git
    ```
2. Open the project in your preferred IDE (e.g., IntelliJ IDEA).
3. Compile and run the main game class.
4. Play the game in your console.

*Database integration is not yet included. All data is currently managed in code.*

## Code Structure Example

Some of the main components include:

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

## Notes

- The game is intended for learning and experimentation, not for production use.
- All database-related features (PostgreSQL, JDBC) will be added in future commits.
- All game logic and data management will be migrated from code to database for more advanced practice.

## License

This project is open-source and free to use for learning purposes.

---

Enjoy learning Java and building your own RPG systems!
