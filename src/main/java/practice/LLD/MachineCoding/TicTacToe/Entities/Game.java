package practice.LLD.MachineCoding.TicTacToe.Entities;

import practice.LLD.MachineCoding.TicTacToe.Strategy.WinningStrategy.WinningStrategy;
import practice.LLD.MachineCoding.TicTacToe.exceptions.DuplicateSymbolException;
import practice.LLD.MachineCoding.TicTacToe.exceptions.MoreThanOneBotException;
import practice.LLD.MachineCoding.TicTacToe.exceptions.PlayersCountDimensionMismatchException;

import java.util.*;

public class Game {
    private List<Player> players;
    private Board board;
    private GameState gameState;
    private List<Move> moves;
    private List<WinningStrategy> winningStrategies;
    private Player winner;
    private int nextMovePlayerIndex;
    private Scanner scanner = new Scanner(System.in);

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
        this.players = players;
        this.gameState = GameState.IN_PROGRESS;
        this.winningStrategies = winningStrategies;
        this.moves = new ArrayList<>();
        this.nextMovePlayerIndex = 0;
        this.board = new Board(dimension);
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public void printBoard() {
        board.printBoard();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public void makeMove() {
        Player currentPlayingTurnPlayer = players.get(nextMovePlayerIndex);
        Move move = currentPlayingTurnPlayer.makeMove(board);

        while (!validateMove(move)){
            System.out.println("Invalid move, please make move again");
            move = currentPlayingTurnPlayer.makeMove(board);
        }

        Cell cellToChange = board.getCells().get(move.getCell().getRow()).get(move.getCell().getCol());
        cellToChange.setPlayer(currentPlayingTurnPlayer);
        cellToChange.setCellState(CellState.FILLED);

        if (checkWinner(move, board)){
            winner = currentPlayingTurnPlayer;
            return;
        }

        Move addMoveToMoveList = new Move(cellToChange, currentPlayingTurnPlayer);
        moves.add(addMoveToMoveList);

        nextMovePlayerIndex++;
        nextMovePlayerIndex = (nextMovePlayerIndex % (getBoard().getDimension()-1));

        if (moves.size() == board.getDimension()*board.getDimension())
            gameState=GameState.DRAWN;

    }

    public void undo(){
        Move moveToRemove = moves.get(moves.size() - 1);
        moves.remove(moveToRemove);

        moveToRemove.getCell().setCellState(CellState.EMPTY);
        moveToRemove.getCell().setPlayer(null);

        nextMovePlayerIndex--;
//        nextMovePlayerIndex = (nextMovePlayerIndex+getBoard().getDimension()-1)%getBoard().getDimension()-1;

        for (WinningStrategy winningStrategy: winningStrategies){
            winningStrategy.undoMove(moveToRemove, board);
        }
    }

    private boolean checkWinner(Move move, Board board) {
        for (WinningStrategy winningStrategy: winningStrategies){
            if (winningStrategy.checkWinner(move, board)){
                gameState = GameState.WON;
                return true;
            }
        }
        return false;
    }

    private Boolean validateMove(Move move) {
        if (board.getCells().get(move.getCell().getRow()).get(move.getCell().getCol()).getCellState()==CellState.FILLED){
            System.out.println("You are trying to fill in non-empty cell");
            return false;
        }

        if (move.getCell().getRow()>= board.getDimension() || move.getCell().getRow()<0)
            return false;
        if (move.getCell().getCol()>= board.getDimension() || move.getCell().getCol()<0)
            return false;
        return true;
    }

    public static class Builder {
        private int dimensions;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        private Builder(){
            this.dimensions = 0;
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
        }

        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder addPlayer(Player player){
            players.add(player);
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder addWinningStrategies(WinningStrategy winningStrategy){
            this.winningStrategies.add(winningStrategy);
            return this;
        }

        public Game build() throws DuplicateSymbolException, PlayersCountDimensionMismatchException, MoreThanOneBotException {
            validate();
            return new Game(dimensions, players, winningStrategies);
        }

        private void validate() throws MoreThanOneBotException, PlayersCountDimensionMismatchException, DuplicateSymbolException {
            validateBotCounts();
            validateUniqueSymbolsForPlayers();
            validateDimensionsAndPlayersCount();
        }

        private void validateUniqueSymbolsForPlayers() throws DuplicateSymbolException{
            Set<Character> playersSet = new HashSet();
            for (Player player: players){
                playersSet.add(player.getSymbol().getAChar());
            }
            if (playersSet.size()!= players.size())
                throw new DuplicateSymbolException();
        }

        private void validateDimensionsAndPlayersCount() throws PlayersCountDimensionMismatchException {
            if (players.size() != dimensions-1){
                throw new PlayersCountDimensionMismatchException();
            }
        }

        private void validateBotCounts() throws MoreThanOneBotException {
            int botCount = 0;
            for (Player player: players) {
                if (player.getPlayerType()==PlayerType.BOT)
                    botCount++;

                if (botCount>1)
                    throw new MoreThanOneBotException();
            }
        }
    }
}
