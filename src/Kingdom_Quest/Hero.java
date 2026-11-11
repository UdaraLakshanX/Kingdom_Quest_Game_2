package Kingdom_Quest;

public class Hero extends Character {
    private HeroType type;
    private Integer experience;

    public Hero(String name, int health, HeroType type) {
        super(name, health);
        this.type = type;
        this.experience = 0;
    }

    public HeroType getType() {
        return type;
    }

    public Integer getExperience() {
        return experience;
    }

    public void addExperience(int exp) {
        this.experience += exp;
    }

    @Override
    public void attack() {
        System.out.println(getName() + " is attacking!");
    }
 
    public void attack(Enemy enemy) throws InvalidActionException {
        if (enemy.getHealth() <= 0) {
            throw new InvalidActionException(getName() + " cannot attack! " + enemy.getName() + " is already defeated.");
        }
        System.out.println(getName() + " attacks " + enemy.getName() + "!");
    }

    public void attack(Enemy enemy, Weapon weapon) {
        System.out.println(getName() + " attacks " + enemy.getName() + " using " + weapon.getName() + "!");
    }

    public void attack(Enemy... enemies) {
        System.out.println(getName() + " uses a multi-attack on " + enemies.length + " enemies!");
        for(Enemy e : enemies) {
            System.out.println(" - Hit " + e.getName());
        }
    }
}
