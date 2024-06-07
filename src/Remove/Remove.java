package Remove;

import user.User;
import view.MainView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Remove {
    private String filePath;
    public Remove(){
        this.filePath = User.getUserFolder()+"\\"+ MainView.getCurrentYear()+"\\"+MainView.getCurrentMonth()+"\\";

    }
    String getFilePath(){
        return filePath;
    }
    abstract void remove(List<Checkbox> cb);

}
