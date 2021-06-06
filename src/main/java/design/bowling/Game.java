package design.bowling;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Getter
@Slf4j
public class Game {
    enum BONUS {
        STRIKE, SPARE, NOTHING
    }

    enum Status {
        NOT_STARTED, IN_PROGRESS, COMPLETED, STOPPED
    }

    private Queue<String> players;
    private Status status;
    private ScoreBoard scoreBoard;
    private int MAX_ROUNDS;

    public Game(int rounds) {
        status = Status.NOT_STARTED;
        players = new LinkedList<>();
        this.MAX_ROUNDS = rounds;
    }

    public Game(List<String> players, int rounds) {
        status = Status.NOT_STARTED;
        players = new LinkedList<>(players);
        this.MAX_ROUNDS = rounds;
    }

    public void start() {
        log.info("Game started...");
        this.status = Status.IN_PROGRESS;
        this.scoreBoard = new ScoreBoard(this.players, MAX_ROUNDS);
    }

    public void stop() {
        this.status = Status.STOPPED;
    }

    public void play() {
        if(!this.status.equals(Status.IN_PROGRESS)) {
            throw new IllegalStateException("Please start the game first");
        }
        int size = this.players.size();
        while(!this.status.equals(Status.COMPLETED)) {
            String player = this.players.poll();
            this.status = this.scoreBoard.updateScore(player);
            this.players.add(player);
        }
    }

    public void addPlayer(String player) {
        if (this.status.equals(Status.NOT_STARTED)) {
            this.players.add(player);
        } else {
            throw new IllegalArgumentException("Game has already started, player cannot be added");
        }
    }
}

@Getter
@Slf4j
//TODO: add List<Scores> to keep track of strike
class Round {
    private int maxChances; //list of chances in one round
    private int score;
    private int currChance;
    private Game.BONUS prevBonus;
    private Game.BONUS currBonus = Game.BONUS.NOTHING; //TODO

    public Round(int maxChances, Game.BONUS bonus) {
        this.maxChances = maxChances;
        currChance = 1;
        this.prevBonus = bonus;
    }

    public void addChance() {
        this.maxChances++;
    }

    /**
     * The bonus must be from previous round
     *
     * @return
     */
    public Game.BONUS play() {
        log.debug(this.toString());
        while(maxChances != 0) {
            if (isRoundCompleted()) {
                throw new IllegalStateException("cannot play, all chances exhausted in this round");
            }
            int currScore = randomScore();
            switch (prevBonus) {
                case NOTHING:
                    this.score += currScore;
                    break;
                case SPARE:
                    if (currChance == 1) this.score += (currScore * 2);
                    else this.score += currScore;
                    break;
                case STRIKE:
                    this.score += (currScore * 2);
                    break;
            }
            maxChances--;
            currChance++;
            log.debug(this.toString());
        }
        return bonus(this.score);
    }

    private Game.BONUS bonus(int score) {
        if (currBonus.equals(Game.BONUS.STRIKE)) {
            currBonus = Game.BONUS.STRIKE;
            log.info("You are the boss - its a strike !!");
            return Game.BONUS.STRIKE;
        } else if (this.score >= 10) {
            currBonus = Game.BONUS.SPARE;
            log.info("YES - its a spare !!");
            return Game.BONUS.SPARE;
        } else {
            return Game.BONUS.NOTHING;
        }
    }

    private int randomScore() {
        final int max_score = 10;
        int score = RandomUtils.nextInt(0, max_score + 1);
        log.info("Scored: "+score);
        if(score >= 10) {
            currBonus = Game.BONUS.STRIKE;
        }
        return score;
    }

    public boolean isRoundCompleted() {
        if (maxChances == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n Bonus: "+currBonus);
        sb.append("\n Score in this round: "+ score);
        return sb.toString();
    }
}

