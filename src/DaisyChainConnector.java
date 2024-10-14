public class DaisyChainConnector
{
    public Box front;
    public int size;
    public Box tail;
    
    public DaisyChainConnector(){
        size = 0;
        front = null;
    }
    
    public void addBox(int data){
        Box newBox = new Box(null, data);
        if(front == null){
            front = newBox;
        }else{
            Box current = front; 
            while(current.getNextBox() != null){
                current = current.getNextBox();
            }
            current.setNextBox(newBox);
        }
        size++;
    }
    
    public void addBoxFront(int data){
        Box newBox = new Box(front, data);
        front = newBox;
        size++;
    }
    
    public void addBoxAtIndex(int data, int inputIndex){
        if(inputIndex == 0){
            addBoxFront(data);
        }
        else{
            Box current = front;
            for(int i = 1; i < inputIndex; i++){
                current = current.getNextBox();
            }
            Box newBox = new Box(current.getNextBox(), data);
            current.setNextBox(newBox);
            size++;
        }
    }
    
    public void removeBoxEnd(){
        Box current = front;
        while(current.getNextBox().getNextBox() != null){
            current = current.getNextBox();
        }
        current.setNextBox(null);
        size--;
    }
    
    public void removeBoxFront(){
        Box tempBox = new Box(null, 0);
        tempBox = front.getNextBox();
        front = tempBox;
        size--;
    }
    
    public void removeBoxAtIndex(int inputIndex){
        if(inputIndex == 0){
            removeBoxFront();
        }
        else{
            Box current = front;
            for(int i = 0; i < inputIndex - 1; i++){
                current = current.getNextBox();
            }
            current.setNextBox(current.getNextBox().getNextBox());
            size--;
        }
    }
    
    public void replace(int data, int dataToReplace){
         Box current = front; 
         while(current.getNextBox() != null){
             current = current.getNextBox();
             if(current.getData() == dataToReplace){
                 current.setData(data);
             }
         }
    }
    
    public int getIndex(int data){
        Box current = front; 
        int index = 0;
        while(current.getNextBox() != null){
            current = current.getNextBox();
            index++;
            if(current.getData() == data){
                return index;
            }
        }
        return -1;
    }
    
    public void clear(){
        front.setNextBox(null);
    }

    public int getSize(){
        return size;
    }
    
    public boolean contains(int data){
        Box current = front; 
        for(int i = 0; i < size; i++){
            if(current.getData() == data){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        String x = "";
        Box current = front;
        for(int i = 0; i < size; i++){
            if(current == null){
            x = "There is something wrong or the list has been cleared.";
            break;
            }else{
            x += current.getData() + ", ";
            current = current.getNextBox();
        }
        }
        return "[" + x + "]";
    }
}