package by.bsuir.filinovichsa.adkpproject.ad;

import by.bsuir.filinovichsa.adkpproject.services.AdService;
import by.bsuir.filinovichsa.adkpproject.servlets.Servlets;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@DiscriminatorValue("EVNT_AD")
public class EventAd extends AbstractAd{
    @Enumerated(EnumType.STRING)
    @Column(name = "eventtype")
    private EventType type;
    private LocalDateTime dateTime;
    private float pricePerVisitor;

    public static AbstractAd create(Object[] parameters) {
        EventAd ad = new EventAd();
        ad.setType(EventType.get((String)parameters[0]));
        ad.setDateTime(LocalDateTime.parse((String)parameters[1], DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        ad.setPricePerVisitor((Float) parameters[2]);
        ad.setDescription((String) parameters[3]);
        return ad;
    }

    public static void getAndSave(HttpServletRequest req, int idAd) {
        String type = Servlets.getStringParameter(req, "eventType");
        String startTime = Servlets.getStringParameter(req, "startTime");
        float price = Integer.parseInt(req.getParameter("pricePerVisitor"));
        String description = Servlets.getStringParameter(req, "adDescription");

        AdService service = AdService.getInstance();
        EventAd ad = (EventAd) service.findById(idAd);
        ad.setType(EventType.get(type));
        ad.setDateTime(LocalDateTime.parse(startTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        ad.setDescription(description);
        ad.setId(idAd);

        service.update(ad);
    }

    @Override
    public int getCountFields() {
        return 4;
    }

    @Override
    public String getField(int number) {
        switch(number) {
            case 0: return "Тип события: " + type.getName();
            case 1: return "Время начала: " + dateTime;
            case 2: return "Стоимость за 1 посетителя: " + pricePerVisitor;
            case 3: return "Описание: " + description;
            default: return "NaN";
        }
    }

    enum EventType {
        EXHIBITION("Выставка"),
        CONFERENCE("Конференция"),
        FESTIVAL("Фестиваль"),
        PRESENTATION("Презентация"),
        SHOW("Шоу"),
        INTERACTIVE("Интерактив"),
        CONCERT("Концерт"),
        OTHER("Другое");

        private String name;

        EventType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static EventType get(String name) {
            for (EventType type : values()) {
                if (type.name.equals(name))
                    return type;
            }
            return null;
        }
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public float getPricePerVisitor() {
        return pricePerVisitor;
    }

    public void setPricePerVisitor(float pricePerVisitor) {
        this.pricePerVisitor = pricePerVisitor;
    }
}
