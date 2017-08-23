/**
 * Created by moran18 on 8/23/2017.
 */
public class XORAlgorithm extends ArithmeticAlgorithm {

    public XORAlgorithm(String name){
        super(name);
    }

    public XORAlgorithm(){
        super();
    }

    @Override
    public void Encrypt() {
        start_encrypt();
        select_key();
        encrypt_decrypt_Algo();
        write_to_file(1);
        end_encrypt();
    }

    private void encrypt_decrypt_Algo(){
        for(int i = 0; i < content.length - 1; i++)
            content[i] = (char) (content[i] ^ this.key);
    }
    @Override
    public void Decrypt() {
        get_key_from_user();
        encrypt_decrypt_Algo();
        write_to_file(2);
    }
}
