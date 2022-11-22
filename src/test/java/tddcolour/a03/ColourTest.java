package tddcolour.a03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColourTest {

    @Test
    @DisplayName("Check that red parameter of float type")
    void newColourRedInputisFloat(){
        Colour testColour = new Colour(0.81f,0.52f,0.43f);
        assertTrue(testColour.getRed().getClass() == float.class);
    }


}
