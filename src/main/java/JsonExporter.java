import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class JsonExporter {

    public static void exportToJson(Object obj) throws IOException {
        Class<?> objClass = obj.getClass();

        if (objClass.isAnnotationPresent(JsonSerializable.class)) {
            JsonSerializable annotation = objClass.getAnnotation(JsonSerializable.class);
            String directory = annotation.directory();

            // Crear carpeta si no existe
            File dir = new File(directory);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Convertir a JSON manualmente
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

            // Guardar archivo
            String fileName = directory + "/" + objClass.getSimpleName() + ".json";
            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write(jsonBuilder.toString());
                System.out.println("JSON file created at: " + fileName);
            }

        } else {
            throw new IllegalArgumentException("Class is not annotated with @JsonSerializable.");
        }
    }
}
