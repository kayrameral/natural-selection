import java.util.List;
import java.util.Random;

public class Ant extends Organism{
    
    public Ant(){
        super();
    }

    public Ant(World world,int x,int y){
        super(world,x,y);
    }

    @Override
    public void breed() {
        if(breedNo==3){
            List<int[]> cellsAround = getCellsAround(x, y);
            Random r = new Random();

            if(cellsAround.size() == 0){
                breedNo = 0;
                return;
            }

            int randomNo = r.nextInt(cellsAround.size());
            new Ant(world,cellsAround.get(randomNo)[0],cellsAround.get(randomNo)[1]);
            breedNo = 0;
        }
    }

    @Override
    public void move(){
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
        breedNo++;
    }

    @Override
    public boolean starve(){
        return false;
    }

    @Override
    public int getType(){
        return 1;
    }
}
