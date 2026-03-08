import java.text.NumberFormat;

public class FormatingNumbers {
    static void main() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result1 = currency.format(0123456.789);
        System.out.println(result1);

        NumberFormat percentage = NumberFormat.getPercentInstance();
        String result2 = percentage.format(0.1);
        System.out.println(result2);
    }
}
