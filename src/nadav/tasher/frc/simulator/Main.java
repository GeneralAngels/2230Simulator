package nadav.tasher.frc.simulator;

import nadav.tasher.frc.simulator.utils.Utils;
import nadav.tasher.frc.simulator.utils.views.MainScreen;

import javax.swing.*;

public class Main {
    /*
    Written By Nadav Tasher Of General Angels
    Last Modified: Sep-2018
     */
    static final String programName = "2230 Simulator";
    static final double programVersion = 0.1;
    private static JFrame mainFrame;

    public static void main(String[] args) {
        loadTheme();
        loadGUI();
    }

    private static void loadTheme() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
            Utils.tellUser("Failed To Set Desired Theme.");
        }
    }

    private static void loadGUI() {
        mainFrame = new JFrame(programName + " " + programVersion);
        mainFrame.setUndecorated(true);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setContentPane(new MainScreen());
        mainFrame.setVisible(true);
    }
}
