package com.github.dzeko14.models.dao;

import com.github.dzeko14.models.User;

import javax.ejb.Singleton;
import java.sql.*;

@Singleton
public class UserDaoImpl implements UserDao {

    private Connection mConnection;

    public UserDaoImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            mConnection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/GymSchema?serverTimezone=UTC", "root", "qwerty12345x");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean saveUser(User user) {
        String query = "INSERT INTO USERS VALUES(?, ?, ?);";
        try {
            PreparedStatement st = mConnection.prepareStatement(query);

            st.setString(1, user.getPhoneNumber());
            st.setString(2, user.getName());
            st.setString(3, user.getPassword());

            st.execute();

            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public User getUserByNumber(String phoneNumber) {
        try {
            String sql = "SELECT * FROM USERS WHERE phoneNumber = ?;";
            PreparedStatement st = mConnection.prepareStatement(sql);
            st.setString(1, phoneNumber);

            ResultSet result = st.executeQuery();
            User user = null;

            if (result.next()) {

                String vendId = result.getString("phoneNumber");
                String name = result.getString("name");
                String password = result.getString("password");

                user = new User(vendId, name, password);
            }

            result.close();
            st.close();

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
