import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.json.XML;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.crypto.dsig.XMLObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class simpleBank {
    private final String USER_AGENT = "Mozilla/5.0";
    private URL obj;
    private HttpURLConnection con;
    private HttpsURLConnection conn;
    private BufferedReader requestResponse;
    private DataOutputStream wr;
    private JSONObject jsonCrpito;
    private JSONObject currency;
    private JSONObject USDcurrency;
    private JSONObject EURcurrency;
    private JSONObject GBPcurrency;
    private String GBP;
    private String EUR;
    private String USD;

    public void reqestCrpitoCurrency(String url) throws Exception{
        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("Response code " + responseCode);
        requestResponse = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuffer response = new StringBuffer();
        String responseString;
        while((responseString = requestResponse.readLine()) != null){
            response.append(responseString);
        }
        jsonCrpito = new JSONObject(response.toString());
        currency = new JSONObject(jsonCrpito.get("bpi").toString());
        USDcurrency = new JSONObject(currency.get("USD").toString());
        USD = USDcurrency.get("rate").toString();
        EURcurrency = new JSONObject(currency.get("EUR").toString());
        EUR = EURcurrency.get("rate").toString();
        GBPcurrency = new JSONObject(currency.get("GBP").toString());
        GBP = GBPcurrency.get("rate").toString();
        System.out.println(response.toString());
//        USD = new JSONObject(USDcurrency.get("rate").toString());
//        System.out.println(json.getString("bpi"));
//        System.out.println("Response :" + USD.toString());
    }
    public void getCurrencyCurse(String url) throws Exception{
        System.out.println(url);
        obj = new URL(url);
        conn = (HttpsURLConnection) obj.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", USER_AGENT);
        conn.setDoOutput(true);
        requestResponse = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuffer response = new StringBuffer();
        String input;
        while((input = requestResponse.readLine()) != null){
            response.append(input);
        }
        System.out.println(response.toString());
    }
}
