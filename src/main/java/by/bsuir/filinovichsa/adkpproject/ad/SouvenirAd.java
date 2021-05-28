package by.bsuir.filinovichsa.adkpproject.ad;

import by.bsuir.filinovichsa.adkpproject.services.AdService;
import by.bsuir.filinovichsa.adkpproject.servlets.Servlets;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@DiscriminatorValue("SOUV_AD")
public class SouvenirAd extends ThingsAd{
    @Enumerated(EnumType.STRING)
    @Column(name = "souvenirtype")
    private SouvenirType type;

    public static AbstractAd create(Object[] parameters) {
        SouvenirAd ad = new SouvenirAd();
        ad.setType(SouvenirType.get((String) parameters[0]));
        ad.setQuantity((Integer) parameters[1]);
        ad.setDescription((String) parameters[2]);
        return ad;
    }

    public static void getAndSave(HttpServletRequest req, int idAd) {
        String type = Servlets.getStringParameter(req, "souvenirType");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String description = Servlets.getStringParameter(req, "adDescription");

        AdService service = AdService.getInstance();
        SouvenirAd ad = (SouvenirAd) service.findById(idAd);
        ad.setType(SouvenirType.get(type));
        ad.setQuantity(quantity);
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
            case 0: return "Тип рекламного изделия: " + type.getName();
            case 1: return "Количество: " + quantity;
            case 2: return "Описание: " + description;
            default: return "NaN";
        }
    }

    enum SouvenirType {
        NOTEBOOK("Записная книжка"),
        PEN("Авторучка"),
        BADGE("Значок"),
        AD_FOLDER("Папка с рекламой"),
        RULER("Линейка"),
        BOOKMARK("Закладка"),
        THERMOMETER("Термометр"),
        LIGHTER("Зажигалка"),
        TRINKET("Брелок");

        private String name;

        public String getName() {
            return name;
        }

        SouvenirType(String name) {
            this.name = name;
        }

        public static SouvenirType get(String name) {
            for (SouvenirType type : values()) {
                if (type.name.equals(name))
                    return type;
            }
            return null;
        }
    }

    public SouvenirType getType() {
        return type;
    }

    public void setType(SouvenirType type) {
        this.type = type;
    }
}
