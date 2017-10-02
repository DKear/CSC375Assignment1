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
        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setVisible(true);

        int threadCount = 32;
        ArrayList<Generation> generations = new ArrayList<>();
        ArrayList<Generation> bestGens = new ArrayList<>();

        int x = 32;
        int y = 32;

        Generation bestGen = new Generation(y, x);
        int happiest = 0;


        for (int i = 0; i < threadCount; i++) {
            generations.add(new Generation(y, x));
            generations.get(i).setSize();
        }
        Generation generation = new Generation(y, x);

        Population classroom = new Population( y , x);
        generation.setSize();
        ArrayList<Thread> threads = new ArrayList<>();
        int tenthousands = 0;
        //System.out.println("initialized");

        while (happiest < generation.classSize * 255  & tenthousands < 1000) {
            for (int i = 0; i < threadCount; i++) {
                threads.add(new Thread(new SwapThread(generations.get(i), 10000, classroom, i, panel, bestGens)));
            }

            for (int i = 0; i < threads.size(); i++) {
                threads.get(i).start();

            /*try{
                threads.get(1).sleep(2000);

            } catch(InterruptedException e){

            }*/

            }


            for (int i = 0; i < threads.size(); i++) {
                try {
                    threads.get(i).join();
                } catch (Exception e) {

                }
            }
            for (int i = 0; i < threads.size(); i++) {
                try {
                    threads.get(i).wait();
                } catch (Exception e) {

                }
            }

            for (int i = 0; i < bestGens.size(); i++) {
                if (classroom.calcHappiness(bestGens.get(i)) > happiest) {
                    //bestGens.get(i).genHappiness
                    happiest = classroom.calcHappiness(bestGens.get(i));// bestGens.get(i).genHappiness;
                    bestGen = new Generation(bestGens.get(i).people.length, bestGens.get(i).people[0].length);
                    for (int a = 0; a < bestGens.get(i).people.length; a++) {
                        for (int b = 0; b < bestGens.get(i).people[0].length; b++) {
                            bestGen.people[a][b] = bestGens.get(i).people[a][b];
                            //bestGen.genHappiness = happiest;
                            bestGen.generationNumber = bestGens.get(i).generationNumber;


                        }
                    }
                    panel.update(panel.getGraphics());
                    classroom.paint(panel.getGraphics(), bestGen);
                    //classroom.updateGeneration(bestGens.get(i));
                }
            }



            generations.clear();
            threads.clear();
            bestGens.clear();
            for (int i = 0; i < threadCount; i++) {
                Generation newGen = new Generation(bestGen.people.length, bestGen.people[0].length);
                for (int a = 0; a < bestGen.people.length; a++) {
                    for (int b = 0; b < bestGen.people[0].length; b++) {
                        newGen.people[a][b] = bestGen.people[a][b];
                        //newGen.genHappiness = happiest;
                        newGen.generationNumber = bestGen.generationNumber;

                    }
                }
                generations.add(newGen);

            }

            tenthousands++;

        }
    }
}
