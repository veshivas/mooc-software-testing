package tudelft.discount;

import tudelft.invoice.Invoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoPlus
    implements ProductDao{
    private static Connection c;

    public ProductDaoPlus() {
        try {
            if(c!=null) return;

            c = DriverManager.getConnection("jdbc:hsqldb:file:mymemdb.db", "SA", "");
            c.prepareStatement("create table product (name varchar(100), price double, category varchar(50)").execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> all() {

        List<Product> allProducts = new ArrayList<>();

        try {
            PreparedStatement ps = c.prepareStatement("select * from product");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                allProducts.add(new Product(name, price, category));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return allProducts;
        }

    }

    public void save(Product p) {
        try {
            PreparedStatement ps = c.prepareStatement("insert into invoice (name, value) values (?,?)");
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setString(3,p.getCategory());

            ps.execute();

            c.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
