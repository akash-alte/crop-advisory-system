import java.util.List;

public interface CropAdvisor {
    String getSeason();
    List<Crop> getAllCrops();
    List<Crop> getSuitableCrops(SoilData soil);
}
