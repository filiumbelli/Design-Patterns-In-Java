public class Test {
    public static void main(String[] args) {
        Diet diet = new DietBuilder.KetogenicBuilder(1500)
                .withDietExplanation("This is a oil related")
                .withMainFood("Olive oil based foods")
                .withRecommendations("Don't use any carb")
                .withDietType("Ketogenic")
                .withMeasurementUnit("SI")
                .withWeight(85)
                .withHeight(190)
                .build();

        System.out.println(diet);
    }

}

