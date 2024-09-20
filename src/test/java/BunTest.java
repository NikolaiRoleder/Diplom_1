import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;
import static praktikum.Constants.DELTA;

public class BunTest {
    String expectedName = "red bun";
    float expectedPrice = 300;
    Bun bun = new Bun(expectedName, expectedPrice);

    @Test
    public void getBunNameTest() {
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getBunPriceTest() {
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, DELTA);

    }
}