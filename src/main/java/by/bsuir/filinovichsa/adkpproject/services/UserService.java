package by.bsuir.filinovichsa.adkpproject.services;

import by.bsuir.filinovichsa.adkpproject.dao.AdvertiserDao;
import by.bsuir.filinovichsa.adkpproject.dao.DistributorDao;
import by.bsuir.filinovichsa.adkpproject.users.AbstractUser;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;
import by.bsuir.filinovichsa.adkpproject.users.BankAccount;
import by.bsuir.filinovichsa.adkpproject.users.Distributor;

import java.util.List;

public class UserService {
    private AdvertiserDao advertiserDao = new AdvertiserDao();
    private DistributorDao distributorDao = new DistributorDao();
    private static UserService instance;

    public static UserService getInstance() {
        if (instance == null)
            instance = new UserService();
        return instance;
    }
    private UserService() {
    }

    public Advertiser findAdvertiser(int id) {
        return advertiserDao.findById(id);
    }

    public Distributor findDistributor(int id) {
        return distributorDao.findById(id);
    }

    public AbstractUser findUserByLoginAndPassword(String login, int password) {
        Advertiser advertiser = advertiserDao.findByLoginAndPassword(login, password);
        if (advertiser != null)
            return advertiser;
        return distributorDao.findByLoginAndPassword(login, password);
    }

    public AbstractUser findUserById(int id) {
        Advertiser advertiser = findAdvertiser(id);
        if (advertiser != null)
            return advertiser;
        return findDistributor(id);
    }

    public List<Advertiser> findAllAdvertisers() { return advertiserDao.findAll(); }
    public List<Distributor> findAllDistributors() {
        return distributorDao.findAll();
    }

    public void saveAdvertiser(Advertiser user) {
        advertiserDao.save(user);
    }

    public void saveDistributor(Distributor user) {
        distributorDao.save(user);
    }

    public void deleteAdvertiser(Advertiser user) {
        advertiserDao.delete(user);
    }

    public void deleteDistributor(Distributor user) {
        distributorDao.delete(user);
    }

    public void updateAdvertiser(Advertiser user) {
        advertiserDao.update(user);
    }

    public void updateDistributor(Distributor user) {
        distributorDao.update(user);
    }
}
