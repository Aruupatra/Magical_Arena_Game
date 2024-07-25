# Magical Arena Game

## Overview

Magical Arena is a turn-based strategy game where two players compete using dice rolls to determine attack and defense outcomes. The game simulates combat until one player's health drops to zero.

## Features

- **Turn-Based Combat:** Players take turns attacking and defending.
- **Dice Mechanics:** Uses 6-sided dice to calculate attack and defense values.
- **Health Management:** Players' health decreases based on the outcome of combat.
- **Game End:** The game ends when a player's health reaches zero.

## Prerequisites

- **Java 21** or later: Ensure you have Java 21 or later installed.
- **Maven**: For building and managing project dependencies.

## How to Run the Code

### 1. Unzip the File

Download and unzip the provided `.zip` file. It contains the project directory with all necessary files and the `.git` history.

### 2. Navigate to the Project Directory

Open a terminal or command prompt and navigate to the unzipped project directory:

```sh
cd path/to/unzipped/project

### 3. Build the Project
mvn clean install

### 4. Run the Application
java -jar target/magical-arena.jar

### 5. Run tests
mvn test

