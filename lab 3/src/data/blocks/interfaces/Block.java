package data.blocks.interfaces;

public interface Block extends InventoryBlock{
    char display_in_inventory();
    boolean isFalls_with_gravity();
    boolean isFall_through();
    void setContenuto(char a);
    boolean isPickable();
}
