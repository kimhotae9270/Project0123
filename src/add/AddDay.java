package add;

import user.User;
import view.MainView;
import view.PopUpView;
import view.ShareScheduleView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddDay extends Add {
    private String filePath;

    public AddDay() {
        this.filePath = getFilePath();
    }

    private String getFilePath() {
        // 현재 로그인한 사용자와 날짜 정보를 기반으로 파일 경로를 생성

        String fileName = "\\" + view.MainView.getCurrentYear() + "\\" + view.MainView.getCurrentMonth();
        return User.getUserFolder() + fileName;
    }

    public void addDay(String schedule) {

        File f = new File(getFilePath());
        if(!f.exists()){
            f.mkdirs();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath+ "\\"+MainView.getCurrentDay()+".txt", true))) {
            String[] texts = schedule.split("\n");

            for(int i = 0;i<texts.length;i++){
                System.out.println(texts[i]);
                writer.write("false;"+texts[i]);

            }



        }catch(IOException e){
            System.out.println("업로드 실패 "+e);
        }

    }
}