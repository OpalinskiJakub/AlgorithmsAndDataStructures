package org.example.SetTable;

public class Set {

    private int[] elements;

    private final int lowerLimit;

    private final int upperLimit;
    public Set(int lowerLimit, int upperLimit){
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        elements = new int[upperLimit-lowerLimit+1];
    }

    private boolean isInLimit(int value){
        if((value<lowerLimit)||(value>upperLimit)){
            return false;
        }else{
            return true;
        }
    }

    public boolean insert(int value){
        if(isInLimit(value)){
            elements[value - lowerLimit] = 1;
            return true;
        }else {
            return false;
        }
    }

    public boolean withDraw(int value){
        if(isInLimit(value)){
            elements[value - lowerLimit] = 0;
            return true;
        }else {
            return false;
        }
    }
    public boolean isInSet(int value){
        if(isInLimit(value)){
            if(elements[value-lowerLimit]==1){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder =  new StringBuilder();
        for(int i=0;i<elements.length;i++){
            if(elements[i]==1) {
                stringBuilder.append(Integer.toString(i + lowerLimit));
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

}
