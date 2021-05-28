package by.bsuir.filinovichsa.adkpproject.ad;

import by.bsuir.filinovichsa.adkpproject.services.AdService;
import by.bsuir.filinovichsa.adkpproject.servlets.Servlets;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@DiscriminatorValue("BLN_AD")
public class BalloonAd extends SkyAd{
    private int numberOfHours;
    private float pricePerHour;
    private boolean newBalloon;

    public static AbstractAd create(Object[] parameters) {
        BalloonAd ad = new BalloonAd();
        ad.setNumberOfHours((Integer) parameters[0]);
        ad.setPricePerHour((Float) parameters[1]);
        ad.setNewBalloon((Boolean) parameters[2]);
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
            case 0: return "Количество часов в воздухе: " + numberOfHours;
            case 1: return "Цена за 1 час полета: " + pricePerHour;
            case 2: return "Новый шар?: " + (newBalloon ? "checked" : "");
            case 3: return "Время запуска: " + dateTime;
            case 4: return "Описание: " + description;
            default: return "NaN";
        }
    }

    public static void getAndSave(HttpServletRequest req, int idAd) {
        int numberOfHours = Integer.parseInt(Servlets.getStringParameter(req, "numberOfHours"));
        float pricePerHour = Float.parseFloat(Servlets.getStringParameter(req, "pricePerHour"));
        String newBalloonString = req.getParameter("newBalloon");
        boolean newBalloon;
        newBalloon = newBalloonString != null;
        String startTime = Servlets.getStringParameter(req, "startTime");
        String description = Servlets.getStringParameter(req, "adDescription");
        AdService service = AdService.getInstance();
        BalloonAd balloonAd = (BalloonAd) service.findById(idAd);
        balloonAd.setNumberOfHours(numberOfHours);
        balloonAd.setPricePerHour(pricePerHour);
        balloonAd.setNewBalloon(newBalloon);
        balloonAd.setDateTime(LocalDateTime.parse(startTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        balloonAd.setDescription(description);
        balloonAd.setId(idAd);
        service.update(balloonAd);
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public float getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public boolean isNewBalloon() {
        return newBalloon;
    }

    public void setNewBalloon(boolean newBalloon) {
        this.newBalloon = newBalloon;
    }
}
