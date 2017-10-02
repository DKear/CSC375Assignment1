import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
/*
Class holds the affinity values of each student, calculates happiness of individuals
and uses that to calculate a generation's total happiness, and paints generations.
*/
public class Population {

    int [][] affinities; // First element represents a person, the second is their affinity to another person.
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
    //Calcs individual happiness
    public int calcIndividualHappiness(Person p){
	//get neighbors
        int iHappiness=0;
        Person north = p.getNeighbors()[0];
        int affNorth = 0;
        Person east = p.getNeighbors()[1];
        int affEast = 0;
        Person south = p.getNeighbors()[2];
        int affSouth = 0;
        Person west = p.getNeighbors()[3];
        int affWest = 0;

	//get affinity from affinities[][] by ID
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
	
	//add up all the affinity values and return the happiness
        iHappiness = affNorth + affEast + affSouth + affWest;
        return iHappiness;
    }

    //calculate the happiness of the whole generation
    public int calcHappiness(Generation g){
        happiness = 0;
	//calculate individual happiness of every person in the generation and add them together
        for (int i = 0; i < g.people.length; i++){
            for (int j = 0 ; j < g.people[0].length; j++){
                happiness = happiness + calcIndividualHappiness(g.people[i][j]);
            }
        }
        return happiness;
    }


    //Paint the generation
    public void paint(Graphics g, Generation gen) {
        int x = 0;
        int y = 0;
        for (int b = 0; b < gen.people.length; b++) {
            for (int a = 0; a < gen.people[0].length; a++) {
		//paint image for an individual, use the affinity to set the green (rgb) value
                Image img = createSeatImage(new Color(0, calcIndividualHappiness(gen.people[b][a]), 0));
                g.drawImage(img, x, y, panel);
                x += 10;
            }
            x = 0;
            y+=10;
        }
        y+=10;
	//paint the generation's happiness
        g.drawString("Happiness: " + calcHappiness(gen), x , y);
        y+=10;
	//paint which generation
        g.drawString("Gen Number: " + gen.generationNumber, x ,y);


    }




    //create an image of a person using a color
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



}
