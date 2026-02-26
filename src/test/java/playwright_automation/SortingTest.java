package playwright_automation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingTest {

    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(true)
        );
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        page.setDefaultTimeout(60000);
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @AfterAll
    static void closeBrowser() {
        browser.close();
        playwright.close();
    }

    @Test
    public void verifyPriceLowToHighSorting() {
        page.navigate("https://practicesoftwaretesting.com/");
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);

        page.locator("[data-test='sort']").waitFor();
        page.locator("[data-test='product-price']").first().waitFor();

        String firstPriceBefore = page.locator("[data-test='product-price']")
                .first().innerText();

        page.selectOption("[data-test='sort']", "price,asc");

        page.waitForFunction(
                "oldPrice => document.querySelector('[data-test=\"product-price\"]')" +
                        ".innerText !== oldPrice",
                firstPriceBefore
        );

        page.locator("[data-test='product-price']").first().waitFor();
        List<String> priceTexts = page.locator("[data-test='product-price']").allTextContents();

        List<Double> prices = new ArrayList<>();
        for (String price : priceTexts) {
            prices.add(Double.parseDouble(price.replace("$", "").trim()));
        }

        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);

        assertEquals(sortedPrices, prices, "Products are not sorted Low to High correctly!");
    }
}