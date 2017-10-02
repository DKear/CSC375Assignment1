import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JPanel {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
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
        int thousands = 0;

        while (happiest < generation.classSize * 255  & thousands < 1000) {
            for (int i = 0; i < threadCount; i++) {
                threads.add(new Thread(new SwapThread(generations.get(i), 1000, classroom, i, panel, bestGens)));
            }

            for (int i = 0; i < threads.size(); i++) {
                threads.get(i).start();


            }


            for (int i = 0; i < threads.size(); i++) {
                try {
                    threads.get(i).join();
                } catch (Exception e) {

                }
            }

            for (int i = 0; i < bestGens.size(); i++) {
                if (classroom.calcHappiness(bestGens.get(i)) > happiest) {
		    happiest = classroom.calcHappiness(bestGens.get(i));
                    bestGen = new Generation(bestGens.get(i).people.length, bestGens.get(i).people[0].length);
                    for (int a = 0; a < bestGens.get(i).people.length; a++) {
                        for (int b = 0; b < bestGens.get(i).people[0].length; b++) {
                            bestGen.people[a][b] = bestGens.get(i).people[a][b];
                            bestGen.generationNumber = bestGens.get(i).generationNumber;


                        }
                    }
                    panel.update(panel.getGraphics());
                    classroom.paint(panel.getGraphics(), bestGen);
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
                        newGen.generationNumber = bestGen.generationNumber;

                    }
                }
                generations.add(newGen);

            }

            thousands++;

        }

	JDialog endBox = new JDialog();
	endBox.add(new JTextField ("Done!"));
	endBox.setSize(50,50);
	endBox.setVisible(true);
    }
}
