package tddcolour.a03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColourTest {

    @Test
    @DisplayName("Check that red parameter is a float")
    void newColourRedisFloat(){
        Colour testColour = new Colour(0.81f,0.52f,0.43f);
        assertEquals(0.81f, testColour.getRed());
    }

}
