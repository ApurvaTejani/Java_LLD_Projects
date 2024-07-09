
# LLD Projects

## 1) Tic Tac Toe Features
- **Flexible Player Count:** Supports any number of players (N) with a dynamic board size of (N+1) x (N+1).
- **Microservices Architecture:** The project is structured using a microservices architecture for better scalability and maintainability.
- **Move History:** Players can view the history of moves made during the game.
- **Undo Move:** Players have the ability to undo their last move.
- **Winning Strategy:** The initial winning strategy includes completing a row, column, or diagonal. The design allows for easy addition or modification of winning strategies in the future.


## Design Patterns used in this project

### Builder Pattern
- **Purpose:** Ensures that only valid game objects are created.
- **Implementation:** Validations are performed on the client side using the Builder pattern to guarantee the integrity of the game objects.

### Strategy Pattern
- **Purpose:** Achieves loose coupling and flexibility in the implementation of winning strategies.
- **Implementation:** Dependency Injection is used to inject different winning strategies, allowing for easy modifications and extensions.


## Class Diagram

![pic](https://github.com/ApurvaTejani/Java_LLD_Projects/assets/122258502/87248005-290d-45c1-a6e9-75dda2657b5c)
