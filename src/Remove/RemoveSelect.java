package Remove;

import user.User;
import view.MainView;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RemoveSelect extends Remove{
    @Override
    public void remove(List<Checkbox> cb) {
        String filePath = User.getUserFolder()+"\\"+ MainView.getCurrentYear()+"\\"+MainView.getCurrentMonth()+"\\"+MainView.getCurrentDay()+".txt";
        try(BufferedWriter w = new BufferedWriter(new FileWriter(filePath))) {
            for(Checkbox checkbox : cb){
                System.out.println(checkbox.getState());
                if(!checkbox.getState()){
                    System.out.println(checkbox.getLabel());
                    w.write(checkbox.getState()+";"+checkbox.getLabel()+"\n");
                }
            }

        }catch (IOException err){
            System.out.println("삭제 실패");
        }
    }
}
