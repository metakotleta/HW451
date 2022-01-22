import java.time.Instant;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MissedCalls {

    private Map<Instant, String> missedCalls = new TreeMap<>();

    // Есть подозрение, что при такой реализации метод pBook.mapContacts(), который довольно тяжелый
    // из-за двух вложенных циклов, будет вызываться при каждом добавлении вызова.
    // Лучше будет положить результат вызова метода в переменную в мэйне, и передавать её как параметр?
    // Или есть более оптимальный способ распасить коллекции в методе mapContacts()?

    public void addCall(Call call, PhoneBook pBook) {
        missedCalls.put(call.getCallTime(), pBook.findPhone(call.getPhoneNumber(), pBook.mapContacts()));
    }

    public void getAll() {
        for (Map.Entry<Instant, String> entry : missedCalls.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
