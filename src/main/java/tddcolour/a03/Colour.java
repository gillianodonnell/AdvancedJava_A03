package tddcolour.a03;


import java.lang.String;

public class Colour {
    private float red;
    private float green;
    private float blue;
    private String combinedRGB;
    private String blueBit;
    private String greenBit;
    private String redBit;
    private float blueBitDecimal;
    private float greenBitDecimal;
    private float redBitDecimal;


    public Colour(float red, float green, float blue) throws IllegalArgumentException {
        //test if red float input is between 0.0 and 1.0
        if (red < 0.0f || red > 1.0f) {
            throw new IllegalArgumentException("Red input must be between 0.0f and 1.0f");
        }

        //test if green float input is between 0.0 and 1.0
        if (green < 0.0f || green > 1.0f) {
            throw new IllegalArgumentException("Green input must be between 0.0f and 1.0f");
        }

        //test if blue float input is between 0.0 and 1.0
        if (blue < 0.0f || blue > 1.0f) {
            throw new IllegalArgumentException("Blue input must be between 0.0f and 1.0f");
        }

        //initialise input parameters
        this.red = red;
        this.green = green;
        this.blue = blue;

    }

    public Colour(String combinedRGB) throws IllegalArgumentException {
        //checks that length of rgb is 24
        if (combinedRGB.length() != 24) {
            throw new IllegalArgumentException("RGB length not 24");
        }
        if (validBit(combinedRGB) != true) {
            throw new IllegalArgumentException("RGB values must be 1 or 0");
        }
        this.combinedRGB = combinedRGB;
        //string slices 24 bit string into first 8 bits, middle 8 bits and last 8 bits
        this.blueBit = combinedRGB.substring(0, 8);
        this.greenBit = combinedRGB.substring(8, 16);
        this.redBit = combinedRGB.substring(16, 24);
        //converts blueBit into float
        this.blueBitDecimal = convertBinaryToFloat(blueBit);
        this.greenBitDecimal = convertBinaryToFloat(greenBit);
        this.redBitDecimal = convertBinaryToFloat(redBit);
    }

    public float getRed() {
        return red;
    }

    public float getGreen() {
        return green;
    }

    public float getBlue() {
        return blue;
    }

    public String getCombinedRGB() {
        return combinedRGB;
    }

    public String getBlueBit() {
        return blueBit;
    }

    public String getGreenBit() {
        return greenBit;
    }

    public String getRedBit() {
        return redBit;
    }

    public float convertBinaryToFloat(String binaryString) {
        float numerator = Integer.parseInt(binaryString, 2);
        float decimal = numerator / 255;
        return decimal;
    }

    public float getBlueBitDecimal() {
        return blueBitDecimal;
    }

    boolean validBit(String bitString) {
        char[] ch = bitString.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            if (ch[i] == '1' || ch[i] == '0') {
                return (true);
            }
        }
        return false;
    }

    public float getGreenBitDecimal() {
        return greenBitDecimal;
    }

    public float getRedBitDecimal() {
        return redBitDecimal;
    }
}