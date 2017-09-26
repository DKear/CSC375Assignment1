
/**
 * Created by Jamie on 9/25/2017.
 */
public class Person {
    int ID;
    Person[] Neighbors;
    int LocationX=0;
    int LocationY=0;
    //int[] Affinities;



    public void setLocation(int x, int y){
        LocationX = x;
        LocationY = y;
    }

    public void setID(int id){
        ID = id;
    }


}
