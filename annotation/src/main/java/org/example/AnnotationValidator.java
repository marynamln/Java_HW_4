package org.example;

import java.lang.reflect.Field;

public class AnnotationValidator {
    public static void validate(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(ValidateMark.class)) {
                ValidateMark validateMark = field.getAnnotation(ValidateMark.class);
                field.setAccessible(true);
                int mark = (int) field.get(obj);
                if (mark < validateMark.min() || mark > validateMark.max()) {
                    throw new IllegalArgumentException("Mark " + mark + " is out of range!");
                }
            }
        }
    }
}
