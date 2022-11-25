package tddcolour.a03;


import java.lang.reflect.Executable;

public class Colour {
    private final float red;
    private final float green;
    private final float blue;

    public Colour(float red, float green, float blue) throws IllegalArgumentException{

        //test if red float input is between 0.0 and 1.0
        if(red < 0.0f || red > 1.0f){
            throw new IllegalArgumentException("Red input must be between 0.0f and 1.0f");
        }else{
            this.red = red;
        }

        //test if green float input is between 0.0 and 1.0
        if(green < 0.0f || green > 1.0f){
            throw new IllegalArgumentException("Green input must be between 0.0f and 1.0f");
        }else{
            this.green = green;
        }

        //test if blue float input is between 0.0 and 1.0
        if(blue < 0.0f || blue > 1.0f){
            throw new IllegalArgumentException("Blue input must be between 0.0f and 1.0f");
        }else{
            this.blue = blue;
        }


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
}
