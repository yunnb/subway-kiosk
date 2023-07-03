package STUDY;

import java.util.Arrays;

public class enumTest {
    public enum Season {
        SPRING, SUMMER, AUTUMN, WINTER
    }

    public static void main(String[] args) {
        Season.SPRING.getDeclaringClass();   // == Class<Season>

        Arrays.stream(Season.values()).forEach(value -> {
            System.out.println("ordinal: " + value.ordinal() + ", name: " + value.name());
        });
        // ordinal : 0, name : SPRING
        // ordinal : 1, name : SUMMER
        // ordinal : 2, name : AUTUMN
        // ordinal : 3, name : WINTER

        Season.valueOf("SPRING");  // ==Season.SPRING
        // Season.valueOf("Java");    // 상수가 존재하지 않으므로 오류 발생
    }
}