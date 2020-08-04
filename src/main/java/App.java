import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.*;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        Window win = new Window();

        //Main code
        MyListener mLis = new MyListener();
        win.addListener(mLis);
        try {
                mLis.start();
                mLis.join();
            } catch (Exception e) {
        }

        long startTime = System.currentTimeMillis();

        GetBase base = new GetBase(mLis.getString());

        try{
                base.start();
                base.join();}
        catch(Exception e){
        }

        ArrayList<BookDetails> arrBd = base.getBd();
        if(arrBd.size()==0){
            win.setResult("There is no such book.");
        }else{
        win.setResult(String.valueOf(arrBd.get(0)));}

        long endTime = System.currentTimeMillis();


        //Checking processes
        System.out.println("Time for getting info from base: " + (endTime - startTime));
        //System.out.println("Checking...");
        //System.out.println(mLis.getString());
    }
}
