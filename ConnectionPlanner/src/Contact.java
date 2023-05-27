import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Contact {

    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private String firstname;
    private String lastname;
    private ArrayList<String> groups;
    private ArrayList<Connection> availableConnections; //Set? :thonk:
    private boolean speaksGerman;
    private boolean speaksEnglish;
    private String[] additionalLanguages; // remove?
    private String[] preferredLanguages;

    public Contact(String firstname, String lastname, boolean speaksGerman, boolean speaksEnglish) {
        this.id = count.incrementAndGet();
        this.firstname = firstname;
        this.lastname = lastname;
        this.speaksGerman = speaksGerman;
        this.speaksEnglish = speaksEnglish;
    }

    public Contact(String firstname, String lastname, boolean speaksGerman, boolean speaksEnglish, ArrayList<String> groups) {
        this.id = count.incrementAndGet();
        this.firstname = firstname;
        this.lastname = lastname;
        this.speaksGerman = speaksGerman;
        this.speaksEnglish = speaksEnglish;
        this.groups = groups;
    }

    public Contact(String firstname, String lastname, boolean speaksGerman, boolean speaksEnglish, ArrayList<String> groups, ArrayList<Connection> availableConnections) {
        this.id = count.incrementAndGet();
        this.firstname = firstname;
        this.lastname = lastname;
        this.speaksGerman = speaksGerman;
        this.speaksEnglish = speaksEnglish;
        this.groups = groups;
        this.availableConnections = availableConnections;
    }

    public Contact(String firstname, String lastname, ArrayList<Connection> availableConnections, boolean speaksGerman, boolean speaksEnglish, String[] additionalLanguages, String[] preferredLanguages) {
        this.id = count.incrementAndGet();
        this.firstname = firstname;
        this.lastname = lastname;
        this.speaksGerman = speaksGerman;
        this.speaksEnglish = speaksEnglish;
        this.availableConnections = availableConnections;
        this.additionalLanguages = additionalLanguages;
        this.preferredLanguages = preferredLanguages;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public ArrayList<String> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<String> groups) {
        this.groups = groups;
    }

    public ArrayList<Connection> getAvailableConnections() {
        return availableConnections;
    }

    public void setAvailableConnections(ArrayList<Connection> availableConnections) {
        this.availableConnections = availableConnections;
    }

    public boolean isSpeaksGerman() {
        return speaksGerman;
    }

    public void setSpeaksGerman(boolean speaksGerman) {
        this.speaksGerman = speaksGerman;
    }

    public boolean isSpeaksEnglish() {
        return speaksEnglish;
    }

    public void setSpeaksEnglish(boolean speaksEnglish) {
        this.speaksEnglish = speaksEnglish;
    }

    public String[] getAdditionalLanguages() {
        return additionalLanguages;
    }

    public void setAdditionalLanguages(String[] additionalLanguages) {
        this.additionalLanguages = additionalLanguages;
    }

    public String[] getPreferredLanguages() {
        return preferredLanguages;
    }

    public void setPreferredLanguages(String[] preferredLanguages) {
        this.preferredLanguages = preferredLanguages;
    }

    @Override
    public String toString() {
        return "Contact[" + getId() + "]{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", groups=" + groups +
                ", availableConnections=" + availableConnections +
                ", speaksGerman=" + speaksGerman +
                ", speaksEnglish=" + speaksEnglish +
                ", additionalLanguages=" + Arrays.toString(additionalLanguages) +
                ", preferredLanguages=" + Arrays.toString(preferredLanguages) +
                '}';
    }
}