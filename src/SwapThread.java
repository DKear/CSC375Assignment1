import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * Created by Jamie on 9/27/2017.
 */
public class SwapThread implements Runnable{
    int stop;
    Integer threadNumber;
    int currentMaxAffinity = 0;
    Generation currentGen;
    Generation currentBestGen;//= new Generation(currentGen.people.length, currentGen.people[0].length);
    Population classroom;
    Exchanger genExchanger = null;
    JPanel panel;
    ArrayList<Generation> bestGens;

    public void run(){
        //currentBestGen = new Generation(currentGen.people.length, currentGen.people[0].length);
        //currentGen.calcHappiness();
        System.out.println("thread: " + threadNumber);
        System.out.println("class size: " + currentGen.classSize);
        System.out.println("generation: " + currentGen.generationNumber);
        //System.out.println("happiness: " + currentGen.genHappiness);
        //classroom.print();
        currentGen.print();



        for(int i = 0; i < stop; i++){
            //classroom.updateGeneration(currentGen);

            currentGen.incGenNum();
            swapSeats(currentGen);
            //currentGen.calcHappiness();
            if(classroom.calcHappiness(currentGen) > currentMaxAffinity){
                currentMaxAffinity = classroom.calcHappiness(currentGen);
                currentBestGen = new Generation(currentGen.people.length, currentGen.people[0].length);
                for (int a = 0; a < currentBestGen.people.length; a ++){
                    for (int b = 0; b < currentBestGen.people[0].length; b++){
                        currentBestGen.people[a][b] = currentGen.people[a][b];
                        //currentBestGen.calcHappiness();
                        currentBestGen.generationNumber = currentGen.generationNumber;

                    }
                }
                currentBestGen.generationNumber = currentGen.generationNumber;


            }

            //setGeneration(currentGen, classroom);
            //System.out.println("thread: " + threadNumber);
            //System.out.println("class size: " + currentGen.classSize);
            //System.out.println("generation: " + currentGen.generationNumber);


        }
        bestGens.add(currentBestGen);
        System.out.println("thread: " + threadNumber);
        System.out.println("class size: " + currentGen.classSize);
        System.out.println("generation: " + currentGen.generationNumber);
        //System.out.println("happiness: " + currentGen.genHappiness);

        //setGeneration(currentGen/*, classroom*/);
        currentGen.print();
        //paint(panel.getGraphics(), currentGen);
        System.out.println("Best Gen number: " + currentBestGen.generationNumber);
        System.out.println("Best Gen happiness: " + currentMaxAffinity);
        //paint(panel.getGraphics(), currentBestGen);

    }
    public SwapThread(Generation g, int s, Population c, Integer tn , JPanel p , ArrayList<Generation> gs){
        currentGen = g;
        stop = s;
        classroom = c;
        threadNumber = tn;
        panel = p;
        bestGens = gs;


    }

    /*public void paint(Graphics g, Generation gen) {
        int x = 0;
        int y = 0;
        for (int b = 0; b < gen.people.length; b++) {
            for (int a = 0; a < gen.people[0].length; a++) {

                Image img = createSeatImage(new Color(0, classroom.calcIndividualHappiness(gen.people[b][a]), 0));
                g.drawImage(img, x, y, panel);
                x += 10;
            }
            x = 0;
            y+=10;
        }


    }





    private Image createSeatImage(Color c){
        BufferedImage bufferedImage = new BufferedImage(10,10,BufferedImage.TYPE_INT_RGB);
        int rgb = c.getRGB();

        for(int i = 0; i < 10 ; i++){
            for(int j = 0; j < 10; j++){
                bufferedImage.setRGB(i, j , rgb);
            }

        }


        return bufferedImage;
    }*/

    public void swapSeats(Generation g){
        Person[][] generation = g.getGeneration();
        int arraySizeY = generation.length;
        int arraySizeX = generation[0].length;
        Random random = new Random();
        Person[][] temp = new Person[1][1];
        int a = random.nextInt(arraySizeY);
        int b = random.nextInt(arraySizeX);
        int c = random.nextInt(arraySizeY);
        int d = random.nextInt(arraySizeX);

        temp[0][0] = generation[a][b];
        generation[a][b] = generation[c][d];
        generation[c][d] = temp[0][0];
        generation[a][b].setNeighbors(generation);
        generation[c][d].setNeighbors(generation);
        //generation[a][b].calcCurrentHappiness();
        //generation[c][d].calcCurrentHappiness();

    }

    /*public void setGeneration(Generation g, Population p){
        p.updateGeneration(g);
    }*/



    /*public int calcOverallAffinity(Person[][] p){

    }*/


}
