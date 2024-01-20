/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

/**
 *
 * @author hkhat
 */
public class User {

    private int userId;
    private String username;
    private String password;
    private String email;
    private String address;
    private String Occupation;
    private int idCount = 20;

    /**
     * No Argument Constructor 
     */
    public User() {
        userId = idCount;
        idCount++;
    }

    /**
     * Argument Constructor but the Int is autoIncremented 
     * @param username as String 
     * @param password as String 
     * @param email as Email 
     * @param address as String
     * @param Occupation as String and the input is usually Student, Employed, UnEmployed 
     */
    public User(String username, String password, String email, String address, String Occupation) {
        userId = idCount;
        idCount++;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.Occupation = Occupation;
    }

    /**
     * All Argument Constructor for User
     * @param userId as int
     * @param username as String 
     * @param password as String 
     * @param email as Email 
     * @param address as String
     * @param Occupation as String and the input is usually Student, Employed, UnEmployed 
     */
    public User(int userId, String username, String password, String email, String address, String Occupation) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.Occupation = Occupation;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String Occupation) {
        this.Occupation = Occupation;
    }

    /**
     * Override toString method to make the Object more readable when printed
     *
     * @return Object in the form of String
     */
    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", username=" + username + ", email=" + email + ", address=" + address + ", Occupation=" + Occupation + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.userId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final User other = (User) obj;
        if (this.userId != other.userId)
        {
            return false;
        }
        return true;
    }

}
