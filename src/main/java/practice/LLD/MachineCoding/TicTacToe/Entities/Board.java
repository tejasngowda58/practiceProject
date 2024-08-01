package practice.LLD.MachineCoding.TicTacToe.Entities;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> cells;
    private int dimension;

    public Board(int dimension){
        this.dimension = dimension;
        this.cells = new ArrayList<>();
        for (int i=0; i<this.dimension; i++){
            cells.add(new ArrayList<>());
        }

        for (int i=0; i<this.dimension; i++) {
            for (int j=0; j<this.dimension; j++) {
                cells.get(i).add(new Cell(i, j));
            }
        }
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getDimension() {
        return dimension;
    }

    public void printBoard() {
        for (int i=0; i<dimension; i++){
            for (int j=0; j<dimension; j++){
                cells.get(i).get(j).printCell();
            }
            System.out.println();
        }
    }
}
