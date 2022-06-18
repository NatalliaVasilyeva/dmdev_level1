package org.dmdev.natalliavasilyeva.regexp.mappers;

import org.dmdev.natalliavasilyeva.regexp.dto.Call;
import org.dmdev.natalliavasilyeva.regexp.dto.Complaint;

public final class CallMapper {
    private CallMapper() {
    }

    public static Call fromComplaint(Complaint complaint) {
        return new Call(complaint.getId(), complaint.getDate(), complaint.getPhoneNumber());
    }
}