package by.bsuir.filinovichsa.adkpproject.factories;

import by.bsuir.filinovichsa.adkpproject.ad.*;

public class AdFactory {
    public AbstractAd createAd(AdType adType, Object[] parameters) {
        if (parameters == null)
            return new AirshipAd();
        switch(adType) {
            case AIRSHIP: return AirshipAd.create(parameters);
            case BALLOON: return BalloonAd.create(parameters);
            case BROADCAST: return BroadcastingAd.create(parameters);
            case EVENT: return EventAd.create(parameters);
            case INTERNET: return InternetAd.create(parameters);
            case MEDIAN_NET: return MediaNetAd.create(parameters);
            case MEDIA_PRINTED: return MediaPrintedAd.create(parameters);
            case OTH_PRINTED: return  OthPrintedAd.create(parameters);
            case OUTDOOR: return OutdoorAd.create(parameters);
            case SOUVENIR: return SouvenirAd.create(parameters);
            default: return null;
        }
    }
}