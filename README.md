# JavaRPGame

**JavaRPGame** is a console-based, turn-based RPG developed as a self-study project to practice and improve Java skills. It features player and monster management, battles, stat progression, and is designed with clean, modular architecture. The game is written in English and intended primarily for learning and experimentation.

---

## Purpose

This project was created for personal study, covering:
- Object-oriented programming in Java.
- Turn-based RPG mechanics and game loop design.
- Database integration with JDBC and PostgreSQL (planned).

---

## Features

- Console-based, turn-based RPG gameplay.
- Player and monster entities, stat management, random encounters, and leveling.
- Modular package and class structure for organization and maintainability.
- All entities and game data currently managed in code (database integration planned).

---

## Project Structure

```
src/
├── controller/
│   ├── GameLoop.java
│   └── PlayerCreation.java
├── DBConnection/
│   ├── DBConnection.java
│   ├── MonsterDAO.java
│   └── PlayerDAO.java
├── model/
│   ├── Entity.java
│   ├── Monster.java
│   ├── Player.java
│   ├── Race.java
│   └── Battle.java
├── service/
│   ├── Battle/
│   │   ├── BattleLogic.java
│   │   ├── PotionLogic.java
│   │   └── RandomBattleGenerator.java
│   ├── combat/
│   │   ├── DamageCalculator.java
│   │   ├── DefenseCalculator.java
│   │   ├── HitMissChanceMonster.java
│   │   ├── HitMissChancePlayer.java
│   │   ├── HumanCritChance.java
│   │   ├── MonsterCritChance.java
│   │   └── PlayerCounterAttack.java
│   ├── event/
│   │   └── RestEvent.java
│   ├── player/
│   │   ├── HumanLvlUp.java
│   │   ├── InitializePlayer.java
│   │   ├── StatsDistributor.java
│   │   └── UpdateStats.java
├── interfaces/
│   └── [Various game interfaces]
└── Main.java
```

---

## Package Overview

### controller
- **GameLoop.java**: Manages the main gameplay loop, exploration, and event/battle triggers.
- **PlayerCreation.java**: Handles creating or selecting player characters.

### DBConnection
- **DBConnection.java**: Database connection management (PostgreSQL).
- **MonsterDAO.java** / **PlayerDAO.java**: CRUD operations for Monster and Player entities.

### model
- **Entity.java**: Abstract base class for all entities (Player, Monster).
- **Player.java**: Player character, with stats, XP, level, and potions.
- **Monster.java**: Enemy characters, XP rewards, and level.
- **Race.java**: Enum for character races.
- **Battle.java**: Stores battle metadata (participants, result, XP).

### service

#### Battle
- **BattleLogic.java**: Handles turns, attacking, and defending.
- **PotionLogic.java**: Manages potion usage and restoration.
- **RandomBattleGenerator.java**: Generates random encounters.

#### combat
- **DamageCalculator.java** / **DefenseCalculator.java**: Damage and defense calculations.
- **HitMissChanceMonster.java** / **HitMissChancePlayer.java**: Hit/miss probabilities.
- **HumanCritChance.java** / **MonsterCritChance.java**: Critical hit calculations.
- **PlayerCounterAttack.java**: Counterattack logic.

#### event
- **RestEvent.java**: Rest and recovery events during exploration.

#### player
- **HumanLvlUp.java**: Leveling up and XP management for humans.
- **InitializePlayer.java**: Player creation and stat initialization.
- **StatsDistributor.java**: Stat distribution interface.
- **UpdateStats.java**: Updates player stats.

### interfaces
- Game logic interfaces for extensibility (e.g., hit/miss, level up, initialization).

---

## Game Flow

1. **Player Creation / Selection**
    - New players are created or existing ones loaded from the database.
    - Players are initialized with race, stats, and status.

2. **Exploration**
    - Players choose an area and number of steps.
    - Each step may trigger a battle, rest event, or neutral event.

3. **Battle System**
    - Turn-based battles: attack, defend, use potions.
    - Outcomes depend on stats, random chance, and critical hits.
    - XP and level progression, manual stat distribution.

4. **Persistence**
    - Player and monster states managed in PostgreSQL (planned).

---

## Technologies

- **Java**: Core language.
- **PostgreSQL**: Database for storing game entities and battles (planned).
- **JDBC**: Java Database Connectivity.
- **DBeaver Community Edition**: Database management.

---

## Upcoming Features

- **Main Hub**: A central area for players, offering access to a shop, quest board for accepting missions, and an inn for resting and recovery. Players can also leave the hub to explore different zones.
- **Magic Skills**: New magical abilities for players, increasing strategic combat options and character customization.
- **Gold System Update**: The model will be updated to support gold acquisition, storage, and spending.
- **Shop**: In-game store to buy/sell items, equipment, and potions using gold.
- **Inn**: Resting place within the hub to recover health and mana.
- **Quest System**: Ability to accept, track, and complete missions for rewards and progression.

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

*All game data currently managed in code. Database integration will be added soon.*

---

## License

This project is open-source and free to use for learning, studying, or personal exploration.

---

Thank you for checking out the project!
