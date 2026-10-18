import java.util.Arrays;
import java.util.List;

public class Crop {
    private final String name;
    private final List<String> suitableSoils;
    private final double minPH;
    private final double maxPH;
    private final List<String> fertilityGroups;
    private final String advice;

    public Crop(String name, String[] suitableSoils, double minPH, double maxPH,
                String[] fertilityGroups, String advice) {
        this.name = name;
        this.suitableSoils = Arrays.asList(suitableSoils);
        this.minPH = minPH;
        this.maxPH = maxPH;
        this.fertilityGroups = Arrays.asList(fertilityGroups);
        this.advice = advice;
    }

    public String getName() {
        return name;
    }

    public String getAdvice() {
        return advice;
    }

    public boolean matches(SoilData soil) {
        return suitableSoils.contains(soil.getSoilType())
                && soil.getPH() >= minPH
                && soil.getPH() <= maxPH
                && fertilityGroups.contains(soil.getFertilityGroup());
    }
}
