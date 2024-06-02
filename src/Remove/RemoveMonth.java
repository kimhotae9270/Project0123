package Remove;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RemoveMonth extends RemoveSca {

    @Override
    public void remove(String monthStartDate) {
        // monthStartDate: '년.월.01'
        LocalDate date = LocalDate.parse(monthStartDate, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        LocalDate startOfMonth = date.withDayOfMonth(1);
        LocalDate endOfMonth = date.withDayOfMonth(date.lengthOfMonth());

        for (LocalDate d = startOfMonth; !d.isAfter(endOfMonth); d = d.plusDays(1)) {
            String formattedDate = d.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            String filePath = basePath + formattedDate;

            deleteFile(filePath);
        }

        System.out.println("All events for the month of " + monthStartDate + " have been deleted.");
    }
}
