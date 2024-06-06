package add;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import user.User;
import view.MainView;

public class AddPeriod extends AddDay {

    // 주어진 시작일과 종료일 사이에 일정을 추가하는 메서드
    public void addSchedule(int start, int end, String newItem) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy\\MM\\dd");

        for (int day = start; day <= end; day++) {
            String dateString = MainView.getCurrentYear() + "\\" + MainView.getCurrentMonth() + "\\" + String.format("%02d", day);
            LocalDate date = LocalDate.parse(dateString, formatter);
            String filePath = User.getUserFolder() + "\\" + date.format(DateTimeFormatter.ofPattern("yyyy\\MM\\dd")) + ".txt";

            File file = new File(filePath);
            file.getParentFile().mkdirs(); 

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(newItem);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}