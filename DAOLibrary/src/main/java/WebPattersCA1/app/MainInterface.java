/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebPattersCA1.app;

import DAO.DAOBooks;
import DAO.DAOException;
import DAO.DAOLoan;
import DAO.DAOUser;
import Library.Book;
import Library.Loans;
import Library.User;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import static java.util.logging.Logger.global;

/**
 *
 * @author hkhat
 */
public class MainInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DAOException {
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale l : locales)
        {
            System.out.println(l);
        }
        Scanner input = new Scanner(System.in);
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter a language code from above :");
//        String lang = input.nextLine();
//        System.out.println("Enter a region code from above :");
//        String region = input.nextLine();
//        
//        Locale currentLocale = new Locale(lang, region);
//        ResourceBundle messages = ResourceBundle.getBundle("properties.MessageBundle", currentLocale);

        boolean stop = false;
        int menu;
        while (!stop)
        {
            try
            {
                System.out.println("---------------------------------------");
                System.out.println(" 1. New User?Sign Up");
                System.out.println(" 2. Already a member?Login");
                System.out.println(" 3. Quit                               ");
                System.out.println("---------------------------------------");
                System.out.print("Choose a menu item: ");
                menu = input.nextInt();
                switch (menu)
                {
                    case 1:
                        MainInterface user = new MainInterface();
                        user.addUser();
                        break;
                    case 2:
                        boolean stopLogin = false;
                        int menu2;
                        int Id = LogIn();
                        if (Id == 0)
                        {
                            stopLogin = true;
                        }
                        System.out.println("Logged in user UsedId : " + Id);
                        while (!stopLogin)
                        {
                            try
                            {
                                System.out.println("---------------------------------------");
                                System.out.println(" 1. Show All the books");
                                System.out.println(" 2. Rent a book");
                                System.out.println(" 3. Return a book");
                                System.out.println(" 4. Currently active loans");
                                System.out.println(" 5. View all books loanded so far");
                                System.out.println(" 6. Logout                               ");
                                System.out.println("---------------------------------------");
                                System.out.print("Choose a menu item: ");
                                menu = input.nextInt();
                                int bookIdInput;
                                switch (menu)
                                {
                                    case 1:
                                        ListAllBooks();
                                        break;
                                    case 2:
                                        System.out.println("The Active Loans are: ");
                                        findAllLoansActiveLoans(Id);
                                        System.out.println("Enter the Book Id: ");
                                        bookIdInput = input.nextInt();
                                        addLoan(Id, bookIdInput);
                                        break;
                                    case 3:
                                        System.out.println("The Active Loans are: ");
                                        findAllLoansActiveLoans(Id);
                                        System.out.println("Enter the Book Id: ");
                                        bookIdInput = input.nextInt();
                                        removeLoan(Id,bookIdInput);
                                        break;
                                    case 4:
                                        findAllLoansActiveLoans(Id);
                                        break;
                                    case 5:
                                        findAllLoans(Id);
                                        break;
                                    case 6:
                                        Id = 0;
                                        stopLogin = true;
                                        break;
                                    default:
                                        System.out.println("Invalid input, please enter from given choices");
                                        break;

                                }
                            } catch (InputMismatchException e)
                            {
                                input.nextLine(); //No infinite loop
                                System.out.println("\nInvalid input, please try again");
                            } catch (StringIndexOutOfBoundsException e)
                            {
                                stopLogin = true;
                            }
                        }
                        break;
                    case 3:
                        stop = true;
                        break;
                    default:
                        System.out.println("Invalid input, please enter from given choices");
                        break;
                }
            } catch (InputMismatchException e)
            {
                input.nextLine(); //No infinite loop
                System.out.println("\nInvalid input, please try again");
            } catch (StringIndexOutOfBoundsException e)
            {
                stop = true;
            }
        }

        System.out.println("Thanks for using the library ");
    }

    /**
     * List all the books using DAOBooks class
     *
     * @throws DAOException for database based error
     */
    private static void ListAllBooks() throws DAOException {
        System.out.println("BOOKS");
        try
        {
            DAOBooks dao = new DAOBooks();

            List<Book> books = dao.findAllBooks();
            if (books.isEmpty())
            {
                System.out.println("List is empty");
            } else
            {
                for (Book b : books)
                {
                    System.out.println(b);;
                }
            }
        } catch (DAOException e)
        {
            System.out.println("Error " + e.getMessage());
        }
    }

    /**
     * Find all the Loans active or inactive under logged In user using DAOLoan
     *
     * @param Id Logged In users ID
     * @throws DAOException for database based error
     */
    private static void findAllLoans(int Id) throws DAOException {
        System.out.println("Find All Loans by User");
        try
        {
            DAOLoan dl = new DAOLoan();
            List<Loans> l1 = dl.findAllLoans(Id);
            if (l1.isEmpty())
            {
                System.out.println("List is empty");
            } else
            {
                for (Loans b : l1)
                {
                    System.out.println(b);;
                }
            }

        } catch (DAOException e)
        {
            System.out.println("Error" + e.getMessage());
        }
    }

    /**
     * Find all the active loans under the user that is loggedIn
     *
     * @param Id: User Id for which loans are checked inputted automatically
     * after logIn
     * @throws DAOException
     */
    private static void findAllLoansActiveLoans(int Id) throws DAOException {
        System.out.println("Find All Active Loans by User");
        try
        {
            DAOLoan dl = new DAOLoan();
            List<Loans> l1 = dl.findAllLoansActiveLoans(Id);
            if (l1.isEmpty())
            {
                System.out.println("List is empty");
            } else
            {
                for (Loans b : l1)
                {
                    System.out.println(b);;
                }
            }

        } catch (DAOException e)
        {
            System.out.println("Error" + e.getMessage());
        }
    }

    /**
     * Lets the user loan the book and adds the record to the database
     *
     * @param Id: UserId for user who is going to loan the book, done
     * automatically
     * @param bookIdInput: BookId which u want to loan
     * @throws DAOException
     */
    private static void addLoan(int Id, int bookIdInput) throws DAOException {
        System.out.println("Loaning the book you want");
        try
        {
            DAOLoan dl = new DAOLoan();
            int a1 = dl.addLoan(Id, bookIdInput);
            if (a1 == 0)
            {
                System.out.println("Loan Unsuccesfull");
            } else
            {
                System.out.println("Loan Succefull ");
            }

        } catch (DAOException e)
        {
            System.out.println("Error" + e.getMessage());
        }
    }

    /**
     * Remove loan using DAOLoan
     *
     * @param Id UserID of the loggedIn user
     * @param BookId Id of book to be inactive
     * @throws DAOException for database based error
     */
    private static void removeLoan(int Id, int bookIdInput) throws DAOException {
        System.out.println("Loaning the book you want");
        try
        {
            DAOLoan dl = new DAOLoan();
            int a1 = dl.removeLoan(Id, bookIdInput);
            if (a1 == 0)
            {
                System.out.println("Loan return Unsuccesfull");
            } else
            {
                System.out.println("Loan return Succefull ");
            }

        } catch (DAOException e)
        {
            System.out.println("Error" + e.getMessage());
        }
    }

    /**
     * addUser: Registers a user into the database with a sequential id value
     */
    private void addUser() {
        System.out.println("\n\n\n\n\n\n\n---------------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("__________________________________________________________________________________");
        try
        {
            //if u get the chance add an option to check if the same email doesnt exist twice
            DAOUser newUser = new DAOUser();

            String username;
            System.out.println("Enter Username");
            username = sc.next();

            String address;
            System.out.println("ENTER address without spaces");
            address = sc.next();

            String occupation;
            System.out.println("Enter occupation");
            occupation = sc.next();
            String password;

            System.out.println("Enter Password");
            password = sc.next();

            String email;
            System.out.println("Enter Email");
            email = sc.next();

            User u = new User(username, password, email, address, occupation);

            int rowsAffected = newUser.addUser(u);
            if (rowsAffected != 0)
            {
                System.out.println("User added!");
            } else
            {
                System.out.println("Problem adding user!");
            }

        } catch (DAOException e)
        {
            System.out.println("Error " + e.getMessage());
        }
    }

    /**
     * Logs the user in by inputting username and password inside the function
     * to make sure the details arent in main file and are removed after log in
     *
     * @return Id: Returns user ID
     * @throws DAOException
     */
    public static int LogIn() throws DAOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("SIGN IN");
        try
        {
            DAOUser users = new DAOUser();

//            String username = "ccc333";
//            String password = "ccc333";
            System.out.println("Enter Username");
            String username;
            username = sc.next();

            System.out.println("Enter Password");
            String password;
            password = sc.next();
            User u = users.LogIn(username, password);
            if (u == null)
            {
                System.out.println("No such user found ");
                return 0;
            } else
            {
                System.out.println("Login Successful");
                return u.getUserId();
            }

        } catch (DAOException e)
        {
            System.out.println("Error " + e.getMessage());
            return 0;
        }

    }
}
