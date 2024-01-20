/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Library.Loans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hkhat
 */
public class DAOLoan extends DAO {

    /**
     * Find all the loans under the User which is loggedIn
     *
     * @param idUser which is userID for logged In user
     * @return List of all the Loans
     * @throws DAOException for database based error
     */
    public List<Loans> findAllLoans(int idUser) throws DAOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Loans> loan = new ArrayList<Loans>();
        try
        {
            con = this.getConnection();

            String query = "SELECT * FROM LOANS WHERE userId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, idUser);

            rs = ps.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("loanId");
                int userId = rs.getInt("userId");
                int bookId = rs.getInt("bookId");
                int underLoan = rs.getInt("underLoan");

                Loans Bookloan = new Loans(id, userId, bookId, underLoan);
                loan.add(Bookloan);
            }
        } catch (SQLException e)
        {
            throw new DAOException("findAllLoans() " + e.getMessage());
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
                throw new DAOException(e.getMessage());
            }
        }
        return loan;     // may be empty
    }

    /**
     * Find all the loans which are active which is determined when the underLoan value in database is 1
     * @param idUser for the loggedIn user to find the loan
     * @return List of all the Active Loans
     * @throws DAOException for connection error
     */
    public List<Loans> findAllLoansActiveLoans(int idUser) throws DAOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Loans> loan = new ArrayList<Loans>();
        try
        {
            con = this.getConnection();
            String query = "SELECT * FROM LOANS WHERE userId = ? And underLoan = 1";
            ps = con.prepareStatement(query);
            ps.setInt(1, idUser);

            rs = ps.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("loanId");
                int userId = rs.getInt("userId");
                int bookId = rs.getInt("bookId");
                int underLoan = rs.getInt("underLoan");

                Loans Bookloan = new Loans(id, userId, bookId, underLoan);
                loan.add(Bookloan);
            }
        } catch (SQLException e)
        {
            throw new DAOException("findAllLoans() " + e.getMessage());
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
                throw new DAOException(e.getMessage());
            }
        }
        return loan;     // may be empty
    }

    /**
     * Adds a loan to the database under the loggedIn user
     * @param Id UserId for logged In user
     * @param BookId Book that is to be loaned ID 
     * @return The number of rows affected to see if it was successful or not
     * @throws DAOException for connection error
     */
    public int addLoan(int Id, int BookId) throws DAOException {
        //no exception for if user already has the book loaned 
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rowsAffected = 0;
        try
        {
            con = getConnection();
            String command = "INSERT INTO LOANS(userId,bookId,underLoan) VALUES( ?, ?, ?)";
            ps = con.prepareStatement(command);
            ps.setInt(1, Id);
            ps.setInt(2, BookId);
            ps.setInt(3, 1);
            rowsAffected = ps.executeUpdate();
        } catch (SQLException e)
        {
            throw new DAOException("addLoan(): " + e.getMessage());
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
                throw new DAOException("addLoan(): " + e.getMessage());
            }
        }
        return rowsAffected;
    }
    
    
        /**
         * Removes the loan and sets it to inactive 
         * @param Id UserID of the loggedIn user
         * @param BookId Id of book to be inactive
         * @return rowsAffected to check the success of the function
         * @throws DAOException  for database based error
         */
        public int removeLoan(int Id, int BookId) throws DAOException {
        //no exception for if user already has the book loaned 
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rowsAffected = 0;
        try
        {
            con = getConnection();
            String command = "UPDATE LOANS SET underLoan = 0 WHERE userId = ? and bookId = ?";
            ps = con.prepareStatement(command);
            ps.setInt(1, Id);
            ps.setInt(2, BookId);
            rowsAffected = ps.executeUpdate();
        } catch (SQLException e)
        {
            throw new DAOException("addLoan(): " + e.getMessage());
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
                throw new DAOException("addLoan(): " + e.getMessage());
            }
        }
        return rowsAffected;
    }

}
