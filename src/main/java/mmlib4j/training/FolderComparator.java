package mmlib4j.training;

import java.io.File;
import java.util.*;

/**
 * Created by rsouza on 05/11/16.
 */
public class FolderComparator {

    private File originalFolder;
    private File markFolder;

    public FolderComparator(File originalFolder, File markFolder) {

        if(originalFolder.isFile() || markFolder.isFile()){
            throw new IllegalArgumentException("The argument it is expected to be a directory");
        }

        this.originalFolder = originalFolder;
        this.markFolder = markFolder;
    }

    public String getOriginalFolderSimpleName(){
        return originalFolder.getName();
    }

    public Collection<MatchImage> getMatchImages(){
        File[] originalFiles = originalFolder.listFiles();
        File[] markFiles = markFolder.listFiles();

        Map<String, File> markMap = new HashMap<String, File>();
        for(File f : markFiles){
            markMap.put(f.getName(), f);
        }

        List<MatchImage> matchImages = new ArrayList<MatchImage>();

        for(File originalFile : originalFiles){
            File markFile = markMap.get(originalFile.getName());

            if(markFile != null){
                matchImages.add(new MatchImage(originalFile, markFile));
            } else {
                System.out.println("No matching image for " + originalFile.getName());
            }
        }

        return matchImages;
    }

}
