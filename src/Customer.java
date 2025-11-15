public class Customer {
    private String customerId;
    private String name;
    private String phoneNumber;

    public Customer (String customerId, String name, String phoneNumber){
        if (customerId == null || customerId.trim().isEmpty()
                || name == null || name.trim().isEmpty()
                || phoneNumber == null || phoneNumber.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setCustomerId (String customerId){
        if (customerId == null || customerId.trim().isEmpty()){
            throw new IllegalArgumentException("Customer Id cannot be null or empty!");
        }
        this.customerId = customerId;
    }
    public void setName (String name){
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty!");
        }
        this.name = name;
    }
    public void setPhoneNumber (String phoneNumber){
        if (phoneNumber == null || phoneNumber.trim().isEmpty()){
            throw new IllegalArgumentException("Phone Number cannot be null or empty!");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerId () { return customerId; }
    public String getName () { return name; }
    public String getPhoneNumber () { return phoneNumber; }

    @Override
    public String toString() {
        return String.format(
                "Customer ID: %s%nName: %s%nPhone: %s%n",
                customerId, name, phoneNumber
        );
    }

}
