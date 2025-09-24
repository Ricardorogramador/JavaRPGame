# JavaRPGame

**JavaRPGame** is a simple turn-based RPG console game developed as a self-study project to practice and improve my Java skills. The main goal is to learn core Java concepts, experiment with game logic, and eventually integrate a database using JDBC. The game is written in English and is designed primarily for personal learning and exploration.

---

## Purpose

This project was created for my own study and experimentation, covering topics such as:
- Object-oriented programming in Java.
- Turn-based RPG mechanics and game loop design.
- Preparation for integrating a relational database using JDBC.

---

## Features

- Console-based, turn-based RPG gameplay.
- Basic mechanics including player and monster entities, random encounters, battles, leveling, and stat management.
- All core data and logic currently managed within the codebase.
- Clear package and class structure for organization and maintainability.

**Note:** In the final version, all entities and game data will be managed directly from a PostgreSQL database.

---

## Project Structure

The main packages and important classes are:

```
Controller/
  └── GameLoop.java

Interfaces/
  ├── EventsInterface.java
  ├── InitializePlayerInterface.java
  └── LevelUpStrategy.java

model/
  ├── Battle.java
  ├── Entity.java
  ├── Monster.java
  ├── Player.java
  └── Race.java

Service_Logic/
  ├── BattleLogic.java
  ├── HumanLvlUp.java
  ├── InitializePlayer.java
  ├── RandomBattleGenerator.java
  ├── RestEvent.java
  ├── StatsDistributor.java
  └── UpdateStats.java

Main.java
```

---

## Planned Technologies

- **Java**: Core programming language.
- **PostgreSQL**: All game data (players, monsters, battles, etc.) will eventually be stored and managed in a PostgreSQL database.
- **JDBC**: Java Database Connectivity for interacting with the database.
- **DBeaver Community Edition**: For designing and managing the PostgreSQL database.

---

## Upcoming Features

- Migration of all game data to PostgreSQL via JDBC.
- More advanced battle logic and entity management.
- Improved code structure for better maintainability and extensibility.

---

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher.
- (Future) PostgreSQL, DBeaver Community Edition.

### Running the Game

1. Clone the repository:
    ```bash
    git clone https://github.com/Ricardorogramador/JavaRPGame.git
    ```
2. Open the project in your preferred IDE (e.g., IntelliJ IDEA).
3. Compile and run `Main.java`.
4. Play the game in your console!

*All game data is currently managed in code. Database integration will be added in the future.*

---

---

## License

This project is open-source and free to use for learning, studying, or personal exploration.

---

Thank you for checking out the project!