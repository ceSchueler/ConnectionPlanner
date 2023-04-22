import java.util.ArrayList;
import java.util.Arrays;

public class Contact {

    private static int id;
    private String firstname;
    private String lastname;
    private String group;
    private ArrayList<Connection> availableConnections; //Set? :thonk:
    private boolean speaksGerman;
    private boolean speaksEnglish;
    private String[] additionalLanguages;
    private String[] preferredLanguages;

    public Contact(String firstname, String lastname, boolean speaksGerman, boolean speaksEnglish) {
        this.id++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.speaksGerman = speaksGerman;
        this.speaksEnglish = speaksEnglish;
        this.group = "NO_GROUP";
    }

    public Contact(String firstname, String lastname, boolean speaksGerman, boolean speaksEnglish, String group) {
        this.id++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.speaksGerman = speaksGerman;
        this.speaksEnglish = speaksEnglish;
        this.group = group;
    }

    public Contact(String firstname, String lastname, boolean speaksGerman, boolean speaksEnglish, String group, ArrayList<Connection> availableConnections) {
        this.id++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.speaksGerman = speaksGerman;
        this.speaksEnglish = speaksEnglish;
        this.group = group;
        this.availableConnections = availableConnections;
    }

    public Contact(String firstname, String lastname, ArrayList<Connection> availableConnections, boolean speaksGerman, boolean speaksEnglish, String[] additionalLanguages, String[] preferredLanguages) {
        this.id++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.speaksGerman = speaksGerman;
        this.speaksEnglish = speaksEnglish;
        this.availableConnections = availableConnections;
        this.additionalLanguages = additionalLanguages;
        this.preferredLanguages = preferredLanguages;
    }

    public static int getId() {
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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
        return "Contact{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", group='" + group + '\'' +
                ", availableConnections=" + availableConnections +
                ", speaksGerman=" + speaksGerman +
                ", speaksEnglish=" + speaksEnglish +
                ", additionalLanguages=" + Arrays.toString(additionalLanguages) +
                ", preferredLanguages=" + Arrays.toString(preferredLanguages) +
                '}';
    }
}