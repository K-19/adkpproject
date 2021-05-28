package by.bsuir.filinovichsa.adkpproject.ad;

import by.bsuir.filinovichsa.adkpproject.services.AdService;
import by.bsuir.filinovichsa.adkpproject.servlets.Servlets;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

@Entity
@DiscriminatorValue("OUTDOOR_AD")
public class OutdoorAd extends AbstractAd{
    @Enumerated(EnumType.STRING)
    @Column(name = "outdoortype")
    private OutdoorType type;
    private String address;
    private boolean backlight;
    private int length;
    private int width;
    private int numberOfPaidDays;

    public static AbstractAd create(Object[] parameters) {
        OutdoorAd ad = new OutdoorAd();
        ad.setType(OutdoorType.get((String) parameters[0]));
        ad.setAddress((String) parameters[1]);
        ad.setBacklight((Boolean) parameters[2]);
        ad.setLength((Integer) parameters[3]);
        ad.setWidth((Integer) parameters[4]);
        ad.setNumberOfPaidDays((Integer) parameters[5]);
        ad.setDescription((String) parameters[6]);
        return ad;
    }

    public static void getAndSave(HttpServletRequest req, int idAd) {
        String type = Servlets.getStringParameter(req, "outdoorType");
        String address = Servlets.getStringParameter(req, "address");
        String backlightString = req.getParameter("backlight");
        boolean backlight;
        backlight = backlightString != null;
        int length = Integer.parseInt(req.getParameter("length"));
        int width = Integer.parseInt(req.getParameter("width"));
        int numberOfPaidDays = Integer.parseInt(req.getParameter("numberOfPaidDays"));
        String description = Servlets.getStringParameter(req, "adDescription");
        AdService service = AdService.getInstance();
        OutdoorAd ad = (OutdoorAd) service.findById(idAd);
        ad.setType(OutdoorType.get(type));
        ad.setAddress(address);
        ad.setBacklight(backlight);
        ad.setLength(length);
        ad.setWidth(width);
        ad.setNumberOfPaidDays(numberOfPaidDays);
        ad.setDescription(description);
        ad.setId(idAd);
        service.update(ad);
    }

    @Override
    public int getCountFields() {
        return 7;
    }

    @Override
    public String getField(int number) {
        switch(number) {
            case 0: return "Тип рекламной конструкции: " + type.getName();
            case 1: return "Адрес конструкции: " + address;
            case 2: return "Подсветка " + backlight;
            case 3: return "Длина рекламной части: " + length;
            case 4: return "Ширина рекламной части: " + width;
            case 5: return "Количество оплаченных дней: " + numberOfPaidDays;
            case 6: return "Описание: " + description;
            default: return "NaN";
        }
    }

    enum OutdoorType {
        BILLBOARD("Рекламный щит"),
        SIGNBOARD("Вывеска"),
        PILLAR("Столб"),
        SHOWCASE("Витрина");

        private String name;

        public String getName() {
            return name;
        }

        OutdoorType(String name) {
            this.name = name;
        }

        public static OutdoorType get(String name) {
            for (OutdoorType type : values()) {
                if (type.name.equals(name))
                    return type;
            }
            return null;
        }
    }

    public OutdoorType getType() {
        return type;
    }

    public void setType(OutdoorType type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isBacklight() {
        return backlight;
    }

    public void setBacklight(boolean backlight) {
        this.backlight = backlight;
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

    public int getNumberOfPaidDays() {
        return numberOfPaidDays;
    }

    public void setNumberOfPaidDays(int numberOfPaidDays) {
        this.numberOfPaidDays = numberOfPaidDays;
    }
}
