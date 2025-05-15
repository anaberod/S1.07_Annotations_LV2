public class Main {
    public static void main(String[] args) {
        // Create an instance of the User class
        User user = new User("Raquel", 40);


        try {
            JsonExporter.exportToJson(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
