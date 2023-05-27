package ConnectionManagement;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class ConnectionType {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private String name;

    private boolean active;
    private boolean[] meansOfConnection;
    private boolean call;
    private boolean message;
    private boolean picture;
    private boolean video;
    private boolean voiceRecording;
    private boolean videoCall;
    private String description;

    protected ConnectionType(String name, boolean call, boolean message, boolean picture, boolean video, boolean voiceRecording, boolean videoCall) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.call = call;
        this.message = message;
        this.picture = picture;
        this.video = video;
        this.voiceRecording = voiceRecording;
        this.videoCall = videoCall;
        meansOfConnection = new boolean[]{call, message, picture, video, voiceRecording, videoCall};
    }

    protected ConnectionType(String name, boolean call, boolean message, boolean picture, boolean video, boolean voiceRecording, boolean videoCall, String description) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.call = call;
        this.message = message;
        this.picture = picture;
        this.video = video;
        this.voiceRecording = voiceRecording;
        this.videoCall = videoCall;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    protected boolean isCall() {
        return call;
    }

    protected boolean isMessage() {
        return message;
    }

    protected boolean isPicture() {
        return picture;
    }

    protected boolean isVideo() {
        return video;
    }

    protected boolean isVoiceRecording() {
        return voiceRecording;
    }

    protected boolean isVideoCall() {
        return videoCall;
    }

    protected String getDescription() {
        return description;
    }

    protected boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    protected boolean[] getMeansOfConnection() {
        return meansOfConnection;
    }

}
