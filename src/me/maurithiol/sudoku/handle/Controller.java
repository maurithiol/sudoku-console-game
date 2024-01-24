package me.maurithiol.sudoku.handle;

public class Controller {

    private final Game game;
    private Move lastMove;

    public Controller() {
        game = new Game();
        game.initializeGame();
    }

    public void run() {
        while (!game.hasEnded()) {
            System.out.println(game.getBoard());
            lastMove = game.getConsole().play(lastMove);
            try {
                game.updateGame(lastMove);
            } catch (IllegalMoveException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The grid has been solved");
        System.out.println(game.getBoard());
    }

}