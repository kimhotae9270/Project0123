package add;

import java.time.LocalDate;
import java.util.Scanner;

class AddWeek extends Add {
    private ScheduleManager scheduleManager;

    public AddWeek(ScheduleManager scheduleManager) {
        this.scheduleManager = scheduleManager;
    }

    void addSchedule() {
        Scanner s = new Scanner(System.in);

        try {
            System.out.println("일정을 추가할 주의 시작 날짜를 입력하세요 yyyy-mm-dd");

            String dateStr = s.nextLine();
            LocalDate startDate = LocalDate.parse(dateStr);

            System.out.println("일정을 입력하세요");

            String description = s.nextLine();
            SplitAdd.splitText(description);

            for (int i = 0; i < 7; i++) {
                LocalDate date = startDate.plusDays(i);
                Event event = new Event(date, description);
                scheduleManager.addEvent(event);
            }

            System.out.println("일정이 성공적으로 추가되었습니다.");
        } catch (Exception e) {
            System.out.println("잘못된 형식입니다. 다시 입력하세요.");
        }
        s.close();
    }
}