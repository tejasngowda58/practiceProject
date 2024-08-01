package practice.LLD.MachineCoding.TicTacToe.Entities;

import practice.LLD.MachineCoding.TicTacToe.Strategy.BotPlayingStrategy.BotPlayingStrategy;
import practice.LLD.MachineCoding.TicTacToe.Strategy.BotPlayingStrategy.EasyBotPlayingStrategy;

public class Bot extends Player{
    private BotDifficulty botDifficulty;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(int id, String name, Symbol symbol, BotDifficulty botDifficulty){
        super(id, name, symbol, PlayerType.BOT);
        this.botDifficulty = botDifficulty;
        this.botPlayingStrategy = new EasyBotPlayingStrategy();
        // Todo botPlayingStrategy = add a factory
    }

    @Override
    public Move makeMove(Board board) {
        Cell cell = botPlayingStrategy.makeMove(board);
        return new Move(cell, this);
    }
}
