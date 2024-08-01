package practice.LLD.DesignPatterns.Observer;

public class AnalyticsSender implements OrderPlacedSubscriber{

    private Flipkart flipkart;

    public AnalyticsSender(){
        flipkart = Flipkart.createInstance();
        flipkart.registerToOrderPlacesEvent(this);
    }

    public ReturnData generateAnalytics(){
        return new ReturnData("Analytics generated");
    }

    @Override
    public ReturnData orderPlaced() {
       return generateAnalytics();
    }
}
