package by.bsuir.filinovichsa.adkpproject.ad;

public enum AdType {
    AIRSHIP("На дирижабле"),
    BALLOON("На воздушном шаре"),
    BROADCAST("В теле-радио эфире"),
    EVENT("На мероприятии"),
    INTERNET("На видеохостинге"),
    MEDIAN_NET("На интернет-ресурсе"),
    MEDIA_PRINTED("В печатных СМИ"),
    OTH_PRINTED("Печатная"),
    OUTDOOR("На уличных коммуникациях"),
    SOUVENIR("На сувенирах");

    private String name;
    AdType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
