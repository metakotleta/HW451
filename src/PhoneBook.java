import java.util.*;

public class PhoneBook {

    private Map<String, String> contactList = new HashMap<>(5);

    public void addContact(String name, String number) {
        contactList.put(number, name);
    }

    public String findName(String phone) {
        return contactList.getOrDefault(phone, phone);
    }

    public Map<String, String> getAll() {
        return contactList;
    }
}
