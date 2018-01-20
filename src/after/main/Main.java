package after.main;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import after.AngryBirds;

public class Main {

	// met le jeu dans une fenêtre
    public static void main(String args[]) {
        Frame frame = new Frame("aNgErY bIrDzz - The Shameless RIPoff");
        final AngryBirds obj = new AngryBirds();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        });
        frame.add(obj);
        frame.pack();
        frame.setVisible(true);
    }

}
