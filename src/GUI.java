import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GUI extends JPanel {
    Color color;

    public GUI(Color c){
        color = c;
    }








    /*public void addComponentToPane(Container pane) {
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
        Generation generation = new Generation(10,10);
        Population classroom = new Population(generation);
        generation.setSize();

        controllingContainer = pane;
        pane.setPreferredSize(new Dimension (1800, 900));
        JFrame frame = new JFrame();
        GridBagConstraints bgc = new GridBagConstraints();


    }*/

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        //frame.getContentPane().add(new GUI(new Color(0,255,0)));
        JPanel panel = new JPanel();
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setVisible(true);

        int threadCount= 2;
        ArrayList<Generation> generations = new ArrayList<>();

        for(int i = 0; i < threadCount; i++){
            generations.add(new Generation(5,5));
            generations.get(i).setSize();
        }
        Generation generation = new Generation(10,10);
        Population classroom = new Population(generation);
        generation.setSize();
        ArrayList<Thread> threads = new ArrayList<>();

        for(int i = 0; i<threadCount; i++) {
            threads.add(new Thread(new SwapThread(generations.get(i), 1000, classroom, i, panel)));
        }

        for(int i = 0; i < threads.size(); i++) {
            threads.get(i).start();

            try{
                threads.get(1).sleep(2000);

            } catch(InterruptedException e){

            }

        }

        for(int i = 0; i < threads.size(); i++) {
            try{
                threads.get(i).join();
            } catch(Exception e){

            }
        }


    }
}
