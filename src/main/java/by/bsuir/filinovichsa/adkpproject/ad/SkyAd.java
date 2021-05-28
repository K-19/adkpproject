package by.bsuir.filinovichsa.adkpproject.ad;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ads")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ad_type")
public abstract class SkyAd extends AbstractAd{
    protected LocalDateTime dateTime;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
