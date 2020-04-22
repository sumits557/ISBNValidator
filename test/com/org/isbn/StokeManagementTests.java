package com.org.isbn;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

public class StokeManagementTests {

    ExternalISBNDataService testWebService;
    StockManager stockManager;
    ExternalISBNDataService testDatabaseService;

    @Before
    public void setup() {
        testWebService = mock(ExternalISBNDataService.class);
        stockManager = new StockManager();
        stockManager.setWebService(testWebService);
        testDatabaseService = mock(ExternalISBNDataService.class);
        stockManager.setDatabaseService(testDatabaseService);

    }

    @Test
    public void testCanGetACorrectLocatorCode() {

        when(testWebService.lookup(anyString())).thenReturn(new Book("", "Of Mice And Men", "S.Sharma"));
        when(testDatabaseService.lookup(anyString())).thenReturn(null);

        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396S4", locatorCode);

    }
    @Test
    public void databaseIsUsedIfDataIsPresent() {

        when(testDatabaseService.lookup("0140177396")).thenReturn(new Book("0140177396", "abc", "abc"));

        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        verify(testDatabaseService, times(1)).lookup("0140177396");
        verify(testWebService, times(0)).lookup(anyString());
    }
    @Test
    public void webserviceIsUsedIfDataIsNotPresentInDatabase() {


        when(testDatabaseService.lookup("0140177396")).thenReturn(null);
        when(testWebService.lookup("0140177396")).thenReturn(new Book("0140177396", "abc", "abc"));


        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);

        verify(testDatabaseService, times(1)).lookup("0140177396");
        verify(testWebService, times(1)).lookup(anyString());
    }
}
