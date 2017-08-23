import java.io.File;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean again = true;
        EncryptionAlgorithm algo = null;
        Scanner sc = null;

        while(again) {
            System.out.println("Which Encryption Algorithm you want to use?, if you want exit press 4");
            System.out.println("(1) Caesar Algorithm");
            System.out.println("(2) XOR Algorithm");
            System.out.println("(3) Multiplication Algorithm");
            sc = new Scanner(System.in);
            int algo_num = sc.nextInt();
            switch (algo_num) {
                case 1:
                    algo = new CaesarAlgorithm();
                    again = false;
                    break;
                case 2:
                    algo = new XORAlgorithm();
                    again = false;
                    break;
                case 3:
                    algo = new MulAlgorithm();
                    again = false;
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.err.println("Error: Index out of bound");
                    break;
            }
        }

        again = true;
        int i = 0;
        while (again){
            System.out.println("Please choose one of the options:");
            System.out.println("(1) Encryption");
            System.out.println("(2) Decryption");
            System.out.println("(3) Exit");
            i = sc.nextInt();
            if (i != 1 || i != 2 || i != 3)
                System.err.println("Error: Index out of bound");
            else if (i == 3)
                System.exit(0);
            else
                again = false;
        }

        again = true;
        File file = null;
        String filename = null;
        while(again) {
            System.out.println("Please enter the name of the file");
            filename = sc.next();
            file = new File(filename);
            if (!file.exists())         // Does the file exist?
                System.err.println("Error: The file isn't exists");
            else if (!file.isFile())   // is it a File and can I read it?
                System.err.println("Error: The path isn't a file");
            else
                again = false;
        }

        algo.setFilename(filename);
        if(i == 1){
            System.out.print("Encryption simulation of file ");
            System.out.println(filename);
            algo.Encrypt();
        }
        else if(i == 2) {
            System.out.print("Decryption simulation of file ");
            System.out.println(filename);
            algo.Decrypt();
        }
        else
            System.err.println("Error: Index out of bound");

        sc.close();
    }

}
