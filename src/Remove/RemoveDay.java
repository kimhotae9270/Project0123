package Remove;

import java.io.File;

public class RemoveDay extends RemoveSca{

    public void remove(String date) {

    	String filePath = basePath; //
    	
    	File file = new File(filePath);
        

        //
        if (file.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete the file");
        }      
    }
}
