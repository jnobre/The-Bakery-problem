package pt.jnobre.padaria;

import pt.jnobre.padaria.model.Code;
import pt.jnobre.padaria.model.Pack;
import pt.jnobre.padaria.model.Product;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Product> products;
    private static final Scanner scanner = new Scanner(System.in);

    public static void loadProducts() {

        Pack pn_1 = new Pack(3,6.99f,Code.PN);
        Pack pn_2 = new Pack(5,8.99f,Code.PN);

        Product pn = new Product("Pastel de Nata", Code.PN, Arrays.asList(pn_1,pn_2));

        Pack ts_1 = new Pack(2,9.95f,Code.TS);
        Pack ts_2 = new Pack(5,16.95f,Code.TS);
        Pack ts_3 = new Pack(8,24.95f,Code.TS);

        Product ts = new Product("Travesseiros de Sintra", Code.TS, Arrays.asList(ts_1,ts_2,ts_3));

        Pack qjd_1 = new Pack(3,5.95f,Code.QJD);
        Pack qjd_2 = new Pack(5,9.95f,Code.QJD);
        Pack qjd_3 = new Pack(9,16.99f,Code.QJD);

        Product qjd = new Product("Queijadinha", Code.QJD, Arrays.asList(qjd_1,qjd_2,qjd_3));

        products = Arrays.asList(pn,ts,qjd);

    }


    public static void main(String[] args)  throws IOException{
        BufferedWriter bufferedWriter = null;

        try {

            bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            loadProducts();

            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }


        } catch (IOException e) {
            System.out.print("Cannot append, buffered writer is closed");
        } finally {
            if(bufferedWriter != null) {
                bufferedWriter.close();
            }

            if(scanner != null)
                scanner.close();
        }


    }

}
