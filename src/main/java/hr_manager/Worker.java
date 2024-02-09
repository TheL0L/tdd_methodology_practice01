package hr_manager;

/**
 * Represents a worker in the HR management system.
 */
public class Worker implements Comparable<Worker>
{
    // Fields
    protected int id;          // Unique identifier for the worker
    protected String firstName; // First name of the worker
    protected String lastName;  // Last name of the worker
    protected String email;     // Email address of the worker
    protected String phone;     // Phone number of the worker
    protected String address;   // Address of the worker
    protected int wage;         // Wage of the worker

    /**
     * Parameterized constructor to create a new Worker.
     *
     * @param id        Unique identifier for the worker.
     * @param firstName First name of the worker.
     * @param lastName  Last name of the worker.
     * @param email     Email address of the worker.
     * @param phone     Phone number of the worker.
     * @param address   Address of the worker.
     * @param wage      Wage of the worker.
     */
    public Worker(int id, String firstName, String lastName, String email, String phone, String address, int wage)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.wage = wage;
    }

    /**
     * Copy constructor to create a new Worker based on an existing Worker.
     *
     * @param otherWorker The worker to copy.
     */
    public Worker(Worker otherWorker)
    {
        this.id = otherWorker.id;
        this.firstName = otherWorker.firstName;
        this.lastName = otherWorker.lastName;
        this.email = otherWorker.email;
        this.phone = otherWorker.phone;
        this.address = otherWorker.address;
        this.wage = otherWorker.wage;
    }

    // Getter and Setter methods for all fields

    /**
     * Get the unique identifier of the worker.
     *
     * @return The unique identifier.
     */
    public int getId()
    {
        return id;
    }

    /**
     * Get the first name of the worker.
     *
     * @return The first name.
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Set the first name of the worker.
     *
     * @param firstName The new first name.
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Get the last name of the worker.
     *
     * @return The last name.
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Set the last name of the worker.
     *
     * @param lastName The new last name.
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Get the email address of the worker.
     *
     * @return The email address.
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Set the email address of the worker.
     *
     * @param email The new email address.
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Get the phone number of the worker.
     *
     * @return The phone number.
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * Set the phone number of the worker.
     *
     * @param phone The new phone number.
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * Get the address of the worker.
     *
     * @return The address.
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Set the address of the worker.
     *
     * @param address The new address.
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * Get the wage of the worker.
     *
     * @return The wage.
     */
    public int getWage()
    {
        return wage;
    }

    /**
     * Set the wage of the worker.
     *
     * @param wage The new wage.
     */
    public void setWage(int wage)
    {
        this.wage = wage;
    }

    /**
     * Returns a string representation of the worker.
     *
     * @return A string representation containing worker details.
     */
    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + firstName + " " + lastName +
                ", Email: " + email +
                ", Phone: " + phone +
                ", Address: " + address +
                ", Wage: " + wage + " NIS";
    }

    /**
     * Compare workers based on their wage.
     *
     * @param otherWorker The worker to compare with.
     * @return A negative integer, zero, or a positive integer as this worker's
     *         wage is less than, equal to, or greater than the specified worker.
     */
    @Override
    public int compareTo(Worker otherWorker) {
        // Compare workers based on their wage
        return Integer.compare(this.wage, otherWorker.wage);
    }
}
