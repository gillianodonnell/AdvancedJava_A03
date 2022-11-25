package tddcolour.a03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class ColourTest {

    @Test
    @DisplayName("Check that red parameter is a float")
    void newColourRedIsFloat(){
        Colour testColour = new Colour(0.81f,0.52f,0.43f);
        assertEquals(0.81f, testColour.getRed());
    }

    @Test
    @DisplayName("Check that green parameter is a float")
    void newColourGreenIsFloat(){
        Colour testColour = new Colour(0.81f,0.52f,0.43f);
        assertEquals(0.52f, testColour.getGreen());
    }

    @Test
    @DisplayName("Check that blue parameter is a float")
    void newColourBlueIsFloat(){
        Colour testColour = new Colour(0.81f,0.52f,0.43f);
        assertEquals(0.43f, testColour.getBlue());
    }

    @Test
    @DisplayName("Red input must be between 0.0 and 1.0")
    void testExpectedExceptionForRedFloatRange(){
       Executable testConstructor = () -> new Colour(5,.4,.1);
       assertThrows(IllegalArgumentException.class, testConstructor, "Invalid red float input");
    }

}
