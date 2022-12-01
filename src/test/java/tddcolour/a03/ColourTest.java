package tddcolour.a03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Colour Class
 */
public class ColourTest {
    Colour firstTestColourThreeParameter;
    Colour firstTestColourOneParameter;
    Colour secondTestColourOneParameter;
    Colour secondTestColourThreeParameter;



    @BeforeEach
    void setUp() {
        //create instance of 3 parameter Colour object used for testing input parameters are floats
        firstTestColourThreeParameter = new Colour(0.81f,0.52f,0.43f);
        secondTestColourThreeParameter = new Colour(0.0f,1.0f,0.5921569f);
        //create instance of 1 parameter Colour object with binary string input
        firstTestColourOneParameter = new Colour("100101111111111100000000");
        secondTestColourOneParameter = new Colour("100101111111111100000000");
    }

    /**
     * Unit test to check that each input parameter in 3 parameter constructor for Colour object is a float
     */
    @Test
    @DisplayName("Check that each input parameter is a float")
    void firstTestColourInputsShouldBeFloats(){
        //test that red input value is a float
        assertEquals(0.81f, firstTestColourThreeParameter.getRed());
        //test that green input value is a float
        assertEquals(0.52f, firstTestColourThreeParameter.getGreen());
        //test that blue input value is a float
        assertEquals(0.43f, firstTestColourThreeParameter.getBlue());
    }

    /**
     * Unit test to test that an exception is thrown when red float parameter isn't a float
     */
    @Test
    @DisplayName("Each input must be between 0.0 and 1.0. IllegalArgumentException should be thrown")
    void testExpectedExceptionForInputFloatRange(){
        //IllegalArgumentException should be thrown
       assertThrows(IllegalArgumentException.class, () -> {
           //create instance of 3 parameter Colour object
           new Colour(5,2,8.0f);
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
            new Colour("10010101");
        });
    }

    /**
     * Unit test to test that the length of the each bit range is 8
     * It should be of length 24 because each red, green, and blue bit range is 8
     */
    @Test
    @DisplayName("Test that combined string assigned 8 bits to each blue, green and red value in the correct order")
    void testBlueBit(){
        assertEquals(firstTestColourOneParameter.getBlueBit(), "10010111");
        assertEquals(firstTestColourOneParameter.getGreenBit(), "11111111");
        assertEquals(firstTestColourOneParameter.getRedBit(), "00000000");

    }

    /**
     * Unit test to test that red, green and blue binary strings are now represented as a float
     */
    @Test
    @DisplayName("Test that blue bit values are now represented as a float")
    void testBlueBitDecimal(){
        assertEquals(firstTestColourOneParameter.getBlueBitDecimal(),0.5921569f);
        assertEquals(firstTestColourOneParameter.getGreenBitDecimal(),1.0f);
        assertEquals(firstTestColourOneParameter.getRedBitDecimal(),0.0f);

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
            //should throw illegal argument exception
            new Colour("222222222222222364738973");
        });
    }

    /**
     * Unit test to test that all characters in binary string in combined rgb are either 0 or 1
     */
    @Test
    @DisplayName("Test that all string bit values in combined rgb are 0 or 1.")
    void testValidCombinedRGBBitValues(){
        assertTrue(firstTestColourOneParameter.validBit("100101111111111100000011"));
    }

    /**
     * Test if the colours are equal; compare component values
     */
    @Test
    @DisplayName("Test if the colours are equal when inputted binary string with equal ranges in same order")
    void testEqualColoursBitsUsingSameConstructorByComparingComponentValues(){
        //colours should be equal as they have the same components
        assertEquals(secondTestColourOneParameter.getBlueBitDecimal(), firstTestColourOneParameter.getBlueBitDecimal());
        assertEquals(secondTestColourOneParameter.getGreenBitDecimal(), firstTestColourOneParameter.getGreenBitDecimal());
        assertEquals(secondTestColourOneParameter.getRedBitDecimal(), firstTestColourOneParameter.getRedBitDecimal());

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



