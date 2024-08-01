package practice.LLD.DesignPatterns.Observer;

public class Client {
    public static void main(String[] args) {
        Flipkart flipkart = Flipkart.createInstance();
        Flipkart flipkart1 = Flipkart.createInstance();

        AnalyticsSender analyticsSender = new AnalyticsSender();
        EmailSender emailSender = new EmailSender();
        flipkart.orderPlaced();
    }
}
