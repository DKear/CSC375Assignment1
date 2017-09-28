public class Population {
    Person[][] people;
    Integer populationSize;

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

    public void setSize(){
        populationSize = people.length*people[0].length;
    }

    public void print(){
        String seat;
        String seatPadding;
        for (int i = 0; i < people.length ; i++){
            for (int j = 0; j < people[i].length; j++){
                seat = people[i][j].ID.toString();
                seatPadding = String.format("%3s" , seat).replace(' ', '0');
                System.out.print("[" + seatPadding + "]");

            }
            System.out.println();;
        }
    }
}
