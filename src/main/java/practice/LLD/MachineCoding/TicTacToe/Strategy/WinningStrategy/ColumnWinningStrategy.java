package practice.LLD.MachineCoding.TicTacToe.Strategy.WinningStrategy;

import practice.LLD.MachineCoding.TicTacToe.Entities.Board;
import practice.LLD.MachineCoding.TicTacToe.Entities.Move;
import practice.LLD.MachineCoding.TicTacToe.Entities.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy{
    Map<Integer, Map<Symbol, Integer>> columns = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {


        if (!columns.containsKey(move.getCell().getCol())){
            columns.put(move.getCell().getCol(), new HashMap<>());
        }

        Map<Symbol, Integer> symbolIntegerMap = columns.get(move.getCell().getCol());
        symbolIntegerMap.put(move.getPlayer().getSymbol(), symbolIntegerMap.getOrDefault(move.getPlayer().getSymbol(), 0)+1);
//        System.out.print("Updating for the column: " + move.getCell().getCol() + " ");
//        System.out.println("Symbol " + move.getPlayer().getSymbol().getAChar() + " " + symbolIntegerMap.get(move.getPlayer().getSymbol()));
        if (columns.get(move.getCell().getCol()).get(move.getPlayer().getSymbol()) == board.getDimension()){
            return true;
        }

        return false;
    }

    public void undoMove(Move move, Board board){
        Map<Symbol, Integer> symbolIntegerMap = columns.get(move.getCell().getCol());
        symbolIntegerMap.put(move.getPlayer().getSymbol(), symbolIntegerMap.get(move.getPlayer().getSymbol())-1);
    }
}
