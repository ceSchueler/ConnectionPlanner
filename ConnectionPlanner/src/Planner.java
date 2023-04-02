import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Planner {
    private static ArrayList<Contact> contacts = new ArrayList<Contact>();
    private static ArrayList<Contact> blacklist = new ArrayList<Contact>();
    private static ArrayList<Contact> selection = new ArrayList<Contact>();
    private static boolean isInit = true;

    public static void main(String[] args) {
        //Connection con1 = new Connection(n)
        Contact c1 = new Contact("Max", "Mustermann", true, false);
        Contact c2 = new Contact("A", "A", false, true);
        Contact c3 = new Contact("B", "B", true, true);
        contacts.add(c1);
        contacts.add(c2);
        contacts.add(c3);
        while (blacklist.size() < contacts.size()) {
            System.out.println("Contact selected: " + pickContact().toString());
        }
    }

    protected static Contact pickContact() {
        Random r = new Random();
        if (isInit) {
            selection = new ArrayList<Contact>(contacts);
            isInit = false;
        }
        selection.removeAll(blacklist);
        int sel = r.nextInt(selection.size());
        blacklist.add(selection.get(sel));
        return selection.get(sel);
    }
}
