package by.bsuir.filinovichsa.adkpproject.products;

import by.bsuir.filinovichsa.adkpproject.ad.AbstractAd;
import by.bsuir.filinovichsa.adkpproject.ad.AdType;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private AdType adType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Advertiser owner;
    @OneToOne(mappedBy = "product")
    private Deal deal;
    private boolean acquired;

    public Product() {
    }

    public Product(String name, String description, AdType adType, Advertiser owner) {
        this.name = name;
        this.description = description;
        this.adType = adType;
        this.owner = owner;
        this.acquired = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public AdType getAdType() {
        return adType;
    }

    public Advertiser getOwner() {
        return owner;
    }

    public boolean isAcquired() {
        return acquired;
    }

    public void setAcquired(boolean acquired) {
        this.acquired = acquired;
    }

    public Deal getDeal() {
        return deal;
    }
}
