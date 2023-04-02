import java.util.ArrayList;

public class Connection {
    private static int id;

    private enum ConnectionMethods {CALL, MESSAGE, PICTURE, VIDEOo, VOICE_RECORDING, VIDEO_CALL}

    private Contact contact;
    private ConnectionType connectionType;
    private ArrayList<String> preferredMethods;


    private String contactInfo; //relevant info - i.e. username / telephone number,...

    public Connection(Contact contact, ConnectionType connectionType, String contactinfo) {
        this.id++;
        this.contact = contact;
        this.connectionType = connectionType;
        this.contactInfo = contactinfo;
    }

    public void setPreferredMethods(boolean call, boolean message, boolean picture, boolean video, boolean voiceRecording, boolean videoCall) {
        boolean[] b = new boolean[6];
        for (int i = 0; i < b.length; i++) {
            b[i] = b[i] && connectionType.getMeansOfConnection()[i];
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i]) {
                this.preferredMethods.add(String.valueOf(ConnectionMethods.values()[i]));
            }
        }
    }
}
