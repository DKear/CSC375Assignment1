import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/*
Class that is to be run in threads. Swaps the seats, calls methods to calculate
happiness to find the best gen in the thread, and adds them to an ArrayList
*/
public class SwapThread implements Runnable{
    int stop;
    Integer threadNumber;
    int currentMaxAffinity = 0;
    Generation currentGen;
    Generation currentBestGen;
    Population classroom;
    JPanel panel;
    ArrayList<Generation> bestGens;

    public void run(){


	//do below until stop value is reached
        for(int i = 0; i < stop; i++){
	    //increment gen
            currentGen.incGenNum();
	    //swap 
            swapSeats(currentGen);
	    //determine if best gen has been made
            if(classroom.calcHappiness(currentGen) > currentMaxAffinity){
                currentMaxAffinity = classroom.calcHappiness(currentGen);
                currentBestGen = new Generation(currentGen.people.length, currentGen.people[0].length);
                for (int a = 0; a < currentBestGen.people.length; a ++){
                    for (int b = 0; b < currentBestGen.people[0].length; b++){
                        currentBestGen.people[a][b] = currentGen.people[a][b];
                        currentBestGen.generationNumber = currentGen.generationNumber;

                    }
                }
                currentBestGen.generationNumber = currentGen.generationNumber;


            }
        }
        bestGens.add(currentBestGen);

    }
    public SwapThread(Generation g, int s, Population c, Integer tn , JPanel p , ArrayList<Generation> gs){
        currentGen = g;
        stop = s;
        classroom = c;
        threadNumber = tn;
        panel = p;
        bestGens = gs;


    }

    public void swapSeats(Generation g){

        Person[][] generation = g.getGeneration();
        int arraySizeY = generation.length;
        int arraySizeX = generation[0].length;
	//swap two random people
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

    }







}
