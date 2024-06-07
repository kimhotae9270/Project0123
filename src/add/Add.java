package add;

import user.User;
import view.MainView;

public abstract class Add {
    private String userPath;

    public abstract void addDay(String newItem);

    public Add() {
        this.userPath = User.getUserFolder() + "\\" + MainView.getCurrentYear() + "\\" + MainView.getCurrentMonth() + "\\";

    }

    public String getUserPath() {
        return userPath;
    }
}