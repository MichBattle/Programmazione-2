package Model;

import java.util.Objects;

public abstract class Record {
    private String field1;
    private String field2;
    private Integer field3;

    public Record(String field1, String field2, Integer field3) {
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

    public boolean equals(Record r){
        return this.field1.equals(r.getField1()) && this.field2.equals(r.getField2()) && Objects.equals(this.field3, r.getField3());
    }

    @Override
    public String toString() {
        return field1 + " " + field2 + " " + field3;
    }
}
