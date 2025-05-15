
import java.io.IOException;


public class JsonExporter {

    public static void exportToJson(Object obj) throws IOException {
        Class<?> objClass = obj.getClass();

        if (!objClass.isAnnotationPresent(JsonSerializable.class)) {
            throw new IllegalArgumentException("Class is not annotated with @JsonSerializable.");
        }

        JsonSerializable annotation = objClass.getAnnotation(JsonSerializable.class);
        String directory = annotation.directory();
        String fileName = objClass.getSimpleName() + ".json";

        ObjectToJsonConverter serializer = new ObjectToJsonConverter(); // <--- Corregido
        String jsonContent = serializer.serialize(obj);

        FileManager fileManager = new FileManager();
        fileManager.saveToFile(jsonContent, directory, fileName);
    }
}
