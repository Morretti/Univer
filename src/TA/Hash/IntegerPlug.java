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

    @Override
    public int hashCode(){
        return 31*value;
    }

    @Override
    public String toString(){
        return ""+value;
    }
}
