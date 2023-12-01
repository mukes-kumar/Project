
import java.util.*;

class Car {

    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;

    public Car(String carId, String brand, String model, double basePricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;

    }

    public String getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double calculatePrice(int rentalDays) {
        return basePricePerDay * rentalDays;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean rent() {
        return false;
    }

    public void returnCar() {
        isAvailable = true;
    }
}

// *********** Customer Details ***************

class Customer {

    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;

    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

}

// To rent Car Details Store*******************
class Rental {

    private Car car;
    private Customer customer;
    private int days;

    public Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Car getCar() {
        return car;

    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }

}

class CarRantalSystem {
    private List<Car> cars; // To Store Car

    private List<Customer> customers; // To store Customer

    private List<Rental> rentals; // To store rentals

    public CarRantalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();

    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days) {

        if (car.isAvailable()) {
            car.rent();
            rentals.add(new Rental(car, customer, days));
        } else {
            System.out.print("Car is not available for rent:");
        }
    }

    public void returnCar(Car car) {
        car.returnCar();
        Rental rentalToRemove = null;

        for (Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
            System.out.println("Car returned successfully");

        } else {
            System.out.println("Car was not rented");

        }

    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("====== Car Rental Syatem======");
            System.out.println("1. Rent a car");
            System.out.print("2. Return a Car");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("\n== Rant a Car ==\n");
                System.out.println("Enterr your name: ");
                String customerName = scanner.nextLine();

                System.out.println("\n Avaliable Cars:");
                for (Car car : cars) {

                    if (car.isAvailable()) {
                        System.out.println(car.getCarId() + " - " + car.getBrand() + " " + car.getModel());

                    }
                }
                System.out.println("\n Enter the car Id you want to rent: ");
                String carId = scanner.nextLine();

                System.out.println("Enter the number of days for rental: ");
                int rentalDays = scanner.nextInt();
                scanner.nextLine();

                Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for (Car car : cars) {
                    if (car.getCarId().equals(carId) && car.isAvailable()) {
                        selectedCar = car;
                        break;
                    }
                }

                if (selectedCar != null) {
                    double totalPrice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("\n== Rental Information==\n");
                    System.out.println("Customer ID: " + newCustomer.getCustomerId());
                    System.out.println("Customer Name: " + newCustomer.getName());
                    System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
                    System.out.println("Rental Days: " + rentalDays);
                    System.out.println("Total Price: $." + totalPrice);

                    System.out.println("\n Confirm rental (Y/N): ");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        rentCar(selectedCar, newCustomer, rentalDays);
                        System.out.println("\n Car rentals successfully. ");
                    } else {
                        System.out.println("\n Rental canceled. ");
                    }
                } else {
                    System.out.println("\nInvalid car selection or car not avaliable for rent. ");

                }
            } else if (choice == 2) {
                System.out.println("\n== Return a Car ==\n");
                System.out.println("Enter the car ID you want to return: ");
                String carId = scanner.nextLine();

                Car carToReturn = null;
                for (Car car : cars) {
                    if (car.getCarId().equals(carId) && car.isAvailable()) {
                        carToReturn = car;
                        break;
                    }
                }
                if (carToReturn != null) {
                    Customer customer = null;
                    for (Rental rental : rentals) {
                        if (rental.getCar() == carToReturn) {
                            customer = rental.getCustomer();
                            break;
                        }
                    }

                    if (customer != null) {
                        returnCar(carToReturn);
                        System.out.println("Car returned successfully by " + customer.getName());

                    } else {
                        System.out.println("Car was not returned or rental information is missing.");

                    }
                } else {
                    System.out.println("Invalid car Id or car is not rentes");

                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter  a valid option.");
            }

        }
        System.out.println("\n Thank you for using the car Rental System!");
        scanner.close();
    }

}

public class Maiin {
    public static void main(String args[]) {
        CarRantalSystem rentalSystem = new CarRantalSystem();
        Car car1 = new Car("C001", "Toyota", "Camry", 60.0);

        Car car2 = new Car("C002", "Honda", "Camry", 100.0);
        Car car3 = new Car("C003", "Mahendra", "Camry", 150.0);

        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        rentalSystem.menu();
    }
}