package Remove;

import user.User;
import view.AddDay2DayScheduleView;
import view.MainView;
import view.PopUpView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RemoveDay2Day {
    public void removeDay2Day(int start, int end){
        String filePath = User.getUserFolder()+"\\"+ MainView.getCurrentYear()+"\\"+MainView.getCurrentMonth();

        for(int day = start;day<=end;day++){
            File f = new File(filePath+"\\"+day+".txt");
            f.delete();
        }
        PopUpView p = new AddDay2DayScheduleView();
        p.popUp("삭제가 완료되었습니다!");
    }
}
