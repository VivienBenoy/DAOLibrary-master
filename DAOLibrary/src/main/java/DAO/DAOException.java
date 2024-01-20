/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author hkhat
 */
import java.sql.SQLException;

public class DAOException extends SQLException {

    /**
     * No Argument with no Output Constructor
     */
    public DAOException() {
    }

    /**
     * DAOException with error msg printed from SQLException
     *
     * @param aMessage the error which is to be printed
     */
    public DAOException(String aMessage) {
        super(aMessage);
    }

}
