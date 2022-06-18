package org.dmdev.natalliavasilyeva.regexp.dto;

import org.dmdev.natalliavasilyeva.regexp.utils.DateFormatter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Call implements Entity {

    private final int id;
    private final LocalDateTime date;
    private final String phoneNumber;

    public Call(int id, LocalDateTime date, String phoneNumber) {
        this.id = id;
        this.date = date;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public List<String> values(){
        return List.of(String.valueOf(getId()), DateFormatter.formatDate(getDate()), getPhoneNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Call call = (Call) o;
        return getId() == call.id && Objects.equals(getDate(), call.date) && Objects.equals(getPhoneNumber(), call.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, phoneNumber);
    }

    @Override
    public String toString() {
        return "Call{" +
                "id=" + getId() +
                ", date=" + getDate() +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                '}';
    }
}