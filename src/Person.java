import java.util.Random;

public class Person implements Runnable {

    private String name;
    private int time;
    private Random r = new Random();
    private Affinity[] affinities;
    private int seatX;
    private int seatY;

    public Person(String n){
        name = n;
        affinities = new Affinity[9];
    }


    public void run(){
        try{

        }catch(Exception e){

        }
    }
}
