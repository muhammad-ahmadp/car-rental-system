# 🚗 Car Rental Management System

A comprehensive console-based car rental management system built with Java, featuring full rental workflow, customer management, and automated cost calculation.

[![Java](https://img.shields.io/badge/Java-11+-orange.svg)](https://www.java.com/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

## ✨ Features

- 🚗 **Car Management** - Add and track rental vehicles
- 👤 **Customer Registration** - Manage customer information
- 📝 **Rental Operations** - Complete rent and return workflow
- 💰 **Automated Billing** - Automatic cost calculation based on rental duration
- ✅ **Input Validation** - Comprehensive error checking and data validation
- 🔄 **Availability Tracking** - Real-time car availability status
- 🎨 **Interactive CLI** - User-friendly command-line interface
- 🛡️ **Duplicate Prevention** - Prevents duplicate car IDs

## 🚀 Quick Start

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any IDE (IntelliJ IDEA, Eclipse, VS Code) or terminal

### Installation

1. **Clone the repository**
```bash
git clone https://github.com/muhammad-ahmadp/car-rental-system.git
cd car-rental-system
```

2. **Compile all files**
```bash
javac *.java
```

3. **Run the application**
```bash
java Manager
```

## 📖 Usage

### Main Menu
```
===== Car Rental System =====
1. Add Car
2. Add Customer
3. Rent a Car
4. Return a Car
5. Show All Cars
6. Show All Customers
7. Show All Rentals
8. Exit
```

### Example Workflow

#### 1. Add a Car
```
Enter your choice: 1
Enter Car ID: C001
Enter Model: Civic
Enter Brand: Honda
Enter Rental Price per Day: 50
✅ Car added successfully!
```

#### 2. Register a Customer
```
Enter your choice: 2
Enter Customer ID: CUST001
Enter Name: Ahmed Ali
Enter Phone Number: 03001234567
✅ Customer added successfully!
```

#### 3. Rent a Car
```
Enter your choice: 3
Enter Rental ID: R001
Enter Customer ID: CUST001
Enter Car ID: C001
Enter Days: 3
✅ Rental completed successfully!

Rental ID: R001
Customer: Ahmed Ali
Car: Honda (Civic)
Days: 3
Total Cost: 150.00
```

#### 4. Return a Car
```
Enter your choice: 4
Enter Rental ID to return: R001
✅ Car returned successfully!
```

## 🏗️ Project Structure

```
car-rental-system/
│
├── Car.java              # Car entity with rental operations
├── Customer.java         # Customer entity
├── Rental.java          # Rental transaction with cost calculation
├── RentalManager.java   # Business logic and data management
├── Manager.java         # Main entry point with CLI interface
└── README.md            # This file
```

## 🔧 Technical Details

### Key Classes

#### `Car`
Represents a rental vehicle with:
- Unique car ID, model, and brand
- Daily rental price
- Availability status
- Rent/return operations with state validation

#### `Customer`
Manages customer information:
- Customer ID and name
- Contact information
- Input validation

#### `Rental`
Handles rental transactions:
- Links customer with rented car
- Tracks rental duration
- Automatically calculates total cost
- Formatted receipt generation

#### `RentalManager`
Central management system:
- Maintains all cars, customers, and rentals
- Duplicate prevention for car IDs
- Search and display operations
- Data access methods

#### `Manager`
User interface:
- Interactive menu system
- Input handling and validation
- Exception handling
- User-friendly error messages

## 🎯 Key Features Explained

### 1. Automated Cost Calculation
```java
public double totalCost() {
    return days * car.getRentalPricePerDay();
}
```
System automatically calculates rental cost based on duration.

### 2. State Management
```java
public void rentCar() {
    if (!isAvailable) {
        throw new IllegalStateException("Car is already rented!");
    }
    this.isAvailable = false;
}
```
Prevents double-booking and invalid state transitions.

### 3. Duplicate Prevention
```java
for (Car c : cars) {
    if (c.getCarId().equals(car.getCarId())) {
        System.out.println("❌ Car ID already exists!");
        return;
    }
}
```
Ensures data integrity by preventing duplicate entries.

## 📊 Sample Output

```
=== All Cars ===
Car ID: C001
Model: Civic
Brand: Honda
Rental Price/Day: 50
Available: No
------------------------------

=== Rental Receipt ===
Rental ID: R001
Customer: Ahmed Ali
Car: Honda (Civic)
Days: 3
Total Cost: 150.00
```

## 🛡️ Validation & Error Handling

### Input Validation
- ✅ All fields validated for null/empty values
- ✅ Numeric values checked for validity
- ✅ Clear error messages for invalid inputs
- ✅ Exception handling for user input

### Business Logic Validation
- ✅ Prevents renting unavailable cars
- ✅ Checks for valid customer and car IDs
- ✅ Validates rental duration (minimum 1 day)
- ✅ Prevents duplicate car registrations

## ⚠️ Known Limitations

- 📝 In-memory storage only (data lost on exit)
- 🔐 No authentication system
- 💾 No database persistence
- 📅 No due date tracking
- 💳 No payment processing
- 🌐 Console-only interface

## 🔮 Future Enhancements

- [ ] Add database integration (MySQL/PostgreSQL)
- [ ] Implement due date and late fee system
- [ ] Add payment processing
- [ ] Create GUI with JavaFX
- [ ] Add search and filter functionality
- [ ] Implement customer rental history
- [ ] Add car maintenance tracking
- [ ] Generate PDF receipts
- [ ] Add email notifications
- [ ] Implement multi-location support

## 🎓 Learning Objectives

This project demonstrates:
- ✅ Object-Oriented Programming principles
- ✅ Encapsulation and data validation
- ✅ Business logic implementation
- ✅ ArrayList usage and management
- ✅ Exception handling
- ✅ User interface design (CLI)
- ✅ State management
- ✅ Real-world problem solving

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**[Muhammad Ahmad]**

- GitHub: [muhammad-ahmadp](https://github.com/muhammad-ahmadp)
- LinkedIn: [muhammad-ahmadcs](https://linkedin.com/in/muhammad-ahmadcs)
- Email: muhammadahmadseng@gmail.com

## 🙏 Acknowledgments

- Built as a practical project to demonstrate Java fundamentals
- Inspired by real-world car rental business operations
- Thanks to the Java community for excellent documentation

## 📧 Contact

Questions or suggestions? Feel free to:
- Open an issue
- Submit a pull request
- Contact me directly

---

⭐ **If this project helped you learn, please give it a star!** ⭐

**Made with ❤️ and Java**
