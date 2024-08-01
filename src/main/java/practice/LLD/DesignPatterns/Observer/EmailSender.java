package practice.LLD.DesignPatterns.Observer;

public class EmailSender implements OrderPlacedSubscriber{

    private Flipkart flipkart;

    public EmailSender() {
        flipkart = Flipkart.createInstance();
        flipkart.registerToOrderPlacesEvent(this);
    }

    public ReturnData sendEmail(){
        return new ReturnData("Sending email");
    }

    @Override
    public ReturnData orderPlaced() {
        return sendEmail();
    }
}
