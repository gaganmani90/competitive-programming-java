package design.bowling;

public class BowlingRunnerMain {
    public static void main(String[] args) {
        Game game = GameFactory.createNewGame(10);
        game.addPlayer("Gagan");
        game.addPlayer("Shivani");
        game.start();
        game.play();
    }
}
