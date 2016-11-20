package mmlib4j.training;

import mmlib4j.images.ColorImage;
import mmlib4j.images.GrayScaleImage;
import mmlib4j.utils.ImageBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsouza on 05/11/16.
 */
public class MarkImageComparator {

    ColorImage originalImage;
    GrayScaleImage markImage;
    String label;

    private List<PixelData> pixelsData = new ArrayList<PixelData>();

    public MarkImageComparator(MatchImage matchImage, String label){
        originalImage = ImageBuilder.openRGBImage(matchImage.getOriginalImage());
        markImage = ImageBuilder.openGrayImage(matchImage.getMarkImage());
        this.label = label;
    }

    public void build(){
        int width = markImage.getWidth();
        int height = markImage.getHeight();

        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                int pixel = markImage.getPixel(x, y);

                if(pixel == 0){
                    pixelsData.add(createPixelData(x, y));
                }

            }
        }
    }

    private PixelData createPixelData(int x, int y) {

        int red = originalImage.getRed(x, y);
        int green = originalImage.getGreen(x, y);
        int blue = originalImage.getBlue(x, y);


        return new PixelData(red, green, blue, label);
    }


    public List<PixelData> getPixelsData() {
        return pixelsData;
    }
}
