import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class window extends JFrame {
    private simpleBank requestCurrency = new simpleBank();
    private JFrame mainFrame;
    private final JLabel titleBitcoin = new JLabel("Actually curse bitcoin");
    private JLabel courseBitcoinUsdEurGbp;
    private final JLabel titleUsdCurse = new JLabel("Actually curse USD to UAH");
    private JLabel usdCurse;
    private final JLabel titleEurCurse = new JLabel("Actually curse EUR to UAH");
    private JLabel eurCurse;
    private final JLabel titleGbpCurse = new JLabel("Actually curse GBP to UAH");
    private JLabel gbpCurse;
    private Button repeatRequest;

    public window() throws Exception{
        mainFrame = new JFrame("Currency checker");
        mainFrame.setBounds(100, 100, 650, 250);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = mainFrame.getContentPane();
        container.setLayout(new GridLayout(5, 2, 2, 2));
        container.add(titleBitcoin);
        courseBitcoinUsdEurGbp = new JLabel(requestCurrency.reqestCrpitoCurrency());
        container.add(courseBitcoinUsdEurGbp);
        usdCurse = new JLabel(requestCurrency.getCurrencyUSD());
        container.add(titleUsdCurse);
        container.add(usdCurse);
        eurCurse = new JLabel(requestCurrency.getCurrencyEUR());
        container.add(titleEurCurse);
        container.add(eurCurse);
        gbpCurse = new JLabel(requestCurrency.getCurrencyGBP());
        container.add(titleGbpCurse);
        container.add(gbpCurse);
        repeatRequest = new Button("Repeat");
        repeatRequest.addActionListener(new ButtonEventListener());
        mainFrame.add(repeatRequest);
        container.setVisible(true);
        mainFrame.setVisible(true);
    }
    class ButtonEventListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                courseBitcoinUsdEurGbp.setText(requestCurrency.reqestCrpitoCurrency());
                usdCurse.setText(requestCurrency.getCurrencyUSD());
                eurCurse.setText(requestCurrency.getCurrencyEUR());
                gbpCurse.setText(requestCurrency.getCurrencyGBP());
            }
            catch(Exception error){
                System.out.println(error);
            }
        }
    }
}
