public class ChipsAndSalsa {
    private final String salsaType;

    public ChipsAndSalsa(String salsaType) {
        this.salsaType = salsaType;
    }

    public double getPrice() {
        return 1.50;
    }

    @Override
    public String toString() {
        return "  Chips & Salsa (" + salsaType + ") - $" + String.format("%.2f", getPrice()) + "\n";
    }
}