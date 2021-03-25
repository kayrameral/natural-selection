import java.util.Random;
import java.util.Scanner;

public class PredatorSim {

    public static void main(String[] args) {
        
        World world = new World();
        Random random = new Random();

        for(int i=0; i<100; i++){
            int x = random.nextInt(20);
            int y = random.nextInt(20);

            while(world.getAt(x,y)!=null){
                x = random.nextInt(20);
                y = random.nextInt(20);
            }
            new Ant(world,x,y);
        } 

        for(int i=0; i<5; i++){
            int x = random.nextInt(20);
            int y = random.nextInt(20);

            while(world.getAt(x,y)!=null){
                x = random.nextInt(20);
                y = random.nextInt(20);
            }
            new Doodlebug(world,x,y);
        } 

        Scanner s = new Scanner(System.in);
        String input = "";

        while(input.length() == 0){
            world.display();
            world.nextTurn();
            System.out.println();
            System.out.print("Prees enter to continue,press any key + enter to exit:");
            input = s.nextLine();
        }
        s.close();
    }
}
