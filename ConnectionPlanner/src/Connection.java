import ConnectionManagement.ConnectionType;
import ConnectionManagement.ConnectionTypes;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Connection {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;

    private enum ConnectionMethods {CALL, MESSAGE, PICTURE, VIDEO, VOICE_RECORDING, VIDEO_CALL}

    private Contact contact;
    private ConnectionType connectionType;
    private ArrayList<String> preferredMethods;


    private String contactInfo; //relevant info - i.e. username / telephone number,...

    public Connection(Contact contact, ConnectionType connectionType, String contactinfo) {
        this.id = count.incrementAndGet();
        this.contact = contact;
        this.connectionType = connectionType;
        this.contactInfo = contactinfo;
        this.preferredMethods = new ArrayList<>();
        setPreferredMethods(true, true, true, true, true, true);
    }

    public void setPreferredMethods(boolean call, boolean message, boolean picture, boolean video, boolean voiceRecording, boolean videoCall) {
        boolean[] b = new boolean[]{call, message, picture, video, voiceRecording, videoCall};
        boolean[] r = new boolean[6];
        ConnectionTypes ct = ConnectionTypes.getInstance();
        for (int i = 0; i < b.length; i++) {
            r[i] = b[i] && ct.getMeansOfConnection(ct.getConnectionTypeByCT(connectionType).getId())[i];
        }
        for (int i = 0; i < r.length; i++) {
            if (r[i]) {
                this.preferredMethods.add(String.valueOf(ConnectionMethods.values()[i]));
            }
        }
    }

    public ArrayList<String> getPreferredMethods() {
        return preferredMethods;
    }

    public ConnectionType getConnectionType() {
        return connectionType;
    }
}
