package by.bsuir.filinovichsa.adkpproject.users;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bankaccounts")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AbstractUser owner;
    @Enumerated(EnumType.STRING)
    private CountryCode countryCode;
    private String checkNumber;
    private String bankBICCode;
    private String balanceAccount;
    private String individualAccount;
    private String bankBranchName;
    private String bankBranchAddress;

    public BankAccount() {
    }

    public BankAccount(AbstractUser owner, CountryCode countryCode, String checkNumber, String bankBICCode, String balanceAccount, String individualAccount, String bankBranchName, String bankBranchAddress) {
        this.owner = owner;
        this.countryCode = countryCode;
        this.checkNumber = checkNumber;
        this.bankBICCode = bankBICCode;
        this.balanceAccount = balanceAccount;
        this.individualAccount = individualAccount;
        this.bankBranchName = bankBranchName;
        this.bankBranchAddress = bankBranchAddress;
    }

    public enum CountryCode {
        BY,
        RU,
        KZ
    }

    public String getFullInformation() {
        String info = countryCode +
                checkNumber +
                bankBICCode +
                balanceAccount +
                individualAccount +
                "\tБанк: " +
                bankBranchName +
                bankBranchAddress;
        return info;
    }

    public int getId() {
        return id;
    }

    public AbstractUser getOwner() {
        return owner;
    }

    public void setOwner(AbstractUser owner) {
        this.owner = owner;
    }

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(CountryCode countryCode) {
        this.countryCode = countryCode;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String getBankBICCode() {
        return bankBICCode;
    }

    public void setBankBICCode(String bankBICCode) {
        this.bankBICCode = bankBICCode;
    }

    public String getBalanceAccount() {
        return balanceAccount;
    }

    public void setBalanceAccount(String balanceAccount) {
        this.balanceAccount = balanceAccount;
    }

    public String getIndividualAccount() {
        return individualAccount;
    }

    public void setIndividualAccount(String individualAccount) {
        this.individualAccount = individualAccount;
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    public String getBankBranchAddress() {
        return bankBranchAddress;
    }

    public void setBankBranchAddress(String bankBranchAddress) {
        this.bankBranchAddress = bankBranchAddress;
    }

}
