import java.util.ArrayList;
import java.util.List;

public abstract class Organism{
    
    protected int x;
    protected int y;
    protected int breedNo;

    protected boolean isMoved;
    protected World world;

    public Organism(){
        this.world = null;
        this.isMoved = false;
        this.breedNo = 0;
        this.x = 0;
        this.y = 0;
    }

    public Organism(World world,int x,int y){
        this.world = world;
        this.x = x;
        this.y = y;
        this.breedNo = 0;
        this.isMoved = false;
        world.setAt(x,y,this);
    }

    public abstract void breed();
    public abstract void move();
    public abstract int getType();
    public abstract boolean starve();

    public List<int[]> getCellsAround(int x, int y){
        List<int[]> cellsAround = new ArrayList<>();

        if(x!=19 && world.getAt(x+1,y)==null) cellsAround.add(new int[]{x+1,y});
        if(y!=19 && world.getAt(x,y+1)==null) cellsAround.add(new int[]{x,y+1});
        if(x!=0 && world.getAt(x-1,y)==null) cellsAround.add(new int[]{x-1,y});
        if(y!=0 && world.getAt(x,y-1)==null) cellsAround.add(new int[]{x,y-1});
    
        return cellsAround;
    }

    public List<int[]> getCellsWithAnts(int x, int y){
        List<int[]> cellsWithAnts = new ArrayList<>();
        
        if(x!=19 && world.getAt(x+1,y)!=null && world.getAt(x+1,y).getType()==1) cellsWithAnts.add(new int[]{x+1,y});
        if(y!=19 && world.getAt(x,y+1)!=null && world.getAt(x,y).getType()==1) cellsWithAnts.add(new int[]{x,y+1});
        if(x!=0 && world.getAt(x-1,y)!=null && world.getAt(x-1,y).getType()==1) cellsWithAnts.add(new int[]{x-1,y});
        if(y!=0 && world.getAt(x,y-1)!=null && world.getAt(x,y-1).getType()==1) cellsWithAnts.add(new int[]{x,y-1});
        return cellsWithAnts;
    }
}
