package Kingdom_Quest;

import java.io.Serializable;

public abstract class Character implements Serializable {
    private String name;
    private int health;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract void attack();

    @Override
    public String toString() {
        return "Name: " + name + " | Health: " + health;
    }
}
