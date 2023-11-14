package data;

import com.github.javafaker.Faker;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TestData {
    private final Faker faker = new Faker(Locale.US);
    //private final SimpleDateFormat formatter = new SimpleDateFormat("dd MMMMM yyyy");
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String eMail = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public String phoneNumberMistake = faker.phoneNumber().subscriberNumber(9);
    public Date dateOfBirth = faker.date().birthday();

    public String currentAddress = faker.address().fullAddress();
    public String subjects = faker.options().option("History", "Hindi", "English", "Math", "Arts");
    public String hobby = faker.options().option("Sports", "Music", "Reading");
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = getRandomCity(state);

    public String getRandomCity(String state) {
        Map<String, String[]> cities = new HashMap<String, String[]>();

        cities.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        cities.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        cities.put("Haryana", new String[]{"Agra", "Lucknow", "Merrut"});
        cities.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});

        return faker.options().option(cities.get(state));
    }
}
