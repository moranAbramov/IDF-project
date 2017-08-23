/**
 * Created by moran18 on 8/22/2017.
 */
public class CaesarAlgorithm extends ArithmeticAlgorithm {

    public CaesarAlgorithm(String name){
        super(name);
    }

    public CaesarAlgorithm(){
        super();
    }
    @Override
    public void Encrypt() {
        start_encrypt();
        select_key();
        encryptAlgo();
        write_to_file(1);
        end_encrypt();
    }

    private void encryptAlgo(){
        int curr;
        for (int i = 0 ; i < this.content.length ; i++ ){
            curr = content[i] + this.key;
            if(curr > MAX_VALUE){
                content[i] = (char) ((curr - MAX_VALUE) + MIN_VALUE - 1);
            }
            else
                content[i] = (char) curr;
        }
    }

    @Override
    public void Decrypt() {
        get_key_from_user();
        decryptAlgo();
        write_to_file(2);
    }

    private void decryptAlgo(){
        int curr;
        for (int i = 0 ; i < this.content.length ; i++ ){
            curr = content[i] + this.key;
            if(curr < MIN_VALUE){
                content[i] = (char) (MAX_VALUE + 1 - (MIN_VALUE - curr));
            }
            else
                content[i] = (char) curr;
        }
    }
}
