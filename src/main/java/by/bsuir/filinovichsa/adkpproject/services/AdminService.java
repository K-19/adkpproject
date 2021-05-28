package by.bsuir.filinovichsa.adkpproject.services;

import by.bsuir.filinovichsa.adkpproject.dao.AdminDao;
import by.bsuir.filinovichsa.adkpproject.users.Admin;

import java.util.List;

public class AdminService {
    private AdminDao adminDao;
    private static AdminService instance;

    public static AdminService getInstance() {
        if (instance == null)
            instance = new AdminService();
        return instance;
    }

    private AdminService() {
        adminDao = new AdminDao();
    }

    public Admin findById(int id) {
        return adminDao.findById(id);
    }

    public Admin findByLoginAndPassword(String login, int password) {
        return adminDao.findByLoginAndPassword(login, password);
    }

    public List<Admin> selectAll() {
        return adminDao.selectAll();
    }

    public void save(Admin admin) {
        adminDao.save(admin);
    }

    public void delete(Admin admin) {
        adminDao.delete(admin);
    }

    public void update(Admin admin) {
        adminDao.update(admin);
    }
}
