import java.util.*;

// впервые не стал реализовывать задание со звездочкой, в общем и целом суть хранения сортированного списка
// и бинарный поиск по списку понятны, но мне категорически нравится HashSet для хранения контактов,
// т.к. позволяет исключать дубли :)

public class PhoneBook {
    Set<Contact> contactList;
//    List<String> groupList = new ArrayList<>(3);
    Map<String, Set<Contact>> groupedContacts = new HashMap<>(5);

    public void addContactAndGroup(List<String> group, Contact contact)  {
        for (int i = 0; i < group.size(); i++) {
//            if (groupedContacts.get(groupList.get(Integer.parseInt(group.get(i)) - 1)) == null) {
            if (!groupedContacts.containsKey(group.get(i))) {
                contactList = new HashSet<>();
                contactList.add(contact);
                groupedContacts.put(group.get(i), contactList);
            } else {
                groupedContacts.get(group.get(i)).add(contact);
            }
        }
    }

    public Map<String, String> mapContacts() {
        Map<String, String> contactMap = new HashMap<>();
        Collection<Set<Contact>> groupValues = groupedContacts.values();
        Iterator<Set<Contact>> iter = groupValues.iterator();
        while (iter.hasNext()) {
            Iterator<Contact> iterContact = iter.next().iterator();
            while (iterContact.hasNext()) {
                Contact item = iterContact.next();
                contactMap.put(item.getPhone(), item.getName());
            }
        }
        return contactMap;
     }

    public String findPhone(String phone, Map<String, String> contacts) {
        if (contacts.containsKey(phone)) {
            return contacts.get(phone);
        } else {
            return phone;
        }
    }

    public void getAll() {
        for (Map.Entry<String, Set<Contact>> entry : groupedContacts.entrySet()) {
            System.out.println("- " + entry.getKey());
            for (Contact value : entry.getValue()) {
                System.out.println("  -- " + value.toString());
            }
        }
    }
}
