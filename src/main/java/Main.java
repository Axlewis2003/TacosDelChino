import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║     Welcome to               ║");
        System.out.println("║     TacosDelChino! 🌮         ║");
        System.out.println("╚══════════════════════════════╝");

        while (true) {
            System.out.println("\n========== HOME SCREEN ==========");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose: ");
            int choice = getIntInput();

            if (choice == 0) {
                System.out.println("\nGracias! See you next time at TacosDelChino!");
                break;
            } else if (choice == 1) {
                startOrder();
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // ─── ORDER SCREEN ────────────────────────────────────────────────────────────

    static void startOrder() {
        Order order = new Order();

        while (true) {
            System.out.println("\n========== ORDER SCREEN ==========");
            System.out.println("Current items: " + order.getTacos().size() + " taco(s), "
                    + order.getDrinks().size() + " drink(s)"
                    + (order.getChips() != null ? ", chips & salsa" : ""));
            System.out.println("1) Add Taco");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips & Salsa");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose: ");
            int choice = getIntInput();

            switch (choice) {
                case 1: addTaco(order); break;
                case 2: addDrink(order); break;
                case 3: addChips(order); break;
                case 4: checkout(order); return;
                case 0:
                    System.out.println("Order cancelled. Returning to home screen.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // ─── ADD TACO ────────────────────────────────────────────────────────────────

    static void addTaco(Order order) {
        System.out.println("\n--- ADD TACO ---");

        // Shell
        System.out.println("Select your shell:");
        System.out.println("1) Corn  2) Flour  3) Hard Shell  4) Bowl");
        System.out.print("Choose: ");
        String[] shells = {"corn", "flour", "hard shell", "bowl"};
        String shell = pickFromList(shells);

        // Size
        System.out.println("\nSelect taco size:");
        System.out.println("1) Single ($3.50)  2) 3-Taco Plate ($9.00)  3) Burrito ($8.50)");
        System.out.print("Choose: ");
        String[] sizes = {"single", "3-taco", "burrito"};
        String size = pickFromList(sizes);

        // Meat
        System.out.println("\nSelect meat (+$1.00/2.00/3.00):");
        System.out.println("1) Carne Asada  2) Al Pastor  3) Carnitas");
        System.out.println("4) Pollo        5) Chorizo    6) Pescado");
        System.out.print("Choose: ");
        String[] meats = {"Carne Asada", "Al Pastor", "Carnitas", "Pollo", "Chorizo", "Pescado"};
        String meat = pickFromList(meats);

        // Extra meat?
        System.out.print("\nAdd extra meat? (1=Yes / 2=No): ");
        boolean extraMeat = getIntInput() == 1;

        // Cheese
        System.out.println("\nSelect cheese (+$0.75/1.50/2.25):");
        System.out.println("1) Queso Fresco  2) Oaxaca  3) Cotija  4) Cheddar");
        System.out.print("Choose: ");
        String[] cheeses = {"Queso Fresco", "Oaxaca", "Cotija", "Cheddar"};
        String cheese = pickFromList(cheeses);

        // Extra cheese?
        System.out.print("\nAdd extra cheese? (1=Yes / 2=No): ");
        boolean extraCheese = getIntInput() == 1;

        // Regular Toppings (free)
        System.out.println("\nSelect regular toppings (FREE - enter numbers separated by commas, or 0 for none):");
        System.out.println("1) Lettuce    2) Cilantro   3) Onions");
        System.out.println("4) Tomatoes   5) Jalapeños  6) Radishes");
        System.out.println("7) Pico de Gallo  8) Guacamole  9) Corn");
        System.out.print("Choose (e.g. 1,3,5): ");
        String[] toppingOptions = {"Lettuce", "Cilantro", "Onions", "Tomatoes",
                "Jalapeños", "Radishes", "Pico de Gallo", "Guacamole", "Corn"};
        List<String> selectedToppings = pickMultiple(toppingOptions);

        // Sauce
        System.out.println("\nSelect sauce (FREE):");
        System.out.println("1) Salsa Verde  2) Salsa Roja  3) Chipotle");
        System.out.println("4) Habanero     5) Mild        6) Extra Hot");
        System.out.print("Choose: ");
        String[] sauces = {"Salsa Verde", "Salsa Roja", "Chipotle", "Habanero", "Mild", "Extra Hot"};
        String sauce = pickFromList(sauces);

        // Salsa coverage
        System.out.print("\nCover taco in salsa? (1=Yes / 2=No): ");
        boolean withSalsa = getIntInput() == 1;

        // Queso coverage
        System.out.print("Cover taco in queso? (1=Yes / 2=No): ");
        boolean withQueso = getIntInput() == 1;

        Taco taco = new Taco(shell, size, meat, extraMeat, cheese, extraCheese,
                selectedToppings, sauce, withSalsa, withQueso);

        order.addTaco(taco);
        System.out.println("\nTaco added! Price: $" + String.format("%.2f", taco.getPrice()));
    }

    // ─── ADD DRINK ───────────────────────────────────────────────────────────────

    static void addDrink(Order order) {
        System.out.println("\n--- ADD DRINK ---");
        System.out.println("1) Small ($2.00)  2) Medium ($2.50)  3) Large ($3.00)");
        System.out.print("Choose size: ");
        String[] sizes = {"small", "medium", "large"};
        String size = pickFromList(sizes);
        Drink drink = new Drink(size);
        order.addDrink(drink);
        System.out.println("Drink added! Price: $" + String.format("%.2f", drink.getPrice()));
    }

    // ─── ADD CHIPS & SALSA ───────────────────────────────────────────────────────

    static void addChips(Order order) {
        if (order.getChips() != null) {
            System.out.println("\nYou already have chips & salsa on this order.");
            return;
        }
        System.out.println("\n--- ADD CHIPS & SALSA ($1.50) ---");
        System.out.println("1) Mild  2) Salsa Roja  3) Salsa Verde  4) Chipotle  5) Habanero");
        System.out.print("Choose salsa type: ");
        String[] salsas = {"Mild", "Salsa Roja", "Salsa Verde", "Chipotle", "Habanero"};
        String salsa = pickFromList(salsas);
        ChipsAndSalsa chips = new ChipsAndSalsa(salsa);
        order.setChips(chips);
        System.out.println("Chips & Salsa added!");
    }

    // ─── CHECKOUT ────────────────────────────────────────────────────────────────

    static void checkout(Order order) {
        // Validate: 0 tacos needs a drink or chips
        if (order.getTacos().isEmpty() && order.getDrinks().isEmpty() && order.getChips() == null) {
            System.out.println("\nYou must order at least 1 taco, or add a drink or chips & salsa.");
            return;
        }

        System.out.println(order.toString());

        System.out.println("1) Confirm Order  2) Cancel Order");
        System.out.print("Choose: ");
        int choice = getIntInput();

        if (choice == 1) {
            saveReceipt(order);
            System.out.println("\nOrder confirmed! Receipt saved. Thank you!");
        } else {
            System.out.println("Order cancelled. Returning to home screen.");
        }
    }

    // ─── SAVE RECEIPT ────────────────────────────────────────────────────────────

    static void saveReceipt(Order order) {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
            String filename = "receipts/" + timestamp + ".txt";
            File dir = new File("receipts");
            dir.mkdirs();
            PrintWriter writer = new PrintWriter(new File(filename));
            writer.println("TacosDelChino - Order Receipt");
            writer.println("Date/Time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            writer.println(order.toString());
            writer.close();
            System.out.println("Receipt saved to: " + filename);
        } catch (Exception e) {
            System.out.println("Could not save receipt: " + e.getMessage());
        }
    }

    // ─── HELPERS ─────────────────────────────────────────────────────────────────

    static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number: ");
            }
        }
    }

    static String pickFromList(String[] options) {
        while (true) {
            int choice = getIntInput();
            if (choice >= 1 && choice <= options.length) {
                return options[choice - 1];
            }
            System.out.print("Invalid. Enter 1-" + options.length + ": ");
        }
    }

    static List<String> pickMultiple(String[] options) {
        List<String> selected = new ArrayList<>();
        String input = scanner.nextLine().trim();
        if (input.equals("0")) return selected;
        String[] parts = input.split(",");
        for (String part : parts) {
            try {
                int num = Integer.parseInt(part.trim());
                if (num >= 1 && num <= options.length) {
                    selected.add(options[num - 1]);
                }
            } catch (NumberFormatException ignored) {}
        }
        return selected;
    }
}