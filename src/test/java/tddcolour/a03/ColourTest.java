package tddcolour.a03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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
       assertThrows(IllegalArgumentException.class, new Executable() {
           @Override
           public void execute() throws Throwable {
               Colour colour = new Colour(5,0.4f,.5f);
           }
       });

    }

    @Test
    @DisplayName("Green input must be between 0.0 and 1.0")
    void testExpectedExceptionForGreenFloatRange(){
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Colour colour = new Colour(.6f,8,.5f);
            }
        });

    }

    @Test
    @DisplayName("Blue input must be between 0.0 and 1.0")
    void testExpectedExceptionForBlueFloatRange(){
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Colour colour = new Colour(.6f,.8f,9);
            }
        });

    }

    @Test
    @DisplayName("String RGB input should be of length 24")
    void testRGBLength(){
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Colour colour = new Colour("10010101");
            }
        });
    }
    }

}
