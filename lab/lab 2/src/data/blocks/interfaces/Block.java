package data.blocks.interfaces;

public interface Block {
    public char display();
    public boolean isFalls_with_gravity();
    public boolean isFall_through();
    public void setContenuto(char a);
}
