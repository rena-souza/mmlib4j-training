package mmlib4j.training;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File original = new File("/home/rsouza/teste/TesteImages/original");
        File mark = new File("/home/rsouza/teste/TesteImages/marcacao");

        FolderComparator folderComparator = new FolderComparator(original, mark);

        for(MatchImage matchImage : folderComparator.getMatchImages()){

            System.out.println(matchImage.getOriginalImage() + " - " + matchImage.getMarkImage());

            MarkImageComparator markImageComparator = new MarkImageComparator(matchImage);
            markImageComparator.build();
            for (PixelData pixelMarkData : markImageComparator.getPixelsData()) {

                System.out.printf("\t%d-%d-%d\n", pixelMarkData.getRed(), pixelMarkData.getGreen(), pixelMarkData.getBlue());

            }


        }

    }
}
