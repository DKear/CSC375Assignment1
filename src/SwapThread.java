import java.util.Random;

/**
 * Created by Jamie on 9/27/2017.
 */
public class SwapThread implements Runnable{
    int stop;
    Integer threadNumber;
    int currentMaxAffinity;
    Generation currentGen;
    Generation currentBestGen;
    Population classroom;
    public void run(){
        System.out.println("thread: " + threadNumber);
        System.out.println("class size: " + currentGen.classSize);
        System.out.println("generation: " + currentGen.generationNumber);
        //classroom.print();
        currentGen.print();


        for(int i = 0; i < stop; i++){
            //classroom.updateGeneration(currentGen);
            currentGen.incGenNum();
            swapSeats(currentGen);
            //setGeneration(currentGen, classroom);
            //System.out.println("thread: " + threadNumber);
            //System.out.println("class size: " + currentGen.classSize);
            //System.out.println("generation: " + currentGen.generationNumber);


        }
        System.out.println("thread: " + threadNumber);
        System.out.println("class size: " + currentGen.classSize);
        System.out.println("generation: " + currentGen.generationNumber);
        setGeneration(currentGen, classroom);
        currentGen.print();

    }
    public SwapThread(Generation g, int s, Population c, Integer tn){
        currentGen = g;
        stop = s;
        classroom = c;
        threadNumber = tn;
    }

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

    }

    public void setGeneration(Generation g, Population p){
        p.updateGeneration(g);
    }



    /*public int calcOverallAffinity(Person[][] p){

    }*/


}
