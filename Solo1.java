
package domino2;

import java.util.ArrayList;

public class Solo1 {
    
    private Table table;
    private ArrayList<Tile> list1,list2,list3,list4;
    private Pack pack;
    
    public Solo1(){
        
    }
    
    public Solo1(Pack pack,Table table){
        this.pack = pack;
        this.table = table;
        list1 = new ArrayList<Tile>();
        list2 = new ArrayList<Tile>();
        list3 = new ArrayList<Tile>();
        list4 = new ArrayList<Tile>();
        pack.shuffle();
        splitLists();
    }
    
    public void splitLists(){
        int a = 0;
        for (Tile tile : pack.getDominos()){
            a++;
            if (a<8){
                list1.add(tile);
            }
            else if (a<15){
                list2.add(tile);
            }
            else if (a<22){
                list3.add(tile);
            }
            else {
                list4.add(tile);
            }
        }
    }
    
    public ArrayList<Tile> getList1(){
        return list1;
    }
    
    public ArrayList<Tile> getList2(){
        return list2;
    }
    
    public ArrayList<Tile> getList3(){
        return list3;
    }
    
    public ArrayList<Tile> getList4(){
        return list4;
    }
    
    public Tile getTheLastTile(ArrayList<Tile> list){
        Tile t = null;
        for (Tile tile : list){
            t =tile;
        }
        return t;
    }
    
    public void removeTile(ArrayList<Tile> list,int t){
          list.remove(t);
        }
    
    public boolean enableTile(Tile t){
        if ((t.getSide1() == table.getLeftSide()) || (t.getSide1() == table.getRightSide()) || (t.getSide2() == table.getLeftSide()) || (t.getSide2() == table.getRightSide())){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int numberOfTilesList(ArrayList<Tile> list){
        return list.size();
    }
}
