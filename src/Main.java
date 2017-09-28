
/**
 * Created by Jamie on 9/25/2017.
 */
public class Main {
    public static void main(String args[]){
        Generation generation = new Generation(10,10);
        Population classroom = new Population(generation);
        generation.setSize();

        new Thread(new SwapThread(generation));



    }
}
