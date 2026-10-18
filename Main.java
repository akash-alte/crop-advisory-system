import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CropAdvisor[] advisors = {
            new KharifAdvisor(),
            new RabiAdvisor(),
            new ZaidAdvisor()
        };

        while (true) {
            System.out.println("\n===== CROP ADVISORY SYSTEM =====");
            System.out.println("1. Get crop recommendations");
            System.out.println("2. View crop list by season");
            System.out.println("3. View saved history");
            System.out.println("4. Exit");

            int choice = readInt("Choose an option (1-4): ", 1, 4);

            switch (choice) {
                case 1:
                    getRecommendations(advisors);
                    break;
                case 2:
                    showAllCrops(advisors);
                    break;
                case 3:
                    FileManager.displayHistory();
                    break;
                case 4:
                    System.out.println("Thank you for using Crop Advisory System.");
                    scanner.close();
                    return;
                default:
                    // readInt prevents this branch from being reached.
                    break;
            }
        }
    }

    private static void getRecommendations(CropAdvisor[] advisors) {
        System.out.println("\nSelect soil type:");
        System.out.println("1. Alluvial  2. Black  3. Red");
        System.out.println("4. Sandy     5. Clayey 6. Loamy");
        String[] soilTypes = {"Alluvial", "Black", "Red", "Sandy", "Clayey", "Loamy"};
        String soilType = soilTypes[readInt("Enter soil type (1-6): ", 1, 6) - 1];

        double pH = readDouble("Enter soil pH (0-14): ", 0.0, 14.0);
        double nutrientPercent = readDouble(
            "Enter combined macronutrient indicator percentage (0-100): ", 0.0, 100.0);

        System.out.println("\nSelect season:");
        System.out.println("1. Kharif  2. Rabi  3. Zaid");
        String[] seasons = {"Kharif", "Rabi", "Zaid"};
        String season = seasons[readInt("Enter season (1-3): ", 1, 3) - 1];

        SoilData soil = new SoilData(soilType, pH, nutrientPercent, season);
        System.out.println("\nFertility indicator group: " + soil.getFertilityGroup());
        System.out.println("Low: 0-33%, Medium: above 33-66%, High: above 66-100%");

        CropAdvisor selectedAdvisor = findAdvisor(advisors, season);
        List<Crop> suitableCrops = selectedAdvisor.getSuitableCrops(soil);

        if (suitableCrops.isEmpty()) {
            System.out.println("\nNo crop in the selected season matched all the rules.");
            System.out.println("Check the soil type, pH, fertility group, and season.");
            FileManager.saveHistory(soil, "No suitable crop found");
            return;
        }

        System.out.println("\nSuitable crop(s):");
        StringBuilder cropNames = new StringBuilder();
        for (Crop crop : suitableCrops) {
            System.out.println("- " + crop.getName() + " — " + crop.getAdvice());
            if (cropNames.length() > 0) {
                cropNames.append(", ");
            }
            cropNames.append(crop.getName());
        }

        FileManager.saveHistory(soil, cropNames.toString());
        System.out.println("\nThese are educational rule-based suggestions, not a guarantee of yield.");
    }

    private static CropAdvisor findAdvisor(CropAdvisor[] advisors, String season) {
        for (CropAdvisor advisor : advisors) {
            if (advisor.getSeason().equals(season)) {
                return advisor;
            }
        }
        // The season is selected from a validated menu, so this is only a safety fallback.
        throw new IllegalArgumentException("Unknown season: " + season);
    }

    private static void showAllCrops(CropAdvisor[] advisors) {
        System.out.println("\n===== CROPS BY SEASON =====");
        for (CropAdvisor advisor : advisors) {
            System.out.println("\n" + advisor.getSeason() + ":");
            for (Crop crop : advisor.getAllCrops()) {
                System.out.println("- " + crop.getName());
            }
        }
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
                // Show the same helpful message for non-numeric input.
            }
            System.out.println("Invalid input. Enter a whole number from " + min + " to " + max + ".");
        }
    }

    private static double readDouble(String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (Double.isFinite(value) && value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
                // Handles text such as "abc".
            }
            System.out.println("Invalid input. Enter a number from " + min + " to " + max + ".");
        }
    }
}
