import javax.print.DocFlavor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MyListener extends Thread implements PropertyChangeListener  {
    private String event;
    private volatile boolean changeDone = false;

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        this.event = (String) event.getNewValue();
        this.changeDone = true;

    }

    public String getString(){
        this.changeDone = false;
        return this.event;

    }

    public void run(){
        while(!changeDone){

        }

    }



}
