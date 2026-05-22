public class Order {
    private List<Taco> tacos = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private ChipsAndSalsa chips;

    public void addTaco(Taco t) { tacos.add(t); }
    public void addDrink(Drink d) { drinks.add(d); }
    public void setChips(ChipsAndSalsa c) { chips = c; }

    public double getTotal() {
        double total = tacos.stream().mapToDouble(Taco::getPrice).sum()
                + drinks.stream().mapToDouble(Drink::getPrice).sum();
        if (chips != null) total += chips.getPrice();
        return total;
    }
}