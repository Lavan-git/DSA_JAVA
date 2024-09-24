public class interfacce {
    public static void main(String[] args) {
        queen q=new queen();
        q.moves();
    }
}
interface ChessPlayer {
    void moves();    
}
class queen implements ChessPlayer{
    public void moves(){
        System.out.println("Up, down, left, right, diagnol, any number of steps.");
    }
}
class rook implements ChessPlayer{
    public void moves(){
        System.out.println("Up,down,left,right, any number of steps.");
    }
}
