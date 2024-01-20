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
public class Loans {

    private int loanId;
    private int userId;
    private int bookId;
    private int underLoan;

    /**
     * No Argument Constructor for Loan
     */
    public Loans() {
    }

    /**
     * All the argument constructor for Loan
     * @param loanId as int
     * @param userId as int 
     * @param bookId as int
     * @param underLoan as int which signifies if book is under loan
     */
    public Loans(int loanId, int userId, int bookId, int underLoan) {
        this.loanId = loanId;
        this.userId = userId;
        this.bookId = bookId;
        this.underLoan = underLoan;
    }
    
    
    public Loans(int underLoan) {
        this.underLoan = underLoan;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUnderLoan() {
        return underLoan;
    }

    public void setUnderLoan(int underLoan) {
        this.underLoan = underLoan;
    }

    /**
     * Override hashCode for LoanId
     * @return hashCode for loanId
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.loanId;
        return hash;
    }

    /**
     * Override equals method for LoanId
     * @param obj which takes the Loan object to compare 
     * @return if the object is equal to the compared object
     */
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
        final Loans other = (Loans) obj;
        if (this.loanId != other.loanId)
        {
            return false;
        }
        return true;
    }
    
    
    /**
     * Override toString method to make the Object more readable when printed 
     * @return Object in the form of String
     */
    @Override
    public String toString() {
        return "Loans{" + "loanId=" + loanId + ", userId=" + userId + ", bookId=" + bookId + ", underLoan=" + underLoan + '}';
    }

    
    
    

}
