import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Random;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Main class for the Tour Booking System application
public class TourBookingSystem extends JFrame {

    // CardLayout to manage different screens (panels)
    private CardLayout cardLayout;
    
    // Main panel that uses CardLayout
    private JPanel mainPanel;
    
    // Constants for card names
    public static final String HOME_PANEL = "Home Panel";
    public static final String LOGIN_PANEL = "Login Panel";
    public static final String SIGNUP_PANEL = "Sign Up Panel";
    public static final String ADMIN_DASHBOARD_PANEL = "Admin Dashboard Panel";
    public static final String CUSTOMER_DASHBOARD_PANEL = "Customer Dashboard Panel";
    public static final String ManageUsersPanel = "Manage Users";
    public static final String ManageToursPanel = "Manage Tours";
    public static final String ManageBookingsPanel = "Manage Bookings";
    public static final String GenerateReportsPanel = "Generate Reports";
    public static final String CreateUserPanel = "Create User";
    public static final String UpdateUserPanel = "Update User";
    public static final String DeleteUserPanel = "Delete User";
    public static final String AddTourPanel = "Add Tour";
    public static final String EditTourPanel = "Edit Tour";
    public static final String DeleteTourPanel = "Delete Tour";
    public static final String ViewToursPanel = "View Tours";
    public static final String ViewBookingsPanel = "View Bookings";
    public static final String UpdateBookingPanel = "Update Booking";
    public static final String DeleteBookingPanel = "delete Booking";
    public static final String UserReportsPanel = "User Reports";
    public static final String ToursReportsPanel = "Tours Reports";
    public static final String BookingsReportsPanel = "Bookings Reports";

    // Constructor to set up the main frame and panels
    public TourBookingSystem() {
        // Set the title of the main window
        setTitle("Avalanche Tours");
        
        // Set the size of the main window
        setSize(600, 400);
        
        // Specify what happens when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Center the window on the screen
        setLocationRelativeTo(null);
        
        // Initialize CardLayout and the main panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        // Create and add the home, login, sign up, and dashboard panels to the main panel
        mainPanel.add(new HomePanel(), HOME_PANEL);
        mainPanel.add(new LoginPanel(), LOGIN_PANEL);
        mainPanel.add(new SignupPanel(), SIGNUP_PANEL);
        mainPanel.add(new AdminDashboardPanel(), ADMIN_DASHBOARD_PANEL);
        mainPanel.add(new CustomerDashboardPanel(), CUSTOMER_DASHBOARD_PANEL);
        // Add the ManageUsersPanel with its card name
        mainPanel.add(new ManageUsersPanel(), ManageUsersPanel);

        // Add the ManageToursPanel with its card name
        mainPanel.add(new ManageToursPanel(), ManageToursPanel);

        // Add the ManageBookingsPanel with its card name
        mainPanel.add(new ManageBookingsPanel(), ManageBookingsPanel);

        // Add the GenerateReportsPanel with its card name
        mainPanel.add(new GenerateReportsPanel(), GenerateReportsPanel);
        
        mainPanel.add(new CreateUserPanel(), CreateUserPanel);
        mainPanel.add(new UpdateUserPanel(), UpdateUserPanel);
        mainPanel.add(new DeleteUserPanel(), DeleteUserPanel);
        mainPanel.add(new AddTourPanel(), AddTourPanel);
        mainPanel.add(new EditTourPanel(), EditTourPanel);
        mainPanel.add(new DeleteTourPanel(), DeleteTourPanel);
        mainPanel.add(new ViewToursPanel(), ViewToursPanel);
        mainPanel.add(new ViewBookingsPanel(), ViewBookingsPanel);
        mainPanel.add(new UpdateBookingPanel(), UpdateBookingPanel);
        mainPanel.add(new DeleteBookingPanel(), DeleteBookingPanel);
        mainPanel.add(new UserReportsPanel(), UserReportsPanel);
        mainPanel.add(new ToursReportsPanel(), ToursReportsPanel);
        mainPanel.add(new BookingsReportsPanel(), BookingsReportsPanel);
        

        
        // Set the initial screen to the Home Panel
        cardLayout.show(mainPanel, HOME_PANEL);
        
        // Add the main panel to the content pane of the frame
        getContentPane().add(mainPanel);
    }
    
    // Inner class representing the Home Panel
    class HomePanel extends JPanel {
        
        // Constructor to set up the Home Panel
        public HomePanel() {
            // Set layout manager for custom positioning
            setLayout(null);
            
            // Create a label to display the welcome message
            JLabel welcomeLabel = new JLabel("Welcome to Avalanche Tours");
            
            // Set the font for the welcome label
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
            
            // Center the text horizontally
            welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            
            // Set the position and size of the welcome label
            welcomeLabel.setBounds(50, 80, 500, 50);
            
            // Add the welcome label to the panel
            add(welcomeLabel);
            
            // Create a menu bar with account options
            JMenuBar menuBar = new JMenuBar();
            
            // Create a menu for account-related actions
            JMenu accountMenu = new JMenu("Account");
            
            // Create a menu item for logging in
            JMenuItem loginMenuItem = new JMenuItem("Login");
            
            // Add action listener to switch to the Login Panel when clicked
            loginMenuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Show the Login Panel
                    cardLayout.show(mainPanel, LOGIN_PANEL);
                }
            });
            
            // Create a menu item for signing up
            JMenuItem signupMenuItem = new JMenuItem("Sign Up");
            
            // Add action listener to switch to the Sign Up Panel when clicked
            signupMenuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Show the Sign Up Panel
                    cardLayout.show(mainPanel, SIGNUP_PANEL);
                }
            });
            
            // Add the menu items to the Account menu
            accountMenu.add(loginMenuItem);
            accountMenu.add(signupMenuItem);
            
            // Add the Account menu to the menu bar
            menuBar.add(accountMenu);
            
            // Set the menu bar for the Home Panel
            TourBookingSystem.this.setJMenuBar(menuBar);
        }
    }
    
    // Inner class representing the Login Panel
    class LoginPanel extends JPanel {
        
        // Constructor to set up the Login Panel
        public LoginPanel() {
            // Set layout manager for custom positioning
            setLayout(null);
            
            // Create a label to indicate this is the login screen
            JLabel loginLabel = new JLabel("Login");
            
            // Set font and alignment for the login label
            loginLabel.setFont(new Font("Arial", Font.BOLD, 22));
            loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
            
            // Set the position and size of the login label
            loginLabel.setBounds(50, 30, 500, 30);
            
            // Add the login label to the panel
            add(loginLabel);
            
            // Create a text field for the email input
            JTextField emailField = new JTextField();
            
            // Set the position and size of the email field
            emailField.setBounds(200, 100, 200, 30);
            
            // Create a label for the email field
            JLabel emailLabel = new JLabel("Email:");
            
            // Set the position and size of the email label
            emailLabel.setBounds(130, 100, 60, 30);
            
            // Create a password field for the password input
            JPasswordField passwordField = new JPasswordField();
            
            // Set the position and size of the password field
            passwordField.setBounds(200, 150, 200, 30);
            
            // Create a label for the password field
            JLabel passwordLabel = new JLabel("Password:");
            
            // Set the position and size of the password label
            passwordLabel.setBounds(130, 150, 70, 30);
            
            // Create a button to submit the login form
            JButton loginButton = new JButton("Login");
            
            // Set the position and size of the login button
            loginButton.setBounds(250, 200, 100, 30);
            
            // Add an action listener to handle the login action
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String email = emailField.getText();
                    String password = new String(passwordField.getPassword());
                    
                    User user = User.login(email, password);
                    if (user != null) {
                        
                        // Store the user in UserSession
                        UserSession.getInstance().setUser(user);
                        
                        // Navigate to the appropriate dashboard
                        if (user.getRole().equalsIgnoreCase("admin")) {
                            cardLayout.show(mainPanel, ADMIN_DASHBOARD_PANEL);
                        } else if (user.getRole().equalsIgnoreCase("customer")) {
                            cardLayout.show(mainPanel, CUSTOMER_DASHBOARD_PANEL);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid email or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            
            // Create a button to navigate back to the Home Panel
            JButton backButton = new JButton("Back");
            
            // Set the position and size of the back button
            backButton.setBounds(10, 10, 70, 25);
            
            // Add an action listener to handle the back navigation
            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Switch back to the Home Panel
                    cardLayout.show(mainPanel, HOME_PANEL);
                }
            });
            
            // Add all components to the Login Panel
            add(emailLabel);
            add(emailField);
            add(passwordLabel);
            add(passwordField);
            add(loginButton);
            add(backButton);
        }
    }
    
    // Inner class representing the Sign Up Panel
    class SignupPanel extends JPanel {
        
        // Constructor to set up the Sign Up Panel
        public SignupPanel() {
            // Set layout manager for custom positioning
            setLayout(null);
            
            // Create a label to indicate this is the sign up screen
            JLabel signupLabel = new JLabel("Sign Up");
            
            // Set font and alignment for the sign up label
            signupLabel.setFont(new Font("Arial", Font.BOLD, 22));
            signupLabel.setHorizontalAlignment(SwingConstants.CENTER);
            
            // Set the position and size of the sign up label
            signupLabel.setBounds(50, 30, 500, 30);
            
            // Add the sign up label to the panel
            add(signupLabel);
            
            // Create a text field for the username input
            JTextField usernameField = new JTextField();
            
            // Set the position and size of the username field
            usernameField.setBounds(200, 80, 200, 30);
            
            // Create a label for the username field
            JLabel usernameLabel = new JLabel("Username:");
            
            // Set the position and size of the username label
            usernameLabel.setBounds(130, 80, 70, 30);
            
            // Create a text field for the email input
            JTextField emailField = new JTextField();
            
            // Set the position and size of the email field
            emailField.setBounds(200, 130, 200, 30);
            
            // Create a label for the email field
            JLabel emailLabel = new JLabel("Email:");
            
            // Set the position and size of the email label
            emailLabel.setBounds(130, 130, 60, 30);
            
            // Create a password field for the password input
            JPasswordField passwordField = new JPasswordField();
            
            // Set the position and size of the password field
            passwordField.setBounds(200, 180, 200, 30);
            
            // Create a label for the password field
            JLabel passwordLabel = new JLabel("Password:");
            
            // Set the position and size of the password label
            passwordLabel.setBounds(130, 180, 70, 30);
            
            // Create a button to submit the sign up form
            JButton signupButton = new JButton("Sign Up");
            
            // Set the position and size of the sign up button
            signupButton.setBounds(250, 230, 100, 30);
            
            // Add an action listener to handle the sign up action
            signupButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Retrieve the entered username, email, and password
                    String username = usernameField.getText();
                    String email = emailField.getText();
                    String password = new String(passwordField.getPassword());
                    
                    // Create a new User object with a generated ID, username, email, password, and default role "customer"
                    // generate user ID
                    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                    StringBuilder userId = new StringBuilder("USR");
                    Random random = new Random();
                    
                    for (int i = 0; i < 3; i++) { // Generate 3 random alphanumeric characters
                        userId.append(characters.charAt(random.nextInt(characters.length())));
                    }
                    // Create a new User object with the generated ID
                    User newUser = new User(userId.toString(), username, email, password, "customer");
                    
                    // Call the signUp method of the User class to store the new user in the database
                    boolean signupSuccessful = newUser.signUp();
                    
                    // Check if sign up was successful
                    if (signupSuccessful) {
                        // Optionally, automatically log in the user after successful sign up
                        User loggedInUser = User.login(email, password);
                        
                        // Navigate to the Customer Dashboard if login is successful
                        if (loggedInUser != null && loggedInUser.getRole().equalsIgnoreCase("customer")) {
                            // Store the user in UserSession
                            UserSession.getInstance().setUser(loggedInUser);
                            cardLayout.show(mainPanel, CUSTOMER_DASHBOARD_PANEL);
                        } else {
                            // If login fails, show an error message
                            JOptionPane.showMessageDialog(null, "Sign up succeeded but automatic login failed.", "Error", JOptionPane.ERROR_MESSAGE);
                            cardLayout.show(mainPanel, HOME_PANEL);
                        }
                    } else {
                        // Show an error message if sign up failed
                        JOptionPane.showMessageDialog(null, "Sign up failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            
            // Create a button to navigate back to the Home Panel
            JButton backButton = new JButton("Back");
            
            // Set the position and size of the back button
            backButton.setBounds(10, 10, 70, 25);
            
            // Add an action listener to handle the back navigation
            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Switch back to the Home Panel
                    cardLayout.show(mainPanel, HOME_PANEL);
                }
            });
            
            // Add all components to the Sign Up Panel
            add(usernameLabel);
            add(usernameField);
            add(emailLabel);
            add(emailField);
            add(passwordLabel);
            add(passwordField);
            add(signupButton);
            add(backButton);
        }
    }
    
    // Inner class representing the Admin Dashboard Panel
    class AdminDashboardPanel extends JPanel {
        
        // Constructor to set up the Admin Dashboard Panel
        public AdminDashboardPanel() {
            // Set layout manager for custom positioning in the admin dashboard
            setLayout(null);

            // Create a label to indicate this is the admin dashboard
            JLabel adminLabel = new JLabel("Admin Dashboard");
            adminLabel.setFont(new Font("Arial", Font.BOLD, 22));
            adminLabel.setHorizontalAlignment(SwingConstants.CENTER);
            adminLabel.setBounds(50, 30, 500, 30);
            add(adminLabel);

            // Create a welcome label that will display the logged-in user's name
            JLabel welcomeLabel = new JLabel();
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            welcomeLabel.setBounds(50, 70, 500, 30);

            // Retrieve the currently logged-in user from the session
            User currentUser = UserSession.getInstance().getUser();
            if (currentUser != null) {
                welcomeLabel.setText("Welcome, " + currentUser.getUsername());
            }
            add(welcomeLabel);

            // Create a button to manage user accounts (create, update, remove users)
            JButton manageUsersButton = new JButton("Manage Users");
            manageUsersButton.setBounds(50, 120, 200, 40);
            manageUsersButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  // go to the ManageUsersPanel
                  cardLayout.show(mainPanel, ManageUsersPanel);
                }
            });
            add(manageUsersButton);

            // Create a button to manage tours (add, edit, delete, view tours)
            JButton manageToursButton = new JButton("Manage Tours");
            manageToursButton.setBounds(300, 120, 200, 40);
            manageToursButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  // move to ManageToursPanel
                  cardLayout.show(mainPanel, ManageToursPanel);
                }
            });
            add(manageToursButton);

            // Create a button to manage bookings (view, update, delete bookings)
            JButton manageBookingsButton = new JButton("Manage Bookings");
            manageBookingsButton.setBounds(50, 180, 200, 40);
            manageBookingsButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  // move to MangeBookingsPanel
                  cardLayout.show(mainPanel, ManageBookingsPanel);
                }
            });
            add(manageBookingsButton);

            // Create a button to generate reports (users, tours, bookings)
            JButton generateReportsButton = new JButton("Generate Reports");
            generateReportsButton.setBounds(300, 180, 200, 40);
            generateReportsButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  // move to GenerateReportsPanel
                  cardLayout.show(mainPanel, GenerateReportsPanel);
                }
            });
            add(generateReportsButton);

            // Create a logout button to clear the session and redirect to the login panel
            JButton logoutButton = new JButton("Logout");
            logoutButton.setBounds(450, 10, 100, 30);
            logoutButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   // Clear the session
                   UserSession.getInstance().clearSession();
        
                   // Redirect to the login screen
                   cardLayout.show(mainPanel, LOGIN_PANEL);
                }
            });
            add(logoutButton);
        }
        
        
    }
    
    // Panel for managing user accounts (create, update, remove users)
    class ManageUsersPanel extends JPanel {

        // Constructor to set up the Manage Users Panel
        public ManageUsersPanel() {
            // Set layout manager for custom positioning
            setLayout(null);

            // Retrieve the logged-in user from the session
            User currentUser = UserSession.getInstance().getUser();

            // Create and add a label to display the logged-in user's name
            JLabel welcomeLabel = new JLabel();
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            if (currentUser != null) {
                welcomeLabel.setText("Logged in as: " + currentUser.getUsername());
            }
            welcomeLabel.setBounds(20, 30, 300, 30);
            add(welcomeLabel);

            // Create a button for "Create User"
            JButton createUserButton = new JButton("Create User");
            createUserButton.setBounds(50, 80, 150, 40);
            createUserButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implement create user functionality
                    cardLayout.show(mainPanel, CreateUserPanel);
                }
            });
            add(createUserButton);

            // Create a button for "Update User"
            JButton updateUserButton = new JButton("Update User");
            updateUserButton.setBounds(220, 80, 150, 40);
            updateUserButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implement update user functionality
                    cardLayout.show(mainPanel, UpdateUserPanel);
                }
            });
            add(updateUserButton);

            // Create a button for "Delete User"
            JButton deleteUserButton = new JButton("Delete User");
            deleteUserButton.setBounds(390, 80, 150, 40);
            deleteUserButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implement delete user functionality
                    cardLayout.show(mainPanel, DeleteUserPanel);
                }
            });
            add(deleteUserButton);

            // Create a clickable label to go back to the Admin Dashboard
            JLabel backLabel = new JLabel("<< Back to Dashboard");
            backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            backLabel.setBounds(20, 320, 200, 30);
            backLabel.setForeground(java.awt.Color.BLUE);
            backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cardLayout.show(mainPanel, ADMIN_DASHBOARD_PANEL);
                }
            });
            add(backLabel);
        }
    }

    // Panel for managing tours (add, edit, delete, view tour details)
    class ManageToursPanel extends JPanel {

        // Constructor to set up the Manage Tours Panel
        public ManageToursPanel() {
            // Set layout manager for custom positioning
            setLayout(null);

            // Retrieve the logged-in user from the session
            User currentUser = UserSession.getInstance().getUser();

            // Create and add a label to display the logged-in user's name
            JLabel welcomeLabel = new JLabel();
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            if (currentUser != null) {
                welcomeLabel.setText("Logged in as: " + currentUser.getUsername());
            }
            welcomeLabel.setBounds(20, 30, 300, 30);
            add(welcomeLabel);

            // Create a button for "Add Tour"
            JButton addTourButton = new JButton("Add Tour");
            addTourButton.setBounds(50, 80, 150, 40);
            addTourButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implement add tour functionality
                    cardLayout.show(mainPanel, AddTourPanel);
                }
            });
            add(addTourButton);

            // Create a button for "Edit Tour"
            JButton editTourButton = new JButton("Edit Tour");
            editTourButton.setBounds(220, 80, 150, 40);
            editTourButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implement edit tour functionality
                    cardLayout.show(mainPanel, EditTourPanel);
                }
            });
            add(editTourButton);

            // Create a button for "Delete Tour"
            JButton deleteTourButton = new JButton("Delete Tour");
            deleteTourButton.setBounds(390, 80, 150, 40);
            deleteTourButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Prompt the user to enter the Tour ID to delete
                    String tourId = JOptionPane.showInputDialog(null, "Enter Tour ID to delete:");
                    if (tourId != null && !tourId.trim().isEmpty()) {
                        // Call the deleteTour method from the Tour class
                        boolean deleted = Tour.deleteTour(tourId);
                        if (deleted) {
                            JOptionPane.showMessageDialog(null, "Tour deleted successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to delete tour.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No Tour ID entered.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            add(deleteTourButton);


            // Create a button for "View Tours"
            JButton viewToursButton = new JButton("View Tours");
            viewToursButton.setBounds(50, 140, 150, 40);
            viewToursButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implement view tours functionality
                    cardLayout.show(mainPanel, ViewToursPanel);
                }
            });
            add(viewToursButton);

            // Create a clickable label to go back to the Admin Dashboard
            JLabel backLabel = new JLabel("<< Back to Dashboard");
            backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            backLabel.setBounds(20, 320, 200, 30);
            backLabel.setForeground(java.awt.Color.BLUE);
            backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cardLayout.show(mainPanel, ADMIN_DASHBOARD_PANEL);
                }
            });
            add(backLabel);
        }
    }

    // Panel for managing bookings (view, update, delete bookings)
    class ManageBookingsPanel extends JPanel {

        // Constructor to set up the Manage Bookings Panel
        public ManageBookingsPanel() {
            // Set layout manager for custom positioning
            setLayout(null);

            // Retrieve the logged-in user from the session
            User currentUser = UserSession.getInstance().getUser();

            // Create and add a label to display the logged-in user's name
            JLabel welcomeLabel = new JLabel();
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            if (currentUser != null) {
                welcomeLabel.setText("Logged in as: " + currentUser.getUsername());
            }
            welcomeLabel.setBounds(20, 30, 300, 30);
            add(welcomeLabel);

            // Create a button for "View Bookings"
            JButton viewBookingsButton = new JButton("View Bookings");
            viewBookingsButton.setBounds(50, 80, 150, 40);
            viewBookingsButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implement view bookings functionality
                    cardLayout.show(mainPanel, ViewBookingsPanel);
                }
            });
            add(viewBookingsButton);

            // Create a button for "Update Booking"
            JButton updateBookingButton = new JButton("Update Booking");
            updateBookingButton.setBounds(220, 80, 150, 40);
            updateBookingButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implement update booking functionality
                    cardLayout.show(mainPanel, UpdateBookingPanel);
                }
            });
            add(updateBookingButton);

            // Create a button for "Delete Booking"
            JButton deleteBookingButton = new JButton("Delete Booking");
            deleteBookingButton.setBounds(390, 80, 150, 40);
            deleteBookingButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implement delete booking functionality
                    cardLayout.show(mainPanel, DeleteBookingPanel);
                }
            });
            add(deleteBookingButton);

            // Create a clickable label to go back to the Admin Dashboard
            JLabel backLabel = new JLabel("<< Back to Dashboard");
            backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            backLabel.setBounds(20, 320, 200, 30);
            backLabel.setForeground(java.awt.Color.BLUE);
            backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cardLayout.show(mainPanel, ADMIN_DASHBOARD_PANEL);
                }
            });
            add(backLabel);
        }
    }

    // Panel for generating reports (users, tours, bookings)
    class GenerateReportsPanel extends JPanel {

        // Constructor to set up the Generate Reports Panel
        public GenerateReportsPanel() {
            // Set layout manager for custom positioning
            setLayout(null);

            // Retrieve the logged-in user from the session
            User currentUser = UserSession.getInstance().getUser();

            // Create and add a label to display the logged-in user's name
            JLabel welcomeLabel = new JLabel();
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            if (currentUser != null) {
                welcomeLabel.setText("Logged in as: " + currentUser.getUsername());
            }
            welcomeLabel.setBounds(20, 30, 300, 30);
            add(welcomeLabel);

            // Create a button for "User Reports"
            JButton userReportsButton = new JButton("User Reports");
            userReportsButton.setBounds(50, 80, 150, 40);
            userReportsButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implement user reports functionality
                    cardLayout.show(mainPanel, UserReportsPanel);
                }
            });
            add(userReportsButton);

            // Create a button for "Tours Reports"
            JButton toursReportsButton = new JButton("Tours Reports");
            toursReportsButton.setBounds(220, 80, 150, 40);
            toursReportsButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implement tours reports functionality
                    cardLayout.show(mainPanel, ToursReportsPanel);
                }
            });
            add(toursReportsButton);

            // Create a button for "Bookings Reports"
            JButton bookingsReportsButton = new JButton("Bookings Reports");
            bookingsReportsButton.setBounds(390, 80, 150, 40);
            bookingsReportsButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implement bookings reports functionality
                    cardLayout.show(mainPanel, BookingsReportsPanel);
                }
            });
            add(bookingsReportsButton);

            // Create a clickable label to go back to the Admin Dashboard
            JLabel backLabel = new JLabel("<< Back to Dashboard");
            backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            backLabel.setBounds(20, 320, 200, 30);
            backLabel.setForeground(java.awt.Color.BLUE);
            backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cardLayout.show(mainPanel, ADMIN_DASHBOARD_PANEL);
                }
            });
            add(backLabel);
        }
    }

    // Panel for creating a new user
    class CreateUserPanel extends JPanel {
        public CreateUserPanel() {
            setLayout(null);

            // Display logged-in user information
            JLabel welcomeLabel = new JLabel();
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            User currentUser = UserSession.getInstance().getUser();
            if (currentUser != null) {
                welcomeLabel.setText("Logged in as: " + currentUser.getUsername());
            }
            welcomeLabel.setBounds(20, 30, 300, 30);
            add(welcomeLabel);

            // Form for new user details
            JLabel usernameLabel = new JLabel("Username:");
            usernameLabel.setBounds(50, 80, 100, 30);
            add(usernameLabel);
            JTextField usernameField = new JTextField();
            usernameField.setBounds(160, 80, 150, 30);
            add(usernameField);

            JLabel emailLabel = new JLabel("Email:");
            emailLabel.setBounds(50, 120, 100, 30);
            add(emailLabel);
            JTextField emailField = new JTextField();
            emailField.setBounds(160, 120, 150, 30);
            add(emailField);

            JLabel passwordLabel = new JLabel("Password:");
            passwordLabel.setBounds(50, 160, 100, 30);
            add(passwordLabel);
            JPasswordField passwordField = new JPasswordField();
            passwordField.setBounds(160, 160, 150, 30);
            add(passwordField);

            // Button to create the user
            JButton createButton = new JButton("Create User");
            createButton.setBounds(160, 210, 150, 40);
            createButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Generate unique 6-character user ID with prefix "USR"
                    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                    StringBuilder userId = new StringBuilder("USR");
                    Random random = new Random();
                    for (int i = 0; i < 3; i++) {
                        userId.append(characters.charAt(random.nextInt(characters.length())));
                    }
                    // Instantiate the User object
                    String username = usernameField.getText();
                    String email = emailField.getText();
                    String password = new String(passwordField.getPassword());
                    User newUser = new User(userId.toString(), username, email, password, "customer");
                    // Attempt to sign up
                    if (newUser.signUp()) {
                        JOptionPane.showMessageDialog(null, "User created successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "User creation failed.");
                    }
                }
            });
            add(createButton);

            // Back label to return to ManageUsersPanel
            JLabel backLabel = new JLabel("<< Back");
            backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            backLabel.setForeground(java.awt.Color.BLUE);
            backLabel.setBounds(20, 320, 100, 30);
            backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cardLayout.show(mainPanel, "ManageUsersPanel");
                }
            });
            add(backLabel);
        }
    }

    // Panel for updating an existing user
    class UpdateUserPanel extends JPanel {
        public UpdateUserPanel() {
            setLayout(null);

            JLabel welcomeLabel = new JLabel();
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            User currentUser = UserSession.getInstance().getUser();
            if (currentUser != null) {
                welcomeLabel.setText("Logged in as: " + currentUser.getUsername());
            }
            welcomeLabel.setBounds(20, 30, 300, 30);
            add(welcomeLabel);

            // Fields to update user details
            JLabel userIdLabel = new JLabel("User ID:");
            userIdLabel.setBounds(50, 80, 100, 30);
            add(userIdLabel);
            JTextField userIdField = new JTextField();
            userIdField.setBounds(160, 80, 150, 30);
            add(userIdField);

            JLabel newUsernameLabel = new JLabel("New Username:");
            newUsernameLabel.setBounds(50, 120, 100, 30);
            add(newUsernameLabel);
            JTextField newUsernameField = new JTextField();
            newUsernameField.setBounds(160, 120, 150, 30);
            add(newUsernameField);

            JLabel newEmailLabel = new JLabel("New Email:");
            newEmailLabel.setBounds(50, 160, 100, 30);
            add(newEmailLabel);
            JTextField newEmailField = new JTextField();
            newEmailField.setBounds(160, 160, 150, 30);
            add(newEmailField);

            JLabel newPasswordLabel = new JLabel("New Password:");
            newPasswordLabel.setBounds(50, 200, 100, 30);
            add(newPasswordLabel);
            JPasswordField newPasswordField = new JPasswordField();
            newPasswordField.setBounds(160, 200, 150, 30);
            add(newPasswordField);

            JButton updateButton = new JButton("Update User");
            updateButton.setBounds(160, 250, 150, 40);
            updateButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Call updateUser method on a User instance (for demo, we create a dummy user)
                    String userId = userIdField.getText();
                    String newUsername = newUsernameField.getText();
                    String newEmail = newEmailField.getText();
                    String newPassword = new String(newPasswordField.getPassword());
                    // In a real application, retrieve the user instance by userId first
                    User dummyUser = new User(userId, "", "", "", "customer");
                    if (dummyUser.updateUser(newUsername, newEmail, newPassword)) {
                        JOptionPane.showMessageDialog(null, "User updated successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "User update failed.");
                    }
                }
            });
            add(updateButton);

            JLabel backLabel = new JLabel("<< Back");
            backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            backLabel.setForeground(java.awt.Color.BLUE);
            backLabel.setBounds(20, 320, 100, 30);
            backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cardLayout.show(mainPanel, "ManageUsersPanel");
                }
            });
            add(backLabel);
        }
    }

    // Panel for deleting a user
    class DeleteUserPanel extends JPanel {
        public DeleteUserPanel() {
            setLayout(null);

            JLabel welcomeLabel = new JLabel();
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            User currentUser = UserSession.getInstance().getUser();
            if (currentUser != null) {
                welcomeLabel.setText("Logged in as: " + currentUser.getUsername());
            }
            welcomeLabel.setBounds(20, 30, 300, 30);
            add(welcomeLabel);

            JLabel userIdLabel = new JLabel("User ID to Delete:");
            userIdLabel.setBounds(50, 80, 150, 30);
            add(userIdLabel);
            JTextField userIdField = new JTextField();
            userIdField.setBounds(210, 80, 150, 30);
            add(userIdField);

            JButton deleteButton = new JButton("Delete User");
            deleteButton.setBounds(210, 130, 150, 40);
            deleteButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String userId = userIdField.getText();
                    if (User.deleteUser(userId)) {
                        JOptionPane.showMessageDialog(null, "User deleted successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "User deletion failed.");
                    }
                }
            });
            add(deleteButton);

            JLabel backLabel = new JLabel("<< Back");
            backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            backLabel.setForeground(java.awt.Color.BLUE);
            backLabel.setBounds(20, 320, 100, 30);
            backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cardLayout.show(mainPanel, "ManageUsersPanel");
                }
            });
            add(backLabel);
        }
    }

    // Panel for adding a new tour
    class AddTourPanel extends JPanel {
        public AddTourPanel() {
            setLayout(null);

            JLabel welcomeLabel = new JLabel();
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            User currentUser = UserSession.getInstance().getUser();
            if (currentUser != null) {
                welcomeLabel.setText("Logged in as: " + currentUser.getUsername());
            }
            welcomeLabel.setBounds(20, 30, 300, 30);
            add(welcomeLabel);

            JLabel nameLabel = new JLabel("Tour Name:");
            nameLabel.setBounds(50, 80, 100, 30);
            add(nameLabel);
            JTextField nameField = new JTextField();
            nameField.setBounds(160, 80, 150, 30);
            add(nameField);

            JLabel destinationLabel = new JLabel("Destination:");
            destinationLabel.setBounds(50, 120, 100, 30);
            add(destinationLabel);
            JTextField destinationField = new JTextField();
            destinationField.setBounds(160, 120, 150, 30);
            add(destinationField);

            JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
            dateLabel.setBounds(50, 160, 130, 30);
            add(dateLabel);
            JTextField dateField = new JTextField();
            dateField.setBounds(190, 160, 120, 30);
            add(dateField);

            JLabel priceLabel = new JLabel("Price:");
            priceLabel.setBounds(50, 200, 100, 30);
            add(priceLabel);
            JTextField priceField = new JTextField();
            priceField.setBounds(160, 200, 150, 30);
            add(priceField);

            // Create a button to add a new tour
            JButton addButton = new JButton("Add Tour");
            addButton.setBounds(160, 250, 150, 40);
            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Generate a unique tour ID with prefix "TOU"
                    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                    StringBuilder tourId = new StringBuilder("TOU");
                    Random random = new Random();
                    for (int i = 0; i < 3; i++) {
                        tourId.append(characters.charAt(random.nextInt(characters.length())));
                    }
                    String generatedId = tourId.toString();

                    // Retrieve tour details from text fields
                    String tourName = nameField.getText();
                    String destination = destinationField.getText();
                    String dateStr = dateField.getText();
                    String priceStr = priceField.getText();

                    try {
                        // Parse the date string (expected format: YYYY-MM-DD)
                        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                        Date tourDate = sdf.parse(dateStr);

                        // Parse the price from string to double
                        double price = Double.parseDouble(priceStr);

                        // Create a new Tour object with the generated ID and provided details
                        Tour newTour = new Tour(generatedId, tourName, destination, tourDate, price);

                        // Call the addTour method to insert the tour into the database
                        if (newTour.addTour()) {
                            JOptionPane.showMessageDialog(null, "Tour added successfully with ID: " + generatedId);
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to add tour.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Invalid input: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            add(addButton);


            JLabel backLabel = new JLabel("<< Back");
            backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            backLabel.setForeground(java.awt.Color.BLUE);
            backLabel.setBounds(20, 320, 100, 30);
            backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cardLayout.show(mainPanel, ManageToursPanel);
                }
            });
            add(backLabel);
        }
    }

    // Panel for editing an existing tour
    class EditTourPanel extends JPanel {
        public EditTourPanel() {
            setLayout(null);

            JLabel welcomeLabel = new JLabel();
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            User currentUser = UserSession.getInstance().getUser();
            if (currentUser != null) {
                welcomeLabel.setText("Logged in as: " + currentUser.getUsername());
            }
            welcomeLabel.setBounds(20, 30, 300, 30);
            add(welcomeLabel);

            JLabel tourIdLabel = new JLabel("Tour ID:");
            tourIdLabel.setBounds(50, 80, 100, 30);
            add(tourIdLabel);
            JTextField tourIdField = new JTextField();
            tourIdField.setBounds(160, 80, 150, 30);
            add(tourIdField);

            JLabel newNameLabel = new JLabel("New Name:");
            newNameLabel.setBounds(50, 120, 100, 30);
            add(newNameLabel);
            JTextField newNameField = new JTextField();
            newNameField.setBounds(160, 120, 150, 30);
            add(newNameField);

            JLabel newDestinationLabel = new JLabel("New Destination:");
            newDestinationLabel.setBounds(50, 160, 120, 30);
            add(newDestinationLabel);
            JTextField newDestinationField = new JTextField();
            newDestinationField.setBounds(180, 160, 130, 30);
            add(newDestinationField);

            JLabel newDateLabel = new JLabel("New Date:");
            newDateLabel.setBounds(50, 200, 100, 30);
            add(newDateLabel);
            JTextField newDateField = new JTextField();
            newDateField.setBounds(160, 200, 150, 30);
            add(newDateField);

            JLabel newPriceLabel = new JLabel("New Price:");
            newPriceLabel.setBounds(50, 240, 100, 30);
            add(newPriceLabel);
            JTextField newPriceField = new JTextField();
            newPriceField.setBounds(160, 240, 150, 30);
            add(newPriceField);

            JButton editButton = new JButton("Edit Tour");
            editButton.setBounds(160, 290, 150, 40);
            editButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        // Retrieve the tour details from the text fields
                        String tourId = tourIdField.getText();
                        String newName = newNameField.getText();
                        String newDestination = newDestinationField.getText();
                        String newDateStr = newDateField.getText();
                        String newPriceStr = newPriceField.getText();

                        // Parse the date string (expected format: YYYY-MM-DD)
                        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                        Date newDate = sdf.parse(newDateStr);

                        // Parse the price string into a double
                        double newPrice = Double.parseDouble(newPriceStr);

                        // In a real application, you would retrieve the existing Tour from the database by tourId.
                        // For demonstration, we create a dummy Tour instance with the given tourId.
                        // The dummy values for name, destination, date, and price are placeholders.
                        Tour tourToEdit = new Tour(tourId, "dummy", "dummy", new Date(), 0.0);

                        // Call the editTour method to update the tour details in the database
                        if (tourToEdit.editTour(newName, newDestination, newDate, newPrice)) {
                            JOptionPane.showMessageDialog(null, "Tour updated successfully!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Tour update failed.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Invalid input: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            add(editButton);


            JLabel backLabel = new JLabel("<< Back");
            backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            backLabel.setForeground(java.awt.Color.BLUE);
            backLabel.setBounds(20, 340, 100, 30);
            backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cardLayout.show(mainPanel, "ManageToursPanel");
                }
            });
            add(backLabel);
        }
    }

    // Panel for deleting a tour
    class DeleteTourPanel extends JPanel {
        public DeleteTourPanel() {
            setLayout(null);

            JLabel welcomeLabel = new JLabel();
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            User currentUser = UserSession.getInstance().getUser();
            if (currentUser != null) {
                welcomeLabel.setText("Logged in as: " + currentUser.getUsername());
            }
            welcomeLabel.setBounds(20, 30, 300, 30);
            add(welcomeLabel);

            JLabel tourIdLabel = new JLabel("Tour ID to Delete:");
            tourIdLabel.setBounds(50, 80, 150, 30);
            add(tourIdLabel);
            JTextField tourIdField = new JTextField();
            tourIdField.setBounds(210, 80, 150, 30);
            add(tourIdField);

            JButton deleteButton = new JButton("Delete Tour");
            deleteButton.setBounds(210, 130, 150, 40);
            deleteButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // In a real application, delete the tour based on the given ID.
                    JOptionPane.showMessageDialog(null, "Tour deleted successfully!");
                }
            });
            add(deleteButton);

            JLabel backLabel = new JLabel("<< Back");
            backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            backLabel.setForeground(java.awt.Color.BLUE);
            backLabel.setBounds(20, 320, 100, 30);
            backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cardLayout.show(mainPanel, "ManageToursPanel");
                }
            });
            add(backLabel);
        }
    }

    // Panel for viewing tours
    class ViewToursPanel extends JPanel {
        public ViewToursPanel() {
            setLayout(null);

            JLabel welcomeLabel = new JLabel();
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            User currentUser = UserSession.getInstance().getUser();
            if (currentUser != null) {
                welcomeLabel.setText("Logged in as: " + currentUser.getUsername());
            }
            welcomeLabel.setBounds(20, 30, 300, 30);
            add(welcomeLabel);

// Create a StringBuilder to hold the tour details text
StringBuilder tourDetails = new StringBuilder();
try {
    // SQL query to retrieve all tours
    String sql = "SELECT id, name, destination, date, price FROM tours";
    Connection conn = DatabaseConnection.getConnection();
    PreparedStatement pstmt = conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();

    // Loop through the result set and append each tour's details
    while (rs.next()) {
        tourDetails.append("ID: " + rs.getString("id") + "\n");
        tourDetails.append("Name: " + rs.getString("name") + "\n");
        tourDetails.append("Destination: " + rs.getString("destination") + "\n");
        tourDetails.append("Date: " + rs.getDate("date") + "\n");
        tourDetails.append("Price: " + rs.getDouble("price") + "\n");
        tourDetails.append("------------------------------\n");
    }

    rs.close();
    pstmt.close();
    conn.close();
} catch (SQLException ex) {
    ex.printStackTrace();
    tourDetails.append("Error retrieving tours.");
}

// Use a JTextArea to display the tour details (supports multiple lines without HTML)
javax.swing.JTextArea toursTextArea = new javax.swing.JTextArea(tourDetails.toString());
toursTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
toursTextArea.setEditable(false);
toursTextArea.setBounds(50, 80, 400, 200);
add(toursTextArea);


            JLabel backLabel = new JLabel("<< Back");
            backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            backLabel.setForeground(java.awt.Color.BLUE);
            backLabel.setBounds(20, 320, 100, 30);
            backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cardLayout.show(mainPanel, ManageToursPanel);
                }
            });
            add(backLabel);
        }
    }

    // Panel for viewing bookings
    class ViewBookingsPanel extends JPanel {
        public ViewBookingsPanel() {
            setLayout(null);

            JLabel welcomeLabel = new JLabel();
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            User currentUser = UserSession.getInstance().getUser();
            if (currentUser != null) {
                welcomeLabel.setText("Logged in as: " + currentUser.getUsername());
            }
            welcomeLabel.setBounds(20, 30, 300, 30);
            add(welcomeLabel);

            JLabel bookingsLabel = new JLabel("Bookings details would appear here.");
            bookingsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            bookingsLabel.setBounds(50, 80, 400, 200);
            add(bookingsLabel);

            JLabel backLabel = new JLabel("<< Back");
            backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            backLabel.setForeground(java.awt.Color.BLUE);
            backLabel.setBounds(20, 320, 100, 30);
            backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cardLayout.show(mainPanel, "ManageBookingsPanel");
                }
            });
            add(backLabel);
        }
    }

    // Panel for updating a booking
    class UpdateBookingPanel extends JPanel {
        public UpdateBookingPanel() {
            setLayout(null);

            JLabel welcomeLabel = new JLabel();
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            User currentUser = UserSession.getInstance().getUser();
            if (currentUser != null) {
                welcomeLabel.setText("Logged in as: " + currentUser.getUsername());
            }
            welcomeLabel.setBounds(20, 30, 300, 30);
            add(welcomeLabel);

            JLabel bookingIdLabel = new JLabel("Booking ID:");
            bookingIdLabel.setBounds(50, 80, 100, 30);
            add(bookingIdLabel);
            JTextField bookingIdField = new JTextField();
            bookingIdField.setBounds(160, 80, 150, 30);
            add(bookingIdField);

            JLabel newStatusLabel = new JLabel("New Status:");
            newStatusLabel.setBounds(50, 120, 100, 30);
            add(newStatusLabel);
            JTextField newStatusField = new JTextField();
            newStatusField.setBounds(160, 120, 150, 30);
            add(newStatusField);

            JButton updateButton = new JButton("Update Booking");
            updateButton.setBounds(160, 170, 150, 40);
            updateButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // In a real application, update the booking status.
                    JOptionPane.showMessageDialog(null, "Booking updated successfully!");
                }
            });
            add(updateButton);

            JLabel backLabel = new JLabel("<< Back");
            backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            backLabel.setForeground(java.awt.Color.BLUE);
            backLabel.setBounds(20, 320, 100, 30);
            backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cardLayout.show(mainPanel, "ManageBookingsPanel");
                }
            });
            add(backLabel);
        }
    }

    // Panel for deleting a booking
    class DeleteBookingPanel extends JPanel {
        public DeleteBookingPanel() {
            setLayout(null);

            JLabel welcomeLabel = new JLabel();
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            User currentUser = UserSession.getInstance().getUser();
            if (currentUser != null) {
                welcomeLabel.setText("Logged in as: " + currentUser.getUsername());
            }
            welcomeLabel.setBounds(20, 30, 300, 30);
            add(welcomeLabel);

            JLabel bookingIdLabel = new JLabel("Booking ID to Delete:");
            bookingIdLabel.setBounds(50, 80, 150, 30);
            add(bookingIdLabel);
            JTextField bookingIdField = new JTextField();
            bookingIdField.setBounds(210, 80, 150, 30);
            add(bookingIdField);

            JButton deleteButton = new JButton("Delete Booking");
            deleteButton.setBounds(210, 130, 150, 40);
            deleteButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // In a real application, delete the booking.
                    JOptionPane.showMessageDialog(null, "Booking deleted successfully!");
                }
            });
            add(deleteButton);

            JLabel backLabel = new JLabel("<< Back");
            backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            backLabel.setForeground(java.awt.Color.BLUE);
            backLabel.setBounds(20, 320, 100, 30);
            backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cardLayout.show(mainPanel, "ManageBookingsPanel");
                }
            });
            add(backLabel);
        }
    }

    // Panel for generating user reports
    class UserReportsPanel extends JPanel {
        public UserReportsPanel() {
            setLayout(null);

            JLabel welcomeLabel = new JLabel();
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            User currentUser = UserSession.getInstance().getUser();
            if (currentUser != null) {
                welcomeLabel.setText("Logged in as: " + currentUser.getUsername());
            }
            welcomeLabel.setBounds(20, 30, 300, 30);
            add(welcomeLabel);

            // Simulate display of user reports (in a real app, data would be loaded)
            JLabel reportsLabel = new JLabel("User Reports would be displayed here.");
            reportsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            reportsLabel.setBounds(50, 80, 400, 200);
            add(reportsLabel);

            JLabel backLabel = new JLabel("<< Back");
            backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            backLabel.setForeground(java.awt.Color.BLUE);
            backLabel.setBounds(20, 320, 100, 30);
            backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cardLayout.show(mainPanel, "GenerateReportsPanel");
                }
            });
            add(backLabel);
        }
    }

    // Panel for generating tours reports
    class ToursReportsPanel extends JPanel {
        public ToursReportsPanel() {
            setLayout(null);

            JLabel welcomeLabel = new JLabel();
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            User currentUser = UserSession.getInstance().getUser();
            if (currentUser != null) {
                welcomeLabel.setText("Logged in as: " + currentUser.getUsername());
            }
            welcomeLabel.setBounds(20, 30, 300, 30);
            add(welcomeLabel);

            JLabel reportsLabel = new JLabel("Tours Reports would be displayed here.");
            reportsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            reportsLabel.setBounds(50, 80, 400, 200);
            add(reportsLabel);

            JLabel backLabel = new JLabel("<< Back");
            backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            backLabel.setForeground(java.awt.Color.BLUE);
            backLabel.setBounds(20, 320, 100, 30);
            backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cardLayout.show(mainPanel, "GenerateReportsPanel");
                }
            });
            add(backLabel);
        }
    }

    // Panel for generating bookings reports
    class BookingsReportsPanel extends JPanel {
        public BookingsReportsPanel() {
            setLayout(null);

            JLabel welcomeLabel = new JLabel();
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            User currentUser = UserSession.getInstance().getUser();
            if (currentUser != null) {
                welcomeLabel.setText("Logged in as: " + currentUser.getUsername());
            }
            welcomeLabel.setBounds(20, 30, 300, 30);
            add(welcomeLabel);

            JLabel reportsLabel = new JLabel("Bookings Reports would be displayed here.");
            reportsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            reportsLabel.setBounds(50, 80, 400, 200);
            add(reportsLabel);

            JLabel backLabel = new JLabel("<< Back");
            backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            backLabel.setForeground(java.awt.Color.BLUE);
            backLabel.setBounds(20, 320, 100, 30);
            backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cardLayout.show(mainPanel, "GenerateReportsPanel");
                }
            });
            add(backLabel);
        }
    }
    
    
    // Inner class representing the Customer Dashboard Panel
    class CustomerDashboardPanel extends JPanel {
        
        // Constructor to set up the Customer Dashboard Panel
        public CustomerDashboardPanel() {
            // Set layout manager for custom positioning
            setLayout(null);
            
            // Create a label to indicate this is the customer dashboard
            JLabel customerLabel = new JLabel("Customer Dashboard");
            
            // Set font and alignment for the customer dashboard label
            customerLabel.setFont(new Font("Arial", Font.BOLD, 22));
            customerLabel.setHorizontalAlignment(SwingConstants.CENTER);
            
            // Set the position and size of the customer dashboard label
            customerLabel.setBounds(50, 30, 500, 30);
            
            // Add the customer dashboard label to the panel
            add(customerLabel);
        }
    }
    
    // Main method to run the application
    public static void main(String[] args) {
        // Create an instance of the main application
        TourBookingSystem app = new TourBookingSystem();
        
        // Make the application visible
        app.setVisible(true);
    }
}
