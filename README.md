# 📚 S1.07 - Custom Java Annotations (Level 2)

This repository contains the solution to Level 2 of the S1.07 Java Annotations exercises, focusing on creating and using a **custom annotation** to serialize Java objects into JSON files.

---

## 📄 Description - Exercise Statement

### Exercise 1

Create a custom annotation that enables serializing a Java object into a JSON file.  
The annotation must accept a parameter specifying the directory where the resulting file should be saved.

---

## 💻 Technologies Used

- Java 17+
- Java Reflection API
- (Optional) Google Gson library for JSON handling
- File I/O (java.io)

---

## 📋 Requirements

- Java Development Kit (JDK) 17 or higher
- A Java IDE (IntelliJ IDEA, Eclipse, VSCode, etc.)
- Git (to clone the repository)
- (Optional) Gson library (`com.google.code.gson:gson`) if automatic JSON serialization is desired

---

## 🛠️ Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/anaberod/S1.07_Annotations_LV2.git
   ```
2. Open the project in your preferred Java IDE.
3. If using Gson, ensure the library is added to your build path or dependencies.

---

## ▶️ Execution

1. Run the `Main` class.
2. An instance of a sample class (e.g., `User`) will be created and exported to a JSON file.
3. The file will be saved in the directory specified by the `@JsonSerializable` annotation (e.g., `output/User.json`).
4. If the folder doesn't exist, it will be automatically created.

---

## 🌐 Deployment

This is a learning project. Deployment to production environments is not required.

---

## 🤝 Contributions

Contributions are welcome for educational improvements.

To contribute:
- Fork the repository.
- Create a new branch (`git checkout -b your-feature-name`).
- Commit your changes (`git commit -m 'Add new feature'`).
- Push to your fork (`git push origin your-feature-name`).
- Open a Pull Request describing your changes.

---
