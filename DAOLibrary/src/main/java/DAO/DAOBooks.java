/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Library.Book;
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
public class DAOBooks extends DAO {
    
    
    /**
     * Find all The books in the database
     * @return All the books in a list format 
     * @throws DAOException for Database error
     */
    public List<Book> findAllBooks() throws DAOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Book> books = new ArrayList<Book>();
        try
        {
            con = getConnection();

            String query = "SELECT * FROM book";
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next())
            {
                int bookId = rs.getInt("bookId");
                String bookName = rs.getString("bookName");
                String author = rs.getString("author");
                int bookCopies = rs.getInt("bookCopies");
                String bookLength = rs.getString("bookLength");


                Book b = new Book(bookId, bookName, author, bookLength, bookCopies);
                books.add(b);
            }
        } catch (SQLException e)
        {
            throw new DAOException("findAllBooks(): " + e.getMessage());
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
                throw new DAOException("findAllBooks(): " + e.getMessage());
            }
        }
        return books;		
    }
}
