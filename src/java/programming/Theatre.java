package java.programming;

import java.util.*;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seat.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    //    getting theatre sit number in an ascending order
    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = null;
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }
        if (requestedSeat == null) {
            System.out.println("There seat number " + seatNumber + " is not available");
            return false;
        }
        return requestedSeat.reserve();
    }

    //for testing
    public void getSeats(){
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber);
        }
    }

    private class Seat {
        private final String seatNumber;
        private boolean reserved = false;

        private Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat" + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = true;
                System.out.println("Reservation of seat " + seatNumber + " has been cancelled");
                return true;
            } else {
                return false;
            }
        }
        public String getSeatNumber() {
            return seatNumber;
        }
    }
}
