package nadav.tasher.frc.simulator.utils;

import javax.swing.*;
import java.awt.*;

public class Utils {
    public static void tellUser(String text) {
        JFrame popup = new JFrame("Notice");
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.CENTER);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        popup.setContentPane(label);
        popup.setPreferredSize(new Dimension(200, 50));
        popup.setMinimumSize(popup.getPreferredSize());
        popup.setMaximumSize(popup.getPreferredSize());
        popup.setLocation((x() - popup.getWidth()) / 2, (y() - popup.getHeight()) / 2);
        popup.setAlwaysOnTop(true);
        popup.setUndecorated(true);
        popup.pack();
        popup.setVisible(true);
        // Start Timer
        Thread timer = new Thread(() -> {
            final int seconds = 10;
            for (int second = seconds; second >= 0; second--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
            popup.setVisible(false);
        });
        timer.start();
    }

    public static int x() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        return screen.width;
    }

    public static int y() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        return screen.height;
    }
}
