public class KharifAdvisor extends SeasonalAdvisor {
    public KharifAdvisor() {
        super("Kharif");

        addCrop(new Crop("Rice",
                new String[]{"Alluvial", "Clayey"}, 5.5, 7.5,
                new String[]{"Medium", "High"},
                "Needs reliable water; avoid water stress."));

        addCrop(new Crop("Maize",
                new String[]{"Alluvial", "Loamy", "Red"}, 5.5, 7.0,
                new String[]{"Medium", "High"},
                "Needs good drainage and adequate sunlight."));

        addCrop(new Crop("Cotton",
                new String[]{"Black", "Alluvial"}, 5.5, 8.0,
                new String[]{"Low", "Medium", "High"},
                "Black soil can be suitable; avoid waterlogging."));
    }
}
