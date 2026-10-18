public class RabiAdvisor extends SeasonalAdvisor {
    public RabiAdvisor() {
        super("Rabi");

        addCrop(new Crop("Wheat",
                new String[]{"Alluvial", "Loamy"}, 5.5, 7.0,
                new String[]{"Medium", "High"},
                "Needs suitable cool-season conditions and drainage."));

        addCrop(new Crop("Chickpea",
                new String[]{"Black", "Red", "Alluvial"}, 5.5, 8.0,
                new String[]{"Low", "Medium", "High"},
                "Avoid waterlogging; maintain balanced nutrients."));

        addCrop(new Crop("Mustard",
                new String[]{"Alluvial", "Sandy", "Loamy"}, 5.5, 7.5,
                new String[]{"Low", "Medium", "High"},
                "A well-drained seedbed is helpful."));
    }
}
