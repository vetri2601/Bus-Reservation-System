public class Passenger {
    private int passengerId;
    private String name;
    private int age;
    private String phoneNumber;

    public Passenger(int passengerId, String name, int age, String phoneNumber) {
        this.passengerId = passengerId;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getDetails() {
        return "Passenger ID: " + passengerId + ", Name: " + name + ", Age: " + age + ", Phone: " + phoneNumber;
    }
}
