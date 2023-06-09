import ConnectionManagement.ConnectionTypes;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Planner {
    private static ArrayList<Contact> contacts = new ArrayList<Contact>();
    private static ArrayList<Contact> previouslySelected = new ArrayList<Contact>();
    private static ArrayList<Contact> excludedFromSelection = new ArrayList<Contact>();

    private static ArrayList<Contact> selection = new ArrayList<Contact>();

    public static void main(String[] args) {
        //Connection con1 = new Connection(n)
        ArrayList<String> groups = new ArrayList<>();
        groups.add("badgroup1");
        groups.add("b");

        Contact c1 = new Contact("Me", "LastName", true, true);
        Contact c2 = new Contact("A", "A", false, true);
        Contact c3 = new Contact("B", "B", true, true);
        Contact c4 = new Contact("firstname", "lastname", true, true, groups);
        Contact c5 = new Contact("firstname", "lastname", true, true, groups);


        ConnectionTypes ct = ConnectionTypes.getInstance();
        Connection con = new Connection(c1, ct.getConnectionTypeByName("Discord"), "someUniqueDiscordUsernameOrMaybeIDActually");
        Connection con1 = new Connection(c1, ct.getConnectionTypeByName("Instagram"), "myNameOnInstagram");
        ArrayList<Connection> cons = new ArrayList<>();
        cons.add(con);
        cons.add(con1);
        c1.setAvailableConnections(cons);
        contacts.add(c1);
        contacts.add(c2);
        contacts.add(c3);
        contacts.add(c4);
        contacts.add(c5);

        initVariables();

        System.out.println("Use \"get\" to get random connection, \"reset\" to reset pool, \"bg\" to blacklist group and \"q\" to quit");
        Scanner scn = new Scanner(System.in);
        while (scn.hasNext()) {
            String in = scn.next().toLowerCase();
            switch (in.trim()) {
                case "q":
                    return;
                case "bg":
                    System.out.println("Enter Groupname");
                    in = scn.next();
                    addtoBlackListByGroup(in);
                    in = "";
                    break;
                case "get":
                    if (selection.size() > 1) {
                        System.out.println("Contact selected: " + pickContactServiceAndConnectionMethod());
                    } else {
                        System.out.println("No more contacts in pool, reset pool.");
                    }
                    in = "";
                    break;
                case "reset":
                    System.out.println("Resetting pool...");
                    resetPool();
                    in = "";
                    break;
                default:
                    System.out.println("No command recognised!");
                    in = "";
                    break;
            }
        }
    }

    private static void initVariables() {
        selection = new ArrayList<>(contacts);
    }

    protected static String pickContactServiceAndConnectionMethod() {
        String out = "";
        Contact c = new Contact("", "", false, false);
        Random r = new Random();
        selection.removeAll(excludedFromSelection);
        selection.removeAll(previouslySelected);
        if (selection.size() > 0) {
            int sel = r.nextInt(selection.size());
            previouslySelected.add(selection.get(sel));
            c = selection.get(sel);
            out = c.toString();
        }

        if (c.getAvailableConnections() != null) {
            ArrayList<Connection> avcons = c.getAvailableConnections();
            Connection con = avcons.get(r.nextInt(avcons.size()));
            ArrayList<String> pm = con.getPreferredMethods();
            String method = pm.get(r.nextInt(pm.size()));
            out += "\nService: " + con.getConnectionType().getName() + "\nMethod: " + method;
        }
        return out;
    }

    protected static void resetPool() {
        previouslySelected.removeAll(previouslySelected);
        selection.addAll(contacts);
    }

    protected void resetBlacklist() {
        excludedFromSelection.removeAll(excludedFromSelection);
    }

    protected void addtoBlackList(ArrayList<Contact> b) {
        for (Contact c : b) {
            excludedFromSelection.add(c);
        }
    }

    protected static void addtoBlackListByGroup(String groupname) {
        int excludedContacts = 0;

        for (Contact c : selection) {
            if (c.getGroups() != null) {
                for (String g : c.getGroups()) {
                    if (g.equals(groupname)) {
                        excludedFromSelection.add(c);
                        excludedContacts++;
                        break;
                    }
                }
            }
        }
        if (excludedContacts > 0) {
            System.out.println("Successfully removed " + excludedContacts + " Contact(s)");
        } else {
            System.out.println("No contacts removed from selection!");
        }
    }
}
