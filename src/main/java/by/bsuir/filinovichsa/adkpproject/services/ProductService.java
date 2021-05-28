package by.bsuir.filinovichsa.adkpproject.services;

import by.bsuir.filinovichsa.adkpproject.dao.ProductDao;
import by.bsuir.filinovichsa.adkpproject.products.Product;


public class ProductService {
    private ProductDao productDao;
    private static ProductService instance;
    public static ProductService getInstance() {
        if (instance == null)
            instance = new ProductService();
        return instance;
    }
    private ProductService() {
        productDao = new ProductDao();
    }

    public Product findById(int id) {
        return productDao.findById(id);
    }

    public void save(Product product) {
        productDao.save(product);
    }

    public void delete(Product product) {
        productDao.delete(product);
    }

    public void update(Product product) {
        productDao.update(product);
    }
}
