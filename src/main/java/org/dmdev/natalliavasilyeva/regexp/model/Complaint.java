package org.dmdev.natalliavasilyeva.regexp.model;

import org.dmdev.natalliavasilyeva.regexp.utils.DateFormatter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Complaint implements Entity {
    private final int id;
    private final LocalDateTime date;
    private final String name;
    private final String phoneNumber;
    private final String complaintText;

    public Complaint(int id, LocalDateTime date, String name, String phoneNumber, String complaintText) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.complaintText = complaintText;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getComplaintText() {
        return complaintText;
    }

    @Override
    public List<String> values(){
        return List.of(String.valueOf(getId()), DateFormatter.formatDate(getDate()), getName(), getPhoneNumber(), getComplaintText());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complaint complaint = (Complaint) o;
        return getId() == complaint.id && Objects.equals(getDate(), complaint.date) && Objects.equals(getName(), complaint.name) && Objects.equals(getPhoneNumber(), complaint.phoneNumber) && Objects.equals(getComplaintText(), complaint.complaintText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, name, phoneNumber, complaintText);
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + getId() +
                ", date=" + getDate() +
                ", name='" + getName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", complaintText='" + getComplaintText() + '\'' +
                '}';
    }
}