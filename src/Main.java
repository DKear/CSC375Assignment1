import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Jamie on 9/25/2017.
 */
public class Main {


    public static void main(String args[]){
        Generation generation = new Generation(10,10);
        Population classroom = new Population(generation);
        generation.setSize();
        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<Generation> generations = new ArrayList<>();
        int threadCount= 2;

        for(int i = 0; i<threadCount; i++) {
            threads.add(new Thread(new SwapThread(generation, 1000, classroom, i)));
        }

        for(int i = 0; i < threads.size(); i++) {
            threads.get(i).start();
        }



        for(int i = 0; i < threads.size(); i++) {
            try{
                threads.get(i).join();
            } catch(Exception e){

            }
        }


    }
}
