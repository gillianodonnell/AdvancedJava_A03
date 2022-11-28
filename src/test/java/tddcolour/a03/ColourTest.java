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
       assertThrows(IllegalArgumentException.class, () -> {
           Colour colour = new Colour(5,0.4f,.5f);
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
                Colour newColour = new Colour("10010101");
            }
        });
    }

    @Test
    @DisplayName("Test blueBit is first 8 bits")
    void testBlueBit(){
        Colour testColour = new Colour("000000001111111100000000");
        assertEquals(testColour.getBlueBit(), "00000000");
    }

    @Test
    @DisplayName("Test greenBit is middle 8 bits")
    void testGreenBit(){
        Colour testColour = new Colour("000000001111111100000000");
        assertEquals(testColour.getGreenBit(), "11111111");
    }

    @Test
    @DisplayName("Test redBit is last 8 bits")
    void testRedBit(){
        Colour testColour = new Colour("000000001111111100000000");
        assertEquals(testColour.getRedBit(), "00000000");
    }

    @Test
    @DisplayName("Test that blue is now a decimal")
    void testBlueBitDecimal(){
        Colour testColour = new Colour("100101111111111100000000");
        assertEquals(testColour.getBlueBitDecimal(),0.5921569f);
    }

    @Test
    @DisplayName("Test that all characters in combined rgb are 0 or 1")
    void testCombinedRGBBitValues(){
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Colour newColour = new Colour("222222222222222364738973");
            }
        });
    }

    @Test
    @DisplayName("Test that green is now a decimal")
    void testGreenBitDecimal(){
        Colour testColour = new Colour("100101111111111100000000");
        assertEquals(testColour.getGreenBitDecimal(),0.5921569f);
    }


}



