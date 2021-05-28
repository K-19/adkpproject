package by.bsuir.filinovichsa.adkpproject.services;

import by.bsuir.filinovichsa.adkpproject.dao.ProductDao;
import by.bsuir.filinovichsa.adkpproject.dao.SupportDao;
import by.bsuir.filinovichsa.adkpproject.products.Product;
import by.bsuir.filinovichsa.adkpproject.support.SupportMessage;

import java.util.List;

public class SupportService {
    private SupportDao supportDao;
    private static SupportService instance;
    public static SupportService getInstance() {
        if (instance == null)
            instance = new SupportService();
        return instance;
    }
    private SupportService() {
        supportDao = new SupportDao();
    }

    public SupportMessage findById(int id) {
        return supportDao.findById(id);
    }

    public List<SupportMessage> selectAll() {
        return supportDao.selectAll();
    }

    public void save(SupportMessage message) {
        supportDao.save(message);
    }

    public void delete(SupportMessage message) {
        supportDao.delete(message);
    }

    public void update(SupportMessage message) {
        supportDao.update(message);
    }
}
