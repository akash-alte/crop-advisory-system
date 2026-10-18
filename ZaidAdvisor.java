public class ZaidAdvisor extends SeasonalAdvisor {
    public ZaidAdvisor() {
        super("Zaid");

        addCrop(new Crop("Watermelon",
                new String[]{"Sandy", "Loamy", "Alluvial"}, 5.5, 7.5,
                new String[]{"Medium", "High"},
                "Needs warm weather and controlled watering."));

        addCrop(new Crop("Cucumber",
                new String[]{"Sandy", "Loamy", "Alluvial"}, 5.5, 7.0,
                new String[]{"Medium", "High"},
                "Maintain even soil moisture and good drainage."));

        addCrop(new Crop("Green Gram (Moong)",
                new String[]{"Alluvial", "Sandy", "Red"}, 5.5, 7.5,
                new String[]{"Low", "Medium", "High"},
                "Avoid waterlogging; maintain balanced nutrients."));
    }
}
