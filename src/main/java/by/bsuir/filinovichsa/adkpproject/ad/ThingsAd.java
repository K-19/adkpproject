package by.bsuir.filinovichsa.adkpproject.ad;

import javax.persistence.*;

@Entity
@Table(name = "ads")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ad_type")
public abstract class ThingsAd extends AbstractAd{
    protected int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
