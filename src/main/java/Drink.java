public class Drink {
    private String size;

    public Drink(String size) {
        this.size = size;
    }

    public double getPrice() {
        switch (size) {
            case "small":  return 2.00;
            case "medium": return 2.50;
            case "large":  return 3.00;
            default:       return 2.00;
        }
    }

    @Override
    public String toString() {
        return "  Drink (" + size + ") - $" + String.format("%.2f", getPrice()) + "\n";
    }
}