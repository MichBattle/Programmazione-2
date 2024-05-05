package Controller;

public class Recordd {
    private String field1;
    private String field2;
    private Integer field3;

    public Recordd(String field1, String field2, Integer field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public Integer getField3() {
        return field3;
    }

    @Override
    public String toString() {
        return field1 + " " + field2 + " " + field3;
    }
}
