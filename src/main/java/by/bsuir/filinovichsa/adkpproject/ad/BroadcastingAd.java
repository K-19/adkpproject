package by.bsuir.filinovichsa.adkpproject.ad;

import by.bsuir.filinovichsa.adkpproject.services.AdService;
import by.bsuir.filinovichsa.adkpproject.servlets.Servlets;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@DiscriminatorValue("BCAST_AD")
public class BroadcastingAd extends AbstractAd{
    @Enumerated(EnumType.STRING)
    @Column(name = "broadcasttype")
    private BroadcastType type;
    private int durationInSec;
    private int numberOfPaidImpressions;
    private int frequency;

    public static AbstractAd create(Object[] parameters) {
        BroadcastingAd ad = new BroadcastingAd();
        ad.setType(BroadcastType.get((String)parameters[0]));
        ad.setDurationInSec((Integer) parameters[1]);
        ad.setNumberOfPaidImpressions((Integer) parameters[2]);
        ad.setFrequency((Integer) parameters[3]);
        ad.setDescription((String) parameters[4]);
        return ad;
    }

    @Override
    public int getCountFields() {
        return 5;
    }

    @Override
    public String getField(int number) {
        switch(number) {
            case 0: return "Тип вещания: " + type.getName();
            case 1: return "Стоимость 1 секунды эфира: " + durationInSec;
            case 2: return "Количество оплаченных показов: " + numberOfPaidImpressions;
            case 3: return "Частота показа в день: " + frequency;
            case 4: return "Описание: " + description;
            default: return "NaN";
        }
    }

    public enum BroadcastType {
        TV("Телевидение"),
        RADIO("Радио");

        private String name;
        BroadcastType(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public static BroadcastType get(String name) {
            for (BroadcastType type : values()) {
                if (type.name.equals(name))
                    return type;
            }
            return null;
        }
    }

    public static void getAndSave(HttpServletRequest req, int idAd) {
        String type = Servlets.getStringParameter(req, "broadcastType");
        int duration = Integer.parseInt(req.getParameter("durationInSec"));
        int numberPaid = Integer.parseInt(req.getParameter("numberOfPaidImpressions"));
        int frequency = Integer.parseInt(req.getParameter("frequency"));
        String description = Servlets.getStringParameter(req, "adDescription");
        AdService service = AdService.getInstance();
        BroadcastingAd broadcastingAd = (BroadcastingAd) service.findById(idAd);
        broadcastingAd.setType(BroadcastingAd.BroadcastType.get(type));
        broadcastingAd.setDurationInSec(duration);
        broadcastingAd.setNumberOfPaidImpressions(numberPaid);
        broadcastingAd.setFrequency(frequency);
        broadcastingAd.setDescription(description);
        broadcastingAd.setId(idAd);
        service.update(broadcastingAd);
    }

    public BroadcastType getType() {
        return type;
    }

    public void setType(BroadcastType type) {
        this.type = type;
    }

    public int getDurationInSec() {
        return durationInSec;
    }

    public void setDurationInSec(int durationInSec) {
        this.durationInSec = durationInSec;
    }

    public int getNumberOfPaidImpressions() {
        return numberOfPaidImpressions;
    }

    public void setNumberOfPaidImpressions(int numberOfPaidImpressions) {
        this.numberOfPaidImpressions = numberOfPaidImpressions;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
