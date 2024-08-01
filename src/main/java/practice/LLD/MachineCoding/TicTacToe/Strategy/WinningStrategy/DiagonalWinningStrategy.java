package practice.LLD.MachineCoding.TicTacToe.Strategy.WinningStrategy;

import practice.LLD.MachineCoding.TicTacToe.Entities.Board;
import practice.LLD.MachineCoding.TicTacToe.Entities.Move;
import practice.LLD.MachineCoding.TicTacToe.Entities.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{
    Map<Symbol, Integer> leftDiagonal = new HashMap<>();
    Map<Symbol, Integer> rightDiagonal = new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {


        if (move.getCell().getRow() == move.getCell().getCol()){
            leftDiagonal.put(move.getPlayer().getSymbol(), leftDiagonal.getOrDefault(move.getPlayer().getSymbol(), 0) +1);
//            System.out.println("Symbol " + move.getPlayer().getSymbol().getAChar() + " " + leftDiagonal.get(move.getPlayer().getSymbol()));
            if (leftDiagonal.get(move.getPlayer().getSymbol()) == board.getDimension())
                return true;
        }

        if (move.getCell().getRow()+move.getCell().getCol() == board.getDimension()-1){
            rightDiagonal.put(move.getPlayer().getSymbol(), rightDiagonal.getOrDefault(move.getPlayer().getSymbol(), 0) +1);
//            System.out.println("Symbol " + move.getPlayer().getSymbol().getAChar() + " " + rightDiagonal.get(move.getPlayer().getSymbol()));
            if (rightDiagonal.get(move.getPlayer().getSymbol()) == board.getDimension())
                return true;
        }

        return false;
    }

    public void undoMove(Move move, Board board){
        if (move.getCell().getRow() == move.getCell().getCol()) {
            leftDiagonal.put(move.getPlayer().getSymbol(), leftDiagonal.get(move.getPlayer().getSymbol()) - 1);
        }
        if (move.getCell().getRow()+move.getCell().getCol() == board.getDimension()-1) {
            rightDiagonal.put(move.getPlayer().getSymbol(), rightDiagonal.get(move.getPlayer().getSymbol()) - 1);
        }
    }
}
