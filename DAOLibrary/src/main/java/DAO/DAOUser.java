/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Library.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hkhat
 */
public class DAOUser extends DAO {

    /**
     * Adds a user to the database ( Have to add a functionality to make sure no two users can have same username or email)
     * @param u User Object  
     * @return RowsAffected for the result
     * @throws DAOException for connection error
     */
    public int addUser(User u) throws DAOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rowsAffected = 0;
        try
        {
            con = getConnection();
            String command = "INSERT INTO user(username, password, email, address, Occupation) VALUE(?,?,?,?,?)";
            ps = con.prepareStatement(command);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getAddress());
            ps.setString(5, u.getOccupation());
            rowsAffected = ps.executeUpdate();

        } catch (SQLException e)
        {
            throw new DAOException("addUser(): " + e.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            } catch (SQLException e)
            {
                throw new DAOException("addUser(): " + e.getMessage());
            }
        }
        return rowsAffected;

    }

    /**
     * Logs the user In with their username and password
     * @param uname Username 
     * @param pass Password
     * @return User Object after logIn with all the details stored in it
     * @throws DAOException for connection error
     */
    public User LogIn(String uname, String pass) throws DAOException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try
        {
            con = this.getConnection();

            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next())
            {
                int userId = rs.getInt("userId");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String occupation = rs.getString("occupation");

                user = new User(userId, username, password, email, address, occupation);
            }
        } catch (SQLException e)
        {
            throw new DAOException("LogIn() " + e.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            } catch (SQLException e)
            {
                throw new DAOException("LogIn()" + e.getMessage());
            }
        }
        return user;     
    }

}
