package Kingdom_Quest;

public class BattleThread implements Runnable {
    private Hero hero;
    private Enemy enemy;
    private Leaderboard leaderboard;

    public BattleThread(Hero hero, Enemy enemy, Leaderboard leaderboard) {
        this.hero = hero;
        this.enemy = enemy;
        this.leaderboard = leaderboard;
    }

    @Override
    public void run() {
        System.out.println(">>> [BATTLE THREAD] Battle started between " + hero.getName() + " and " + enemy.getName() + "!");
 
        try {
            Thread.sleep(1500);
 
            System.out.println(">>> [BATTLE THREAD] " + hero.getName() + " defeated " + enemy.getName() + "!");
 
            leaderboard.addScore(50, hero.getName());
 
        } catch (InterruptedException e) {
            System.out.println("Battle was interrupted!");
        }
    }
}