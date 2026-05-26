import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Taco> tacos;
    private List<Drink> drinks;
    private ChipsAndSalsa chips;

    public Order() {
        this.tacos = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = null;
    }

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void setChips(ChipsAndSalsa chips) {
        this.chips = chips;
    }

    public List<Taco> getTacos() {
        return tacos;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public ChipsAndSalsa getChips() {
        return chips;
    }

    public boolean isEmpty() {
        return tacos.isEmpty() && drinks.isEmpty() && chips == null;
    }

    public boolean hasOnlyZeroTacosWithoutSide() {
        // If no tacos, must have at least a drink or chips & salsa
        return tacos.isEmpty() && drinks.isEmpty() && chips == null;
    }

    public double getTotal() {
        double total = 0;
        for (Taco t : tacos) total += t.getPrice();
        for (Drink d : drinks) total += d.getPrice();
        if (chips != null) total += chips.getPrice();
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n========== ORDER SUMMARY ==========\n");

        if (tacos.isEmpty()) {
            sb.append("  No tacos\n");
        } else {
            sb.append("TACOS:\n");
            for (int i = 0; i < tacos.size(); i++) {
                sb.append("  --- Taco #").append(i + 1).append(" ---\n");
                sb.append(tacos.get(i).toString());
            }
        }

        if (!drinks.isEmpty()) {
            sb.append("DRINKS:\n");
            for (Drink d : drinks) sb.append(d.toString());
        }

        if (chips != null) {
            sb.append("SIDES:\n");
            sb.append(chips.toString());
        }

        sb.append("====================================\n");
        sb.append("TOTAL: $").append(String.format("%.2f", getTotal())).append("\n");
        sb.append("====================================\n");
        return sb.toString();
    }
}