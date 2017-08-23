import java.util.Scanner;

/**
 * Created by moran18 on 8/23/2017.
 */
public abstract class ArithmeticAlgorithm extends EncryptionAlgorithm {

    protected byte key;
    protected final byte MAX_VALUE = 127;
    protected final byte MIN_VALUE = -128;

    public ArithmeticAlgorithm(String name){
        super(name);
    }

    public ArithmeticAlgorithm(){
        super();
    }

    protected void select_key(){
        this.key = (byte)(Math.random() * 100);
        System.out.println("The selected key is "+ this.key);
    }

    protected void get_key_from_user(){
        System.out.println("Please enter a key");
        Scanner sc = new Scanner(System.in);
        this.key = sc.nextByte();
    }

    @Override
    public abstract void Encrypt();

    @Override
    public abstract void Decrypt();
}
