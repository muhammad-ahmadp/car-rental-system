public class Car {
    private String carId;
    private String model;
    private String brand;
    private int rentalPricePerDay;
    private boolean isAvailable;

    public Car(String carId, String model, String brand, int rentalPricePerDay, boolean isAvailable) {
        if (carId == null || carId.trim().isEmpty()
                || model == null || model.trim().isEmpty()
                || brand == null || brand.trim().isEmpty()
                || rentalPricePerDay < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.carId = carId;
        this.model = model;
        this.brand = brand;
        this.rentalPricePerDay = rentalPricePerDay;
        this.isAvailable = isAvailable;
    }

    public void setCarId(String carId) {
        if (carId == null || carId.trim().isEmpty()) {
            throw new IllegalArgumentException("CarId cannot be null or empty!");
        }
        this.carId = carId;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty!");
        }
        this.model = model;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or empty!");
        }
        this.brand = brand;
    }

    public void setRentalPricePerDay(int rentalPricePerDay) {
        if (rentalPricePerDay < 0) {
            throw new IllegalArgumentException("RentalPrice cannot be negative!");
        }
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getCarId() { return carId; }
    public String getModel() { return model; }
    public String getBrand() { return brand; }
    public int getRentalPricePerDay() { return rentalPricePerDay; }
    public boolean isAvailable() { return isAvailable; }

    public void rentCar() {
        if (!isAvailable) {
            throw new IllegalStateException("Car is already rented!");
        }
        this.isAvailable = false;
    }

    public void returnCar() {
        if (isAvailable) {
            throw new IllegalStateException("Car is already returned!");
        }
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return String.format(
                "Car ID: %s%nModel: %s%nBrand: %s%nRental Price/Day: %d%nAvailable: %s%n",
                carId, model, brand, rentalPricePerDay, isAvailable ? "Yes" : "No"
        );
    }
}
