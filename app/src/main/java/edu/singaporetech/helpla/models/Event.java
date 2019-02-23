package edu.singaporetech.helpla.models;

import java.util.Date;

public class Event {
    private Date date;
     String desc;
     String eventName;
     String organizer;
     String[] participant;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String[] getParticipant() {
        return participant;
    }

    public void setParticipant(String[] participant) {
        this.participant = participant;
    }
}
