package mmlib4j.training;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author rsouza on 20/11/16.
 */
public class PixelDataCsvWriter {

    private final String SEPARATOR = ";";

    private File file;
    private List<PixelData> pixelDatas;

    public PixelDataCsvWriter(File file, List<PixelData> pixelDatas) {
        this.file = file;
        this.pixelDatas = pixelDatas;
    }

    public void write() throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        PrintWriter out = new PrintWriter(fos);

        writeHeader(out);

        for (PixelData pixelData : pixelDatas) {
            writeData(out, pixelData);
        }

        out.close();
    }

    private void writeData(PrintWriter out, PixelData pixelData) {
        StringBuffer dataLine = new StringBuffer();
        dataLine.append(pixelData.getRed() + SEPARATOR);
        dataLine.append(pixelData.getGreen() + SEPARATOR);
        dataLine.append(pixelData.getBlue() + SEPARATOR);
        dataLine.append(pixelData.getH() + SEPARATOR);
        dataLine.append(pixelData.getS() + SEPARATOR);
        dataLine.append(pixelData.getI() + SEPARATOR);
        dataLine.append(pixelData.getY() + SEPARATOR);
        dataLine.append(pixelData.getCb() + SEPARATOR);
        dataLine.append(pixelData.getCr() + SEPARATOR);
        dataLine.append(pixelData.getLabel());

        out.println(dataLine);
    }

    private void writeHeader(PrintWriter out) {
        StringBuffer header = new StringBuffer("R" + SEPARATOR + "G" + SEPARATOR + "B" + SEPARATOR);
        header.append("H" + SEPARATOR + "S" + SEPARATOR + "I" + SEPARATOR);
        header.append("Y" + SEPARATOR + "Cb" + SEPARATOR + "Cr" +  SEPARATOR +"label");

        out.println(header);
    }
}
