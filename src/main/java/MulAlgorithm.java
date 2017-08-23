/**
 * Created by moran18 on 8/23/2017.
 */
public class MulAlgorithm extends ArithmeticAlgorithm {

    public MulAlgorithm(String name){
        super(name);
    }

    public MulAlgorithm(){
        super();
    }

    @Override
    public void Encrypt() {
        start_encrypt();
        this.key = 3;
        encrypt_decrypt_Algo(this.key);
        write_to_file(1);
        end_encrypt();
    }

    private void encrypt_decrypt_Algo(byte key){
        for(int i=0 ;i < content.length ;i++) {
           // System.out.print("the content is : " + content[i]);
            content[i] = (char) MWO((byte) content[i], key);
            //System.out.println("   the content is : " + content[i]);
        }
    }

    private byte MWO(byte a, byte b){
        return (byte)(a * b);
    }

    private byte get_key(){
        byte decr_key = 0;
        byte i = MIN_VALUE;
        for(;i < MAX_VALUE && (i != 0) && (i % 2 != 0); i++){
            if(MWO(i ,key) == 1) {
                decr_key = i;
                break;
            }
        }
        return decr_key;
    }

    @Override
    public void Decrypt() {
        select_key();
        get_key();
        encrypt_decrypt_Algo(get_key());
        write_to_file(2);
    }

}
