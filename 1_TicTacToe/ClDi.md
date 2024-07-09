classDiagram
direction TB
class Board {
  + Board(int) 
  - int dimensions
  - List~List~Cell~~ board
  + getDimensions() int
  + getBoard() List~List~Cell~~
  + setBoard(List~List~Cell~~) void
  + display() void
}
class Bot {
  + Bot(char, String, PlayerType, BotDifficuiltyLevel) 
  - BotPlayingStrategy bps
  - BotDifficuiltyLevel bdl
}
class BotDifficuiltyLevel {
<<enumeration>>
  + BotDifficuiltyLevel() 
  +  HARD
  +  EASY
  +  MEDIUM
  + values() BotDifficuiltyLevel[]
  + valueOf(String) BotDifficuiltyLevel
}
class BotPlayingStrategy {
  + BotPlayingStrategy() 
}
class Cell {
  + Cell(int, int) 
  - int row
  - Player player
  - int col
  - CellState cellState
  + setRow(int) void
  + setPlayer(Player) void
  + getRow() int
  + setCol(int) void
  + getCol() int
  + getCellState() CellState
  + setCellState(CellState) void
  + getPlayer() Player
}
class CellAlreadyFilledException {
  + CellAlreadyFilledException(String) 
}
class CellState {
<<enumeration>>
  + CellState() 
  +  FILLED
  +  EMPTY
  + valueOf(String) CellState
  + values() CellState[]
}
class Game {
  - Game() 
  - Board board
  - GameWinningStrategy gws
  - Player winner
  - List~Move~ moves
  - List~Player~ players
  - int currentPlayerIndex
  - GameStatus gamestatus
  ~ int reservedPositionForUndo
  + setCurrentPlayerIndex(int) void
  + getBuilder() Builder
  + undo() void
  + makeNextMove() void
  + setGamestatus(GameStatus) void
  + getGamestatus() GameStatus
  + setBoard(Board) void
  + setGws(GameWinningStrategy) void
  + displayBoard() void
  + setPlayers(List~Player~) void
  + setMoves(List~Move~) void
}
class GameController {
  + GameController() 
  + createGame(int, List~Player~) Game
  + undo(Game) void
  + displayBoard(Game) void
  + getGameStatus(Game) GameStatus
  + executeNextMove(Game) void
}
class GameStatus {
<<enumeration>>
  + GameStatus() 
  +  IN_PROGRESS
  +  DRAW
  +  WIN
  + values() GameStatus[]
  + valueOf(String) GameStatus
}
class GameWinningStrategy {
<<Interface>>
  + checkWinner(Board, Player, Cell) boolean
}
class IllegalIndexPassedByUser {
  + IllegalIndexPassedByUser(String) 
}
class InvalidGameConstructorParameterException {
  + InvalidGameConstructorParameterException(String) 
}
class Move {
  + Move(Player, Cell) 
  - Player player
  - Cell cell
  + getPlayer() Player
  + setCell(Cell) void
  + getCell() Cell
  + setPlayer(Player) void
}
class OrderOneGameWinningStrategy {
  + OrderOneGameWinningStrategy(int) 
  ~ List~HashMap~Character, Integer~~ rowCount
  ~ List~HashMap~Character, Integer~~ colCount
  ~ HashMap~Character, Integer~ topRightDiag
  ~ HashMap~Character, Integer~ topLeftDiag
  + isTopRightDiag(int, int, int) boolean
  + checkWinner(Board, Player, Cell) boolean
  + isTopLeftDiag(int, int) boolean
}
class Player {
  + Player(char, String, PlayerType) 
  - PlayerType type
  - char symbol
  - String name
  + setType(PlayerType) void
  + getName() String
  + decideMove(Board) Move
  + setName(String) void
  + getSymbol() char
  + getType() PlayerType
  + setSymbol(char) void
}
class PlayerType {
<<enumeration>>
  + PlayerType() 
  +  BOT
  +  HUMAN
  + values() PlayerType[]
  + valueOf(String) PlayerType
}
class TicTacToeClient {
  + TicTacToeClient() 
  + main(String[]) void
}

Board  ..>  Cell : «create»
Bot "1" *--> "bdl 1" BotDifficuiltyLevel 
Bot "1" *--> "bps 1" BotPlayingStrategy 
Bot  -->  Player 
Cell "1" *--> "cellState 1" CellState 
Cell "1" *--> "player 1" Player 
Game "1" *--> "board 1" Board 
Game  ..>  CellAlreadyFilledException : «create»
Game "1" *--> "gamestatus 1" GameStatus 
Game "1" *--> "gws 1" GameWinningStrategy 
Game  ..>  Move : «create»
Game "1" *--> "moves *" Move 
Game "1" *--> "players *" Player 
Move "1" *--> "cell 1" Cell 
Move "1" *--> "player 1" Player 
OrderOneGameWinningStrategy  ..>  GameWinningStrategy 
Player  ..>  Cell : «create»
Player  ..>  IllegalIndexPassedByUser : «create»
Player  ..>  Move : «create»
Player "1" *--> "type 1" PlayerType 
TicTacToeClient  ..>  Bot : «create»
TicTacToeClient  ..>  GameController : «create»
TicTacToeClient  ..>  Player : «create»
