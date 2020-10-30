package dynamic_beat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Example extends JFrame {
    

    private JLabel jl;
    private JPanel jp;
    private JButton jb;

    public Example() {
        setTitle("Example");
        setSize(300,300);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        jp = new JPanel();

        jb = new JButton("Press me");
        jl = new JLabel("Hello");
        jp.add(jb);
        jp.add(jl);
        add(jp);
        setVisible(true);
    
    
    }
}
