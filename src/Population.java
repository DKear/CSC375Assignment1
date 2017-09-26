public class Population {
    Person[][] people;
    int populationSize;

    public Population(int x, int y){

        people = new Person[x][y];
        int idCounter = 0;

        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){

                Person newPerson = new Person();
                newPerson.setID(idCounter);
                newPerson.setLocation(x, y);
                setSize(idCounter + 1);

            }
        }

    }

    public void setSize(int s){
        populationSize = s;
    }
}
