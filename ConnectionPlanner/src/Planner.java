import ConnectionManagement.ConnectionType;
import ConnectionManagement.ConnectionTypes;

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
        Contact c1 = new Contact("Me", "LastName", true, true);
        Contact c2 = new Contact("A", "A", false, true);
        Contact c3 = new Contact("B", "B", true, true);

        ConnectionTypes ct = ConnectionTypes.getInstance();
        Connection con = new Connection(c1, ct.getConnectionTypeByName("Discord"), "someDiscordUser#1234");
        Connection con1 = new Connection(c1, ct.getConnectionTypeByName("Instagram"), "myNameOnInstagram");
        ArrayList<Connection> cons = new ArrayList<>();
        cons.add(con);
        cons.add(con1);
        c1.setAvailableConnections(cons);
        contacts.add(c1);
        contacts.add(c2);
        contacts.add(c3);
        while (blacklist.size() < contacts.size()) {
            System.out.println("Contact selected: " + pickContactServiceAndConnectionMethod());
        }
    }

    protected static String pickContactServiceAndConnectionMethod() {
        String out = "";
        Random r = new Random();
        if (isInit) {
            selection = new ArrayList<Contact>(contacts);
            isInit = false;
        }
        selection.removeAll(blacklist);
        int sel = r.nextInt(selection.size());
        blacklist.add(selection.get(sel));
        Contact c = selection.get(sel);
        out = c.toString();
        if (c.getAvailableConnections() != null) {
            ArrayList<Connection> avcons = c.getAvailableConnections();
            Connection con = avcons.get(r.nextInt(avcons.size()));
            ArrayList<String> pm = con.getPreferredMethods();
            String method = pm.get(r.nextInt(pm.size()));
            out += "\nService: " + con.getConnectionType().getName() + "\nMethod: " + method;
        }
        return out;
    }
}
