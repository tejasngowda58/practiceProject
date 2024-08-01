package practice.LLD.MachineCoding.TicTacToe.Entities;

import java.io.InputStream;
import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    Scanner scanner = new Scanner(System.in);

    public Player(int id, String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board) {
        System.out.println("Now player " + name + "'s turn. Please enter moves");
        System.out.println("Enter the row(0 based index)");
        int row = scanner.nextInt();

        System.out.println("Enter the col(0 based index)");
        int col = scanner.nextInt();
        Move move = new Move(new Cell(row, col), this);
        return move;
    }
}
