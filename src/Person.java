import java.util.Random;

/**
 * Created by Jamie on 9/25/2017.
 */
public class Person {
    Integer ID;
    //-1 means empty
    Person[] Neighbors = new Person[4];
    //[0] is North, [1] is East, [2] is South, [3] is West
    int LocationX=0;
    int LocationY=0;
    int[] affValue;
    //int currentHappiness;


    public Person(){
        ID = -1;


    }

    public void setAffinityValues(int size){
        Random random = new Random();
        affValue = new int[size];
        for (int i = 0; i < size; i++){
            affValue[i] = random.nextInt(63);
        }

    }

    /*public void calcCurrentHappiness(){
        Person north = this.getNeighbors()[0];
        int affNorth = 0;
        Person east = this.getNeighbors()[1];
        int affEast = 0;
        Person south = this.getNeighbors()[2];
        int affSouth = 0;
        Person west = this.getNeighbors()[3];
        int affWest = 0;

        if(north.getID() != -1){
            affNorth = affValue[north.getID()];
        }if(east.getID() != -1){
            affEast = affValue[east.getID()];
        }
        if(south.getID() != -1){
            affSouth = affValue[south.getID()];
        }if(west.getID() != -1){
            affWest = affValue[west.getID()];
        }

        currentHappiness = affNorth + affEast + affSouth + affWest;

    }*/

    /*public int getHappiness(){
        return currentHappiness;
    }*/

    public void setLocation(int y, int x){
        LocationX = x;
        LocationY = y;
    }

    public void setID(int id){
        ID = id;
    }

    public int getID(){
        return ID;
    }

    public void setNeighbors(Person[][] p){
        Neighbors[0] = new Person();
        Neighbors[1] = new Person();
        Neighbors[2] = new Person();
        Neighbors[3] = new Person();

        if(LocationY - 1 >= 0){
            Neighbors[0] = p[LocationY-1][LocationX];
        }
        if(LocationX + 1 < p.length){
            Neighbors[1] = p[LocationY][LocationX+1];
        }
        if(LocationY + 1 < p[LocationY].length){
            Neighbors[2] = p[LocationY+1][LocationX];
        }
        if(LocationX - 1 >= 0){
            Neighbors[3] = p[LocationY][LocationX-1];
        }

    }

    public Person[] getNeighbors(){
        return Neighbors;

    }


}
