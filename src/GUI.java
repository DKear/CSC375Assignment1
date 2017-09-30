import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GUI implements ActionListener {

    Container controllingContainer;


    public void addComponentToPane(Container pane) {
        //Graphics g = new Graphic;
        pane.setPreferredSize(new Dimension (1800, 900));
        Generation generation = new Generation(10,10);
        Population classroom = new Population(generation);
        generation.setSize();
        BufferedImage image = new BufferedImage(20,20,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.drawString("test", 200, 200);
        pane.paint(g);

        for(int i = 0; i < generation.getGeneration().length; i++){
            for (int j = 0; j < generation.getGeneration()[0].length; j++){
                pane.print(g);
            }
        }
        /*Generation generation = new Generation(10,10);
        Population classroom = new Population(generation);
        generation.setSize();

        controllingContainer = pane;
        pane.setPreferredSize(new Dimension (1800, 900));
        JFrame frame = new JFrame();
        GridBagConstraints bgc = new GridBagConstraints();*/


    }

    public void actionPerformed(ActionEvent e) {

    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("CSC375Assignment1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        GUI gui = new GUI();
        gui.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        /*int threadCount= 2;

        ArrayList<Thread> threads = new ArrayList<>();
        for(int i = 0; i < threadCount; i++){
            ArrayList<Generation> generations = new ArrayList<>();
            generations.add(new Generation(10,10));
            generations.get(i).setSize();
        }*/


        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
