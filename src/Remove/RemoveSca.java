package Remove;

import java.io.File;

public abstract class RemoveSca {
    protected static String basePath = "filepath/folderpath-";
    
    public abstract void remove(String identifier);

    protected boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.delete();
    }
}
