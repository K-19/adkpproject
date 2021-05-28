package by.bsuir.filinovichsa.adkpproject.users;



import by.bsuir.filinovichsa.adkpproject.ad.OutdoorAd;
import by.bsuir.filinovichsa.adkpproject.support.SupportMessage;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(name = "usertype")
    @Enumerated(EnumType.STRING)
    protected UserType type;
    @Column(name = "nameorg")
    protected String nameOrganization;
    protected String description;
    protected String address;
    protected String agentName;
    protected String agentSurname;
    protected String agentPhone;
    protected String login;
    protected int password;
    @Column(name = "registrdate")
    protected LocalDateTime registerDate;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    protected List<BankAccount> bankAccounts;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    protected List<SupportMessage> messages;

    public static enum UserType {
        LEGAL_ENTITY("Юридическое лицо"),
        INDIVIDUAL_ENTREPRENEUR("Индивидуальный предприниматель");
        private String name;
        UserType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public static UserType get(String name) {
            for (UserType type : values()) {
                if (type.name.equals(name))
                    return type;
            }
            return null;
        }
    }

    public AbstractUser() {
    }

    public void addBankAccount(BankAccount account) {
        this.bankAccounts.add(account);
    }
    public void removeBankAccount(BankAccount account) { this.bankAccounts.remove(account); }
    public void addSupportMessage(SupportMessage message) { this.messages.add(message); }

    public void load() {
        for (BankAccount account : bankAccounts) {
            account.getIndividualAccount();
        }
        for (SupportMessage message : messages) {
            message.getText();
        }
    }

    public List<String> getAllCountriesCode() {
        List<String> codes = new ArrayList<>();
        for (BankAccount.CountryCode code : BankAccount.CountryCode.values()) {
            codes.add(code.name());
        }
        return codes;
    }

    public List<SupportMessage> getMessages() {
        Collections.sort(messages, new Comparator<SupportMessage>() {
            @Override
            public int compare(SupportMessage o1, SupportMessage o2) {
                return o2.getId() - o1.getId();
            }
        });
        return messages;
    }

    public String getFullAgentName() {
        return agentSurname + " " + agentName + " | " + agentPhone;
    }

    public int getId() {
        return id;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getNameOrganization() {
        return nameOrganization;
    }

    public void setNameOrganization(String nameOrganization) {
        this.nameOrganization = nameOrganization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentSurname() {
        return agentSurname;
    }

    public void setAgentSurname(String agentSurname) {
        this.agentSurname = agentSurname;
    }

    public String getAgentPhone() {
        return agentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public long howManyDaysSinceRegistration() {
        return ChronoUnit.DAYS.between(registerDate, LocalDateTime.now());
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getPassword() {
        return password;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

}
