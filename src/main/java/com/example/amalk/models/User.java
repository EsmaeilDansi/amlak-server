package com.example.amalk.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String id;

    private String phoneNumber;

    User() {
    }

    public User(String id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;

    }

    public String getId() {
        return this.id;
    }


    public void setId(String id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        User user = (User) o;
        return Objects.equals(this.id, user.id)
                && Objects.equals(this.phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.phoneNumber);
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phoneNumber=" + phoneNumber +
                '}';
    }


}
