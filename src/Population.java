public class Population {

    Generation generation;

    public Population(Generation g){

        generation = g;
    }


    public void print(){
        String seat;
        String seatPadding;
        for (int i = 0; i < generation.getGeneration().length ; i++){
            for (int j = 0; j < generation.getGeneration()[i].length; j++){
                seat = generation.getGeneration()[i][j].ID.toString();
                seatPadding = String.format("%3s" , seat).replace(' ', '0');
                System.out.print("[" + seatPadding + "]");

            }
            System.out.println();
        }
    }

    public void updateGeneration(Generation g){
        generation = g;
    }
}
