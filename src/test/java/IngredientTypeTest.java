import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private IngredientType type;
    private String expectedName;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        });
    }

    public IngredientTypeTest(IngredientType type, String expectedName) {
        this.type = type;
        this.expectedName = expectedName;
    }

    @Test
    public void testIngredientTypeValues() {
        String actualName = type.toString();
        assertEquals(expectedName, actualName);
    }

}