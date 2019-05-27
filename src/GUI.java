import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JPanel panel;
    static JTextField tf;


    public GUI(){

        JFrame calc = new JFrame("GUI");
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setResizable(false);

        //the Panel
        panel = new JPanel();
        panel.setSize(290,500);
        panel.setLayout(null);

        //the text field
        tf = new JTextField();
        tf.setSize(300,50);
        tf.setLocation(5,40);
        tf.setEditable(false);

        panel.add(tf);

        calc.add(panel);
        calc.setSize(290,500);
        calc.setVisible(true);
    }
}
