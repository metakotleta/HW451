import java.time.Instant;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook pBook = new PhoneBook();
        MissedCalls mCalls = new MissedCalls();

        while(true) {
            System.out.println("Введите имя контакта и номер телефона без пробелов или 'нет' для завершения:");
            String input = scanner.nextLine();
            if (input.equals("нет")) {
                break;
            }
            String[] splitInput = input.split(" ");
// В такой реализации в принципе необходимость сущности "Контакт" отпадает.
//            Contact contact = new Contact(splitInput[0], splitInput[1]);

            pBook.addContact(splitInput[0], splitInput[1]);
        }

        printBook(pBook);

        while(true) {
            System.out.println("Введите номер, с которого будем звонить (себе?), или 'нет' для выхода");
            String input = scanner.nextLine();
            if (input.equals("нет")) {
                break;
            }
            Call call = new Call(input);

            mCalls.addCall(call, pBook);
        }
        printMissed(mCalls);
    }

    public static void printBook(PhoneBook pBook) {
        for (Map.Entry<String, String> entry : pBook.getAll().entrySet()) {
            System.out.println(entry.getValue() + ": " + entry.getKey());
        }
    }

    public static void printMissed(MissedCalls mCalls) {
        for (Map.Entry<Instant, String> entry : mCalls.getAll().entrySet()) {
            System.out.println("В " + entry.getKey() + " пропущенный вызов от " + entry.getValue());
        }
    }
}
