package by.bsuir.filinovichsa.adkpproject.ad;

import javax.persistence.*;

@Entity
@Table(name = "ads")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ad_type")
public abstract class PrintedAd extends ThingsAd{
    protected int length;
    protected int width;


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
