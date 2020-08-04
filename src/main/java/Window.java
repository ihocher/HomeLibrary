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
    JButton buttonReset;
    JTextArea resultLabel;

    Window() {
        this.frame.setSize(500, 300);
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

        this.buttonReset = new JButton("reset");
        this.buttonReset.setSize(this.button.getSize());
        this.buttonReset.setLocation(350,40);
        this.frame.add(this.buttonReset);

        this.resultLabel = new JTextArea();
        this.resultLabel.setSize(170, 80);
        this.resultLabel.setLocation(150, 100);
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
                if ( event.getSource() == Window.this.field || event.getSource() == Window.this.button) {
                        Window.this.reqText = field.getText();
                        Window.this.setVariable(Window.this.reqText);
                        boolean done = false;

                        //Waiting for a request from SQL database
                        while(!done){
                            if(Window.this.result != null){
                                Window.this.resultLabel.setText(Window.this.result);
                                //System.out.println("Result of request: " + Window.this.result);
                                done = true;
                            }else{
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        result = "";
                }
            }
    }
}
