package Kingdom_Quest;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class GameFileManager {

    public class SaveHelper {
        public void printSuccessMessage() {
            System.out.println("[System] File saving process completed successfully.");
        }
    }

    public void saveBattleLog(String heroName, int score) {

        StringBuilder logData = new StringBuilder();
        logData.append("=== Kingdom Quest Battle Log ===\n");
        logData.append("Hero Name: ").append(heroName).append("\n");
        logData.append("Total Score: ").append(score).append("\n");
        logData.append("Status: Victorious!\n");
        logData.append("================================\n");

        try (FileWriter writer = new FileWriter("battle_log.txt")) {
            writer.write(logData.toString());
            System.out.println(">>> [FILE I/O] Battle log successfully saved to 'battle_log.txt'");
 
            SaveHelper helper = new SaveHelper();
            helper.printSuccessMessage();
 
        } catch (IOException e) {
            System.out.println("Error saving game data: " + e.getMessage());
        }
    }

    // Aluthen ekathu karapu method eka (Serialization requirement)
    public void saveHeroObject(Hero hero) {
        try (FileOutputStream fileOut = new FileOutputStream("hero_data.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(hero);
            System.out.println(">>> [SERIALIZATION] Hero object ('" + hero.getName() + "') successfully serialized and saved!");
        } catch (IOException e) {
            System.out.println("Serialization Error: " + e.getMessage());
        }
    }
}