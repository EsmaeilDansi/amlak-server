package com.example.amalk.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    private String id;

    private String caption;

    private String file_uuid;

    private String owner_id;

    private int create_time;

    private int value;

    private String location;

    private  int measure;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    Message() {

    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", caption='" + caption + '\'' +
                ", file_uuid='" + file_uuid + '\'' +
                ", owner_id='" + owner_id + '\'' +
                ", create_time=" + create_time +
                ", value=" + value +
                ", location='" + location + '\'' +
                ", measure=" + measure +
                ", type='" + type + '\'' +
                '}';
    }

    public Message(String id, String caption, String file_uuid, String owner_id, int create_time, int value, String location, int measure, String type) {
        this.id = id;
        this.caption = caption;
        this.file_uuid = file_uuid;
        this.owner_id = owner_id;
        this.create_time = create_time;
        this.value = value;
        this.location = location;
        this.measure = measure;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getFile_uuid() {
        return file_uuid;
    }

    public void setFile_uuid(String file_uuid) {
        this.file_uuid = file_uuid;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMeasure() {
        return measure;
    }

    public void setMeasure(int measure) {
        this.measure = measure;
    }
}
