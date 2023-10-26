package fitness;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fitness {

    public static void main(String[] args) throws IOException {

        String fullName;
        int age;
        int id;
        int phoneNumber;
        String email;

        Scanner input = new Scanner(System.in);
        ArrayList<Customer> customersArray = new ArrayList<>();
        ArrayList<Booking> bookingsArray = new ArrayList<>();

        ArrayList<Offers> offersArray = new ArrayList<>();
        addOffers(offersArray);
        readFile(customersArray, bookingsArray, offersArray);

        int press;
        boolean check = true;
        do {
            System.out.println("--------------------------------------------------------");
            System.out.println("\t\tWELCOME TO ");
            System.out.println("--------------------------------------------------------\n");

            System.out.println("press 1 to Booking Package");
            System.out.println("press 2 to Display Your Package ");
            System.out.println("press 0 to Exit");
            press = input.nextInt();

            switch (press) {
                case 1: {
                    System.out.println("Enter your ID :");
                    id = input.nextInt();

                    System.out.println("Enter your full Name:");
                    input.nextLine();
                    fullName = input.nextLine();

                    System.out.println("How old are you?");
                    age = input.nextInt();

                    while (true){

                        if (age<18){
                            break;
                        }
                        else {
                            System.out.println("The age must be under 18 sorry....");
                            System.exit(0);
                        }

                    }

                    System.out.println("Enter your phone number :");
                    phoneNumber = input.nextInt();

                    System.out.print("Enter your email: ");
                    input.nextLine();
                    email = input.nextLine();

                    Customer customer = new Customer(id, fullName, phoneNumber, email, age);

                    Booking booking = new Booking(customer);
                    customersArray.add(customer);
                    booking.bookingPackage(offersArray);
                    bookingsArray.add(booking);

                    booking.printInvoice();
                    break;
                }
                case 2: {

                    System.out.println("Enter Your ID to show your Package:");
                    id = input.nextInt();
                    boolean found = false;
                    for (Customer customer : customersArray) {
                        if (customer.getId() == id) {
                            Booking booking = bookingsArray.get(customersArray.indexOf(customer));
                            System.out.println(booking.toString());
                            found = true;
                            break;

                        }

                    }
                    if (!found) {
                        System.out.println("Customer ID is wrong!\n");
                    }
                    break;
                }
                case 0: {

                    System.out.println("Thank You");
                    writeFile(customersArray, bookingsArray);
                    check = false;
                    break;

                }
                default: 
                    System.out.println("Error!,please enter valid input!\n");
                    
                    break;
                
            }
        } while (check);
    }

    public static void addOffers( ArrayList<Offers> offersArrya) {

        Offers offer = new Offers( "Swimming",500);
        offersArrya.add(offer);

        Offers offer1 = new Offers( "Ballet",250);
        offersArrya.add(offer1);

        Offers offer2= new Offers( "Karate",600);
        offersArrya.add(offer2);
    }

    public static void writeFile(ArrayList<Customer> customers, ArrayList<Booking> bookings) throws IOException {

        FileWriter writeToFile = new FileWriter("bookings.txt");
        for (Customer customer : customers) {

            Booking booking = bookings.get(customers.indexOf(customer));
            writeToFile.write(customer.getId() + "\n" + customer.getFullName() + "\n" + customer.getPhoneNumber() + "\n" + customer.getAge() + "\n" + customer.getEmail());
            writeToFile.write("\n" + booking.getOffer().getNameOffer() + "\n" + booking.getPeriod());
            writeToFile.write("\n" + booking.isPersonalCoach());
            writeToFile.write("\n" + booking.isLocker()+"\n");

        }
        writeToFile.close();

    }

    public static void readFile(ArrayList<Customer> customersArray, ArrayList<Booking> bookings, ArrayList<Offers> offers) throws FileNotFoundException {

            File read = new File("bookings.txt");
            Scanner myReader = new Scanner(read);
            while (myReader.hasNextLine()) {
                int id = Integer.parseInt(myReader.nextLine());
                String name = myReader.nextLine();
                int phone = Integer.parseInt(myReader.nextLine());
                int age = Integer.parseInt(myReader.nextLine());
                String email = myReader.nextLine();

                String namePackage = myReader.nextLine();
                int period = Integer.parseInt(myReader.nextLine());
                boolean personalCoach = Boolean.parseBoolean(myReader.nextLine());
                boolean locker = Boolean.parseBoolean(myReader.nextLine());

                Customer customer = new Customer(id, name, phone,email, age);
                
                Booking booking = new Booking();
                booking.setCustomer(customer);

                for (Offers offer : offers) {
                    if (offer.getNameOffer().equals(namePackage)) {
                        booking.setOffer(offer);
                    }
                }
                booking.setPeriod(period);
                booking.setPersonalCoach(personalCoach);
                booking.setLocker(locker);

                customersArray.add(customer);
                bookings.add(booking);
            }
            myReader.close();
    }
}
