# Student Management System (For Educational Use Only)

## Description

This Java program serves as a simple command-line interface for managing student data. It's designed as a project for educational purposes, particularly for the Object-Oriented Programming (OOP) class at Budi Luhur University. The system allows students to practice fundamental concepts of Java programming, including classes, objects, arrays, user input, error handling, and basic file operations.

The program facilitates various operations such as adding new student data, editing existing records, deleting entries, and displaying all student information. It emphasizes proper input validation and error handling to ensure a robust and user-friendly experience. Students can explore and modify the codebase to deepen their understanding of Java programming principles and best practices.

## Educational Note

This project is intended solely for educational purposes within the OOP class at Budi Luhur University. It provides students with a practical application to reinforce theoretical concepts learned in lectures and labs. Through hands-on experience with real-world scenarios, students can enhance their problem-solving skills, logical thinking abilities, and collaborative teamwork.

While this project encourages experimentation and exploration, students should adhere to academic integrity principles and avoid plagiarism or unauthorized collaboration. The program code, documentation, and any modifications made should reflect individual understanding and efforts. Proper citation of external resources and attribution of ideas borrowed from peers or online sources is essential to maintain academic honesty and integrity.

## Usage
1. Compile the Java code using a Java compiler:
```javac Scratch.java```
2. Run the program: 
```markdown
java Scratch
```
3. Follow the on-screen menu to perform desired operations:
- **Tambah Data (Add Data):** Add a new student entry.
- **Hapus Data (Delete Data):** Remove an existing student entry.
- **Edit Data:** Modify existing student information.
- **Tampilkan Semua Data (Show All Data):** Display all student records.
- **Keluar (Exit):** Terminate the program.

## Student Data Format

Each student entry consists of the following information:
- **Name:** Full name of the student.
- **NIM (Nomor Induk Mahasiswa):** Unique identification number of the student (10 digits).
- **Tanggal Lahir (Date of Birth):** Birth date of the student (DD-MM-YYYY format).

## Error Handling

The program includes error handling mechanisms for various scenarios:
- Invalid input data (e.g., blank space, incorrect date format, invalid NIM format).
- Index out of bounds errors when selecting options or editing data.

## Additional Notes

- The program initializes with pre-existing student data for demonstration purposes.
- Ensure to input data in the correct format as per the provided guidelines.
- The program provides a back button option (input 99) for navigating back to the main menu.
- Custom exceptions are utilized for handling specific validation checks.
- You can extend this program by adding more features such as search functionality, sorting, or saving data to a file for persistence.

Feel free to explore and modify the code to suit your needs!

