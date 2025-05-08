public class Main {
    public static void main(String[] args) {
        // Create an instance of the User class
        User user = new User("Alice", 30);

        // Try to export it as JSON
        try {
            JsonExporter.exportToJson(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
