package practice.LLD.MachineCoding.TicTacToe.Strategy.BotPlayingStrategy;

import practice.LLD.MachineCoding.TicTacToe.Entities.*;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Cell makeMove(Board board) {
        for (int i=0; i<board.getDimension(); i++){
            for (int j=0; j< board.getDimension(); j++){
                if (board.getCells().get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    return new Cell(i,j);
                }
            }
        }
        return new Cell(0,0);
    }
}
