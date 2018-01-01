import java.util.HashSet;

public class Grid_Element {
    private int value;
    HashSet<Integer> possibilities;

    public Grid_Element(int value){
        this.value = value;
        this.possibilities = new HashSet<>(10);
        for(int i = 1;i<10;i++)
            possibilities.add(i);
    }
    
    public Grid_Element(){
        this(0);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public HashSet<Integer> getPossibilities() {
        return possibilities;
    }

    public int getValue() {
        return value;
    }
}
