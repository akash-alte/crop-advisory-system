public class SoilData {
    private final String soilType;
    private final double pH;
    private final double macronutrientPercentage;
    private final String season;

    public SoilData(String soilType, double pH, double macronutrientPercentage, String season) {
        this.soilType = soilType;
        this.pH = pH;
        this.macronutrientPercentage = macronutrientPercentage;
        this.season = season;
    }

    public String getSoilType() {
        return soilType;
    }

    public double getPH() {
        return pH;
    }

    public double getMacronutrientPercentage() {
        return macronutrientPercentage;
    }

    public String getSeason() {
        return season;
    }

    public String getFertilityGroup() {
        if (macronutrientPercentage <= 33.0) {
            return "Low";
        }
        if (macronutrientPercentage <= 66.0) {
            return "Medium";
        }
        return "High";
    }
}
