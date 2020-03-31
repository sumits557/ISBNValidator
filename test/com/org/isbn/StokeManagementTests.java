package com.org.isbn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StokeManagementTests {

    @Test
    public void testCanGetACorrectLocatorCode() {

        ExternalISBNDataService testService = new ExternalISBNDataService() {

            @Override
            public Book lookup(String isbn) {
                return new Book(isbn, "Of Mice and Mem", "S.Sharma");
            }
        };

        StockManager stockManager = new StockManager();
        stockManager.setService(testService);

        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396S4", locatorCode);

    }
    @Test
    public void databaseIsUsedIfDataIsPresent() {
        //fail();
    }
    @Test
    public void webserviceIsUsedIfDataIsNotPresentInDatabase() {
        //fail();
    }
}
