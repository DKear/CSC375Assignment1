import java.util.ArrayList;

/**
 * Created by Jamie on 9/25/2017.
 */
public class Main {


    public static void main(String args[]){
        int threadCount= 4;
        ArrayList<Generation> generations = new ArrayList<>();

        for(int i = 0; i < threadCount; i++){
            generations.add(new Generation(10,10));
            generations.get(i).setSize();
        }
        Generation generation = new Generation(10,10);
        //Population classroom = new Population(generation);
        generation.setSize();
        ArrayList<Thread> threads = new ArrayList<>();

        //for(int i = 0; i<threadCount; i++) {
        //    threads.add(new Thread(new SwapThread(generations.get(i), 1000, classroom, i, exchanger)));
        //}

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
