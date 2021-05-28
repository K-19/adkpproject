package by.bsuir.filinovichsa.adkpproject.users;

import by.bsuir.filinovichsa.adkpproject.services.AdminService;
import by.bsuir.filinovichsa.adkpproject.services.SupportService;
import by.bsuir.filinovichsa.adkpproject.services.UserService;
import by.bsuir.filinovichsa.adkpproject.support.SupportMessage;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    protected String name;
    protected String surname;
    private String login;
    private int password;
    protected LocalDateTime registerDate;

    public Admin() {
    }

    public Admin(String name, String surname, String login, int password, LocalDateTime registerDate) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.registerDate = registerDate;
    }

    public List<SupportMessage> getAllMessages() {
        List<SupportMessage> list = SupportService.getInstance().selectAll();
        Collections.sort(list, new Comparator<SupportMessage>() {
            @Override
            public int compare(SupportMessage o1, SupportMessage o2) {
                return o2.getId() - o1.getId();
            }
        });
        return list;
    }

    public List<Advertiser> getAdvertisers() {
        return UserService.getInstance().findAllAdvertisers();
    }

    public List<Distributor> getDistributors() {
        return UserService.getInstance().findAllDistributors();
    }

    public List<AbstractUser> getAllUsers() {
        List<AbstractUser> users = new ArrayList<>();
        for (Advertiser advertiser : getAdvertisers()) {
            users.add(advertiser);
        }
        for (Distributor distributor : getDistributors()) {
            users.add(distributor);
        }
        return users;
    }

    public List<Admin> getAllAdmins() {
        return AdminService.getInstance().selectAll();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }
}
