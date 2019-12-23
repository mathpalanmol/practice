package prac;


import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {
    private static final String ALGO = "AES";
    private Key key;
    private Cipher c;
    private static final byte[] KEYVALUE = new byte[] { 'A', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p' };

    public Encryption() {
        try {
            key = generateKey();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws Exception {
    	Encryption obj = new Encryption();
    	String json = "{\n" + 
    			"    \"amount\": 100,\n" + 
    			"    \"userId\": 1002025,\n" + 
    			"    \"channelId\": 1,\n" + 
    			"    \"paymentOption\": \"LAXMIVILASBANK_CARD\",\n" + 
    			"    \"paymentMode\": \"DEBITCARD\",\n" + 
    			"    \"merchantId\": \"RUMMY\",\n" + 
    			"    \"gateway\": \"BILLDESK\"\n" + 
    			"}";
    String requestBody = obj.encrypt(json);
    System.out.println("requestBody: " + requestBody);
	}
    
    private Key generateKey() throws Exception {
        /*
         * ClassLoader classLoader = getClass().getClassLoader();
         * InputStreamReader ip = new
         * InputStreamReader(classLoader.getResourceAsStream("keyfile.bin"));
         * byte[] bFile = IOUtils.toByteArray(ip);
         */
        Key key = new SecretKeySpec(KEYVALUE, ALGO);
        return key;
    }

    public  String encrypt(String data) throws Exception {
        c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        String encryptedValue = new String(Base64.getEncoder().encode(encVal));
        return encryptedValue;

    }

    public String decrypt(String encryptedData) throws Exception {
        c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);

        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
}