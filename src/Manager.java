import java.util.Scanner;

public class Manager {
    public static void main(String[] args) {
        RentalManager rentalManager = new RentalManager();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Car Rental System =====");
            System.out.println("1. Add Car");
            System.out.println("2. Add Customer");
            System.out.println("3. Rent a Car");
            System.out.println("4. Return a Car");
            System.out.println("5. Show All Cars");
            System.out.println("6. Show All Customers");
            System.out.println("7. Show All Rentals");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice! Enter a number from 1 to 8.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    // Add Car
                    System.out.print("Enter Car ID: ");
                    String carId = sc.nextLine();
                    System.out.print("Enter Model: ");
                    String model = sc.nextLine();
                    System.out.print("Enter Brand: ");
                    String brand = sc.nextLine();
                    System.out.print("Enter Rental Price per Day: ");
                    int pricePerDay = Integer.parseInt(sc.nextLine());

                    Car car = new Car(carId, model, brand, pricePerDay, true);
                    rentalManager.addCar(car);
                    System.out.println("Car added successfully!");
                }
                case 2 -> {
                    // Add Customer
                    System.out.print("Enter Customer ID: ");
                    String customerId = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    Customer customer = new Customer(customerId, name, phone);
                    rentalManager.addCustomer(customer);
                    System.out.println("Customer added successfully!");
                }
                case 3 -> {
                    // Rent a Car
                    System.out.print("Enter Rental ID: ");
                    String rentalId = sc.nextLine();
                    System.out.print("Enter Customer ID: ");
                    String custId = sc.nextLine();
                    System.out.print("Enter Car ID: ");
                    String carId = sc.nextLine();
                    System.out.print("Enter Days: ");
                    int days = Integer.parseInt(sc.nextLine());

                    Customer cust = null;
                    Car car = null;

                    for (Customer c : rentalManager.getCustomers()) {
                        if (c.getCustomerId().equals(custId)) {
                            cust = c;
                            break;
                        }
                    }

                    for (Car c : rentalManager.getCars()) {
                        if (c.getCarId().equals(carId)) {
                            car = c;
                            break;
                        }
                    }

                    if (cust == null) {
                        System.out.println("Customer not found!");
                    } else if (car == null) {
                        System.out.println("Car not found!");
                    } else if (!car.isAvailable()) {
                        System.out.println("Car is not available!");
                    } else {
                        car.rentCar();
                        Rental rental = new Rental(rentalId, days, car, cust);
                        rentalManager.addRental(rental);
                        System.out.println("Rental completed successfully!");
                        System.out.println(rental);
                    }
                }
                case 4 -> {
                    // Return a Car
                    System.out.print("Enter Rental ID to return: ");
                    String rentalId = sc.nextLine();
                    boolean found = false;
                    for (Rental r : rentalManager.getRentals()) {
                        if (r.getRentalId().equals(rentalId)) {
                            r.getCar().returnCar();
                            System.out.println("Car returned successfully!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Rental ID not found!");
                }
                case 5 -> rentalManager.displayAllCars();
                case 6 -> rentalManager.displayAllCustomers();
                case 7 -> rentalManager.displayAllRentals();
                case 8 -> {
                    exit = true;
                    System.out.println("Exiting... Thank you!");
                }
                default -> System.out.println("Invalid choice! Enter 1-8.");
            }
        }

        sc.close();
    }
}
