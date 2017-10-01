public class Generation {
    Person[][] people;
    Integer generationNumber = 0;
    Integer classSize = 0;
    Integer genHappiness = 0;

    public Generation(int y, int x){
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
                setSize();
                people[a][b].setNeighbors(people);
                people[a][b].setAffinityValues(this.classSize);
                people[a][b].calcCurrentHappiness();
            }
        }
    }

    public void calcHappiness(){
        int rTotal = 0;
        for(int i = 0; i < people.length; i++) {
            for (int j = 0; j < people[0].length; j++) {

                rTotal = rTotal + people[i][j].getHappiness();


            }
        }
        genHappiness = rTotal;
    }



    public void setSize(){
        classSize = people.length*people[0].length;
    }

    public Person[][] getGeneration(){
        return people;
    }

    public int incGenNum(){return ++generationNumber;}
    public void print(){
        String seat;
        String seatPadding;
        for (int i = 0; i < this.getGeneration().length ; i++){
            for (int j = 0; j < this.getGeneration()[i].length; j++){
                seat = this.getGeneration()[i][j].ID.toString();
                seatPadding = String.format("%3s" , seat).replace(' ', '0');
                System.out.print("[" + seatPadding + "]");

            }
            System.out.println();
        }
    }
}
