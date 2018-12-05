package test;

import main.model.Gomma;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


public class GommaTest {

    @Test
    public void gommaInstantiation () {
        Gomma gomma = new Gomma("example", "example", 1.0);
        assertNotNull(gomma);
        assertEquals("example", gomma.getModel());
        assertEquals("example", gomma.getManufacturer());
        assertEquals(1.0, gomma.getPrice());
    }
}
