package java.programming;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Theatre theatre = new Theatre("Art Scape", 8,12);
        theatre.getSeats();
        if (theatre.reserveSeat("H11")) {
            System.out.println("Please pay");
        }else {
            System.out.println("Sorry the seat as been taken");
        }
        if (theatre.reserveSeat("H11")){
            System.out.println("Please pay");
        }else {
            System.out.println("Sorry, seat is already taken");
        }
    }
}
