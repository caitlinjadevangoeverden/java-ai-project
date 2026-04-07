# Clue Game AI & Logic Solver

A Java-based simulation of the board game *Clue*, featuring both:

*  A **scripted deduction engine** (rule-based reasoning)
*  An **AI-driven solver** that learns through scoring and inference

---

##  Features

###  Scripted Game (Murder 1)

* Simulates a real Clue game with predefined moves
* Uses elimination logic to deduce:

  * Suspect
  * Weapon
  * Room
* Tracks deductions step-by-step

###  AI Game (Murder 3)

* Dynamically generates guesses
* Uses a scoring system to:

  * Increase confidence in likely cards
  * Eliminate impossible ones
* Learns from:

  * Refutations
  * Card reveals
* Produces a final AI-driven accusation

---

##  Key Concepts

* Object-Oriented Design (Java)
* State management via `GameState`
* Separation of concerns:

  * `ClueProgram` → entry point
  * `ClueGame` → shared logic/utilities
  * `ScriptedGame` → deterministic gameplay
  * `AIGame` → AI logic + scoring
* Rule-based reasoning vs heuristic AI

---

##  Project Structure

```
.
├── ClueProgram.java   // Main entry point
├── ClueGame.java      // Shared game logic
├── ScriptedGame.java  // Predefined game simulation
├── AIGame.java        // AI-based gameplay
├── GameState.java     // AI scoring state
└── output/            // Generated result files
```

---

##  How to Run

### 1. Compile

```bash
javac *.java
```

### 2. Run

```bash
java ClueProgram
```

---

##  Output

Results are written to the `output/` folder:

* `murder1_results.txt`
* `murder3_results.txt`

Each file contains:

* Suggestions
* Refutations
* Deductions
* Final accusation

---

##  Future Improvements

* Smarter AI (probabilistic reasoning / Bayesian updates)
* Prevent repeated guesses
* GUI visualization of the game board
* Multiplayer simulation

---

##  Author

**Caitlin van Goeverden**

This project demonstrates:

* Problem-solving through logic systems
* AI-style heuristic reasoning
* Clean code organization across multiple classes

---
