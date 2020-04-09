import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.String;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;

class Scratch {
    public String namaMahasiswa;
    public int nimMahasiswa;
    public String tanggalLahir;
    static Scratch[] mahasiswa = new Scratch[3];


    public static void main(String[] args){
        mahasiswa[0] = new Scratch("Disiplin Gusti Telaumbanua", 1980416001, "18-08-1999");
        mahasiswa[1] = new Scratch("Sarinulo Laowo", 1980416002, "15-07-2000");
        mahasiswa[2] = new Scratch("Emida Bawaulu", 1980416004, "22-04-2001");
        userMenu();
    }

    public Scratch(String nama, int nim, String tanggal) {
        this.namaMahasiswa = nama;
        this.nimMahasiswa = nim;
        this.tanggalLahir = tanggal;
    }


    public  static void userMenu(){
        String[] menu = {"Tambah Data", "Hapus Data", "Edit Data", "Tampilkan Semua Data", "Keluar"};

        for (int i = 0; i < menu.length ; i++) {
            System.out.println(i+1+". " + menu[i]);
        }

        try {
            System.out.print("Input number: ");
            Scanner myScan = new Scanner(System.in);
            int chooseMenu = myScan.nextInt();

            switch (chooseMenu){
                case 1:
                    addArr();
                    break;
                case 2:
                    removeArr();
                    break;
                case 3:
                    editMenu();
                    break;
                case 4:
                    printData();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.err.println("command not Found");
                    break;
            }
            if(chooseMenu < 1 || chooseMenu > 5){
                throw new ArithmeticException();
            }
        }

        catch (NumberFormatException e){
            System.err.println("Only Accept Integer "+ e);
            System.err.println("Nim contains 10 digits of integers "+ e);
        }

        catch (InputMismatchException e){
            System.err.println("Only Input Numbers "+ e);
        }

        catch (ArithmeticException e){
            System.err.println("Wrong number, just 1-5 "+ e);
        }

        catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Wrong index "+ e);
        }

        catch (IllegalArgumentException e){
            System.err.println("illegal argument " + e);
        }

        catch (Exception e){
            e.printStackTrace();
        }

    }
    
    public static void allData(){
        if (mahasiswa.length > 0){
            for (int i = 0; i < mahasiswa.length ; i++) {
                System.out.format("%-5d%-30s%-15d%-20s%n",i ,mahasiswa[i].namaMahasiswa, mahasiswa[i].nimMahasiswa, mahasiswa[i].tanggalLahir);
            }
        }
    }

    public static void printData(){
        allData();
        backButton();
    }

    public static void removeArr() {
        allData();
        Scratch[] copyArr = new Scratch[mahasiswa.length - 1];

        System.out.print("Please input index :");
        Scanner myScan = new Scanner(System.in);
        int chooseIndex = myScan.nextInt();
        if(chooseIndex < 0 || chooseIndex > mahasiswa.length - 1) throw new ArrayIndexOutOfBoundsException();

        System.out.print("Are you sure want to delete " + mahasiswa[chooseIndex].namaMahasiswa + "?(Y/N): ");

        String yesOrNo = myScan.next();

        if(yesOrNo.equals("Y") || yesOrNo.equals("y")){
            System.arraycopy(mahasiswa, 0, copyArr, 0, chooseIndex);

            System.arraycopy(mahasiswa, chooseIndex + 1,
                    copyArr, chooseIndex,
                    mahasiswa.length - chooseIndex - 1);

            mahasiswa = Arrays.copyOf(copyArr, copyArr.length);

            System.out.println("Data Successfully Removed \n");
            for (int i = 0; i < mahasiswa.length; i++) {
                System.out.format("%-5d%-30s%-15d%-20s%n", i, mahasiswa[i].namaMahasiswa, mahasiswa[i].nimMahasiswa, mahasiswa[i].tanggalLahir);
            }
            backButton();
        }else if(yesOrNo.equals("N") || yesOrNo.equals("n")){
            userMenu();
        }else throw new IllegalArgumentException("Invalid character");


    }

    public static void addArr() throws ParseException {
        Scratch[] copyArr = new Scratch[mahasiswa.length + 1];

        if(mahasiswa.length > 0) copyArr = Arrays.copyOf(mahasiswa, copyArr.length);

        Scanner scanAttribute = new Scanner(System.in);

        System.out.print("============================================================ \n");
        System.out.print("Enter Name: ");
        String name = scanAttribute.nextLine();
        validateName(name);


        System.out.print("Enter Nim (1912345678): ");

        int nim = Integer.parseInt(scanAttribute.nextLine());
        validateNim(nim);

        System.out.print("Enter Tgl-Lahir (DDMMYYYY): ");
        String tgl = scanAttribute.nextLine().replaceAll("(^\\d{2})(\\d{2})(\\d{4})", "$1-$2-$3");
        validateName(tgl);
        validateDate(tgl);

        copyArr[mahasiswa.length] = new Scratch(name, nim, tgl);


        System.out.print("Data Successfully Added \n");
        for (int i = 0; i <  copyArr.length ; i++) {
            System.out.format("%-5d%-30s%-15d%-20s%n", i, copyArr[i].namaMahasiswa, copyArr[i].nimMahasiswa, copyArr[i].tanggalLahir);
        }

        mahasiswa = Arrays.copyOf(copyArr, mahasiswa.length+1);
        backButton();
    }

    public static void validateName(String str){
        if(str.isBlank()) throw new IllegalArgumentException("Cannot Accept Blank Space");
    }

    public static void validateNim(int nim){
        boolean validateNim = Integer.toString(nim).matches("(^(?=[19]+)\\d{2})(?=[0-9]+)\\d{8}$");

        if(!validateNim){
            throw new IllegalArgumentException("2 digits of first nim must be '19.........' and contains 10 digits of number");
        }

    }

    public static void validateDate(String tgl)throws ParseException{

        boolean validateDate =  tgl.matches("(^(?=[0-9]+)\\d{2})-(?=[0-9]+)\\d{2}-((?=[0-9]+)\\d{4}$)");

        if (validateDate){
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            LocalDate myObj = LocalDate.now();
            DateTimeFormatter newDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formattedDate = myObj.format(newDate);
            Date birthDate = dateFormat.parse(tgl);
            Date currentDate = dateFormat.parse(formattedDate);

            if(birthDate.compareTo(currentDate) > 0){
                throw new IllegalArgumentException("Your birth date can't be greater than current date");
            }

        }
        else {
            throw new IllegalArgumentException("Please follow the birth date format!");
        }

    }

    public static void editMenu() throws ParseException{
        allData();
        System.out.print("============================================================ \n");
        Scanner scanMenu = new Scanner(System.in);

        Scratch[] editArr = Arrays.copyOf(mahasiswa, mahasiswa.length);

        System.out.print("Input Index Do You Want Edit: ");
        int index = Integer.parseInt(String.valueOf(scanMenu.nextLine()));

        System.out.print("Enter Name: ");
        String editName = scanMenu.nextLine();
        validateName(editName);


        System.out.print("Enter Nim: ");
        int editNim = Integer.parseInt(String.valueOf(scanMenu.nextLine()));
        validateNim(editNim);

        System.out.print("Enter Birth: ");
        String editbirth = scanMenu.nextLine().replaceAll("(^\\d{2})(\\d{2})(\\d{4})", "$1-$2-$3");
        validateName(editbirth);
        validateDate(editbirth);

        editArr[index].namaMahasiswa = editName;
        editArr[index].nimMahasiswa = editNim;
        editArr[index].tanggalLahir = editbirth;

        System.out.print("Data Successfully Edited: \n");
        for (int i = 0; i <  editArr.length ; i++) {
            System.out.format("%-5d%-30s%-15d%-20s%n", i, editArr[i].namaMahasiswa, editArr[i].nimMahasiswa, editArr[i].tanggalLahir);
        }

        mahasiswa = Arrays.copyOf(editArr, mahasiswa.length);
        backButton();
    }

    public static void backButton(){
        System.out.println("99. Back");

        Scanner scanAttribute = new Scanner(System.in);
        int back  = scanAttribute.nextInt();

        if (back == 99){
            userMenu();
        }else {
            throw new IllegalArgumentException("Only have 99");
        }
    }
}