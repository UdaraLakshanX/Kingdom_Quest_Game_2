package Kingdom_Quest;

public class KingdomQuestMain {

    static {
        System.out.println("=========================================");
        System.out.println("   Welcome to Kingdom Quest Adventure!   ");
        System.out.println("=========================================\n");
    }

    {
        System.out.println("[System] Initializing game environment...");
    }

    public static void main(String[] args) {
        KingdomQuestMain game = new KingdomQuestMain();
        game.startGame();
    }

    public void startGame() {
        System.out.println("\n--- Loading Characters ---");
 
        Weapon sword = new Weapon("Excalibur", 50);

        Hero myHero = new Hero("Arthur", 100, HeroType.WARRIOR);

        Enemy goblin = new Enemy("Goblin", 30, EnemyType.MONSTER);
        Enemy dragon = new Enemy("Fire Dragon", 200, EnemyType.DRAGON);
        Enemy knight = new Enemy("Dark Knight", 150, EnemyType.DARK_KNIGHT);

        System.out.println("Player Profile: " + myHero.toString());
        System.out.println("Class: " + myHero.getType() + "\n");

        System.out.println("--- Testing Overloaded Attacks ---");
 
        try {
            myHero.attack(goblin);
        } catch (InvalidActionException e) {
            System.out.println("[EXCEPTION] " + e.getMessage());
        }

        myHero.attack(dragon, sword);
        myHero.attack(goblin, dragon, knight);
 
        System.out.println("----------------------------------");
 
        System.out.println("\n--- Testing Battle Thread & Synchronization ---");
 
        Leaderboard globalLeaderboard = new Leaderboard();
 
        BattleThread battle1 = new BattleThread(myHero, goblin, globalLeaderboard);
        Thread thread1 = new Thread(battle1);
 
        thread1.start();
 
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        System.out.println("\n--- Testing Generics & Collections ---");
 
        Inventory<Weapon> heroInventory = new Inventory<>();
 
        Weapon bow = new Weapon("Elven Bow", 40);
        Weapon magicStaff = new Weapon("Staff of Fire", 60);
 
        heroInventory.addItem(sword);
        heroInventory.addItem(bow);
        heroInventory.addItem(magicStaff);
 
        heroInventory.showInventory();
 
        System.out.println("\n--- Testing File I/O & StringBuilder ---");
 
        GameFileManager fileManager = new GameFileManager();
        fileManager.saveBattleLog(myHero.getName(), 250);

        System.out.println("\n--- Testing Serialization ---");
        fileManager.saveHeroObject(myHero);

        System.out.println("\n--- Testing Exception Handling (try, catch, finally) ---");
        try {
            System.out.println("[System] Setting Goblin health to 0 to trigger exception...");
            goblin.setHealth(0);
            myHero.attack(goblin); 
        } catch (InvalidActionException e) {
            System.out.println("[EXCEPTION CAUGHT] " + e.getMessage());
        } finally {
            System.out.println("[System] Attack sequence completed.");
        }
 
        System.out.println("\n[Demo Completed Successfully!]");
    }
}