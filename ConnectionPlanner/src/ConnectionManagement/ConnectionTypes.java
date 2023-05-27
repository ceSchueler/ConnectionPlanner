package ConnectionManagement;

import java.util.ArrayList;

public class ConnectionTypes {

    private static final ConnectionTypes OBJ = new ConnectionTypes();
    private ArrayList<ConnectionType> connectionTypes;

    private ConnectionTypes() {
        this.connectionTypes = new ArrayList<>();
        ConnectionType disco = new ConnectionType("Discord", true, true, true, true, false, true); //1 false
        ConnectionType email = new ConnectionType("Email", false, true, true, false, false, false); //4 false
        ConnectionType faceb = new ConnectionType("Facebook", true, true, true, true, true, true); //All true
        ConnectionType insta = new ConnectionType("Instagram", true, true, true, true, true, true); //All true
        ConnectionType linke = new ConnectionType("LinkedIn", true, true, true, false, false, true); //2 false
        ConnectionType skype = new ConnectionType("Skype", true, true, true, true, true, true); //All true
        ConnectionType slack = new ConnectionType("Slack", true, true, true, true, true, true); //All true
        ConnectionType snapc = new ConnectionType("Snapchat", true, true, true, true, true, true); //All true
        ConnectionType telep = new ConnectionType("Telephone", true, true, true, false, true, false); //2 false
        ConnectionType twitt = new ConnectionType("Twitter", false, true, true, false, false, false); //4 false
        ConnectionType whats = new ConnectionType("Whatsapp", true, true, true, true, true, true); //All true
        connectionTypes.add(disco);
        connectionTypes.add(email);
        connectionTypes.add(faceb);
        connectionTypes.add(insta);
        connectionTypes.add(linke);
        connectionTypes.add(skype);
        connectionTypes.add(slack);
        connectionTypes.add(snapc);
        connectionTypes.add(telep);
        connectionTypes.add(twitt);
        connectionTypes.add(whats);
    }

    public static ConnectionTypes getInstance() {
        return OBJ;
    }

    public ConnectionType getConnectionTypeByCT(ConnectionType ct) {
        for (ConnectionType c : connectionTypes) {
            if (c == ct) {
                return c;
            }
        }
        return null;
    }

    public ConnectionType getConnectionTypeByName(String name) {
        for (ConnectionType c : connectionTypes) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public void listAllConnectionTypes(boolean onlyNames) {
        if (onlyNames) {
            for (ConnectionType c : connectionTypes) {
                System.out.println(c.getName());
            }
        } else {
            for (ConnectionType c : connectionTypes) {
                System.out.println(c.getName() + " description= " + c.getDescription() + "{ call= " + c.isCall() + ", message= " + c.isMessage() + ", picture= " + c.isPicture() + ", video= " + c.isVideo() + ", voiceRecording= " + c.isVoiceRecording() + ", videoCall= " + c.isVideoCall() + '}');
            }
        }
    }

    public boolean[] getMeansOfConnection(int id) {
        for (ConnectionType c : connectionTypes) {
            if (c.getId() == id) {
                return c.getMeansOfConnection();
            }
        }
        return null;
    }


    public boolean isCall(int id) {
        for (ConnectionType c : connectionTypes) {
            if (c.getId() == id) {
                return c.isCall();
            }
        }
        return Boolean.parseBoolean(null);
    }

    public boolean isMessage(int id) {
        for (ConnectionType c : connectionTypes) {
            if (c.getId() == id) {
                return c.isMessage();
            }
        }
        return Boolean.parseBoolean(null);
    }

    public boolean isPicture(int id) {
        for (ConnectionType c : connectionTypes) {
            if (c.getId() == id) {
                return c.isPicture();
            }
        }
        return Boolean.parseBoolean(null);
    }

    public boolean isVideo(int id) {
        for (ConnectionType c : connectionTypes) {
            if (c.getId() == id) {
                return c.isVideo();
            }
        }
        return Boolean.parseBoolean(null);
    }

    public boolean isVoiceRecording(int id) {
        for (ConnectionType c : connectionTypes) {
            if (c.getId() == id) {
                return c.isVoiceRecording();
            }
        }
        return Boolean.parseBoolean(null);
    }

    public boolean isVideoCall(int id) {
        for (ConnectionType c : connectionTypes) {
            if (c.getId() == id) {
                return c.isVideoCall();
            }
        }
        return Boolean.parseBoolean(null);
    }

    public String getDescription(int id) {
        for (ConnectionType c : connectionTypes) {
            if (c.getId() == id) {
                return c.getDescription();
            }
        }
        return null;
    }

    public boolean isActive(int id) {
        for (ConnectionType c : connectionTypes) {
            if (c.getId() == id) {
                return c.isActive();
            }
        }
        return Boolean.parseBoolean(null);
    }
}
