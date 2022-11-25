package tddcolour.a03;


import java.lang.reflect.Executable;

public class Colour {
    private float red;
    private float green;
    private float blue;
    private String combinedRGB;
    private String blueBit;


    public Colour(float red, float green, float blue) throws IllegalArgumentException{
        //test if red float input is between 0.0 and 1.0
        if(red < 0.0f || red > 1.0f){
            throw new IllegalArgumentException("Red input must be between 0.0f and 1.0f");
        }

        //test if green float input is between 0.0 and 1.0
        if(green < 0.0f || green > 1.0f){
            throw new IllegalArgumentException("Green input must be between 0.0f and 1.0f");
        }

        //test if blue float input is between 0.0 and 1.0
        if(blue < 0.0f || blue > 1.0f){
            throw new IllegalArgumentException("Blue input must be between 0.0f and 1.0f");
        }

        //initialise input parameters
        this.red = red;
        this.green = green;
        this.blue = blue;

    }

    public Colour(String combinedRGB) throws IllegalArgumentException{
        if(combinedRGB.length() != 24){
            throw new IllegalArgumentException("RGB length not 24");
        }
        this.combinedRGB = combinedRGB;
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
}
