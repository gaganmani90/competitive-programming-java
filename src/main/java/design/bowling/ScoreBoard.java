package design.bowling;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

@Slf4j
public class ScoreBoard {
    private Map<String, Stack<Round>> playerRounds;
    private Map<String, Integer> totalScores;
    int TOTAL_ROUNDS;
    private Game.BONUS prevBonus = Game.BONUS.NOTHING;

    public ScoreBoard(Queue<String> players, int rounds) {
        initialize(players);
        this.TOTAL_ROUNDS = rounds;
        log.info("Scoreboard created for "+players.size()+" players");
    }

    private void initialize(Queue<String> players) {
        playerRounds = new HashMap<>();
        totalScores = new HashMap<>();
        for (String player : players) {
            Stack<Round> rounds = new Stack<>();
            Round round = new Round(2, Game.BONUS.NOTHING);
            rounds.push(round);
            playerRounds.put(player, rounds);
        }
    }

    public Game.Status updateScore(String player) {
        if(isGameCompleted(player)) {
            return calculateWinner();
        }
        Game.Status status = Game.Status.IN_PROGRESS;
        Stack<Round> rounds = playerRounds.get(player);
        if (rounds.peek().isRoundCompleted()) {
            Round round = new Round(2, prevBonus);
            rounds.add(round);
        }
        log.info("ROUND: "+rounds.size()+" | PLAYER: "+player+ "");
        prevBonus = rounds.peek().play();
        return status;
    }

    private boolean isGameCompleted(String player) {
        Stack<Round> rounds = playerRounds.get(player);
        Round currRound = rounds.peek();
        if (rounds.size() >= TOTAL_ROUNDS && currRound.isRoundCompleted()) {
            totalScores.put(player,scoreByPlayer(player));
            log.info("GAME COMPLETED | PLAYER: "+player+"| SCORE: " + totalScores.get(player));
            return true;
        }
        return false;
    }


    public int scoreByPlayer(String player) {
        int totalScore = 0;
        if (playerRounds.containsKey(player)) {
            for (Round round : playerRounds.get(player)) {
                totalScore += round.getScore();
            }
        }
        return totalScore;
    }

    private Game.Status calculateWinner() {
        Game.Status status = Game.Status.IN_PROGRESS;
        if(totalScores.size() == playerRounds.size()) {
            log.info("ALL PLAYERS COMPLETED THE GAME");
            status = Game.Status.COMPLETED;

            int max = Integer.MIN_VALUE;
            String playerName = " ";
            for (String player : totalScores.keySet()) {
                if(totalScores.get(player) >= max) {
                    max = totalScores.get(player);
                    playerName = player;
                }

            }
            log.info("WINNER is :"+playerName + " with SCORE: " + max);
            printScoreReport(playerName);
        }
        return status;
    }

    private void printScoreReport(String player) {
        Stack<Round> rounds = this.playerRounds.get(player);
        int count  = rounds.size();
        log.info("==================================");
        log.info("Score report for player: "+player);
        for (Round round : rounds) {
            log.info("Round: "+count--);
            log.info(round.toString());
        }
        log.info("==================================");
    }
}
