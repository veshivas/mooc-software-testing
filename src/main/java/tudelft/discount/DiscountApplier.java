package tudelft.discount;

public class DiscountApplier {

    private ProductDao dao;

    public DiscountApplier (ProductDao dao) {
        this.dao = dao;
    }

    public void setNewPrices() {

        for(Product product : dao.all()) {
            if(product.getCategory().equalsIgnoreCase("BUSINESS")) {
                product.setPrice(product.getPrice() * 1.1);
            }
            if(product.getCategory().equalsIgnoreCase("HOME")) {
                product.setPrice(product.getPrice() * 0.9);
            }
        }

    }
}
