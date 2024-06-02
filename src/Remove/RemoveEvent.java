package Remove;

import java.io.File;

public class RemoveEvent extends RemoveSca {

    public void remove(String identifier) {
        
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
