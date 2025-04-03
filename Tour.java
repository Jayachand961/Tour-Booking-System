import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Tour {
    
    // Stores the unique 6-character tour ID
    private String id;
    
    // Stores the name of the tour
    private String name;
    
    // Stores the destination of the tour
    private String destination;
    
    // Stores the date of the tour
    private Date date;
    
    // Stores the price of the tour
    private double price;

    // Constructor to initialize the Tour object
    public Tour(String id, String name, String destination, Date date, double price) {
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.date = date;
        this.price = price;
    }

    // Method to add a new tour
    public boolean addTour() {
        String sql = "INSERT INTO tours (id, name, destination, date, price) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, this.id);
            pstmt.setString(2, this.name);
            pstmt.setString(3, this.destination);
            pstmt.setDate(4, new java.sql.Date(this.date.getTime()));
            pstmt.setDouble(5, this.price);

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to edit the tour details
    public boolean editTour(String newName, String newDestination, Date newDate, double newPrice) {
        String sql = "UPDATE tours SET name = ?, destination = ?, date = ?, price = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newName);
            pstmt.setString(2, newDestination);
            pstmt.setDate(3, new java.sql.Date(newDate.getTime()));
            pstmt.setDouble(4, newPrice);
            pstmt.setString(5, this.id);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                // Update the object's fields if the database update was successful
                this.name = newName;
                this.destination = newDestination;
                this.date = newDate;
                this.price = newPrice;
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // Method to delete a tour
    public static boolean deleteTour(String tourId) {
        String sql = "DELETE FROM tours WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tourId);

            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
