public class Taco {
    private String shell;      // corn, flour, hard shell, bowl
    private String size;       // single, 3-taco, burrito
    private String meat;       // carne asada, al pastor, etc.
    private String cheese;     // Queso Fresco, Oaxaca, etc.
    private List<String> regularToppings; // lettuce, cilantro, etc.
    private String sauce;      // salsa verde, chipotle, etc.
    private boolean extraMeat;
    private boolean extraCheese;
    private boolean withQueso;
    private boolean withSalsa;

    public double getPrice() {
        double base = 0;
        if (size.equals("single")) base = 3.50;
        if (size.equals("3-taco")) base = 9.00;
        if (size.equals("burrito")) base = 8.50;

        double meatPrice = size.equals("single") ? 1.00 : size.equals("3-taco") ? 2.00 : 3.00;
        double cheesePrice = size.equals("single") ? 0.75 : size.equals("3-taco") ? 1.50 : 2.25;
        double extraMeatPrice = size.equals("single") ? 0.50 : size.equals("3-taco") ? 1.00 : 1.50;
        double extraCheesePrice = size.equals("single") ? 0.30 : size.equals("3-taco") ? 0.60 : 0.90;

        return base + meatPrice + cheesePrice
                + (extraMeat ? extraMeatPrice : 0)
                + (extraCheese ? extraCheesePrice : 0);
    }
}
