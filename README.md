# Student Management System

This Java program provides a simple command-line interface for managing student data. It allows users to add, edit, delete, and display student information.

## Features

- Add new student data including name, ID (NIM), and date of birth.
- Edit existing student data.
- Delete student data.
- Display all student data.
- Error handling for invalid input data.

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

