import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    String expectedName = "hot sauce";
    float expectedPrice = 100;
    IngredientType expectedType = IngredientType.SAUCE;
    Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

    @Test
    public void ingredientNameTest() {
        String actualName = ingredient.getName();
        assertEquals(expectedName, actualName);
    }
    @Test
    public void ingredientTypeTest() {
        IngredientType actualType = ingredient.getType();
        assertEquals(expectedType, actualType);
    }
    @Test
    public void ingredientPriceTest() {
        float actualPrice = ingredient.getPrice();
        assertEquals(expectedPrice, actualPrice,0);
    }
}
