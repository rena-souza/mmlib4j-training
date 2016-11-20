package mmlib4j.training;

/**
 * Created by rsouza on 05/11/16.
 */
public class PixelData {

    private int red, green, blue;
    float H,S,I;
    float Y,Cb,Cr;
    private String label;

    public PixelData(int red, int green, int blue, String label) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        initHSI();
        initYCbCr();
        this.label = label;
    }

    private void initYCbCr() {
        Y = 0.299F * (float) getRed() + 0.587F * (float) getGreen() + 0.114F * (float) getBlue();
        Cb = -0.169F * (float) getRed() - 0.331F * (float) getGreen() + 0.5F * (float) getBlue() + 128.0F;
        Cr = 0.5F * (float) getRed() - 0.419F * (float) getGreen() - 0.081F * (float) getBlue() + 128.0F;
    }

    private void initHSI() {
        float red = (float) getRed() / 255.0F;
        float green = (float) getGreen() / 255.0F;
        float blue = (float) getBlue() / 255.0F;
        float var_Min = Math.min(red, green);
        var_Min = Math.min(var_Min, blue);
        float var_Max = Math.max(red, green);
        var_Max = Math.max(var_Max, blue);
        float del_Max = var_Max - var_Min;
        I = (red + green + blue) / 3.0F;
        if(del_Max == 0.0F) {
            H = 0.0F;
            S = 0.0F;
        } else {
            S = 1.0F - var_Min / I;
            H = 0.0F;
            float del_R = ((var_Max - red) / 6.0F + del_Max / 2.0F) / del_Max;
            float del_G = ((var_Max - green) / 6.0F + del_Max / 2.0F) / del_Max;
            float del_B = ((var_Max - blue) / 6.0F + del_Max / 2.0F) / del_Max;
            if(red == var_Max) {
                H = del_B - del_G;
            } else if(green == var_Max) {
                H = 0.33333334F + del_R - del_B;
            } else if(blue == var_Max) {
                H = 0.6666667F + del_G - del_R;
            }

            if(H < 0.0F) {
                ++H;
            }

            if(H > 1.0F) {
                --H;
            }
        }
    }


    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public float getH() {
        return H;
    }

    public float getS() {
        return S;
    }

    public float getI() {
        return I;
    }

    public float getY() {
        return Y;
    }

    public float getCb() {
        return Cb;
    }

    public float getCr() {
        return Cr;
    }

    public String getLabel() {
        return label;
    }
}
