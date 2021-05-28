package by.bsuir.filinovichsa.adkpproject.ad;

import by.bsuir.filinovichsa.adkpproject.services.AdService;
import by.bsuir.filinovichsa.adkpproject.servlets.Servlets;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@DiscriminatorValue("AIR_AD")
public class AirshipAd extends SkyAd{
    private int numberOfDays;
    private int length;
    private int width;

    public AirshipAd() {
    }

    public static AbstractAd create(Object[] parameters) {
        AirshipAd ad = new AirshipAd();
        ad.setNumberOfDays((Integer) parameters[0]);
        ad.setLength((Integer) parameters[1]);
        ad.setWidth((Integer) parameters[2]);
        ad.setDateTime(LocalDateTime.parse((String)parameters[3], DateTimeFormatter.ISO_LOCAL_DATE_TIME));
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
            case 0: return "Количество дней в воздухе: " + numberOfDays;
            case 1: return "Длина рекламной части: " + length;
            case 2: return "Ширина рекламной части: " + width;
            case 3: return "Время запуска: " + dateTime;
            case 4: return "Описание: " + description;
            default: return "NaN";
        }
    }

    public static void getAndSave(HttpServletRequest req, int idAd) {
        int numberOfDays = Integer.parseInt(Servlets.getStringParameter(req, "numberOfDays"));
        int length = Integer.parseInt(Servlets.getStringParameter(req, "length"));
        int width = Integer.parseInt(Servlets.getStringParameter(req, "width"));
        String startTime = Servlets.getStringParameter(req, "startTime");
        String description = Servlets.getStringParameter(req, "adDescription");

        AdService service = AdService.getInstance();
        AirshipAd ad = (AirshipAd) service.findById(idAd);
        ad.setNumberOfDays(numberOfDays);
        ad.setLength(length);
        ad.setWidth(width);
        ad.setDateTime(LocalDateTime.parse(startTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        ad.setDescription(description);
        ad.setId(idAd);

        service.update(ad);
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

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
