package add;

import java.time.LocalDate;
import java.util.Scanner;

class AddDateToDate extends Add {
    private ScheduleManager scheduleManager;

    public AddDateToDate(ScheduleManager eventManager) {
        this.scheduleManager = eventManager;
    }

    @Override
    void addSchedule() {
        Scanner s = new Scanner(System.in);
        System.out.println("일정을 시작할 날짜를 입력하세요 yyyy-mm-dd");

        String dateStr1 = s.nextLine();
        LocalDate startDate = LocalDate.parse(dateStr1);

        System.out.println("일정을 끝낼 날짜를 입력하세요 yyyy-mm-dd");
        String dateStr2 = s.nextLine();
        LocalDate endDate = LocalDate.parse(dateStr2);

        System.out.println("일정을 입력하세요");

        String description = s.nextLine();
        SplitAdd.splitText(description);

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            Event event = new Event(currentDate, description);
            scheduleManager.addEvent(event);
            currentDate = currentDate.plusDays(1);
        }
        s.close();
    }
}
