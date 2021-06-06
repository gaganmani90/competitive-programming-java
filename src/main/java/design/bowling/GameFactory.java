package design.bowling;

import java.util.List;

public class GameFactory {
    public static Game createNewGame(List<String> players) {
        return new Game(players, 10);
    }

    public static Game createNewGame() {
        return new Game(10);
    }

    public static Game createNewGame(int rounds) {
        return new Game(rounds);
    }
}
