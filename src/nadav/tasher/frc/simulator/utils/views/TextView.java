package nadav.tasher.frc.simulator.utils.views;

import javax.swing.*;
import java.awt.*;

public class TextView extends JLabel {
    public static final float defaultSize = 22f;

    public TextView() {
        init();
    }

    public TextView(String text) {
        init();
        setText(text);
    }

    private void init() {
        setFont(Font.getFont(Font.SANS_SERIF, getFont()).deriveFont(defaultSize));
        setOpaque(false);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void setText(String text) {
        super.setText("<html>" + "<div style='text-align: center;'>" + text + "</div>" + "</html>");
    }

    public void setTextSize(float size) {
        setFont(getFont().deriveFont(size));
    }

    public void setTextColor(Color color) {
        setForeground(color);
    }
}
