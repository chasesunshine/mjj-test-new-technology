package org.wanbang.study.autoWiredByNameOrByType.test;

import lombok.Data;

@Data
public class UserService {
    private UserDAO userDAO;
    private int id;
    private String name;

    public void add(User user) {
        userDAO.save(user);
    }
    public UserDAO getUserDAO() {
        return userDAO;
    }
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "userDAO=" + userDAO +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
