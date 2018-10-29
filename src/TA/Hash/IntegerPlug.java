package TA.Hash;

public class IntegerPlug {
    private int value;
    private int hash;

    public IntegerPlug(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    //    public int hashCode(int size){
//        double A=0.618033;
//        int n = size;
//        int k = value;
//        double drob = (k*A) - ((int) (k*A));
//        int result = (int)(n*drob);
//
//        return result;
//    }

    @Override
    public String toString(){
        return ""+value;
    }
}
