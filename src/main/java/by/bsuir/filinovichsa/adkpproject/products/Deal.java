package by.bsuir.filinovichsa.adkpproject.products;

import by.bsuir.filinovichsa.adkpproject.ad.AbstractAd;
import by.bsuir.filinovichsa.adkpproject.services.DealService;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;
import by.bsuir.filinovichsa.adkpproject.users.Distributor;

import javax.persistence.*;

@Entity
@Table(name = "deals")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ad_id")
    private AbstractAd ad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distributor_id")
    private Distributor distributor;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String comment;

    public Deal() {
    }

    public Deal(Product product, AbstractAd ad, Distributor distributor, Status status, String comment) {
        this.product = product;
        this.ad = ad;
        this.distributor = distributor;
        this.status = status;
        this.comment = comment;
    }

    public enum Status {
        TO_DISTRIBUTOR("Ожидается ответ дистрибьютора"),
        DELETE_BY_DISTRIBUTOR("Отклонено дистрибьютором"),
        TO_ADVERTISER("Ожидается ответ адвертайзера"),
        DELETE_BY_ADVERTISER("Удалено рекламодателем"),
        CONFIRM("Заключено");

        private String name;
        Status(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    public void load() {
        DealService.getInstance().load(this);
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public AbstractAd getAd() {
        return ad;
    }

    public void setAd(AbstractAd ad) {
        this.ad = ad;
    }

    public Advertiser getAdvertiser() {
        return product.getOwner();
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
