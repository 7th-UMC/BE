package hsu.umc.server.entity;

import lombok.Getter;

@Getter
public enum Category {
    PM(1), DESIGN(2), WEB(3), IOS(4), ANDROID(5), SERVER(6);

    private final int value;


    Category(int value) {
        this.value = value;
    }

}
