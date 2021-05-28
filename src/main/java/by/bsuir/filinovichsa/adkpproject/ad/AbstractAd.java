package by.bsuir.filinovichsa.adkpproject.ad;

import by.bsuir.filinovichsa.adkpproject.products.Deal;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

@Entity
@Table(name = "ads")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ad_type")
public abstract class AbstractAd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(mappedBy = "ad")
    private Deal deal;
    protected String description;

    public abstract int getCountFields();
    public abstract String getField(int number);

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }
}
