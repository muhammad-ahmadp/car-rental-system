import java.util.ArrayList;

public class RentalManager {
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Rental> rentals = new ArrayList<>();

    // Add new rental
    public void addRental(Rental r) {
        rentals.add(r);
    }

    // Add new car
    public void addCar(Car car) {
        for (Car c : cars) {
            if (c.getCarId().equals(car.getCarId())) {
                System.out.println("Car ID already exists!");
                return;
            }
        }
        cars.add(car);
        System.out.println("Car added successfully!");
    }

    // Add new customer
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Display all cars
    public void displayAllCars() {
        System.out.println("=== All Cars ===");
        for (Car car : cars) {
            System.out.println(car.toString());
            System.out.println("------------------------------");
        }
    }

    // Display all customers
    public void displayAllCustomers() {
        System.out.println("=== All Customers ===");
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
        System.out.println("------------------------------");
    }

    // Display all rentals
    public void displayAllRentals() {
        System.out.println("=== Rental Receipt ===");
        for (Rental rental : rentals) {
            System.out.println(rental.toString());
        }
    }

    // Getter for cars
    public ArrayList<Car> getCars() {
        return cars;
    }

    // Getter for customers
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    // Getter for rentals
    public ArrayList<Rental> getRentals() {
        return rentals;
    }
}
