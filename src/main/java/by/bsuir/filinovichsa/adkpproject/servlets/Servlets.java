package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.ad.AdType;
import by.bsuir.filinovichsa.adkpproject.services.UserService;
import by.bsuir.filinovichsa.adkpproject.users.AbstractUser;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;
import by.bsuir.filinovichsa.adkpproject.users.Distributor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;

public class Servlets {
    public static String getStringParameter(HttpServletRequest req, String parameterName) {
        String value = req.getParameter(parameterName);
        if (value == null)
            return "";
        else return new String(value.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }

    public static AbstractUser.UserType getUserType(HttpServletRequest req, String paramName, String forwardPageName) {
        String orgType = Servlets.getStringParameter(req, paramName);
        AbstractUser.UserType userType = null;
        switch(orgType) {
            case "Юридическое лицо":
                userType = AbstractUser.UserType.LEGAL_ENTITY;
                break;
            case "Индивидуальный предприниматель":
                userType = AbstractUser.UserType.INDIVIDUAL_ENTREPRENEUR;
                break;
            default:
                return null;
        }
        return userType;
    }

    public static boolean allNotEmpty(String...strings) {
        for (String string : strings) {
            if (string.isEmpty())
                return false;
        }
        return true;
    }

    public static void refreshAdvertiser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        int idUser = ((Advertiser)session.getAttribute("user")).getId();
        UserService service = UserService.getInstance();
        Advertiser freshAdvertiser = service.findAdvertiser(idUser);
        session.setAttribute("user", freshAdvertiser);
    }

    public static void refreshDistributor(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        int idUser = ((Distributor)session.getAttribute("user")).getId();
        UserService service = UserService.getInstance();
        Distributor freshDistributor = service.findDistributor(idUser);
        session.setAttribute("user", freshDistributor);
    }

    public static Object[] readAdByRequest(HttpServletRequest req, AdType adType) {
        String startTime;
        String description;
        int length;
        int width;
        int quantity;
        String type;
        String mediaType;
        String internetType;
        float pricePerViewing;
        switch(adType) {
            case AIRSHIP:
                int numberOfDays = Integer.parseInt(Servlets.getStringParameter(req, "numberOfDays"));
                length = Integer.parseInt(Servlets.getStringParameter(req, "length"));
                width = Integer.parseInt(Servlets.getStringParameter(req, "width"));
                startTime = Servlets.getStringParameter(req, "startTime");
                description = Servlets.getStringParameter(req, "description");
                return new Object[]{numberOfDays, length, width, startTime, description};
            case BALLOON:
                int numberOfHours = Integer.parseInt(Servlets.getStringParameter(req, "numberOfHours"));
                float pricePerHour = Float.parseFloat(Servlets.getStringParameter(req, "pricePerHour"));
                String newBalloonString = req.getParameter("newBalloon");
                boolean newBalloon;
                newBalloon = newBalloonString != null;
                startTime = Servlets.getStringParameter(req, "startTime");
                description = Servlets.getStringParameter(req, "adDescription");
                return new Object[]{numberOfHours, pricePerHour, newBalloon, startTime, description};
            case BROADCAST:
                type = Servlets.getStringParameter(req, "broadcastType");
                int duration = Integer.parseInt(req.getParameter("durationInSec"));
                int numberPaid = Integer.parseInt(req.getParameter("numberOfPaidImpressions"));
                int frequency = Integer.parseInt(req.getParameter("frequency"));
                description = Servlets.getStringParameter(req, "adDescription");
                return new Object[]{type, duration, numberPaid, frequency, description};
            case MEDIA_PRINTED:
                mediaType = Servlets.getStringParameter(req, "mediaPrintType");
                int pageNumber = Integer.parseInt(Servlets.getStringParameter(req, "pageNumber"));
                length = Integer.parseInt(Servlets.getStringParameter(req, "length"));
                width = Integer.parseInt(Servlets.getStringParameter(req, "width"));
                quantity = Integer.parseInt(Servlets.getStringParameter(req, "quantity"));
                description = Servlets.getStringParameter(req, "adDescription");
                return new Object[]{mediaType, pageNumber, length, width, quantity, description};
            case OTH_PRINTED:
                String othType = Servlets.getStringParameter(req, "othPrintType");
                String paperSize = Servlets.getStringParameter(req, "paperSize");
                float density = Float.parseFloat(Servlets.getStringParameter(req, "paperDensity"));
                String paperMaterial = Servlets.getStringParameter(req, "material");
                length = Integer.parseInt(req.getParameter("length"));
                width = Integer.parseInt(Servlets.getStringParameter(req, "width"));
                quantity = Integer.parseInt(req.getParameter("quantity"));
                description = Servlets.getStringParameter(req, "adDescription");
                return new Object[]{othType, paperSize, density, paperMaterial, length, width, quantity, description};
            case EVENT:
                type = Servlets.getStringParameter(req, "eventType");
                startTime = Servlets.getStringParameter(req, "startTime");
                float price = Integer.parseInt(req.getParameter("pricePerVisitor"));
                description = Servlets.getStringParameter(req, "adDescription");
                return new Object[]{type, startTime, price, description};
            case MEDIAN_NET:
                mediaType = Servlets.getStringParameter(req, "mediaType");
                int numberOfPaidImpressions = Integer.parseInt(Servlets.getStringParameter(req, "numberOfPaidImpressions"));
                length = Integer.parseInt(req.getParameter("length"));
                width = Integer.parseInt(Servlets.getStringParameter(req, "width"));
                String format = Servlets.getStringParameter(req, "format");
                int versions = Integer.parseInt(req.getParameter("numberOfVersions"));
                internetType = Servlets.getStringParameter(req, "internetType");
                pricePerViewing = Float.parseFloat(req.getParameter("pricePerViewing"));
                description = Servlets.getStringParameter(req, "adDescription");
                return new Object[]{mediaType, numberOfPaidImpressions, length, width, format, versions, internetType, pricePerViewing, description};
            case SOUVENIR:
                type = Servlets.getStringParameter(req, "souvenirType");
                quantity = Integer.parseInt(req.getParameter("quantity"));
                description = Servlets.getStringParameter(req, "adDescription");
                return new Object[]{type, quantity, description};
            case INTERNET:
                internetType = Servlets.getStringParameter(req, "internetType");
                pricePerViewing = Float.parseFloat(req.getParameter("pricePerViewing"));
                description = Servlets.getStringParameter(req, "adDescription");
                return new Object[]{internetType, pricePerViewing, description};
            case OUTDOOR:
                type = Servlets.getStringParameter(req, "outdoorType");
                String address = Servlets.getStringParameter(req, "address");
                String backlightString = req.getParameter("backlight");
                boolean backlight;
                backlight = backlightString != null;
                length = Integer.parseInt(req.getParameter("length"));
                width = Integer.parseInt(req.getParameter("width"));
                int numberOfPaidDays = Integer.parseInt(req.getParameter("numberOfPaidDays"));
                description = Servlets.getStringParameter(req, "adDescription");
                return new Object[]{type, address, backlight, length, width, numberOfPaidDays, description};
            default: return null;
        }
    }
}
