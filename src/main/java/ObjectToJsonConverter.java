import java.lang.reflect.Field;

public class ObjectToJsonConverter {
    public String serialize(Object obj) {
        Class<?> objClass = obj.getClass();
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n");

        Field[] fields = objClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            String name = fields[i].getName();
            Object value;
            try {
                value = fields[i].get(obj);
            } catch (IllegalAccessException e) {
                continue;
            }

            jsonBuilder.append("  \"").append(name).append("\": ");
            if (value instanceof String) {
                jsonBuilder.append("\"").append(value).append("\"");
            } else {
                jsonBuilder.append(value);
            }

            if (i < fields.length - 1) {
                jsonBuilder.append(",");
            }
            jsonBuilder.append("\n");
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}
