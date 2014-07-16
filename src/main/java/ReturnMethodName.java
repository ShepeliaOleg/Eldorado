/**
 * Created by New on 11.07.2014.
 */
public class ReturnMethodName {

    public String returnMethodName (){
        Exception exception = new Exception();

        return exception.getStackTrace()[1].getMethodName().toString();
    }
}
