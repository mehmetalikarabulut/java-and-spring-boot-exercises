package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public int userInsert(String name, String surname, String email, String password, String date) {
        int status = 0;
        DB db = new DB();
        try {
            String sql = "INSERT INTO `users` (`name`, `surname`, `email`, `password`, `date`) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, surname);
            pre.setString(3, email);
            pre.setString(4, password);
            pre.setString(5, date);
            status = pre.executeUpdate();
        } catch (Exception ex) {
            System.err.println("userLogin Error : " + ex);
        } finally {
            db.close();
        }
        return status;
    }

    public int userUpdate(String name, String surname, int uid) {
        int status2 = 0;
        DB db = new DB();
        try {
            String sql = "UPDATE users SET name = ?, surname = ? WHERE uid = ?";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, surname);
            pre.setInt(3, uid);
            status2 = pre.executeUpdate();
        } catch (Exception ex) {
            System.err.println("userLogin Error : " + ex);
        } finally {
            db.close();
        }
        return status2;
    }

    public int userDelete(int uid) {
        int status3 = 0;
        DB db = new DB();
        try {
            String sql = "DELETE FROM users WHERE uid = ?";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setInt(1, uid);
            status3 = pre.executeUpdate();
        } catch (Exception ex) {
            System.err.println("userLogin Error : " + ex);
        } finally {
            db.close();
        }
        return status3;
    }
}
