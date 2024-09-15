import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import praktikum.IngredientType;
import java.util.EnumSet;
import static org.junit.Assert.assertTrue;

public class IngredientTypeTest {
    @ParameterizedTest
    @EnumSource(value = IngredientType.class, names = {"SAUCE", "FILLING"})
    public void testIngredientTypeValues(IngredientType ingredientType) {
        assertTrue(EnumSet.allOf(IngredientType.class).contains(ingredientType));
    }
}