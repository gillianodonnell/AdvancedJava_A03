package tddcolour.a03;


import java.lang.String;

/**
Colour class representing RGB colours.
The Colour class implements the following functionality
 • A constructor for a Colour object with three parameters which specify the colour components, in
 the order red, green and blue, using a floating point values in the range 0.0 to 1.0
• A constructor for a Colour object that specifies one parameter which is a combined RGB value
consisting of the red component in bits 16-23, the green component in bits 8-15, and the blue
component in bits 0-7
• It is not allowed to create a Colour object without specifying valid component values
• Colours can be compared, to be equal they must have the same component values
 */

public class Colour {
    private float red; //red float parameter for 3 parameter constructor
    private float green; //green float parameter for 3 parameter constructor
    private float blue; //blue float parameter for 3 parameter constructor
    private String blueBit; //blue 8 bit binary string accessed from combined RGB string in 1 parameter constructor with a getter
    private String greenBit; //green 8 bit binary string accessed from combined RGB string in 1 parameter constructor with a getter
    private String redBit; //red 8 bit binary string accessed from combined RGB string in 1 parameter constructor with a getter
    private float blueBitDecimal; //blue 8 bit binary string represented as a float
    private float greenBitDecimal; //green 8 bit binary string represented as a float
    private float redBitDecimal; //red 8 bit binary string represented as a float


    /**
     * A constructor for a Colour object with three parameters which specify the colour components
     * @param red red colour floating point value in the range 0.0 to 1.0
     * @param green green colour floating point value in the range 0.0 to 1.0
     * @param blue blue floating point value in the range 0.0 to 1.0
     * @throws IllegalArgumentException exception thrown to indicate an illegal or unsuitable argument passed to a method
     */
    public Colour(float red, float green, float blue) throws IllegalArgumentException {
        //test if red float input is between 0.0 and 1.0. If it's not in this range throw IllegalArgumentException
        if (red < 0.0f || red > 1.0f) {
            throw new IllegalArgumentException("Red input must be between 0.0f and 1.0f");
        }

        //test if green float input is between 0.0 and 1.0. If it's not in this range throw IllegalArgumentException
        if (green < 0.0f || green > 1.0f) {
            throw new IllegalArgumentException("Green input must be between 0.0f and 1.0f");
        }

        //test if blue float input is between 0.0 and 1.0. If it's not in this range throw IllegalArgumentException
        if (blue < 0.0f || blue > 1.0f) {
            throw new IllegalArgumentException("Blue input must be between 0.0f and 1.0f");
        }

        //initialise input parameters
        this.red = red;
        this.green = green;
        this.blue = blue;

    }

    /**
     * A constructor for a Colour object that specifies one parameter which is a combined RGB value
     * consisting of the red component in bits 16-23, the green component in bits 8-15, and the blue
     * component in bits 0-7
     * @param combinedRGB one String parameter which is a combined RGB value
     * consisting of the red component in bits 16-23, the green component in bits 8-15, and the blue
     * component in bits 0-7
     * @throws IllegalArgumentException exception thrown to indicate an illegal or unsuitable argument passed to a method
     */
    public Colour(String combinedRGB) throws IllegalArgumentException {
        //throws exception if combined RGB length is not 24
        if (combinedRGB.length() != 24) {
            throw new IllegalArgumentException("RGB length not 24");
        }
        //throws exception if combined RGB bit values aren't 1s or 0s by calling function validBit
        if (!validBit(combinedRGB)) {
            throw new IllegalArgumentException("RGB values must be 1 or 0");
        }
        //string slices 24 bit string into first 8 bits, middle 8 bits and last 8 bits
        this.blueBit = combinedRGB.substring(0, 8);
        this.greenBit = combinedRGB.substring(8, 16);
        this.redBit = combinedRGB.substring(16, 24);
        //converts blueBit into float
        this.blueBitDecimal = convertBinaryToFloat(blueBit);
        this.greenBitDecimal = convertBinaryToFloat(greenBit);
        this.redBitDecimal = convertBinaryToFloat(redBit);
    }

    /**
     * Getter for 3 parameter Colour constructor
     * @return red colour floating point value in the range 0.0 to 1.0
     */
    public float getRed() {
        return red;
    }

    /**
     * Getter for 3 parameter Colour constructor
     * @return green colour floating point value in the range 0.0 to 1.0
     */
    public float getGreen() {
        return green;
    }

    /**
     * Getter for 3 parameter Colour constructor
     * @return blue colour floating point value in the range 0.0 to 1.0
     */
    public float getBlue() {
        return blue;
    }

    /**
     * Getter for 1 parameter Colour constructor
     * @return string blue component in bits 0-7
     */
    public String getBlueBit() {
        return blueBit;
    }

    /**
     * Getter for 1 parameter Colour constructor
     * @return string blue component in bits 8-15
     */
    public String getGreenBit() {
        return greenBit;
    }

    /**
     * Getter for 1 parameter Colour constructor
     * @return string blue component in bits 16-24
     */
    public String getRedBit() {
        return redBit;
    }

    /**
     * Method converting binary string to float
     * @param binaryString string of bits
     * @return float
     */
    public float convertBinaryToFloat(String binaryString) {
        float numerator = Integer.parseInt(binaryString, 2);
        return numerator / 255;
    }

    /**
     * Getter for 1 parameter Colour constructor
     * @return float red component bits 0-7
     */
    public float getBlueBitDecimal() {
        return blueBitDecimal;
    }

    /**
     * Method to check that bit values in string are only 1s or 0s
     * @param bitString string of bits
     * @return boolean
     */
    boolean validBit(String bitString) {
        //converts bitString to char array
        char[] binary = bitString.toCharArray();
        //iterates through array and checks values
        for (char bitValue : binary) {
            if (bitValue == '1' || bitValue == '0') {
                return (true);
            }
        }
        return false;
    }

    /**
     * Getter for 1 parameter Colour constructor
     * @return float green component bits 8-15
     */
    public float getGreenBitDecimal() {
        return greenBitDecimal;
    }

    /**
     * Getter for 1 parameter Colour constructor
     * @return float red component bits 16-24
     */
    public float getRedBitDecimal() {
        return redBitDecimal;
    }

}