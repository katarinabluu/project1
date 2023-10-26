package fitness;

import java.util.ArrayList;
import java.util.Scanner;

public class Booking {

    private Customer customer;
    private boolean personalCoach;
    private boolean locker;

    private Offers offer;
    private int period;
    private double price;

    public Booking() {
    }

    public Booking(Customer customer) {
        this.customer = customer;
    }

    public Booking(Customer customer, boolean personalCoach,boolean locker ,int period, double price) {
        this.customer = customer;
        this.personalCoach = personalCoach;
        this.period = period;
        this.price = price;
        this.locker = locker;
    }

    public void bookingPackage(ArrayList<Offers> offers) {
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("\n\t\tList of Package\n");
            int number = 1;
            for (Offers offer : offers) {
                System.out.println(number + ". " + offer.toString() + " per month"+ "\n");
                number+=1;
                
            }

            System.out.println("Enter Number of Package that you want:");
            int pressPlan = input.nextInt();

            if (pressPlan > 0 && pressPlan <= offers.size()) {

                this.offer =offers.get(pressPlan - 1);

            } else {
                System.out.println("Error!!");
                continue;
            }

            System.out.println("\nChoose your plan");
            System.out.println("1- 1 Month     | "+offer.getPrice()*1+" SR");
            System.out.println("2- 3 Month     | "+offer.getPrice()*3+" SR");
            System.out.println("3- 6 Month     | "+offer.getPrice()*6+" SR");
            System.out.println("4- 12 Month    | "+offer.getPrice()*12+" SR");

            int choose = input.nextInt();
            if (choose > 0 && choose <= 4) {
                if (choose == 1) {
                    period = 1;

                } else if (choose == 2) {
                    period = 3;

                } else if (choose == 3) {
                    period = 6;

                } else {
                    period = 12;

                }

                while (true) {
                    System.out.println("personal Couch? (more 500 SR)");
                    System.out.print("y/n: ");
                    String check = input.next();
                    if (check.equals("y") || check.equals("Y")) {
                        personalCoach = true;
                        break;
                    } else if (check.equals("n") || check.equals("N")) {
                        personalCoach = false;
                        break;
                    } else {
                        System.out.println("please enter y or n!!");
                    }
                }
                while (true) {
                    System.out.println("Do you want Locker? (more 250 SR)");
                    System.out.print("y/n: ");
                    String check = input.next();
                    if (check.equals("y") || check.equals("Y")) {
                        locker = true;
                        break;
                    } else if (check.equals("n") || check.equals("N")) {
                        locker = false;
                        break;
                    } else {
                        System.out.println("please enter y or n!!");
                    }
                }

                System.out.println("Booking has been added successfully\n");
                break;
            } else {
                System.out.println("Enter a correct input!!");

            }
        } while (true);
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPersonalCoach() {
        return personalCoach;
    }
    public boolean isLocker() {
        return locker;
    }

    public void setPersonalCoach(boolean personalCoach) {
        this.personalCoach = personalCoach;
    }

    public void setLocker(boolean locker) {
        this.locker = locker;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void printInvoice() {

        System.out.println("\t Invoice\n");

        System.out.printf("- %-20s%s\n", offer.getNameOffer(), offer.getPrice());
        if (personalCoach) {
            System.out.printf("- %-20s%s\n","Personal Coach",500);
            price+=500;
        }
        if (locker) {
            System.out.printf("- %-20s%s\n","Locker",250);
            price+=250;
        }
        price+=(offer.getPrice()*period);
        System.out.println("- "+period+" months\n");
        System.out.println("- Total: "+price);
        
    }

    public Offers getOffer() {
        return offer;
    }

    public void setOffer(Offers offer) {
        this.offer = offer;
    }

    @Override
    public String toString() {
        return "\tBooking Information\n"
                + "Package : " + offer.getNameOffer()
                + "\nPeriod Time : " + period + " month"+"\n"
                + "Personal Coach :" + personalCoach + "\n"
                + "Locker :" + locker + "\n";

    }
}
