import java.util.ArrayList;

public final class ConnectionType {
    private static int id;

    private String name;

    private enum meansofConnection {CALL, MESSAGE, PICTURE, VIDEO, VOICE_RECORDING, VIDEO_CALL}

    private boolean[] meansOfConnection;
    private boolean call;
    private boolean message;
    private boolean picture;
    private boolean video;
    private boolean voiceRecording;
    private boolean videoCall;
    private String description;
    private static ArrayList<ConnectionType> connectionTypes;

    public static void main(String[] args) {
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
    }

    public ConnectionType(String name, boolean call, boolean message, boolean picture, boolean video, boolean voiceRecording, boolean videoCall) {
        this.id++;
        this.name = name;
        this.call = call;
        this.message = message;
        this.picture = picture;
        this.video = video;
        this.voiceRecording = voiceRecording;
        this.videoCall = videoCall;
        connectionTypes.add(this);
        meansOfConnection = new boolean[]{call, message, picture, video, voiceRecording, videoCall};
    }

    public ConnectionType(String name, boolean call, boolean message, boolean picture, boolean video, boolean voiceRecording, boolean videoCall, String description) {
        this.id++;
        this.name = name;
        this.call = call;
        this.message = message;
        this.picture = picture;
        this.video = video;
        this.voiceRecording = voiceRecording;
        this.videoCall = videoCall;
        this.description = description;
    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCall() {
        return call;
    }

    public boolean isMessage() {
        return message;
    }

    public boolean isPicture() {
        return picture;
    }

    public boolean isVideo() {
        return video;
    }

    public boolean isVoiceRecording() {
        return voiceRecording;
    }

    public boolean isVideoCall() {
        return videoCall;
    }

    public String getDescription() {
        return description;
    }

    public boolean[] getMeansOfConnection() {
        return meansOfConnection;
    }

    public static boolean contains(String name) {
        for (ConnectionType c : connectionTypes) {
            if (c.name == name) {
                return true;
            }
        }
        return false;
    }

    public static void listAll(boolean onlyNames) {
        if (onlyNames) {
            for (ConnectionType c : connectionTypes) {
                System.out.println(c.getName());
            }
        } else {
            for (ConnectionType c : connectionTypes) {
                System.out.println(c.name + " description= " + c.description + "{ call= " + c.call + ", message= " + c.message + ", picture= " + c.picture + ", video= " + c.video + ", voiceRecording= " + c.voiceRecording + ", videoCall= " + c.videoCall + '}');

            }
        }

    }
}
