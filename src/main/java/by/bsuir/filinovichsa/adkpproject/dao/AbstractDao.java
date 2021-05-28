package by.bsuir.filinovichsa.adkpproject.dao;

import by.bsuir.filinovichsa.adkpproject.products.Product;
import by.bsuir.filinovichsa.adkpproject.users.AbstractUser;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;
import by.bsuir.filinovichsa.adkpproject.users.BankAccount;

import java.util.Collections;
import java.util.Comparator;

public abstract class AbstractDao {
    public void sortBankAccounts(AbstractUser user) {
        user.getBankAccounts().sort(new Comparator<BankAccount>() {
            @Override
            public int compare(BankAccount o1, BankAccount o2) {
                return o1.getId() - o2.getId();
            }
        });
    }

    public void sortProducts(Advertiser user) {
        user.getProducts().sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getId() - o2.getId();
            }
        });
    }
}
