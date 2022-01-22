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
            Contact contact = new Contact(splitInput[0], splitInput[1]);

//            System.out.println("Укажите номер группы контакта через пробел:");
//            pBook.printGroup();

            System.out.println("Укажите группы контакта через пробел:");

            List<String> listInput = new ArrayList<>();
            input = scanner.nextLine();
            splitInput = input.split(" ");
            Collections.addAll(listInput, splitInput);

            pBook.addContactAndGroup(listInput, contact);
        }
        pBook.getAll();

        while(true) {
            System.out.println("Введите номер, с которого будем звонить (себе?), или 'нет' для выхода");
            String input = scanner.nextLine();
            if (input.equals("нет")) {
                break;
            }
            Call call = new Call(input);

            mCalls.addCall(call, pBook);
        }
        mCalls.getAll();
    }
}
