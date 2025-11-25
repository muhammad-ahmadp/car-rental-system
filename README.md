# Car Rental Management System

A comprehensive, console-based application developed in Java to manage the full lifecycle of a car rental business, from vehicle and customer registration to rental transactions and automated billing. This project highlights the implementation of complex business logic and state management within an Object-Oriented framework.

[![Java](https://img.shields.io/badge/Java-11+-orange.svg)](https://www.java.com/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

---

## 1. Overview

The Car Rental Management System is designed to simulate the core operations of a rental agency. It focuses on maintaining data integrity, tracking the availability of assets, and accurately calculating transaction costs based on business rules.

### Core Features

*   **Asset Management:** Add and track rental vehicles, including model, brand, and daily price.
*   **Customer Management:** Register and manage customer information.
*   **Rental Workflow:** Complete end-to-end process for renting and returning a car.
*   **Automated Billing:** Calculates the total rental cost based on the daily rate and rental duration.
*   **State Management:** Real-time tracking of car availability to prevent double-booking.
*   **Data Integrity:** Comprehensive input validation and prevention of duplicate car IDs.

---

## 2. Technical Architecture

The system is modularly designed with distinct classes handling the core entities, transactions, and business logic.

### Project Structure

```
car-rental-system/
│
├── Car.java              # Car entity with rental state
├── Customer.java         # Customer entity
├── Rental.java           # Rental transaction and cost calculation
├── RentalManager.java    # Business logic and data management
└── Manager.java          # Main entry point with CLI interface
```

### Key Classes and Responsibilities

| Class | Responsibility | Key Concepts Demonstrated |
| :--- | :--- | :--- |
| `Car.java` | Represents a rental asset and manages its availability state. | Encapsulation, State Management, Data Validation. |
| `Customer.java` | Manages customer data. | Encapsulation, Input Validation. |
| `Rental.java` | Models the transaction, linking `Car` and `Customer`. | Business Logic Implementation, Automated Calculation. |
| `RentalManager.java` | Central repository for all entities and core business operations. | Collection Management (`ArrayList`), Search Logic, Duplicate Prevention. |

---

## 3. Design Decisions

The design prioritizes robust state management and accurate financial transactions, which are critical for a rental business.

*   **State Management:** The `Car` class includes an `isAvailable` flag, and the `rentCar()` method explicitly checks this state before proceeding, preventing logical errors like renting an already-rented vehicle.
*   **Business Logic Encapsulation:** The cost calculation logic is encapsulated within the `Rental` class, ensuring that the billing process is consistent and decoupled from the main management logic.
*   **Data Integrity:** Duplicate prevention is implemented for car IDs in the `RentalManager`, a necessary feature for maintaining a reliable asset inventory.
*   **Exception Handling:** The system uses exceptions (e.g., `IllegalStateException`) to handle invalid state transitions (like trying to rent an unavailable car), promoting clean error handling.

### Code Example: State Management and Validation

```java
public void rentCar() {
    // Prevents double-booking and invalid state transitions
    if (!isAvailable) {
        throw new IllegalStateException("Car is already rented!");
    }
    this.isAvailable = false;
}

public double totalCost() {
    // Automated cost calculation
    return days * car.getRentalPricePerDay();
}
```

---

## 4. How to Run

### Prerequisites
*   Java Development Kit (JDK) 8 or higher

### Installation and Execution

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/muhammad-ahmadp/car-rental-system.git
    cd car-rental-system
    ```

2.  **Compile all files:**
    ```bash
    javac *.java
    ```

3.  **Run the application:**
    ```bash
    java Manager
    ```

### Sample Workflow

```
===== Car Rental System =====
1. Add Car
...
3. Rent a Car
...
Enter your choice: 3
Enter Rental ID: R001
Enter Customer ID: CUST001
Enter Car ID: C001
Enter Days: 3
Rental completed successfully!

Rental ID: R001
Customer: Ahmed Ali
Car: Honda (Civic)
Days: 3
Total Cost: 150.00
```

---

## 5. Limitations and Future Enhancements

### Known Limitations

*   **Persistence:** Data is stored in memory only and is lost upon application exit.
*   **Interface:** Limited to a console-only interface.
*   **Financial:** Lacks integration for payment processing and tax calculation.

### What I'd Do Next

*   Implement **database persistence** (e.g., using JDBC) for permanent data storage.
*   Develop a **Graphical User Interface (GUI)** using JavaFX or Swing.
*   Add a **due date and late fee system** to enhance business logic.
*   Implement **customer rental history** tracking and **car maintenance** tracking.
*   Integrate **Unit Tests** to cover core business logic and state transitions.

---

## 6. Contact and License

### Author

**Muhammad Ahmad**

*   GitHub: [@muhammad-ahmadp](https://github.com/muhammad-ahmadp)
*   LinkedIn: [muhammad-ahmadcs](https://linkedin.com/in/muhammad-ahmadcs)

### License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

### Acknowledgments

This project was built as a practical demonstration of Java fundamentals and the implementation of complex business rules in a real-world scenario.
