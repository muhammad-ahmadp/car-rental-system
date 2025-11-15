public class Rental {
    private String rentalId;
    private int days;
    private Car car;
    private Customer customer;

    public Rental(String rentalId, int days, Car car, Customer customer) {
        if (rentalId == null || rentalId.trim().isEmpty()
                || days < 1 || car == null || customer == null) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.rentalId = rentalId;
        this.days = days;
        this.car = car;
        this.customer = customer;
    }

    public String getRentalId() { return rentalId; }
    public int getDays() { return days; }
    public Car getCar () { return car; }

    public double totalCost() {
        return days * car.getRentalPricePerDay();
    }

    @Override
    public String toString() {
        return String.format(
                "Rental ID: %s%nCustomer: %s%nCar: %s (%s)%nDays: %d%nTotal Cost: %.2f%n",
                rentalId,
                customer.getName(),
                car.getBrand(),
                car.getModel(),
                days,
                totalCost()
        );
    }
}
