package com.example.amalk.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "files")
public class FileInfo {

    @Id
    private String file_uuid;
    private String messageId;

    public FileInfo(String file_uuid, String messageId) {
        this.file_uuid = file_uuid;
        this.messageId = messageId;
    }
    public FileInfo(){

    }

    public String getFile_uuid() {
        return file_uuid;
    }

    public void setFile_uuid(String file_uuid) {
        this.file_uuid = file_uuid;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}