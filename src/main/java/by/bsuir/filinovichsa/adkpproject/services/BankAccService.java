package by.bsuir.filinovichsa.adkpproject.services;

import by.bsuir.filinovichsa.adkpproject.dao.BankAccDao;
import by.bsuir.filinovichsa.adkpproject.dao.DealDao;
import by.bsuir.filinovichsa.adkpproject.products.Deal;
import by.bsuir.filinovichsa.adkpproject.users.BankAccount;

public class BankAccService {
    private BankAccDao bankAccDao;
    private static BankAccService instance;
    public static BankAccService getInstance() {
        if (instance == null)
            instance = new BankAccService();
        return instance;
    }
    private BankAccService() {
        bankAccDao = new BankAccDao();
    }

    public BankAccount findById(int id) {
        return bankAccDao.findById(id);
    }

    public void save(BankAccount account) {
        bankAccDao.save(account);
    }

    public void delete(BankAccount account) {
        bankAccDao.delete(account);
    }

    public void update(BankAccount account) {
        bankAccDao.update(account);
    }
}
