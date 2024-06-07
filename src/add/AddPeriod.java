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


        for (int day = start; day <= end; day++) {


            String filePath = getUserPath()+day+".txt";

            File file = new File(getUserPath());
            if(!file.exists()){
                file.mkdirs();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write("false;"+newItem+"\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}