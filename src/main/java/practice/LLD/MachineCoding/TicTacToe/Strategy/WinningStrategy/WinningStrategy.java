package practice.LLD.MachineCoding.TicTacToe.Strategy.WinningStrategy;

import practice.LLD.MachineCoding.TicTacToe.Entities.Board;
import practice.LLD.MachineCoding.TicTacToe.Entities.Move;

public interface WinningStrategy {
    public boolean checkWinner(Move move, Board board);

    public void undoMove(Move move, Board board);
}
