import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args)  throws Exception {
        simpleBank s = new simpleBank();
//        s.reqestCrpitoCurrency("https://api.coindesk.com/v1/bpi/currentprice.json");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());
//        String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?" + "valcode=EUR" + "&date=" + date + "&json";
        String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&date=20190618&json";
        s.getCurrencyCurse(url);
    }
}
