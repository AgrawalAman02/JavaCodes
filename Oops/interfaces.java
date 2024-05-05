//INTERFACE
//--multiple inheritance
//-- total abstraction
/* - all methods are public, abstract & without implementation
   - used to achieve total abstraction
   - varaibles in the interfaces are final , public & static
 */
package Oops;

public class interfaces {
    public static void main(String[] args) {
        Queen q= new Queen();
        q.moves();

//        multiple interface call;;
        Beer b = new Beer();
        b.eat();
    }
}
interface ChessPlayer{
    void moves();
}
class Queen implements ChessPlayer{
    @Override
    public void moves() {
        System.out.println("up,down, left , right, diagonal(in all four direction)");
    }
}
class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up,down, left , right");
    }
}
class King implements ChessPlayer{
    public void moves(){
        System.out.println("up,down, left , right, diagonal by 1 step");
    }
}


//  example of multiple interface
interface herbivore{
    public void eat();
}
interface canrivore{
    public void eat();
}
class Beer implements herbivore,canrivore{
    public void eat(){
        System.out.println("it is both carnivore and herbivore");
    }
}