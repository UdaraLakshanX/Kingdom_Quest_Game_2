package Kingdom_Quest;

public class Leaderboard {
    private int totalScore = 0;

    public synchronized void addScore(int score, String heroName) {
        totalScore += score;
        System.out.println("[Leaderboard Update] " + heroName + " earned " + score + " points! (Total Score: " + totalScore + ")");
    }
}
