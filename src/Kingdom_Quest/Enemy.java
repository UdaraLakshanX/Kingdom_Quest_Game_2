package Kingdom_Quest;

public class Enemy extends Character {
    private EnemyType type;

    public Enemy(String name, int health, EnemyType type) {
        super(name, health);
        this.type = type;
    }

    public EnemyType getType() {
        return type;
    }

    @Override
    public void attack() {
        System.out.println(getName() + " (Enemy) is attacking!");
    }
}