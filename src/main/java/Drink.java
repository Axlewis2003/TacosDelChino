public class Drink {
    private final String size;

    public Drink(String size) {
        this.size = size;
    }

    public double getPrice() {
        return switch (size) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 2.00;
        };
    }

    @Override
    public String toString() {
        return "  Drink (" + size + ") - $" + String.format("%.2f", getPrice()) + "\n";
    }
}