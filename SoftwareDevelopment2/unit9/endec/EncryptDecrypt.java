package endec;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

public class EncryptDecrypt {

    public static Encrypter getTransposeEncrypter() {
       return StringUtils::transposeChars;
    }

    public static Decrypter getTransposeDecrypter() {
        return StringUtils::transposeChars;
    }

    public static Encrypter getBase64Encrypter() {
        return new Encrypter() {
            @Override
            public String encrypt(String plainText) {
                Base64.Encoder encoder = Base64.getEncoder();
                String encryptedText = encoder.encodeToString(plainText.getBytes());
                return encryptedText;
            }
        };
    }

    public static Decrypter getBase64Decrypter() {
        return new Decrypter() {
            @Override
            public String decrypt(String encryptedText) {
                Base64.Decoder decoder = Base64.getDecoder();
                byte[] bytes = decoder.decode(encryptedText);
                String plainText = new String(bytes);
                return plainText;
            }
        };
    }

    public static Encrypter getSubstitutionEncrypter(){
        return (text) -> new SubstitutionEncryptorDecryptor().encrypt(text);
    }

    public static Decrypter getSubstitutionDecrypter() {
        return (text) -> new SubstitutionEncryptorDecryptor().decrypt(text);
    }

    public static void EncryptDecryptTest(Encrypter encrypter,Decrypter decrypter) {
        try {
            String plainText = "You miss 100 percent of the shots you never take.";
            String encryptedText = encrypter.encrypt(plainText);
            String decryptedText = decrypter.decrypt(encryptedText);
            System.out.println("Plain Text:     " + plainText);
            System.out.println("Encrypted Text: " + encryptedText);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
        }
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println("\nTranspose");
        EncryptDecryptTest(getTransposeEncrypter(),getTransposeDecrypter());

        System.out.println("\nBase64");
        EncryptDecryptTest(getBase64Encrypter(),getBase64Decrypter());

        System.out.println("\nSubstitution");
        EncryptDecryptTest(getSubstitutionEncrypter(),getSubstitutionDecrypter());

        System.out.println("\n\nAlice Small Below\n");

        List<String> lines = FileEncryptorDecryptor.getLines("data/alice_small.txt");

        Encrypter encrypter = EncryptDecrypt.getTransposeEncrypter();

        lines.stream().forEach(
            Encrypter -> System.out.println(encrypter.encrypt(Encrypter))
        );

        System.out.println("\n\nAlice 64 Decrypted Below\n");

        List<String> alice64Lines = FileEncryptorDecryptor.getLines("data/alice_small_base64.txt");

        Decrypter decrypter = EncryptDecrypt.getBase64Decrypter();

        alice64Lines.stream().forEach(
            Decrypter -> System.out.println(decrypter.decrypt(Decrypter))
        );

        List<String> aliceTransposeLines = FileEncryptorDecryptor.getLines("data/alice_small_transpose.txt");

        System.out.println("\n\nAlice Transpose Decrypted Below\n");

        Decrypter decrypter2 = EncryptDecrypt.getTransposeDecrypter();

        aliceTransposeLines.stream().forEach(
            Decrypter -> System.out.println(decrypter2.decrypt(Decrypter))
        );
        
        System.out.println("\n\nAlice Transpose Decrypted Below No Empty Lines\n");

        aliceTransposeLines.stream().filter(item -> item.length() != 0).forEach(
            Decrypter -> System.out.println(decrypter2.decrypt(Decrypter))
        );
    }
}
