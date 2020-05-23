import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ListenToMe {
    private String variable = "";
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void setVariable(String newValue) {
        String oldValue = variable;
        variable = newValue;
        support.firePropertyChange("variable", oldValue, newValue);
    }
}
