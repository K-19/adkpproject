package by.bsuir.filinovichsa.adkpproject.users;

import by.bsuir.filinovichsa.adkpproject.ad.AdType;
import by.bsuir.filinovichsa.adkpproject.ad.OutdoorAd;
import by.bsuir.filinovichsa.adkpproject.products.Deal;
import by.bsuir.filinovichsa.adkpproject.products.Product;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "distributors")
public class Distributor extends AbstractUser {
    @Enumerated(EnumType.STRING)
    private DistributorType distributorType;
    @OneToMany(mappedBy = "distributor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Deal> deals;

    public Distributor() {
    }

    public Distributor(DistributorType distributorType, UserType type, String nameOrganization, String description, String address, String agentName, String agentSurname, String agentPhone, String login, int password) {
        this.distributorType = distributorType;
        this.type = type;
        this.nameOrganization = nameOrganization;
        this.description = description;
        this.address = address;
        this.agentName = agentName;
        this.agentSurname = agentSurname;
        this.agentPhone = agentPhone;
        this.bankAccounts = new ArrayList<>();
        this.login = login;
        this.password = password;
        this.registerDate = LocalDateTime.now();
    }

    public enum DistributorType {
        NEWSPAPER(Collections.singletonList(AdType.MEDIA_PRINTED), "Газета"),
        MAGAZINE(Collections.singletonList(AdType.MEDIA_PRINTED), "Журнал"),
        INTERNET_PORTAL(Arrays.asList(AdType.INTERNET, AdType.MEDIAN_NET), "Интернет-портал"),
        RADIO_STATION(Collections.singletonList(AdType.BROADCAST), "Радиостанция"),
        TV_CHANNEL(Collections.singletonList(AdType.BROADCAST), "ТВ-канал"),
        OTHER(Arrays.asList(AdType.AIRSHIP, AdType.BALLOON, AdType.EVENT, AdType.OTH_PRINTED, AdType.OUTDOOR, AdType.SOUVENIR), "Другое");

        private final List<AdType> adTypes;
        private final String name;
        DistributorType(List<AdType> adTypes, String name) {
            this.adTypes = adTypes;
            this.name = name;
        }

        public boolean checkAvailableType(AdType type) {
            return this.adTypes.contains(type);
        }

        public String getName() {
            return name;
        }

        public static DistributorType get(String name) {
            for (DistributorType type : values()) {
                if (type.name.equals(name))
                    return type;
            }
            return null;
        }
    }

    public DistributorType getDistributorType() {
        return distributorType;
    }

    public List<Deal> getAvailableDeals() {
        List<Deal> deals = new ArrayList<>();
        for (Deal deal : this.deals) {
            if (deal.getStatus() != Deal.Status.CONFIRM && deal.getStatus() != Deal.Status.DELETE_BY_DISTRIBUTOR) {
                deals.add(deal);
            }
        }
        return deals;
    }

    public String getNameOrganization() {
        return super.getNameOrganization();
    }

    public void load() {
        super.load();
        for (Deal deal : deals) {
            deal.load();
        }
    }

    public List<Deal> getConfirmAdDeals() {
        List<Deal> deals = new ArrayList<>();
        for (Deal deal : this.deals) {
            if (deal.getStatus() == Deal.Status.CONFIRM) {
                deals.add(deal);
            }
        }
        return deals;
    }

    public void setDistributorType(DistributorType distributorType) {
        this.distributorType = distributorType;
    }
}
