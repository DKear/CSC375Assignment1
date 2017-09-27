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
                newPerson.setID(idCounter);
                people[i][j] = newPerson;

                ++idCounter;


            }
        }
        for (int a = 0; a < y; a++){
            for (int b = 0; b < x; b++){
                people[a][b].setNeighbors(people);
            }
        }

    }

    public void swapPeople(Person a, Person b){
        


    }

    public void setSize(){
        populationSize = people.length*people[0].length;
    }
}
