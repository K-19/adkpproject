package by.bsuir.filinovichsa.adkpproject.users;

import by.bsuir.filinovichsa.adkpproject.ad.AdType;
import by.bsuir.filinovichsa.adkpproject.dao.DealDao;
import by.bsuir.filinovichsa.adkpproject.products.Deal;
import by.bsuir.filinovichsa.adkpproject.products.Product;
import by.bsuir.filinovichsa.adkpproject.services.DealService;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "advertisers")
public class Advertiser extends AbstractUser {
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;
    private int productAll;

    public Advertiser() {
    }

    public Advertiser(UserType type, String nameOrganization, String description, String address, String agentName, String agentSurname, String agentPhone, String login, int password) {
        this.type = type;
        this.nameOrganization = nameOrganization;
        this.description = description;
        this.address = address;
        this.agentName = agentName;
        this.agentSurname = agentSurname;
        this.agentPhone = agentPhone;
        this.bankAccounts = new ArrayList<>();
        this.login = login;
        this.password = password;
        this.registerDate = LocalDateTime.now();
        this.products = new ArrayList<>();
        this.productAll = 0;
    }

    public void addProduct(Product product) {
        this.products.add(product);
        productAll++;
    }

    public boolean hasProductWithId(int id) {
        for (Product product : getProducts()) {
            if (product.getId() == id)
                return true;
        }
        return false;
    }

    public void load() {
        super.load();
        for (Product product : products) {
            product.getId();
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getWaitingDistributorsProducts() {
        List<Product> resultList = new ArrayList<>();
        resultList.addAll(getDeleteByDistributorProducts());
        resultList.addAll(getToAdvertiserProducts());
        resultList.addAll(getToDistributorProducts());
        return resultList;
//        for (Product product : getProducts()) {
//            if (product.getDeal() != null && product.getDeal().getStatus() == Deal.Status.DELETE_BY_DISTRIBUTOR) {
//                resultList.add(product);
//            }
//        }
//        for (Product product : getProducts()) {
//            if (product.getDeal() != null && product.getDeal().getStatus() == Deal.Status.TO_ADVERTISER) {
//                resultList.add(product);
//            }
//        }
//        for (Product product : getProducts()) {
//            if (product.getDeal() != null && product.getDeal().getStatus() == Deal.Status.TO_DISTRIBUTOR) {
//                resultList.add(product);
//            }
//        }
    }

    public List<Product> getAllProductsWithStatus(Deal.Status status) {
        List<Product> resultList = new ArrayList<>();
        for (Product product : getProducts()) {
            if (product.getDeal() != null && product.getDeal().getStatus() == status) {
                resultList.add(product);
            }
        }
        return resultList;
    }

    public List<Product> getToAdvertiserProducts() {
        return getAllProductsWithStatus(Deal.Status.TO_ADVERTISER);
    }

    public List<Product> getDeleteByDistributorProducts() {
        return getAllProductsWithStatus(Deal.Status.DELETE_BY_DISTRIBUTOR);
    }

    public List<Product> getConfirmProducts() {
        return getAllProductsWithStatus(Deal.Status.CONFIRM);
    }

    public List<Product> getToDistributorProducts() {
        return getAllProductsWithStatus(Deal.Status.TO_DISTRIBUTOR);
    }

    public List<Deal> getConfirmAdDeals() {
        List<Deal> resultList = new ArrayList<>();
        DealService service = DealService.getInstance();
        for (Product product : getProducts()) {
            if (product.getDeal() != null) {
                Deal deal = service.findById(product.getDeal().getId());
                if (deal != null && deal.getStatus() == Deal.Status.CONFIRM) {
                    resultList.add(deal);
                }
            }
        }
        return resultList;
    }

    public int getAdSizeDealsWithAdType(int number) {
        switch(number) {
            case 0: return getAdTypeProducts(AdType.AIRSHIP);
            case 1: return getAdTypeProducts(AdType.BALLOON);
            case 2: return getAdTypeProducts(AdType.BROADCAST);
            case 3:  return getAdTypeProducts(AdType.EVENT);
            case 4: return getAdTypeProducts(AdType.MEDIAN_NET);
            case 5: return getAdTypeProducts(AdType.INTERNET);
            case 6: return getAdTypeProducts(AdType.MEDIA_PRINTED);
            case 7: return getAdTypeProducts(AdType.OTH_PRINTED);
            case 8: return getAdTypeProducts(AdType.OUTDOOR);
            case 9: return getAdTypeProducts(AdType.SOUVENIR);
            default: return 0;
        }
    }

    private int getAdTypeProducts(AdType adType) {
        List<Deal> resultList = new ArrayList<>();
        DealService service = DealService.getInstance();
        for (Product product : getProducts()) {
            if (product.getDeal() != null) {
                Deal deal = service.findById(product.getDeal().getId());
                if (deal != null && product.getAdType() == adType) {
                    resultList.add(deal);
                }
            }
        }
        return resultList.size();
    }

    public int getProductAll() {
        return productAll;
    }
}
