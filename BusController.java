package Reservation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BusController {

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            ArrayList<Bus> buses = new ArrayList<>();
            ArrayList<Booking> bookings = new ArrayList<>();

            buses.add(new Bus(1, true, 1));
            buses.add(new Bus(2, false, 50));
            buses.add(new Bus(3, true, 20));
            buses.add(new Bus(4, false, 35));

            for (Bus b : buses) {
                b.displayBus();
            }

            int userChoice;

            do {
                System.out.println("\nEnter 1 to book and enter 2 to exit...");
                try {
                    userChoice = s.nextInt();

                    if (userChoice == 1) {
                        Booking booking = new Booking();
                        if (booking.isAvailable(buses, bookings)) {
                            bookings.add(booking);
                            System.out.println("Booked successfully...");
                        } else {
                            System.out.println("No seats available. Check for another bus...");
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter 1 to book or 2 to exit.");
                    s.nextLine(); // Clear the input buffer
                    userChoice = 0; // Reset userChoice to continue the loop
                } catch (Exception e) {
                    System.out.println("Thank You!");
                    userChoice = 0; // Reset userChoice to continue the loop
                }
            } while (userChoice == 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
