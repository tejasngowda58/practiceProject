package practice.LLD.MachineCoding.TicTacToe.Strategy.BotPlayingStrategy;

import practice.LLD.MachineCoding.TicTacToe.Entities.Board;
import practice.LLD.MachineCoding.TicTacToe.Entities.Cell;
import practice.LLD.MachineCoding.TicTacToe.Entities.Move;

public interface BotPlayingStrategy {
    Cell makeMove(Board board);
}
