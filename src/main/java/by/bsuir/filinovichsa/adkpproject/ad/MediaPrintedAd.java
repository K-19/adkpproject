package by.bsuir.filinovichsa.adkpproject.ad;

import by.bsuir.filinovichsa.adkpproject.services.AdService;
import by.bsuir.filinovichsa.adkpproject.servlets.Servlets;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@DiscriminatorValue("MPRINT_AD")
public class MediaPrintedAd extends PrintedAd{
    @Enumerated(EnumType.STRING)
    @Column(name = "mediaprinttype")
    private MediaPrintType type;
    private int pageNumber;

    public static AbstractAd create(Object[] parameters) {
        MediaPrintedAd ad = new MediaPrintedAd();
        ad.setType(MediaPrintType.get((String) parameters[0]));
        ad.setPageNumber((Integer) parameters[1]);
        ad.setLength((Integer) parameters[2]);
        ad.setWidth((Integer) parameters[3]);
        ad.setQuantity((Integer) parameters[4]);
        ad.setDescription((String) parameters[5]);
        return ad;
    }

    @Override
    public int getCountFields() {
        return 6;
    }

    @Override
    public String getField(int number) {
        switch(number) {
            case 0: return "Тип печатного издания: " + type.getName();
            case 1: return "Номер страницы: " + pageNumber;
            case 2: return "Длина рекламной части: " + length;
            case 3: return "Ширина рекламной части: " + width;
            case 4: return "Тираж номера: " + quantity;
            case 5: return "Описание: " + description;
            default: return "NaN";
        }
    }

    enum MediaPrintType {
        NEWSPAPER("Газета"),
        MAGAZINE("Журнал"),
        CATALOG("Каталог");

        private String name;

        public String getName() {
            return name;
        }

        MediaPrintType(String name) {
            this.name = name;
        }

        public static MediaPrintType get(String name) {
            for (MediaPrintType type : values()) {
                if (type.name.equals(name))
                    return type;
            }
            return null;
        }
    }

    public static void getAndSave(HttpServletRequest req, int idAd) {
        String mediaType = Servlets.getStringParameter(req, "mediaPrintType");
        int pageNumber = Integer.parseInt(Servlets.getStringParameter(req, "pageNumber"));
        int length = Integer.parseInt(Servlets.getStringParameter(req, "length"));
        int width = Integer.parseInt(Servlets.getStringParameter(req, "width"));
        int quantity = Integer.parseInt(Servlets.getStringParameter(req, "quantity"));
        String description = Servlets.getStringParameter(req, "adDescription");

        AdService service = AdService.getInstance();
        MediaPrintedAd ad = (MediaPrintedAd) service.findById(idAd);
        ad.setType(MediaPrintType.get(mediaType));
        ad.setPageNumber(pageNumber);
        ad.setLength(length);
        ad.setWidth(width);
        ad.setQuantity(quantity);
        ad.setDescription(description);
        ad.setId(idAd);

        service.update(ad);
    }

    public MediaPrintType getType() {
        return type;
    }

    public void setType(MediaPrintType type) {
        this.type = type;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
