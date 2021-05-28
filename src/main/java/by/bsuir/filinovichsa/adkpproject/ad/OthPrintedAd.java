package by.bsuir.filinovichsa.adkpproject.ad;

import by.bsuir.filinovichsa.adkpproject.services.AdService;
import by.bsuir.filinovichsa.adkpproject.servlets.Servlets;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@DiscriminatorValue("OTHPRINT_AD")
public class OthPrintedAd extends PrintedAd{
    @Enumerated(EnumType.STRING)
    @Column(name = "printtype")
    private PrintType type;
    @Enumerated(EnumType.STRING)
    private PaperSize paperSize;
    private float paperDensity;
    protected String paperMaterial;

    public static AbstractAd create(Object[] parameters) {
        OthPrintedAd ad = new OthPrintedAd();
        ad.setType(PrintType.get((String) parameters[0]));
        ad.setPaperSize(PaperSize.get((String) parameters[1]));
        ad.setPaperDensity((Float) parameters[2]);
        ad.setPaperMaterial((String) parameters[3]);
        ad.setLength((Integer) parameters[4]);
        ad.setWidth((Integer) parameters[5]);
        ad.setQuantity((Integer) parameters[6]);
        ad.setDescription((String) parameters[7]);
        return ad;
    }

    public static void getAndSave(HttpServletRequest req, int idAd) {
        String othType = Servlets.getStringParameter(req, "othPrintType");
        String paperSize = Servlets.getStringParameter(req, "paperSize");

        float density = Float.parseFloat(Servlets.getStringParameter(req, "paperDensity"));
        String paperMaterial = Servlets.getStringParameter(req, "material");
        int length = Integer.parseInt(req.getParameter("length"));
        int width = Integer.parseInt(Servlets.getStringParameter(req, "width"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String description = Servlets.getStringParameter(req, "adDescription");

        AdService service = AdService.getInstance();
        OthPrintedAd ad = (OthPrintedAd) service.findById(idAd);
        ad.setType(PrintType.get(othType));
        ad.setPaperSize(PaperSize.get(paperSize));
        ad.setPaperDensity(density);
        ad.setPaperMaterial(paperMaterial);
        ad.setLength(length);
        ad.setWidth(width);
        ad.setDescription(description);
        ad.setId(idAd);

        service.update(ad);
    }

    @Override
    public int getCountFields() {
        return 8;
    }

    @Override
    public String getField(int number) {
        switch(number) {
            case 0: return "Тип печатного изделия: " + type.getName();
            case 1: return "Размер страницы: " + paperSize;
            case 2: return "Плотность бумаги: " + paperDensity;
            case 3: return "Материал бумаги: " + paperMaterial;
            case 4: return "Длина рекламной части: " + length;
            case 5: return "Ширина рекламной части: " + width;
            case 6: return "Тираж номера: " + quantity;
            case 7: return "Описание: " + description;
            default: return "NaN";
        }
    }

    enum PrintType {
        POSTER("Плакат"),
        LEAFLET("Листовка"),
        BROCHURE("Брошюра"),
        POSTCARD("Открытка"),
        CALENDAR("Календарь"),
        BUSINESS_CARD("Визитка");

        private String name;

        public String getName() {
            return name;
        }

        PrintType(String name) {
            this.name = name;
        }

        public static PrintType get(String name) {
            for (PrintType type : values()) {
                if (type.name.equals(name))
                    return type;
            }
            return null;
        }
    }

    public PrintType getType() {
        return type;
    }

    public void setType(PrintType type) {
        this.type = type;
    }

    public PaperSize getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(PaperSize paperSize) {
        this.paperSize = paperSize;
    }

    public float getPaperDensity() {
        return paperDensity;
    }

    public void setPaperDensity(float paperDensity) {
        this.paperDensity = paperDensity;
    }

    public String getPaperMaterial() {
        return paperMaterial;
    }

    public void setPaperMaterial(String paperMaterial) {
        this.paperMaterial = paperMaterial;
    }
}
