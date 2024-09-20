import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static praktikum.Constants.DELTA;

// Не правильно прочитал задания, и сделал этот автотест. Удалять жаль-кросивое.
@RunWith(Parameterized.class)
public class DataBaseParametrizedTest {
private final int index;
private final String expectedName;
private final float expectedPrice;
public DataBaseParametrizedTest (int index, String expectedName, float expectedPrice){
    this.index= index;
    this.expectedName = expectedName;
    this.expectedPrice = expectedPrice;
}
    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {0, "black bun", 100},
                {1, "white bun", 200},
                {2, "red bun", 300},
        });
    }
    @Test
    public void bunsDataTest (){
        Database database = new Database();
        String actualName = database.availableBuns().get(index).getName();
        float actualPrice = database.availableBuns().get(index).getPrice();
        assertEquals(expectedName,actualName);
        assertEquals(expectedPrice,actualPrice, DELTA);
    }
}
