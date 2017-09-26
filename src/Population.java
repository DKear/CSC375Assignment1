public class Population {
    Person[][] people;
    int populationSize;

    public Population(int y, int x){

        people = new Person[y][x];
        int idCounter = 0;

        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){

                Person newPerson = new Person();
                newPerson.setID(idCounter);
                newPerson.setLocation(i, j);
                people[i][j] = newPerson;


            }
        }

    }

    public void setSize(){
        populationSize = people.length*people[0].length;
    }
}
