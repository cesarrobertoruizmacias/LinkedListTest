package uaslp.ingenieria.labs.list;

public class ArrayList <H> implements List<H>{

    private Object array[];
    private int size;

    public ArrayList() {
        this.array = new Object[4];
    }

    @Override
    public void add(H data) {
        if(size == array.length){
            Object[]oldArray = array;
        array =  new Object[array.length * 2];
            if (oldArray.length >= 0) System.arraycopy(oldArray, 0, array, 0, oldArray.length);
        }
        this.array[size++] = data;
    }

    @Override
    public H get(int index) {
        return (H)this.array[index];
    }

    @Override
    public double delete(int index) throws MyIndexOutOfBoundException {
        if (array.length - (index + 1) >= 0)
        {
            System.arraycopy(array, index + 1, this.array, index + 1 - 1, array.length - (index + 1));
    }else{
        throw new MyIndexOutOfBoundException();
    }
      size--;
        return 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<H> getIterator() {
        return new ForwardIterator();
    }

    //@Override
    //public void insert(H data, Position position, Iterator<H> it) {
    //}

    @Override
    public Iterator<H> getReverseIterator() {
        return new ReverseIterator();
    }

    public class ForwardIterator implements Iterator<H>{
        private int currentIndex;

        public ForwardIterator(){
            currentIndex=0;
        }

      //  public int getCurrentIndex(){
       //     return currentIndex;
       // }

        @Override
        public boolean hasNext() {
            return currentIndex<size;
        }

        @Override
        public H next() {
            H data;
            data=get(currentIndex);
            currentIndex++;
            return data;
        }
    }

    public class ReverseIterator implements Iterator<H>{
        private int currentIndex;

        public ReverseIterator(){
            currentIndex=size-1;
        }

     //   public int getCurrentIndex(){
       //     return currentIndex;
      //  }

        @Override
        public boolean hasNext() {
            return currentIndex>=0;
        }

        @Override
        public H next() {
            H data;
            data=get(currentIndex);
            currentIndex--;
            return data;
        }
    }
}