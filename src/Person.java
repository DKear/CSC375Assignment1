
/**
 * Created by Jamie on 9/25/2017.
 */
public class Person {
    int ID;
    //-1 means empty
    Person[] Neighbors = new Person[4];
    //[0] is North, [1] is East, [2] is South, [3] is West
    int LocationX=0;
    int LocationY=0;
    //int[] Affinities;

    public Person(){
        ID = -1;
    }



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
