package practice.LLD.MachineCoding.TicTacToe;

import practice.LLD.MachineCoding.TicTacToe.Controller.GameController;
import practice.LLD.MachineCoding.TicTacToe.Entities.*;
import practice.LLD.MachineCoding.TicTacToe.Strategy.WinningStrategy.ColumnWinningStrategy;
import practice.LLD.MachineCoding.TicTacToe.Strategy.WinningStrategy.DiagonalWinningStrategy;
import practice.LLD.MachineCoding.TicTacToe.Strategy.WinningStrategy.RowWinningStrategy;
import practice.LLD.MachineCoding.TicTacToe.Strategy.WinningStrategy.WinningStrategy;
import practice.LLD.MachineCoding.TicTacToe.exceptions.DuplicateSymbolException;
import practice.LLD.MachineCoding.TicTacToe.exceptions.MoreThanOneBotException;
import practice.LLD.MachineCoding.TicTacToe.exceptions.PlayersCountDimensionMismatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DuplicateSymbolException, PlayersCountDimensionMismatchException, MoreThanOneBotException {

        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Tejas", new Symbol('x'), PlayerType.HUMAN));
        players.add(new Player(2, "Nisarga", new Symbol('o'), PlayerType.HUMAN));

        List<WinningStrategy> winningStrategies = new ArrayList<>(List.of(new RowWinningStrategy(), new ColumnWinningStrategy(), new DiagonalWinningStrategy()));
        Game game = gameController.startGame(3, players, winningStrategies);

        while (gameController.getGameStatus(game).equals(GameState.IN_PROGRESS) ) {
            gameController.printBoard(game);
            gameController.makeMove(game);

            System.out.println("Do u want to undo the move. Press 'y' to undo, else press 'n'");
            String undoDecision = scanner.next();
            while (undoDecision.equals("y")){
                gameController.undo(game);
                System.out.println("Do u want to undo the move. Press 'y' to undo, else press 'n'");
                undoDecision = scanner.next();
            }
        }

        gameController.printBoard(game);
        if (gameController.getGameStatus(game).equals(GameState.WON)){
            System.out.println("We have a winner");
        }
        if (gameController.getGameStatus(game).equals(GameState.DRAWN)){
            System.out.println("MatchDrawn");
        }

    }
}
