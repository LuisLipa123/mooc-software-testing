package tudelft.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DiscountApplierTest {

    private static final double DELTA = 0.0001;

    @Test
    void homeCategoryGetsTenPercentDiscount() {
        ProductDao dao = Mockito.mock(ProductDao.class);
        Product home = new Product("Vacuum", 100.0, "HOME");

        when(dao.all()).thenReturn(Collections.singletonList(home));

        DiscountApplier applier = new DiscountApplier(dao);
        applier.setNewPrices();

        assertEquals(90.0, home.getPrice(), DELTA);
    }

    @Test
    void businessCategoryGetsTenPercentIncrease() {
        ProductDao dao = Mockito.mock(ProductDao.class);
        Product business = new Product("Laptop", 200.0, "BUSINESS");

        when(dao.all()).thenReturn(Collections.singletonList(business));

        DiscountApplier applier = new DiscountApplier(dao);
        applier.setNewPrices();

        assertEquals(220.0, business.getPrice(), DELTA);
    }

    @Test
    void unknownCategoryPriceDoesNotChange() {
        ProductDao dao = Mockito.mock(ProductDao.class);
        Product other = new Product("Book", 50.0, "OTHER");

        when(dao.all()).thenReturn(Collections.singletonList(other));

        DiscountApplier applier = new DiscountApplier(dao);
        applier.setNewPrices();

        assertEquals(50.0, other.getPrice(), DELTA);
    }

    @Test
    void appliesRulesToMultipleProductsInOneRun() {
        ProductDao dao = Mockito.mock(ProductDao.class);

        Product home = new Product("Chair", 100.0, "HOME");         // -> 90
        Product business = new Product("Phone", 100.0, "BUSINESS");  // -> 110
        Product other = new Product("Pen", 100.0, "OTHER");          // -> 100

        List<Product> products = Arrays.asList(home, business, other);
        when(dao.all()).thenReturn(products);

        DiscountApplier applier = new DiscountApplier(dao);
        applier.setNewPrices();

        assertEquals(90.0, home.getPrice(), DELTA);
        assertEquals(110.0, business.getPrice(), DELTA);
        assertEquals(100.0, other.getPrice(), DELTA);
    }

    @Test
    void callingSetNewPricesTwiceAppliesChangeTwice() {
        ProductDao dao = Mockito.mock(ProductDao.class);
        Product home = new Product("Table", 100.0, "HOME"); // 100 -> 90 -> 81

        when(dao.all()).thenReturn(Collections.singletonList(home));

        DiscountApplier applier = new DiscountApplier(dao);
        applier.setNewPrices();
        applier.setNewPrices();

        assertEquals(81.0, home.getPrice(), DELTA);
    }
}
