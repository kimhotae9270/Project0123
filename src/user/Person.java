package user;

abstract class Person {
    private static String userFolder;
    String id;
    public static void setUserFolder(String id){
        userFolder = "C:\\schedule_system\\User\\"+id;
    }
    public static String getUserFolder(){
        return userFolder;
    }
    abstract void setUserId(String id);
    abstract String getUserId();
}
