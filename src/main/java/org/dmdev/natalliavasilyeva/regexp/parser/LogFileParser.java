package org.dmdev.natalliavasilyeva.regexp.parser;

import org.dmdev.natalliavasilyeva.regexp.dto.Complaint;
import org.dmdev.natalliavasilyeva.regexp.utils.PhoneUtils;
import org.dmdev.natalliavasilyeva.regexp.utils.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class LogFileParser {
    private static final String ID_GROUP = "id";
    private static final String DATE_GROUP = "date";
    private static final String NAME_GROUP = "name";
    private static final String PHONE_GROUP = "phone";
    private static final String COMPLAINT_GROUP = "complaint";
    private static final String LOG_FILE_REGEXP = "^(?<id>\\d+),\\s?(?<date>.*),\\s?(?<name>(?:[a-zA-Z]+\\s[a-zA-Z]+)),\\s?(?<phone>(?:(?:\\+?(375|80)?\\s?)?\\(?(17|29|33|44|25)\\)?\\s?(\\d{3})[-|\\s]?(\\d{2})[-|\\s]?(\\d{2}))),\\s?(?<complaint>\\w.*)$";
    private static final Pattern PATTERN = Pattern.compile(LOG_FILE_REGEXP);
    public static AtomicInteger lineCounter = new AtomicInteger(0);

    public List<Complaint> parse(Path path) throws IOException {
        List<Complaint> complaints = buildLogFileRows(path);
        lineCounter.getAndAdd(complaints.size());
        return complaints;
    }

    private List<Complaint> buildLogFileRows(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.skip(lineCounter.get())
                    .filter(not(StringUtils.EMPTY::equals))
                    .map(this::buildLogFileRow)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        }
    }

    private Optional<Complaint> buildLogFileRow(String line) {
        return Optional.of(line)
                .map(PATTERN::matcher)
                .filter(Matcher::find)
                .map(matcher -> {
                    var id = Integer.parseInt(matcher.group(ID_GROUP));
                    var date = LocalDateTime.parse(matcher.group(DATE_GROUP));
                    var name = matcher.group(NAME_GROUP);
                    var phoneNumber = matcher.group(PHONE_GROUP);
                    var complaintText = matcher.group(COMPLAINT_GROUP);
                    return new Complaint(id, date, name, PhoneUtils.formatPhone(phoneNumber), complaintText);
                });
    }
}