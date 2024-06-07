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




    public void addDay(String schedule) {

        File f = new File(getUserPath());
        if(!f.exists()){
            f.mkdirs();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getUserPath()+ "\\"+MainView.getCurrentDay()+".txt", true))) {
            String[] texts = schedule.split("\n");

            for(int i = 0;i<texts.length;i++){

                writer.write("false;"+texts[i]+"\n");

            }



        }catch(IOException e){
            System.out.println("업로드 실패 "+e);
        }

    }
}