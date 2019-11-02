package objects;

public class seat {
    private boolean isBooked;

    public seat(){
        this.isBooked = false;
    }

    public void book(){
        isBooked = true;
    }
    
    public String toString(){
        if (isBooked == false) return "[ ]";
        else return "[X]";
    }
}