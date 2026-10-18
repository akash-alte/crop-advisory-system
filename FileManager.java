import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private static final String FILE_NAME = "advisory_history.txt";

    public static void saveHistory(SoilData soil, String result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write("Season: " + soil.getSeason()
                    + " | Soil type: " + soil.getSoilType()
                    + " | pH: " + soil.getPH()
                    + " | Macronutrient indicator: " + soil.getMacronutrientPercentage()
                    + "% (" + soil.getFertilityGroup() + ")"
                    + " | Result: " + result);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Could not save history: " + e.getMessage());
        }
    }

    public static void displayHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean hasRecords = false;

            System.out.println("\n===== SAVED ADVISORY HISTORY =====");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                hasRecords = true;
            }

            if (!hasRecords) {
                System.out.println("No saved records yet.");
            }
        } catch (IOException e) {
            System.out.println("No saved history found yet. Generate a recommendation first.");
        }
    }
}
