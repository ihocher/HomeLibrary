import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends ListenToMe {
    private String reqText ;
    private String result;
    private JFrame frame = new JFrame("Bookshelf");
    private JTextField field;
    private JLabel label;
    private JButton button;
    private JButton buttonReset;
    private JTextArea resultLabel;

    Window() {
        frame.setSize(500, 300);
        frame.setLocation(300, 200);
        frame.setLayout((LayoutManager)null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Enter a book name");
        label.setLocation(10, 15);
        label.setSize(label.getPreferredSize());
        frame.add(label);

        field = new JTextField();
        field.setColumns(15);
        field.setSize(field.getPreferredSize());
        field.setLocation(150, 15);
        field.setToolTipText("Enter a book name");
        frame.add(field);

        button = new JButton("search");
        button.setSize(button.getPreferredSize());
        button.setLocation(350, 10);
        frame.add(button);

        buttonReset = new JButton("reset");
        buttonReset.setSize(button.getSize());
        buttonReset.setLocation(350,40);
        frame.add(buttonReset);

        resultLabel = new JTextArea();
        resultLabel.setSize(170, 80);
        resultLabel.setLocation(150, 100);
        frame.add(resultLabel);

        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Window.this.reqText = field.getText();
                Window.this.setVariable(Window.this.reqText);
                boolean done = false;

                //Waiting for a request from SQL database
                while(!done){
                   if(Window.this.result != null){
                        Window.this.resultLabel.setText(Window.this.result);
                        done = true;
                    }else{
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException exception) {
                            exception.printStackTrace();
                        }
                    }
                }

                result = null;
            }
        });

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Window.this.reqText = field.getText();
                Window.this.setVariable(Window.this.reqText);
                boolean done = false;

                //Waiting for a request from SQL database
                while(!done){
                    if(Window.this.result != null){
                        Window.this.resultLabel.setText(Window.this.result);
                        done = true;
                    }else{
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException exception) {
                            exception.printStackTrace();
                        }
                    }
                }
                result = null;
            }
        });
        frame.setVisible(true);
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
