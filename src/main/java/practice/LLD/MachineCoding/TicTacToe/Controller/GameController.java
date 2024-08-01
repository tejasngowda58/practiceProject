package practice.LLD.MachineCoding.TicTacToe.Controller;

import practice.LLD.MachineCoding.TicTacToe.Entities.Game;
import practice.LLD.MachineCoding.TicTacToe.Entities.GameState;
import practice.LLD.MachineCoding.TicTacToe.Entities.Player;
import practice.LLD.MachineCoding.TicTacToe.Strategy.WinningStrategy.WinningStrategy;
import practice.LLD.MachineCoding.TicTacToe.exceptions.DuplicateSymbolException;
import practice.LLD.MachineCoding.TicTacToe.exceptions.MoreThanOneBotException;
import practice.LLD.MachineCoding.TicTacToe.exceptions.PlayersCountDimensionMismatchException;

import java.util.List;

public class GameController {

    public Game startGame(int dimensions, List<Player> players, List<WinningStrategy> winningStrategies) throws DuplicateSymbolException, PlayersCountDimensionMismatchException, MoreThanOneBotException {
        return Game.getBuilder().
                setDimensions(dimensions).
                setPlayers(players).
                setWinningStrategies(winningStrategies).
                build();
    }

    public GameState getGameStatus(Game game){
        return game.getGameState();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public void undo(Game game){
        game.undo();
    }
}
