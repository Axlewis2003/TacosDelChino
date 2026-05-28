import java.util.List;

public class Taco {
    private final String shell;
    private final String size;
    private final String meat;
    private final boolean extraMeat;
    private final String cheese;
    private final boolean extraCheese;
    private final List<String> regularToppings;
    private final String sauce;
    private final boolean withSalsa;
    private final boolean withQueso;

    public Taco(String shell, String size, String meat, boolean extraMeat,
                String cheese, boolean extraCheese, List<String> regularToppings,
                String sauce, boolean withSalsa, boolean withQueso) {
        this.shell = shell;
        this.size = size;
        this.meat = meat;
        this.extraMeat = extraMeat;
        this.cheese = cheese;
        this.extraCheese = extraCheese;
        this.regularToppings = regularToppings;
        this.sauce = sauce;
        this.withSalsa = withSalsa;
        this.withQueso = withQueso;
    }

    public double getPrice() {
        double base = 0;
        double meatPrice = 0;
        double cheesePrice = 0;
        double extraMeatPrice = 0;
        double extraCheesePrice = 0;

        switch (size) {
            case "single":
                base = 3.50;
                meatPrice = 1.00;
                cheesePrice = 0.75;
                extraMeatPrice = 0.50;
                extraCheesePrice = 0.30;
                break;
            case "3-taco":
                base = 9.00;
                meatPrice = 2.00;
                cheesePrice = 1.50;
                extraMeatPrice = 1.00;
                extraCheesePrice = 0.60;
                break;
            case "burrito":
                base = 8.50;
                meatPrice = 3.00;
                cheesePrice = 2.25;
                extraMeatPrice = 1.50;
                extraCheesePrice = 0.90;
                break;
        }

        double total = base + meatPrice + cheesePrice;
        if (extraMeat) total += extraMeatPrice;
        if (extraCheese) total += extraCheesePrice;
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  [").append(size.toUpperCase()).append("] Taco\n");
        sb.append("    Shell: ").append(shell).append("\n");
        sb.append("    Meat: ").append(meat);
        if (extraMeat) sb.append(" (+ extra meat)");
        sb.append("\n");
        sb.append("    Cheese: ").append(cheese);
        if (extraCheese) sb.append(" (+ extra cheese)");
        sb.append("\n");
        if (!regularToppings.isEmpty()) {
            sb.append("    Toppings: ").append(String.join(", ", regularToppings)).append("\n");
        }
        sb.append("    Sauce: ").append(sauce).append("\n");
        sb.append("    Covered in salsa: ").append(withSalsa ? "Yes" : "No").append("\n");
        sb.append("    Covered in queso: ").append(withQueso ? "Yes" : "No").append("\n");
        sb.append("    Price: $").append(String.format("%.2f", getPrice())).append("\n");
        return sb.toString();
    }
}