package practice.LLD.MachineCoding.TicTacToe.Strategy.WinningStrategy;

import practice.LLD.MachineCoding.TicTacToe.Entities.Board;
import practice.LLD.MachineCoding.TicTacToe.Entities.Move;
import practice.LLD.MachineCoding.TicTacToe.Entities.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{
    Map<Integer, Map<Symbol, Integer>> rows = new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {


        if (!rows.containsKey(move.getCell().getRow())){
            rows.put(move.getCell().getRow(), new HashMap<>());
        }

        Map<Symbol, Integer> symbolIntegerMap = rows.get(move.getCell().getRow());
        symbolIntegerMap.put(move.getPlayer().getSymbol(), symbolIntegerMap.getOrDefault(move.getPlayer().getSymbol(), 0)+1);
//        System.out.print("Updating for the row: " + move.getCell().getRow() + " ");
//        System.out.println("Symbol " + move.getPlayer().getSymbol().getAChar() + " " + symbolIntegerMap.get(move.getPlayer().getSymbol()));
        if (rows.get(move.getCell().getRow()).get(move.getPlayer().getSymbol()) == board.getDimension()){
            return true;
        }

        return false;
    }

    public void undoMove(Move move, Board board){
        Map<Symbol, Integer> symbolIntegerMap = rows.get(move.getCell().getRow());
        symbolIntegerMap.put(move.getPlayer().getSymbol(), symbolIntegerMap.get(move.getPlayer().getSymbol())-1);
    }
}
