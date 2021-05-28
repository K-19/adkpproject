package by.bsuir.filinovichsa.adkpproject.services;

import by.bsuir.filinovichsa.adkpproject.ad.AbstractAd;
import by.bsuir.filinovichsa.adkpproject.dao.AdDao;

public class AdService {
    private AdDao adDao;
    private static AdService instance;
    public static AdService getInstance() {
        if (instance == null)
            instance = new AdService();
        return instance;
    }
    private AdService() {
        adDao = new AdDao();
    }

    public AbstractAd findById(int id) {
        return adDao.findById(id);
    }

    public void save(AbstractAd ad) {
        adDao.save(ad);
    }

    public void delete(AbstractAd ad) {
        adDao.delete(ad);
    }

    public void update(AbstractAd ad) {
        adDao.update(ad);
    }
}
