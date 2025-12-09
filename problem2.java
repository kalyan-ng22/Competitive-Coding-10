// Time Complexity : O(1) for peek(), next() and hasNext()
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : Peeking iterator:The idea is to stay one step ahead as we cannot comeback when next() is performed on an iterartor.
// So during intialization itself, we perform next and store the first element in bufferedVal. If peek() is called,
// we return that value in bufferedValue. If next is called, we need to return the current bufferedVal and also move to the next pointer
// and store that value. hasNext() will return true if we have a value in bufferdValue.


class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    int bufferedVal; //to store the value in advance
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.it = iterator;
        if(it != null && it.hasNext()){ //store the next value at intialization
            bufferedVal = it.next();
        }else{
            bufferedVal = 0;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(bufferedVal > 0){ //if present, return
            return bufferedVal;
        }
        return -1;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int temp = bufferedVal; //store in temp
        if(it.hasNext()){
            bufferedVal = it.next(); //advance and store the next
        }else{
            bufferedVal = 0;
        }
        return temp; //return temp
    }

    @Override
    public boolean hasNext() {
        return bufferedVal > 0;
    }
}