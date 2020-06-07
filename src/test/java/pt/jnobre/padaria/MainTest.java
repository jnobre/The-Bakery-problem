package pt.jnobre.padaria;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pt.jnobre.padaria.model.Code;
import pt.jnobre.padaria.model.Pack;
import pt.jnobre.padaria.model.Product;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static pt.jnobre.padaria.Main.*;

public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testLoad() {
        loadProducts();
        assertEquals(3, products.size());
    }

    @Test
    public void testSolve() {
        testLoad();
        Solve(Code.PN, 10);
        assertEquals("10 PN €17,98\n\t2 * 5 €8,99\n", outContent.toString());
    }


    public void testFindMinPacks() {
        testLoad();
        Product product = products.stream()
                .filter(p -> Code.PN.equals(p.getCodeProduct()))
                .findAny()
                .orElse(null);
        List<Pack> packs = product.getPacks();
        int[] counters = new int[packs.size()];
        solution = new int[packs.size()];
        minPacks = Integer.MAX_VALUE;
        totalPrice = 0;


        findMinPacks(packs, 10, 0, counters, 0, 0);

        assertEquals(minPacks,2);
    }

}
