package hsu.umc.server.entity;

import lombok.Getter;

@Getter
public enum Category {
    PM(1), DESIGN(2), WEB(3), IOS(4), ANDROID(5), SERVER(6);

    private final int value;


    Category(int value) {
        this.value = value;
    }

    public static Category fromValue(int value) {
        for (Category category : Category.values()) {
            if (category.getValue() == value) {
                return category;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
