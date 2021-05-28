package by.bsuir.filinovichsa.adkpproject.ad;

import by.bsuir.filinovichsa.adkpproject.services.AdService;
import by.bsuir.filinovichsa.adkpproject.servlets.Servlets;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

@Entity
@DiscriminatorValue("MNET_AD")
public class MediaNetAd extends InternetAd{
    @Enumerated(EnumType.STRING)
    @Column(name = "medianetadtype")
    private MediaNetAdType mediaType;
    private int numberOfPaidImpressions;
    private int length;
    private int width;
    @Enumerated(EnumType.STRING)
    private FormatType format;
    private int numberOfVersions;

    public static AbstractAd create(Object[] parameters) {
        MediaNetAd ad = new MediaNetAd();
        ad.setMediaType(MediaNetAdType.get((String) parameters[0]));
        ad.setNumberOfPaidImpressions((Integer) parameters[1]);
        ad.setLength((Integer) parameters[2]);
        ad.setWidth((Integer) parameters[3]);
        ad.setFormat(FormatType.get((String) parameters[4]));
        ad.setNumberOfVersions((Integer) parameters[5]);
        ad.setType(InternetAdType.get((String) parameters[6]));
        ad.setPricePerViewing((Float) parameters[7]);
        ad.setDescription((String) parameters[8]);
        return ad;
    }

    public static void getAndSave(HttpServletRequest req, int idAd) {
        String mediaType = Servlets.getStringParameter(req, "mediaType");
        int numberOfPaidImpressions = Integer.parseInt(Servlets.getStringParameter(req, "numberOfPaidImpressions"));
        int length = Integer.parseInt(req.getParameter("length"));
        int width = Integer.parseInt(Servlets.getStringParameter(req, "width"));
        String format = Servlets.getStringParameter(req, "format");
        int versions = Integer.parseInt(req.getParameter("numberOfVersions"));
        String internetType = Servlets.getStringParameter(req, "internetType");
        float pricePerViewing = Float.parseFloat(req.getParameter("pricePerViewing"));
        String description = Servlets.getStringParameter(req, "adDescription");

        AdService service = AdService.getInstance();
        MediaNetAd ad = (MediaNetAd) service.findById(idAd);
        ad.setMediaType(MediaNetAdType.get(mediaType));
        ad.setNumberOfPaidImpressions(numberOfPaidImpressions);
        ad.setLength(length);
        ad.setWidth(width);
        ad.setFormat(FormatType.get(format));
        ad.setNumberOfVersions(versions);
        ad.setType(InternetAdType.get(internetType));
        ad.setPricePerViewing(pricePerViewing);
        ad.setDescription(description);
        ad.setId(idAd);

        service.update(ad);
    }

    @Override
    public int getCountFields() {
        return 9;
    }

    @Override
    public String getField(int number) {
        switch(number) {
            case 0: return "Тип информации: " + mediaType.getName();
            case 1: return "Количество оплаченых просмотров: " + numberOfPaidImpressions;
            case 2: return "Длина рекламной части: " + length;
            case 3: return "Ширина рекламной части: " + width;
            case 4: return "Формат информации: " + format.getName();
            case 5: return "Количество версий: " + numberOfVersions;
            case 6: return "Тип интернет-рекламы: " + type.getName();
            case 7: return "Стоимость 1 просмотра: " + pricePerViewing;
            case 8: return "Описание: " + description;
            default: return "NaN";
        }
    }

    enum MediaNetAdType {
        BANNER("Баннер"), // баннер
        POP_UP_BANNER("Вспылающий баннер"), // всплывающий баннер
        TEXT("Текстовая"); // текстовая

        private String name;
        MediaNetAdType(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public static MediaNetAdType get(String name) {
            for (MediaNetAdType type : values()) {
                if (type.name.equals(name))
                    return type;
            }
            return null;
        }
    }

    enum FormatType {
        HTML5("HTML5"),
        FLASH("FLASH"),
        HTML5_FLASH("HTML5 + FLASH");

        private String name;

        public String getName() {
            return name;
        }

        FormatType(String name) {
            this.name = name;
        }

        public static FormatType get(String name) {
            for (FormatType type : values()) {
                if (type.name.equals(name))
                    return type;
            }
            return null;
        }
    }

    public MediaNetAdType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaNetAdType mediaType) {
        this.mediaType = mediaType;
    }

    public int getNumberOfPaidImpressions() {
        return numberOfPaidImpressions;
    }

    public void setNumberOfPaidImpressions(int numberOfPaidImpressions) {
        this.numberOfPaidImpressions = numberOfPaidImpressions;
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

    public FormatType getFormat() {
        return format;
    }

    public void setFormat(FormatType format) {
        this.format = format;
    }

    public int getNumberOfVersions() {
        return numberOfVersions;
    }

    public void setNumberOfVersions(int numberOfVersions) {
        this.numberOfVersions = numberOfVersions;
    }
}
