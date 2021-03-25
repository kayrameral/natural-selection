public class World{

    private Organism[][] grid = null;

    public World(){
        grid = new Organism[20][20];
    }

    public Organism getAt(int x,int y){
        if((x>=0) && (x<20) && (y>=0) && (y<20)){
            return grid[x][y];
        }
        return null;
    }

    public void setAt(int x,int y,Organism org){
        if((x>=0) && (x<20) && (y>=0) && (y<20)){
            grid[x][y] = org;
        }
    }

    public void display(){
        System.out.println();
        System.out.println();

        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                if(grid[i][j] == null) System.out.print("- ");
                else if(grid[i][j].getType() == 1) System.out.print("o ");
                else System.out.print("X ");
            }
            System.out.println();
        }
    }

    public void nextTurn(){

        for(int i=0; i<20; i++)
            for(int j=0; j<20; j++)
                if(grid[i][j] != null) grid[i][j].isMoved = false;

        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                if((grid[i][j]!= null) && (grid[i][j].getType() == 0) && (!grid[i][j].isMoved)){
                    grid[i][j].isMoved = true;
                    grid[i][j].move();
                }
            }
        }
                
        for (int i=0; i<20; i++) {
            for (int j=0; j<20; j++) {
                if ((grid[i][j] != null) && (grid[i][j].getType()==1) && (!grid[i][j].isMoved)){
                    grid[i][j].isMoved = true;
                    grid[i][j].move();
                }
            }
        }
                    
        for (int i=0; i<20; i++) 
            for (int j=0; j<20; j++) 
                if ((grid[i][j] != null) && (grid[i][j].getType()==0))
                    if (grid[i][j].starve()) grid[i][j] = null;

        for (int i=0; i<20; i++)
            for (int j=0; j<20; j++)
                if ((grid[i][j] != null) && (grid[i][j].isMoved))
                    grid[i][j].breed();
                  
    }
}