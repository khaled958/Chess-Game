package component;

public class Player {


    private final COLOR color;
    private String Name;
    public Player(COLOR color,String name) {
        this.color = color;
        this.Name = name;
    }
    public COLOR getColor() {
        return color;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
