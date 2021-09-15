import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JPanel panel;
    static JTextField tf;

    public GUI(){

        JFrame UIFrame = new JFrame("GUI");
        UIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UIFrame.setResizable(false);

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

        UIFrame.add(panel);
        UIFrame.setSize(290,500);
        UIFrame.setVisible(true);
    }
}
