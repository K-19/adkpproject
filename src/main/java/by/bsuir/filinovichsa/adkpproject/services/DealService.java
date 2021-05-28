package by.bsuir.filinovichsa.adkpproject.services;

import by.bsuir.filinovichsa.adkpproject.ad.AbstractAd;
import by.bsuir.filinovichsa.adkpproject.dao.AdDao;
import by.bsuir.filinovichsa.adkpproject.dao.DealDao;
import by.bsuir.filinovichsa.adkpproject.products.Deal;

public class DealService {
    private DealDao dealDao;
    private static DealService instance;
    public static DealService getInstance() {
        if (instance == null)
            instance = new DealService();
        return instance;
    }
    private DealService() {
        dealDao = new DealDao();
    }

    public Deal findById(int id) {
        return dealDao.findById(id);
    }

    public void save(Deal deal) {
        dealDao.save(deal);
    }

    public void delete(Deal deal) {
        dealDao.delete(deal);
    }

    public void update(Deal deal) {
        dealDao.update(deal);
    }

    public void load(Deal deal) { dealDao.load(deal); }
}
