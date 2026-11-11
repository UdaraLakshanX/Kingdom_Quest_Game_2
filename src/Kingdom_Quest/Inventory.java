package Kingdom_Quest;

import java.util.ArrayList;
import java.util.List;

public class Inventory<T> {
 
    private List<T> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);

        if (item instanceof Weapon) {
            System.out.println(">>> [INVENTORY] Added Weapon: " + ((Weapon) item).getName());
        } else {
            System.out.println(">>> [INVENTORY] Added Item: " + item.toString());
        }
    }

    public void showInventory() {
        System.out.println("\n--- Player Inventory ---");
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (T item : items) {
                if (item instanceof Weapon) {
                    System.out.println("- " + ((Weapon) item).getName() + " (Damage: " + ((Weapon) item).getDamage() + ")");
                }
            }
        }
        System.out.println("------------------------");
    }
}
