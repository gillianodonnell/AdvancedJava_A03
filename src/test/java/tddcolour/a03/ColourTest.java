package tddcolour.a03;

import org.junit.jupiter.api.BeforeEach;
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
        //create instance of 3 parameter Colour object
        Colour testColour = new Colour(0.81f,0.52f,0.43f);
        assertEquals(0.81f, testColour.getRed());
    }

    /**
     * Unit test to check that the green input parameter is a float
     */
    @Test
    @DisplayName("Check that green parameter is a float")
    void newColourGreenIsFloat(){
        //create instance of 3 parameter Colour object
        Colour testColour = new Colour(0.81f,0.52f,0.43f);
        assertEquals(0.52f, testColour.getGreen());
    }

    /**
     * Unit test to check that the blue input parameter is a float
     */
    @Test
    @DisplayName("Check that blue parameter is a float")
    void newColourBlueIsFloat(){
        //create instance of 3 parameter Colour object
        Colour testColour = new Colour(0.81f,0.52f,0.43f);
        assertEquals(0.43f, testColour.getBlue());
    }

    /**
     * Unit test to test that an exception is thrown when red float parameter isn't a float
     */
    @Test
    @DisplayName("Red input must be between 0.0 and 1.0. IllegalArgumentException should be thrown")
    void testExpectedExceptionForRedFloatRange(){
        //IllegalArgumentException should be thrown
       assertThrows(IllegalArgumentException.class, () -> {
           //create instance of 3 parameter Colour object
           Colour colour = new Colour(5,0.4f,.5f);
       });

    }

    /**
     * Unit test to test that an exception is thrown when green float parameter isn't a float
     */
    @Test
    @DisplayName("Green input must be between 0.0 and 1.0. IllegalArgumentException should be thrown")
    void testExpectedExceptionForGreenFloatRange(){
        assertThrows(IllegalArgumentException.class, () -> {
            //create instance of 3 parameter Colour object
            Colour colour = new Colour(.6f,8,.5f);
        });

    }

    /**
     * Unit test to test that an exception is thrown when blue float parameter isn't a float
     */
    @Test
    @DisplayName("Blue input must be between 0.0 and 1.0. IllegalArgumentException should be thrown")
    void testExpectedExceptionForBlueFloatRange(){
        //using lambda function
        assertThrows(IllegalArgumentException.class, () -> {
            //create instance of 3 parameter Colour object
            Colour colour = new Colour(.6f,.8f,9);
        });
    }

    /**
     * Unit test to test that the length of the combined rgb is of length 24
     * It should be of length 24 because each red,green and blue bit range is 8
     */
    @Test
    @DisplayName("String RGB input should be of length 24")
    void testRGBLength(){
        //Anonymous new Executable() was replaced with lambda
        assertThrows(IllegalArgumentException.class, () -> {
            //create instance of 1 parameter Colour object with binary string input
            Colour testColour = new Colour("10010101");
        });
    }

    /**
     * Unit test to test that the length of the blue bit range is 8
     * It should be of length 24 because each red,green and blue bit range is 8
     */
    @Test
    @DisplayName("Test blueBit is first 8 bits")
    void testBlueBit(){
        //create instance of 1 parameter Colour object with binary string input
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
        //create instance of 1 parameter Colour object with binary string input
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
        //create instance of 1 parameter Colour object with binary string input
        Colour testColour = new Colour("000000001111111100000000");
        assertEquals(testColour.getRedBit(), "00000000");
    }

    /**
     * Unit test to test that blue bit values are now represented as a float
     */
    @Test
    @DisplayName("Test that blue bit values are now represented as a float")
    void testBlueBitDecimal(){
        //create instance of 1 parameter Colour object with binary string input
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
    @DisplayName("Test that all string bit values in combined rgb are 0 or 1. Should throw IllegalArgumentException")
    void testCombinedRGBBitValues(){
        assertThrows(IllegalArgumentException.class, () -> {
            //create instance of 1 parameter Colour object with binary string input
            Colour testColour = new Colour("222222222222222364738973");
        });
    }

    /**
     * Unit test to test that all characters in binary string in combined rgb are either 0 or 1
     */
    @Test
    @DisplayName("Test that all string bit values in combined rgb are 0 or 1.")
    void testValidCombinedRGBBitValues(){
        //create instance of 1 parameter Colour object with binary string input
        Colour testColour = new Colour("100101111111111100000011");
        assertTrue(testColour.validBit("100101111111111100000011"));
    }

    /**
     * Test if the colours are equal; compare component values
     */
    @Test
    @DisplayName("Test if the colours are equal when inputted similar binary string with equal ranges in different order")
    void testEqualColoursBitsInDifferentOrder(){
        //create first instance of 1 parameter Colour object with binary string input
        //first combined rgb given as a binary string
        Colour firstColour = new Colour("100101111111111100000011");
        //create second instance of 1 parameter Colour object with binary string input
        //first combined rgb given as a binary string with same 8 bit ranges but in different order
        Colour secondColour = new Colour("100101111111111100000011");
        //colours should be equal as they have the same components
        assertEquals(firstColour.getBlueBitDecimal(),secondColour.getBlueBitDecimal());
        assertEquals(firstColour.getGreenBitDecimal(),secondColour.getGreenBitDecimal());
        assertEquals(firstColour.getRedBitDecimal(),secondColour.getRedBitDecimal());

    }

    /**
     * Unit test to test that both constructors make the same colour
     * Test if the colours are equal
     * similar binary string with equal ranges in different order
     */
    @Test
    @DisplayName("Test if the two constructors make the same colour")
    void testEqualColoursEqualDifferentConstructors(){
        //create instance of 3 parameter Colour object with 3 float parameters as input
        Colour firstColour = new Colour(0.007843138f,0.96862745f,0.5921569f);
        //create instance of 1 parameter Colour object with binary string input
        Colour secondColour = new Colour("100101111111011100000010");
        //colours should be equal
        assertEquals(firstColour.getBlue(),secondColour.getBlueBitDecimal());
        assertEquals(firstColour.getGreen(),secondColour.getGreenBitDecimal());
        assertEquals(firstColour.getRed(),secondColour.getRedBitDecimal());
    }

}



