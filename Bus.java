import java.util.*;

public class Bus {
    private int busId;
    private String busNumber;
    private int rows;
    private int columns;
    private String source;
    private String destination;
    private String[][] seats; // Seat layout (e.g., A1, B2)

    public Bus(int busId, String busNumber, int rows, int columns, String source, String destination) {
        this.busId = busId;
        this.busNumber = busNumber;
        this.rows = rows;
        this.columns = columns;
        this.source = source;
        this.destination = destination;
        this.seats = new String[rows][columns];

        char rowLabel = 'A';
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = rowLabel + String.valueOf(j + 1); // E.g., A1, B2
            }
            rowLabel++;
        }
    }

    public int getBusId() {
        return busId;
    }

    public String getRoute() {
        return source + " - " + destination;
    }

    public String[][] getSeats() {
        return seats;
    }

    public boolean bookSeat(String seatNumber) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (seats[i][j].equals(seatNumber)) {
                    seats[i][j] = "X"; // Mark as booked
                    return true;
                }
            }
        }
        return false; // Seat not found or already booked
    }

    public boolean cancelSeat(String seatNumber) {
        char rowLabel = seatNumber.charAt(0);
        int columnNumber = Integer.parseInt(seatNumber.substring(1)) - 1;

        int rowIndex = rowLabel - 'A';
        if (rowIndex >= 0 && rowIndex < rows && columnNumber >= 0 && columnNumber < columns && seats[rowIndex][columnNumber].equals("X")) {
            seats[rowIndex][columnNumber] = seatNumber; // Restore seat
            return true;
        }
        return false; // Seat not booked or invalid
    }

    public void displaySeats() {
        System.out.println("Seat Layout (X = Booked):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(seats[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public String getDetails() {
        return "Bus ID: " + busId + ", Number: " + busNumber + ", Route: " + getRoute();
    }
}
