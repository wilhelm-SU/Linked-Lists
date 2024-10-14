public class Box
{
    private Box next;
    private int data;
    
    public Box(Box inputBoxNext, int inputData){
        data = inputData;
        next = inputBoxNext;
    }
    
    // 2 getters 2 setters
    
    public Box getNextBox(){
        return next;
    }
    
    public void setNextBox(Box newBox){
        next = newBox;
    }
    
    public int getData(){
        return data;
    }
    
    public void setData(int newData){
        data = newData;
    }
}
