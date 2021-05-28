package by.bsuir.filinovichsa.adkpproject.ad;

public enum PaperSize {
    A0,
    A1,
    A2,
    A3,
    A4;

    public static PaperSize get(String name) {
        for (PaperSize type : values()) {
            if (type.toString().equals(name))
                return type;
        }
        return null;
    }
}
