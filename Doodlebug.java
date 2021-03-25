import java.util.List;
import java.util.Random;

public class Doodlebug extends Organism{
    
    int starveNo;

    public Doodlebug(){
        super();
        this.starveNo = 0;
    }

    public Doodlebug(World world, int x, int y){
        super(world,x,y);
        this.starveNo = 0;
    }

    @Override
    public void breed() {
        if(breedNo==8){
            List<int[]> cellsAround = getCellsAround(x, y);

            if(cellsAround.size() == 0){
                breedNo = 0;
                return;
            }

            Random r = new Random();
            int randomNo = r.nextInt(cellsAround.size());
            new Doodlebug(world,cellsAround.get(randomNo)[0],cellsAround.get(randomNo)[1]);
            breedNo = 0;
        }
    }

    @Override
    public void move() {
        List<int[]> cellsWithAnts = getCellsWithAnts(x,y);

        if(cellsWithAnts.size()==0){

            List<int[]> cellsAround = getCellsAround(x, y);

            if(cellsAround.size()==0){
                breedNo = 0;
                return;
            }

            Random r = new Random();
            int randomNo = r.nextInt(cellsAround.size());
            world.setAt(x, y, null);
            x = cellsAround.get(randomNo)[0];
            y = cellsAround.get(randomNo)[1];

            world.setAt(x, y, this);
            starveNo++;
            breedNo++;

        }else{
            Random r = new Random();
            int randomNo = r.nextInt(cellsWithAnts.size());
            world.setAt(x, y, null);
            x = cellsWithAnts.get(randomNo)[0];
            y = cellsWithAnts.get(randomNo)[1];
            world.setAt(x, y, this);
            starveNo=0;
            breedNo++;
        }
    }

    @Override
    public boolean starve() {
        return (starveNo == 3);
    }

    @Override
    public int getType() {
        return 0;
    }
}
