package practice.exception.src;

public class Test {
    public String getData(String data) throws Exception {
        if (data!=null){
            return "data is present";
        }
        throw new Exception("Exception");
    }
}
