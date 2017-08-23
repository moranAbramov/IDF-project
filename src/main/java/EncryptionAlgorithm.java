/**
 * Created by moran18 on 8/22/2017.
 */

import lombok.Data;
import lombok.Setter;
import java.io.*;
import java.lang.*;



public @Data @Setter  abstract class EncryptionAlgorithm {

    @Setter String filename;
    protected char[]  content;
    protected long start_time;
    protected long end_time;

    public EncryptionAlgorithm(String name){
       this.filename = name;
       this.content = getContent();
    }

    public EncryptionAlgorithm(){}

    private char[] getContent(){
        String input = "";
        BufferedReader br = null;
        StringBuilder sb = null;
        try {
            FileReader file = new FileReader(this.filename);
            br = new BufferedReader(file);
            sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            input = sb.toString();
            try {               // Close the BufferedReader.
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return input.toCharArray();
    }

    private void print_content(){
        System.out.println("Starting printing the content");
        for(int i = 0; i < content.length; i++)
            System.out.print(content[i]);
        System.out.println();

    }

    protected void write_to_file(int flag) {
        String toWrite = new String(this.content);
       // print_content();
        BufferedWriter bw = null;
        FileWriter fw = null;
        String newFileName = null;
        if(flag == 1)
            newFileName = this.filename + ".encrypted.txt";
        else {
            String[] tmp = this.filename.split("\\.");
            newFileName = tmp[0] + "_decrypted." + tmp[1];
        }
        try {
            fw = new FileWriter(newFileName);
            bw = new BufferedWriter(fw);
            bw.write(toWrite);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    protected void start_encrypt(){
        System.out.println("Start Encryption");
       this.start_time = System.currentTimeMillis();
    }

    protected void end_encrypt(){
        this.end_time = System.currentTimeMillis();
        System.out.println("End Ecryption");
        System.out.println("The process took "+ (this.end_time - this.start_time) + " milliseconds");

    }

    public abstract void Encrypt();
    public abstract void Decrypt();
}
