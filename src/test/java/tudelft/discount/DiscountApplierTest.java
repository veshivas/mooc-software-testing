package tudelft.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiscountApplierTest {
    @Test
    public void test_home_discount_price() {
        Product p1 = new Product("Sofa",100, "HOME");
        Product p2 = new Product("Intercomm", 200, "home");
        List<Product> products = Arrays.asList(p1, p2);
        ProductDaoPlus dao = Mockito.mock(ProductDaoPlus.class);

        Mockito.when(dao.all()).thenReturn(products);
        DiscountApplier da = new DiscountApplier(dao);
        da.setNewPrices();
        Assertions.assertEquals(90, p1.getPrice());
        Assertions.assertEquals(180, p2.getPrice());
    }

    @Test
    public void test_business_discount_price() {
        Product p1 = new Product("Metting table",1000, "business");
        Product p2 = new Product("Intercomm", 2000, "BUSINESS");
        List<Product> products = Arrays.asList(p1, p2);
        ProductDaoPlus dao = Mockito.mock(ProductDaoPlus.class);

        Mockito.when(dao.all()).thenReturn(products);
        DiscountApplier da = new DiscountApplier(dao);
        da.setNewPrices();
        Assertions.assertEquals(1100, p1.getPrice());
        Assertions.assertEquals(2200, p2.getPrice());
    }

}
