import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Booking {

    private String id;
    private String userId;
    private String tourId;
    private Date bookingDate;

    public Booking(String id, String userId, String tourId, Date bookingDate) {
        this.id = id;
        this.userId = userId;
        this.tourId = tourId;
        this.bookingDate = bookingDate;
    }

    public boolean createBooking() {
        String sql = "INSERT INTO bookings (id, user_id, tour_id, booking_date) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, this.id);
            pstmt.setString(2, this.userId);
            pstmt.setString(3, this.tourId);
            pstmt.setDate(4, new java.sql.Date(this.bookingDate.getTime()));

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
