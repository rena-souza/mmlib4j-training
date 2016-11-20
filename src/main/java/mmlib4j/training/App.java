package mmlib4j.training;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        String originalParam = System.getProperty(TrainingConstants.ORIGINAL_FOLDER);
        String markParam = System.getProperty(TrainingConstants.MARK_FOLDER);
        String outParam = System.getProperty(TrainingConstants.OUTPUT_FILE);
        String label = System.getProperty(TrainingConstants.LABEL);

        assertNotEmpty(originalParam, "You need to specify the folder with the original images");
        assertNotEmpty(markParam, "You need to specify the folder with the mark images");
        assertNotEmpty(outParam, "You need to specify the output file");




        File original = new File(originalParam);
        File mark = new File(markParam);

        FolderComparator folderComparator = new FolderComparator(original, mark);

        for(MatchImage matchImage : folderComparator.getMatchImages()){

            System.out.println(matchImage.getOriginalImage() + " - " + matchImage.getMarkImage());

            String pixelLabel = label != null && !label.trim().equals("") ? label : folderComparator.getOriginalFolderSimpleName();

            MarkImageComparator markImageComparator = new MarkImageComparator(matchImage, pixelLabel);
            markImageComparator.build();

            File fileOut = new File(outParam);
            new PixelDataCsvWriter(fileOut, markImageComparator.getPixelsData()).write();

        }

    }

    private static void assertNotEmpty(String param, String message) {
        if(param == null || "".equals(param.trim())){
            System.out.println(message);
            System.exit(1);
        }
    }
}
