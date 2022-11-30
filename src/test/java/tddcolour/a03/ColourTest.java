package tddcolour.a03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Colour Class
 */
public class ColourTest {

    /**
     * Unit test to check that the red input parameter is a float
     */
    @Test
    @DisplayName("Check that red parameter is a float")
    void newColourRedIsFloat(){
        Colour testColour = new Colour(0.81f,0.52f,0.43f);
        assertEquals(0.81f, testColour.getRed());
    }

    /**
     * Unit test to check that the green input parameter is a float
     */
    @Test
    @DisplayName("Check that green parameter is a float")
    void newColourGreenIsFloat(){
        Colour testColour = new Colour(0.81f,0.52f,0.43f);
        assertEquals(0.52f, testColour.getGreen());
    }

    /**
     * Unit test to check that the blue input parameter is a float
     */
    @Test
    @DisplayName("Check that blue parameter is a float")
    void newColourBlueIsFloat(){
        Colour testColour = new Colour(0.81f,0.52f,0.43f);
        assertEquals(0.43f, testColour.getBlue());
    }

    /**
     * Unit test to test that an exception is thrown when red float parameter isn't a float
     */
    @Test
    @DisplayName("Red input must be between 0.0 and 1.0")
    void testExpectedExceptionForRedFloatRange(){
       assertThrows(IllegalArgumentException.class, () -> {
           Colour colour = new Colour(5,0.4f,.5f);
       });

    }

    /**
     * Unit test to test that an exception is thrown when green float parameter isn't a float
     */
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

    /**
     * Unit test to test that an exception is thrown when blue float parameter isn't a float
     */
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

    /**
     * Unit test to test that the length of the combined rgb is of length 24
     * It should be of length 24 because each red,green and blue bit range is 8
     */
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

    /**
     * Unit test to test that the length of the blue bit range is 8
     * It should be of length 24 because each red,green and blue bit range is 8
     */
    @Test
    @DisplayName("Test blueBit is first 8 bits")
    void testBlueBit(){
        Colour testColour = new Colour("000000001111111100000000");
        assertEquals(testColour.getBlueBit(), "00000000");
    }

    /**
     * Unit test to test that the length of the green bit range is 8
     * It should be of length 24 because each red,green and blue bit range is 8
     */
    @Test
    @DisplayName("Test greenBit is middle 8 bits")
    void testGreenBit(){
        Colour testColour = new Colour("000000001111111100000000");
        assertEquals(testColour.getGreenBit(), "11111111");
    }

    /**
     * Unit test to test that the length of the red bit range is 8
     * It should be of length 24 because each red,green and blue bit range is 8
     */
    @Test
    @DisplayName("Test redBit is last 8 bits")
    void testRedBit(){
        Colour testColour = new Colour("000000001111111100000000");
        assertEquals(testColour.getRedBit(), "00000000");
    }

    /**
     * Unit test to test that blue bit values are now represented as a float
     */
    @Test
    @DisplayName("Test that blue is now a decimal")
    void testBlueBitDecimal(){
        Colour testColour = new Colour("100101111111111100000000");
        assertEquals(testColour.getBlueBitDecimal(),0.5921569f);
    }

    /**
     * Unit test to test that green bit values are now represented as a float
     */
    @Test
    @DisplayName("Test that green bit values are now represented as a float")
    void testGreenBitDecimal(){
        //create instance of 1 parameter Colour object with binary string input
        Colour testColour = new Colour("100101111111111100000000");
        assertEquals(testColour.getGreenBitDecimal(),1.0f);
    }

    /**
     * Unit test to test that red bit values are now represented as a float
     */
    @Test
    @DisplayName("Test that red bit values are now represented as a float")
    void testRedBitDecimal(){
        //create instance of 1 parameter Colour object with binary string input
        Colour testColour = new Colour("100101111111111100000000");
        assertEquals(testColour.getRedBitDecimal(),0.0f);
    }

    /**
     * Unit test to test that all characters in binary string in combined rgb are either 0 or 1
     * Should throw IllegalArgumentException
     */
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

    /**
     * Test if the colours are equal; compare component values
     */
    @Test
    @DisplayName("Test if the colours are equal when inputted same bit string")
    void testEqualColours(){
        Colour firstColour = new Colour("100101111111111100000011");
        Colour secondColour = new Colour("100101111111111100000011");
        float firstBlueColour = firstColour.getBlueBitDecimal();
        float firstGreenColour = firstColour.getGreenBitDecimal();
        float firstRedColour = firstColour.getRedBitDecimal();
        float firstColourFloat = firstBlueColour * firstGreenColour * firstRedColour;
        float secondBlueColour = secondColour.getBlueBitDecimal();
        float secondGreenColour = secondColour.getGreenBitDecimal();
        float secondRedColour = secondColour.getRedBitDecimal();
        float secondColourFloat = secondRedColour * secondBlueColour * secondGreenColour;
        assertEquals(firstColourFloat,secondColourFloat);

    }

    /**
     * Unit test to test that both constructors make the same colour
     * Test if the colours are equal
     * similar binary string with equal ranges in different order
     */
    @Test
    @DisplayName("Test if the two constructors make the same colour using makeColour method")
    void testEqualColoursEqualDifferentConstructors(){
        Colour firstColour = new Colour(.3921568627f,.156827451f,.0f);
        Colour secondColour = new Colour("100101111111111100000000");
        float createFirstColour = firstColour.makeColour(firstColour.getBlue(),firstColour.getGreen(),firstColour.getRed());
        float createSecondColour = secondColour.makeColour(secondColour.getBlueBitDecimal(),secondColour.getGreenBitDecimal(),secondColour.getRedBitDecimal());
        assertEquals(createSecondColour,createFirstColour);
    }

}



