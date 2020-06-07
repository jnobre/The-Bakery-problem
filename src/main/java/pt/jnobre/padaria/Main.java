package pt.jnobre.padaria;

import javafx.util.Pair;
import pt.jnobre.padaria.model.Code;
import pt.jnobre.padaria.model.Pack;
import pt.jnobre.padaria.model.Product;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static List<Product> products;
    private static final Scanner input = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("0.00");
    public static int minPacks;
    public static int[] solution;
    public static float totalPrice;

    /**
     * Products print.
     */
    private static void printStock() {
        products.forEach(System.out::println);
    }

    /**
     * Loads the inventory of products and packages into memory.
     */
    public static void loadProducts() {

        Pack pn_1 = new Pack(5,8.99f,Code.PN);
        Pack pn_2 = new Pack(3,6.99f,Code.PN);

        Product pn = new Product("Pastel de Nata", Code.PN, Arrays.asList(pn_1,pn_2).stream().sorted().collect(Collectors.toList()));

        Pack ts_1 = new Pack(8,24.95f,Code.TS);
        Pack ts_2 = new Pack(5,16.95f,Code.TS);
        Pack ts_3 = new Pack(2,9.95f,Code.TS);

        Product ts = new Product("Travesseiros de Sintra", Code.TS,  Arrays.asList(ts_1,ts_2,ts_3).stream().sorted().collect(Collectors.toList()));

        Pack qjd_1 = new Pack(9,16.99f,Code.QJD);
        Pack qjd_2 = new Pack(5,9.95f,Code.QJD);
        Pack qjd_3 = new Pack(3,5.95f,Code.QJD);

        Product qjd = new Product("Queijadinha", Code.QJD, Arrays.asList(qjd_1,qjd_2,qjd_3).stream().sorted().collect(Collectors.toList()));

        products = Arrays.asList(pn,ts,qjd);

    }


    /**
     * Finds the smallest combination of packages for a given quantity.
     * @param packs
     * @param qty
     * @param amount
     * @param counters
     * @param countPacks
     * @param price
     */
    public static void findMinPacks(List<Pack> packs, int qty, int amount, int[] counters, int countPacks, float price) {

        if(amount > qty)
            return;

        if(qty == amount){ //found a possibility
            if(countPacks < minPacks) {
                minPacks = countPacks;
                solution = Arrays.copyOf(counters, counters.length);
                totalPrice = price;
            }
            return;
        }

        for(int i = 0 ; i < counters.length ; i++) {
            amount = amount + packs.get(i).getQuantity();
            counters[i] = counters[i] + 1;
            countPacks = countPacks + 1;
            price = price + packs.get(i).getPrice();

            findMinPacks(packs, qty, amount, counters, countPacks, price);

            counters[i] = counters[i] - 1;
            countPacks = countPacks - 1;
            amount = amount - packs.get(i).getQuantity();
            price = price - packs.get(i).getPrice();
        }

    }


    /**
     * Determine nature of product and prints the final solution.
     * @param codeProduct
     * @param qty
     */
    public static void Solve(final Code codeProduct, Integer qty) {

        Product product = products.stream()
                .filter(p -> codeProduct.equals(p.getCodeProduct()))
                .findAny()
                .orElse(null);

        List<Pack> packs = product.getPacks();

        int[] counters = new int[packs.size()];
        solution = new int[packs.size()];
        minPacks = Integer.MAX_VALUE;
        totalPrice = 0;

        findMinPacks(packs, qty, 0, counters, 0, 0); //recursive solution

        System.out.println(qty + " " + codeProduct + " €" + df.format(totalPrice));
        for(int i = 0 ; i < solution.length ; i++) {
            if(solution[i] > 0)
                System.out.println("\t"+ solution[i] + " * " + packs.get(i).getQuantity() + " €" + df.format(packs.get(i).getPrice()));
        }

    }

    public static void main(String[] args) {
        List<Pair<Code, Integer>> orders = new ArrayList<>();

        try {

            loadProducts();
//            printStock();

            //read input
            while (input.hasNextLine()) {
                String[] line = input.nextLine().split(" ");
                Integer qty = Integer.parseInt(line[0]);
                Code code = Code.valueOf(line[1]);
                orders.add(new Pair<>(code, qty) );
            }

            for(Pair<Code,Integer> order : orders) {
                Solve(order.getKey(),order.getValue());
            }



        } catch (NumberFormatException e1)  {
            System.out.println("Invalid Input");
            throw e1;
        } catch (IllegalArgumentException e2)  {
            System.out.println("Invalid Code");
            throw e2;
        } catch(Exception e) {
            throw e;
        } finally {
            if(input != null)
                input.close();
        }


    }

}
