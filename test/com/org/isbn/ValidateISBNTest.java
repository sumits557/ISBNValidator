package com.org.isbn;

import com.org.isbn.ValidateISBN;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateISBNTest {

    @Test
    public void checkAValidISBNTest(){
        ValidateISBN  validateISBN = new ValidateISBN();
        boolean result = validateISBN.checkISBN("0140449116");
        assertTrue("first value", result);
        result  = validateISBN.checkISBN("0140177396");
        assertTrue("second value", result);
    }

    @Test
    public void checkAInValidISBNTest(){
        ValidateISBN  validateISBN = new ValidateISBN();
        boolean result = validateISBN.checkISBN("0114044917");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNNotAllowed() {
        ValidateISBN  validateISBN = new ValidateISBN();
        validateISBN.checkISBN("011404491");
    }

    @Test(expected = NumberFormatException.class)
    public void nonNumericISBNAreNotAllowed() {
        ValidateISBN  validateISBN = new ValidateISBN();
        validateISBN.checkISBN("helloWorld");
    }

    @Test
    public void ISBNNumbersEndingWithXAreValid() {
        ValidateISBN validateISBN = new ValidateISBN();
        boolean result = validateISBN.checkISBN("012000030X");
        assertTrue(result);
    }
}
