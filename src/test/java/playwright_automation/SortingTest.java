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

    static final String URL = "https://practicesoftwaretesting.com/";

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(true)

                        .setArgs(Arrays.asList(
                                "--no-sandbox",
                                "--disable-setuid-sandbox",
                                "--disable-dev-shm-usage",
                                "--disable-gpu"
                        ))
        );
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext(
                new Browser.NewContextOptions()

                        .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                                "AppleWebKit/537.36 (KHTML, like Gecko) " +
                                "Chrome/120.0.0.0 Safari/537.36")
        );
        page = context.newPage();

        page.setDefaultTimeout(90000);
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

        boolean loaded = false;
        for (int attempt = 1; attempt <= 3; attempt++) {
            try {
                page.navigate(URL, new Page.NavigateOptions()
                        .setTimeout(60000));
                page.waitForLoadState(LoadState.DOMCONTENTLOADED);
                loaded = true;
                break;
            } catch (Exception e) {
                System.out.println("Navigate attempt " + attempt + " failed: " + e.getMessage());
                if (attempt == 3) throw e;
            }
        }

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