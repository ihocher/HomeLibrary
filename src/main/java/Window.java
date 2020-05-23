import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends ListenToMe {
    String reqText ;
    String result;
    JFrame frame = new JFrame("Bookshelf");
    JTextField field;
    JLabel label;
    JButton button;
    JLabel resultLabel;

    Window() {
        this.frame.setSize(500, 200);
        this.frame.setLocation(300, 200);
        this.frame.setLayout((LayoutManager)null);
        this.frame.setDefaultCloseOperation(3);

        this.label = new JLabel("Enter a book name");
        this.label.setLocation(10, 15);
        this.label.setSize(this.label.getPreferredSize());
        this.frame.add(this.label);

        this.field = new JTextField();
        this.field.setColumns(15);
        this.field.setSize(this.field.getPreferredSize());
        this.field.setLocation(150, 15);
        this.field.setToolTipText("Enter a book name");
        this.frame.add(this.field);

        this.button = new JButton("search");
        this.button.setSize(this.button.getPreferredSize());
        this.button.setLocation(350, 10);
        this.frame.add(this.button);

        //Change format of whole window and set more space for resultLabel. Need to have opportunity to put 3 lines.
        this.resultLabel = new JLabel();
        this.resultLabel.setSize(200, 200);
        this.resultLabel.setLocation(150, 20);
        this.frame.add(this.resultLabel);

        Window.theHandler handler = new Window.theHandler();
        this.field.addActionListener(handler);
        this.button.addActionListener(handler);
        this.frame.setVisible(true);
    }

    public void setResult(String result) {
        this.result = result;
    }

    private class theHandler implements ActionListener {
        private theHandler() {
        }

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == Window.this.button || event.getSource() == Window.this.field) {
                Window.this.reqText = field.getText();
                Window.this.setVariable(Window.this.reqText);
                try {
                    //Need to change waiting instrument
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Window.this.resultLabel.setText(Window.this.result);
            }


        }
    }
}
