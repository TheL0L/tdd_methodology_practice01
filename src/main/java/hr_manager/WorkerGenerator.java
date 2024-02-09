package hr_manager;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * A class that generates unique random workers with specified fields.
 */
public class WorkerGenerator
{
    private static final String[] FIRST_NAMES = {"John", "Jane", "Michael", "Emily", "David", "Sarah", "Christopher", "Jessica", "Matthew", "Amanda", "Daniel", "Olivia", "Andrew", "Sophia", "Brian", "Emma", "Kevin", "Lauren", "Steven", "Rachel"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez", "Lopez"};
    private static final String[] EMAIL_DOMAINS = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "company.com", "example.com", "testmail.com", "domain.com", "mailservice.com", "mailprovider.com"};
    private static final String[] STREET_NAMES = {"Main", "First", "Second", "Third", "Park", "Fifth", "Maple", "Elm", "Cedar", "Oak", "Pine", "Birch", "Cherry", "Willow", "Spruce", "Magnolia", "Juniper", "Holly", "Sycamore", "Cypress"};
    private static final String[] CITIES = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose", "Austin", "Seattle", "Denver", "Miami", "Atlanta", "Boston", "Las Vegas", "Portland", "Orlando", "Nashville"};


    private static final Random random = new Random();

    private static final int MIN_WAGE = 3_000;
    private static final int MAX_WAGE = 15_000;


    public static Worker[] generateWorkers(int numWorkers) {
        Worker[] Workers = new Worker[numWorkers];
        Set<Integer> usedIds = new HashSet<>();
        Set<String> usedPhones = new HashSet<>();
        Set<String> usedEmails = new HashSet<>();


        for (int i = 0; i < numWorkers; i++) {
            int id = generateUniqueID(usedIds);
            String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
            String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
            String email = generateEmail(firstName.toLowerCase(), lastName.toLowerCase(), EMAIL_DOMAINS[random.nextInt(EMAIL_DOMAINS.length)], usedEmails);
            String phone = generatePhoneNumber(usedPhones);
            String address = generateAddress();
            int salary = generateRandomWage();
            Workers[i] = new Worker(id, firstName, lastName, email, phone, address, salary);

            usedIds.add(id);
            usedPhones.add(phone);
            usedEmails.add(email);
        }
        return Workers;
    }

    private static int generateUniqueID(Set<Integer> usedIds) {
        int id;
        do {
            id = random.nextInt(900000000) + 100000000; // Generate 9-digit ID
        } while (usedIds.contains(id));
        return id;
    }

    private static String generatePhoneNumber(Set<String> usedPhones) {
        StringBuilder builder;
        String phoneNumber;
        do {
            builder = new StringBuilder("05");
            for (int i = 0; i < 8; i++) {
                builder.append(random.nextInt(10));
            }
            phoneNumber = builder.toString();
        } while (usedPhones.contains(phoneNumber));

        return phoneNumber;
    }

    private static String generateEmail(String firstName, String lastName, String domain, Set<String> usedEmails) {
        String prefix = firstName + '.' + lastName;
        String suffix = '@' + domain;
        String email;
        do {
            email = prefix + random.nextInt() + suffix;
        } while (usedEmails.contains(email));

        return email;
    }

    private static String generateAddress() {
        int streetNumber = random.nextInt(1000) + 1;
        String streetName = STREET_NAMES[random.nextInt(STREET_NAMES.length)] + " St";
        String city = CITIES[random.nextInt(CITIES.length)];
        return streetNumber + " " + streetName + ", " + city;
    }

    private static int generateRandomWage() {
        return random.nextInt(MAX_WAGE - MIN_WAGE + 1) + MIN_WAGE;
    }
}
