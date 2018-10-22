package TA.Hash;

public class IntegerPlug {
    private int value;

    public IntegerPlug(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
