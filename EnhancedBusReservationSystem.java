import java.util.*;

public class EnhancedBusReservationSystem {
    private static List<Bus> buses = new ArrayList<>();
    private static Map<Integer, Reservation> reservations = new HashMap<>();
    private static int reservationCounter = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample data
        buses.add(new Bus(1, "TN01AB1234", 4, 4, "Chennai", "Madurai"));
        buses.add(new Bus(2, "TN02CD5678", 5, 4, "Chennai", "Coimbatore"));

        while (true) {
            System.out.println("\n--- Enhanced Bus Reservation System ---");
            System.out.println("1. View Available Buses");
            System.out.println("2. Display Seat Layout");
            System.out.println("3. Reserve a Seat");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Display Booked Passengers");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableBuses();
                    break;
                case 2:
                    displaySeatLayout();
                    break;
                case 3:
                    reserveSeat();
                    break;
                case 4:
                    cancelBooking();
                    break;
                case 5:
                    displayBookedPassengers();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void viewAvailableBuses() {
        System.out.println("\nAvailable Buses:");
        for (Bus bus : buses) {
            System.out.println(bus.getDetails());
        }
    }

    private static void displaySeatLayout() {
        System.out.print("\nEnter Bus ID: ");
        int busId = scanner.nextInt();
        Bus bus = findBusById(busId);
        if (bus != null) {
            bus.displaySeats();
        } else {
            System.out.println("Bus not found.");
        }
    }

    private static void reserveSeat() {
        System.out.print("\nEnter Bus ID: ");
        int busId = scanner.nextInt();
        System.out.print("Enter Passenger Name: ");
        String name = scanner.next();
        System.out.print("Enter Passenger Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Passenger Phone Number: ");
        String phoneNumber = scanner.next();
        System.out.print("Enter Seat Number (e.g., A1): ");
        String seatNumber = scanner.next();

        Bus bus = findBusById(busId);

        if (bus == null) {
            System.out.println("Invalid bus.");
            return;
        }

        if (bus.bookSeat(seatNumber)) {
            Passenger passenger = new Passenger(reservationCounter, name, age, phoneNumber);
            reservations.put(reservationCounter, new Reservation(reservationCounter, busId, passenger, seatNumber));
            System.out.println("Reservation successful! Reservation ID: " + reservationCounter);
            reservationCounter++;
        } else {
            System.out.println("Seat not available.");
        }
    }

    private static void cancelBooking() {
        System.out.print("\nEnter Reservation ID: ");
        int reservationId = scanner.nextInt();

        Reservation reservation = reservations.remove(reservationId);
        if (reservation != null) {
            Bus bus = findBusById(reservation.getBusId());
            if (bus != null) bus.cancelSeat(reservation.getSeatNumber());
            System.out.println("Booking cancelled.");
        } else {
            System.out.println("Reservation not found.");
        }
    }

    private static void displayBookedPassengers() {
        System.out.println("\nBooked Passengers:");
        for (Reservation reservation : reservations.values()) {
            System.out.println(reservation.getDetails());
        }
    }

    private static Bus findBusById(int busId) {
        for (Bus bus : buses) {
            if (bus.getBusId() == busId) {
                return bus;
            }
        }
        return null;
    }
}
