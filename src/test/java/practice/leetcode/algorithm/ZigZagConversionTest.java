package practice.leetcode.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class ZigZagConversionTest {
    @Test
    public void testConvert() {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        String input = "PAYPALISHIRING";

        String result = zigZagConversion.convert(input, 3);
        assertEquals("PAHNAPLSIIGYIR", result);
        assertEquals("PINALSIGYAHRPI", zigZagConversion.convert(input, 4));
    }

    @Test
    public void testBoundaryConvert() {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        String input = "PAYPALISHIRING";

        assertEquals("PAYPALISHIRIGN", zigZagConversion.convert(input, input.length() - 1));
    }

    @Test
    public void testBoundary4Convert() {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        String input = "PAYPALISHIRING";

        assertEquals(input, zigZagConversion.convert(input, 1));
        assertEquals(input, zigZagConversion.convert(input, input.length()));
    }
}