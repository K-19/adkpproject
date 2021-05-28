package by.bsuir.filinovichsa.adkpproject.ad;

import by.bsuir.filinovichsa.adkpproject.services.AdService;
import by.bsuir.filinovichsa.adkpproject.servlets.Servlets;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@DiscriminatorValue("INET_AD")
public class InternetAd extends AbstractAd{
    @Enumerated(EnumType.STRING)
    @Column(name = "internetadtype")
    protected InternetAdType type;
    protected float pricePerViewing;

    public static AbstractAd create(Object[] parameters) {
        InternetAd ad = new InternetAd();
        ad.setType(InternetAdType.get((String) parameters[0]));
        ad.setPricePerViewing((Float) parameters[1]);
        ad.setDescription((String) parameters[2]);
        return ad;
    }

    public static void getAndSave(HttpServletRequest req , int idAd) {
        String internetType = Servlets.getStringParameter(req, "internetType");
        float pricePerViewing = Float.parseFloat(req.getParameter("pricePerViewing"));
        String description = Servlets.getStringParameter(req, "adDescription");

        AdService service = AdService.getInstance();
        InternetAd ad = (InternetAd) service.findById(idAd);
        ad.setType(InternetAdType.get(internetType));
        ad.setPricePerViewing(pricePerViewing);
        ad.setDescription(description);
        ad.setId(idAd);

        service.update(ad);
    }

    @Override
    public int getCountFields() {
        return 3;
    }

    @Override
    public String getField(int number) {
        switch(number) {
            case 0: return "Тип интернет-рекламы: " + type.getName();
            case 1: return "Стоимость 1 просмотра: " + pricePerViewing;
            case 2: return "Описание: " + description;
            default: return "NaN";
        }
    }

    enum InternetAdType {
        FAST("Пост"),
        PRODUCT_PLACEMENT("Продакт-плейсмент"),
        MEDIA("Медийная");

        private String name;
        InternetAdType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static InternetAdType get(String name) {
            for (InternetAdType type : values()) {
                if (type.name.equals(name))
                    return type;
            }
            return null;
        }
    }

    public InternetAdType getType() {
        return type;
    }

    public void setType(InternetAdType type) {
        this.type = type;
    }

    public float getPricePerViewing() {
        return pricePerViewing;
    }

    public void setPricePerViewing(float pricePerViewing) {
        this.pricePerViewing = pricePerViewing;
    }
}
