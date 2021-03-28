public class Diet<SELF extends DietBuilder> {
    int calory;
    String dietType;
    int weight;
    int height;
    String measurementUnit;
    String mainFood;
    String dietExplanation;
    String recommendations;

    @Override
    public String toString() {
        return "Diet{" +
                "calory=" + calory +
                ", dietType='" + dietType + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", measurementUnit='" + measurementUnit + '\'' +
                ", mainFood='" + mainFood + '\'' +
                ", dietExplanation='" + dietExplanation + '\'' +
                ", recommendations='" + recommendations + '\'' +
                '}';
    }

    public Diet() {
    }
}

class DietBuilder<SELF extends DietBuilder<SELF>> {
    protected Diet diet = new Diet();


    public DietBuilder(int calory) {
        diet.calory = calory;
    }

    public SELF withDietType(String dietType) {
        diet.dietType = dietType;
        return (SELF) this;
    }

    public SELF withWeight(int weight) {
        diet.weight = weight;
        return (SELF) this;
    }

    public SELF withHeight(int height) {
        diet.height = height;
        return (SELF) this;
    }

    public SELF withMeasurementUnit(String unit) {
        diet.measurementUnit = unit;
        return (SELF) this;
    }

    public Diet build() {
        return diet;
    }


    static class KetogenicBuilder extends DietBuilder<KetogenicBuilder> {
        Diet diet = super.diet;

        public KetogenicBuilder(int calory) {
            super(calory);
        }


        public KetogenicBuilder withMainFood(String mainFood) {
            diet.mainFood = mainFood;
            return this;
        }

        public KetogenicBuilder withDietExplanation(String dietExplanation) {
            diet.dietExplanation = dietExplanation;
            return this;
        }

        public KetogenicBuilder withRecommendations(String recommendations) {
            diet.recommendations = recommendations;
            return this;
        }


    }

    static class PaleoBuilder extends DietBuilder<PaleoBuilder> {


        public PaleoBuilder(int calory) {
            super(calory);
        }
        public PaleoBuilder withMainFood(String mainFood) {
            diet.mainFood = mainFood;
            return this;
        }

        public PaleoBuilder withDietExplanation(String dietExplanation) {
            diet.dietExplanation = dietExplanation;
            return this;
        }

        public PaleoBuilder withRecommendations(String recommendations) {
            diet.recommendations = recommendations;
            return this;
        }
    }
}
