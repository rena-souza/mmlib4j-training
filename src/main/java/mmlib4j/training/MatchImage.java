package mmlib4j.training;

import java.io.File;

/**
 * Created by rsouza on 05/11/16.
 */
public class MatchImage {

    private File originalImage;
    private File markImage;

    public MatchImage(File originalImage, File markImage) {
        this.originalImage = originalImage;
        this.markImage = markImage;
    }

    public File getMarkImage() {
        return markImage;
    }

    public File getOriginalImage() {
        return originalImage;
    }
}
