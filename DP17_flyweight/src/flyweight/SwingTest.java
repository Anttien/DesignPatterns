package flyweight;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Tests if Swing border objects are flyweight objects. Swing provides a border
 * factory that creates flyweight borders. Therefore the comparing of `border1`
 * and `border2` results true. Each border has shared intrinsic states, and the
 * extrinsic states (in this case only `Dimension`) are passed in during runtime
 *
 * Source:
 * <a href=https://www.javaworld.com/article/2073632/build-ci-sdlc/make-your-apps-fly.html>
 * Javaworld </a>
 */
public class SwingTest extends JFrame {

    public static void main(String[] args) {
        SwingTest test = new SwingTest();
        test.setBounds(20, 20, 250, 150);
        test.setVisible(true);
    }

    public SwingTest() {
        super("Border flyweights");
        JPanel panel = new JPanel(), panel2 = new JPanel();
        Border border = BorderFactory.createRaisedBevelBorder();
        Border border2 = BorderFactory.createRaisedBevelBorder();
        panel.setBorder(border);
        panel.setPreferredSize(new Dimension(100, 100));
        panel2.setBorder(border2);
        panel2.setPreferredSize(new Dimension(50, 50));
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(panel);
        contentPane.add(panel2);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
        if (border == border2) {
            System.out.println("bevel borders are shared");
        } else {
            System.out.println("bevel borders are NOT shared");
        }
    }
}
