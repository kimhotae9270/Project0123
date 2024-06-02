package add;

import java.time.LocalDate;
import java.util.Scanner;
//보류------------------------------------------------------------------
class AddYear extends Add {
    private ScheduleManager scheduleManager;

    public AddYear(ScheduleManager scheduleManager) {
        this.scheduleManager = scheduleManager;
    }

    void addSchedule() {
        Scanner s = new Scanner(System.in);

        try {
            System.out.println("일정을 추가할 해의 시작 날짜를 입력하세요 yyyy");

            String yearStr = s.nextLine();
            int year = Integer.parseInt(yearStr);
            LocalDate startDate = LocalDate.of(year, 1, 1);
            LocalDate endDate = LocalDate.of(year, 12, 31);

            System.out.println("일정을 입력하세요");

            String description = s.nextLine();
            SplitAdd.splitText(description);

            LocalDate date = startDate;
            while (!date.isAfter(endDate)) {
                Event event = new Event(date, description);
                scheduleManager.addEvent(event);
                date = date.plusDays(1);
            }

            System.out.println("일정이 성공적으로 추가되었습니다.");
        } catch (Exception e) {
            System.out.println("잘못된 형식입니다. 다시 입력하세요.");
        }
        s.close();
    }
}