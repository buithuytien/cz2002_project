package display;

public abstract class display{
    public display prev;
    protected abstract void start();
    protected void destroy(){
        if (prev == null) System.exit(1);
        else prev.start();
    }

    protected void intent(display i, display j){
        j.prev = i;
        j.start();
    }

    protected display getPrev(){
        return prev;
    }
}