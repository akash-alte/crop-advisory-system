import java.util.ArrayList;
import java.util.List;

public abstract class SeasonalAdvisor implements CropAdvisor {
    private final String season;
    private final List<Crop> crops = new ArrayList<>();

    protected SeasonalAdvisor(String season) {
        this.season = season;
    }

    protected void addCrop(Crop crop) {
        crops.add(crop);
    }

    @Override
    public String getSeason() {
        return season;
    }

    @Override
    public List<Crop> getAllCrops() {
        return new ArrayList<>(crops);
    }

    @Override
    public List<Crop> getSuitableCrops(SoilData soil) {
        List<Crop> suitable = new ArrayList<>();
        if (!season.equals(soil.getSeason())) {
            return suitable;
        }

        for (Crop crop : crops) {
            if (crop.matches(soil)) {
                suitable.add(crop);
            }
        }
        return suitable;
    }
}
