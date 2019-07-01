package xyz.vaith.springbootdatabase.enumeration;


import lombok.Getter;
import lombok.Setter;

public enum Sex {
    MALE(1, "男"), FEMALE(2, "女");

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String value;

    Sex(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public static Sex getEnumById(int id) {
        for (Sex sex : Sex.values()) {
            if (sex.getId() == id) {
                return sex;
            }
        }
        return null;
    }

}
