import java.io.File;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean again = true;
        System.out.println("Please choose one of the options:");
        System.out.println("(1) Encryption");
        System.out.println("(2) Decryption");
        Scanner sc = new Scanner(System.in);
        int i= sc.nextInt();

        while(again){
            System.out.println("Please enter the name of the file");
            String filename = sc.next();
            File file = new File(filename);
            if(i == 1){
                System.out.print("Encryption simulation of file ");
                System.out.println(filename);
            }
            else if(i == 2) {
                System.out.print("Decryption simulation of file ");
                System.out.println(filename);
            }
            else
                System.err.println("Error: Index out of bound");

            if (!file.exists())         // Does the file exist?
                System.err.println("Error: The file isn't exists");
            else if (!file.isFile())   // is it a File and can I read it?
                System.err.println("Error: The path isn't a file");
            else
                again = false;
        }
        sc.close();
    }

}
