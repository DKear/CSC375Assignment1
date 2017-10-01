import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Population {

    int [][] affinities;
    JPanel panel = new JPanel();
    int happiness = 0;

    public Population( int y , int x){

        affinities = new int [y*x][x*y];
        Random random = new Random();
        for (int i = 0; i < x*y; i++) {
            for (int j = 0; j < x * y; j++) {
                affinities[i][j] = random.nextInt(63);
            }
        }
    }

    public int calcIndividualHappiness(Person p){
        int iHappiness=0;
        Person north = p.getNeighbors()[0];
        int affNorth = 0;
        Person east = p.getNeighbors()[1];
        int affEast = 0;
        Person south = p.getNeighbors()[2];
        int affSouth = 0;
        Person west = p.getNeighbors()[3];
        int affWest = 0;

        if(north.getID() != -1){
            affNorth = affinities[p.getID()][north.getID()];
        }if(east.getID() != -1){
            affEast = affinities[p.getID()][east.getID()];
        }
        if(south.getID() != -1){
            affSouth = affinities[p.getID()][south.getID()];
        }if(west.getID() != -1){
            affWest = affinities[p.getID()][west.getID()];
        }

        iHappiness = affNorth + affEast + affSouth + affWest;
        return iHappiness;
    }

    public int calcHappiness(Generation g){
        happiness = 0;
        for (int i = 0; i < g.people.length; i++){
            for (int j = 0 ; j < g.people[0].length; j++){
                happiness = happiness + calcIndividualHappiness(g.people[i][j]);
            }
        }
        return happiness;
    }


    /*public void print(){
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
    }*/

    public void paint(Graphics g, Generation gen) {
        int x = 0;
        int y = 0;
        for (int b = 0; b < gen.people.length; b++) {
            for (int a = 0; a < gen.people[0].length; a++) {

                Image img = createSeatImage(new Color(0, calcIndividualHappiness(gen.people[b][a]), 0));
                g.drawImage(img, x, y, panel);
                x += 10;
            }
            x = 0;
            y+=10;
        }
        y+=10;
        g.drawString("Happiness: " + calcHappiness(gen), x , y);
        y+=10;
        g.drawString("Gen Number: " + gen.generationNumber, x ,y);


    }





    private Image createSeatImage(Color c){
        BufferedImage bufferedImage = new BufferedImage(10,10,BufferedImage.TYPE_INT_RGB);
        int rgb = c.getRGB();

        for(int i = 0; i < 10 ; i++){
            for(int j = 0; j < 10; j++){
                bufferedImage.setRGB(i, j , rgb);
            }

        }


        return bufferedImage;
    }

    public void paintBestSolution(){

    }



/*    public void updateGeneration(Generation g){
        generation = g;
    }*/
}
