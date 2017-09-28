import java.util.Random;

/**
 * Created by Jamie on 9/27/2017.
 */
public class SwapThread implements Runnable{
    int stop = 10;
    int currentMaxAffinity;
    Generation currentGen;
    Generation currentBestGen;
    Population classroom;
    public void run(){

        for(int i = 0; i < stop; i++){
            System.out.println("thread 1");
            System.out.println("class size: " + currentGen.classSize);
            System.out.println("generation: " + currentGen.generationNumber);
            classroom.print();
        }

    }
    public SwapThread(Generation g, int s, Population c){
        currentGen = g;
        stop = s;
        classroom = c;
    }

    public void swapSeats(Generation g){
        Person[][] generation = g.getGeneration();
        int arraySize = generation.length*generation[0].length;
        Random random = new Random();
        Person[][] temp = new Person[1][1];
        int a = random.nextInt(arraySize-1);
        int b = random.nextInt(arraySize-1);
        int c = random.nextInt(arraySize-1);
        int d = random.nextInt(arraySize-1);

        temp[0][0] = generation[a][b];
        generation[a][b] = generation[c][d];
        generation[c][d] = generation[a][b];

    }

    public void setGeneration(Generation g, Population p){
        p.updateGeneration(g);
    }

    /*public int calcOverallAffinity(Person[][] p){

    }*/


}
