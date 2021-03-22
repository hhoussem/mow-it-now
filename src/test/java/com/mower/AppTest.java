package com.mower;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {
    @Test
    public void read_Test() {
        String actual = App.read("5 5\n" +
                "1 2 N\n" +
                "GAGAGAGAA\n" +
                "3 3 E\n" +
                "AADAADADDA");

        Assert.assertEquals("1 3 N\n" + ""
                        + "5 1 E",
                actual);
    }
}
