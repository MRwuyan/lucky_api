package http;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/*
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
*/

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class ChromeMain {
    public static void main2(String[] args) throws IOException, InterruptedException, URISyntaxException {
     /*   long time = System.currentTimeMillis();
        // 可省略，若驱动放在其他目录需指定驱动路径
        System.setProperty("webdriver.chrome.driver", "D:\\chromedrvier\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://coinmarketcap.com/currencies/massgrid/");
        // 休眠1s,为了让js执行完
        //Thread.sleep(100l);
        // 网页源码
        String source = driver.getPageSource();

        System.out.println(source);
        driver.close();
        System.out.println("耗时:"+(System.currentTimeMillis()-time));

        WebElement element=driver.findElementByClassName("text-semi-bold details-panel-item--price__value");
        System.out.println(element.getText());*/

    }


    public static String TO_BTC_PARICE_KEY = "TO_BTC_PARICE_KEY";

    public static String TO_USDT_PARICE_KEY = "TO_USDT_PARICE_KEY";

    private static Map<String, String> jjj(String url) throws URISyntaxException, IOException {
        Map<String, String> map = new HashMap<>();

        Document doc = Jsoup.connect(url).get();

        Elements toBtcPrice = doc.getElementsByAttribute("data-format-price-crypto");

        Elements toUsdtPrice = doc.getElementsByClass("details-panel-item--price__value");

        map.put(TO_BTC_PARICE_KEY, toBtcPrice.text());
        map.put(TO_USDT_PARICE_KEY, toUsdtPrice.text());

        return map;
    }


    public static void main(String[] args) throws IOException, URISyntaxException {
/*

        List<RatePrice> ratePriceList=new ArrayList<>();

        Map<String,String> massgrid = jjj("https://coinmarketcap.com/currencies/massgrid/");

        RatePrice mgd_usdt=new RatePrice(new BigDecimal(massgrid.get(TO_USDT_PARICE_KEY)),"MGD/USDT");
        RatePrice mgd_btc=new RatePrice(new BigDecimal(massgrid.get(TO_BTC_PARICE_KEY)),"MGD/BTC");


        ratePriceList.add(mgd_usdt);
        ratePriceList.add(mgd_btc);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        massgrid = jjj("https://coinmarketcap.com/currencies/bitcoin/");
        RatePrice btc_usdt=new RatePrice(new BigDecimal(massgrid.get(TO_USDT_PARICE_KEY)),"BTC/USDT" );
        System.out.println(massgrid);


        ratePriceList.add(btc_usdt);



        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        massgrid = jjj("https://coinmarketcap.com/currencies/ethereum/");
        RatePrice eth_usdt=new RatePrice(new BigDecimal(massgrid.get(TO_USDT_PARICE_KEY)),"ETH/USDT" );
        RatePrice eth_BTC=new RatePrice(new BigDecimal(massgrid.get(TO_BTC_PARICE_KEY)),"ETH/BTC" );


        ratePriceList.add(eth_usdt);
        ratePriceList.add(eth_BTC);

        System.out.println(massgrid);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        massgrid = jjj("https://coinmarketcap.com/currencies/litecoin/");
        RatePrice ltc_usdt=new RatePrice(new BigDecimal(massgrid.get(TO_USDT_PARICE_KEY)),"LTC/USDT" );
        RatePrice ltc_BTC=new RatePrice(new BigDecimal(massgrid.get(TO_BTC_PARICE_KEY)),"LTC/BTC" );


        ratePriceList.add(ltc_usdt);
        ratePriceList.add(ltc_BTC);

        BigDecimal ltc_usdt_price=ltc_usdt.getBasePrice();
        BigDecimal eth_usdt_price=eth_usdt.getBasePrice();
        BigDecimal mgd_usdt_price=mgd_usdt.getBasePrice();

        BigDecimal ltc_eth_price=ltc_usdt_price.divide(eth_usdt_price, 6, BigDecimal.ROUND_HALF_UP);
        RatePrice ltc_eth=new RatePrice(ltc_eth_price,"LTC/ETH");

        BigDecimal mgd_eth_price=mgd_usdt_price.divide(eth_usdt_price, 6, BigDecimal.ROUND_HALF_UP) ;
        RatePrice MGD_eth=new RatePrice(mgd_eth_price,"MGD/ETH");

        ratePriceList.add(ltc_eth);
        ratePriceList.add(MGD_eth);
        //ltc 对  eth
        //MGD 对 ETH


        for(RatePrice  ratePrice:ratePriceList  ){

            System.out.println(ratePrice);

        }
*/



    }



    //MGD
    //https://coinmarketcap.com/currencies/massgrid/

    //BTC
    //https://coinmarketcap.com/currencies/bitcoin/

    //ETH
    //https://coinmarketcap.com/currencies/ethereum/

    //LTC
    //https://coinmarketcap.com/currencies/litecoin/


}
