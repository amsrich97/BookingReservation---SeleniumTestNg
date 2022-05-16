package DjangoApp;

import com.demoblaze.base.TestUtilities;
import com.demoblaze.pages.SearchResultsPage;
import com.demoblaze.pages.WelcomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class DjangoLoginTest extends TestUtilities {

    @Parameters({"username","password"})
    @Test
    public void hotelReservation() throws InterruptedException {
        System.out.println("JI");
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openPage();
        SearchResultsPage searchResultsPage = welcomePage.reservationDetails();
        searchResultsPage.getPageHeader();

    }


}