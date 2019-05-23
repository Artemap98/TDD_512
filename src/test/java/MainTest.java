package test.java;

import org.junit.Assert;
import org.junit.Test;


public class MainTest {

    @Test
    void CellClassCreationTest() {
        Cell cell = new Cell();
        Assert.assertNotNull(cell);
    }



};

