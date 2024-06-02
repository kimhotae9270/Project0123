package Remove;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;

public class RemoveWeek extends RemoveSca {

    @Override
    public void remove(String weekStartDate) {
        // weekStartDate: '년.월.일'
        LocalDate date = LocalDate.parse(weekStartDate, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        LocalDate startOfWeek = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate endOfWeek = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        for (LocalDate d = startOfWeek; !d.isAfter(endOfWeek); d = d.plusDays(1)) {
            String formattedDate = d.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            String filePath = basePath + formattedDate;

            deleteFile(filePath);
        }

        System.out.println("All events for the week starting from " + weekStartDate + " have been deleted.");
    }
}
