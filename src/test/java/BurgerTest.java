import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    Burger burger = new Burger();

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertNotNull(burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
        burger.addIngredient(ingredient);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void removeIngredientsTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        burger.moveIngredient(0, 2);
        assertEquals("dinosaur", burger.ingredients.get(2).name);
        assertEquals("hot sauce", burger.ingredients.get(0).name);
        assertEquals("chili sauce", burger.ingredients.get(1).name);
    }

    @Test
    public void burgerGetPriceTest() {
        float mockPrice = 100;
        float expectedBurgerPrice = 300;
        Mockito.when(bun.getPrice()).thenReturn(mockPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(mockPrice);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actualBurgerPrice = burger.getPrice();
        assertEquals(expectedBurgerPrice, actualBurgerPrice, 0);
    }

    @Test
    public void burgerGetReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("dinosaur");
        Mockito.when(ingredient.getPrice()).thenReturn(300f);
        String expected = "(==== white bun ====)\r\n= filling dinosaur =\r\n(==== white bun ====)\r\n\r\nPrice: 700,000000\r\n";
        assertEquals(expected, burger.getReceipt());
    }
}