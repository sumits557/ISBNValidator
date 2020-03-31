package com.org.isbn;

public class ValidateISBN {

    public boolean checkISBN(String isbn) {

        if (isbn.length() != 10) {
            throw new NumberFormatException(("ISBN number must be a 10 digit"));
        }

        int total = 0;
        for(int i = 0; i < 10; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                if (i == 9 && isbn.charAt(i) == 'X') {
                    total += 10;
                } else {
                throw new NumberFormatException("ISBN numbers can only contain numberic digits");
                }
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
            }
        }
        if (total % 11 == 0) {
            return  true;
        } else {
            return  false;
        }
    }
}
