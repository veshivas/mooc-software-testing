package tudelft.invoice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class InvoiceFilterTest {
    @Test
    void filterInvoices() {

        //InvoiceDao dao = new InvoiceDao();
        Invoice i1 = new Invoice("Mauricio", 20.0);
        Invoice i2 = new Invoice("Arie", 300.0);
        InvoiceDao dao = Mockito.mock(InvoiceDao.class);
        //dao.save(mauricio);
        //dao.save(arie);

        List<Invoice> list = Arrays.asList(i1, i2);
        Mockito.when(dao.all()).thenReturn(list);
        InvoiceFilter filter = new InvoiceFilter(dao);
        List<Invoice> result = filter.filter();

        Assertions.assertEquals("Mauricio", result.get(0).getCustomer());
        Assertions.assertEquals(1, result.size());

        dao.close();
    }

}
