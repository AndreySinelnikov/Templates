import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.util.Enumeration;

public class ReadInstalledCertificatesFromJavaKeystore {

    public static void main(String[] args) {
        try {
            File file = new File("C:\\Program Files\\Java\\jdk1.8.0_301\\jre\\lib\\security\\cacerts");
            // File file = new File("C:\\Program Files\\Java\\jre1.8.0_301\\lib\\security\\cacerts");
            InputStream is = new FileInputStream(file);
            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            String password = "changeit"; // default password for keystore
            keystore.load(is, password.toCharArray());
            
            Enumeration<String> enumeration = keystore.aliases();
            while(enumeration.hasMoreElements()) {
                String alias = enumeration.nextElement();
                System.out.println("alias name: " + alias);
                Certificate certificate = keystore.getCertificate(alias);
                // System.out.println(certificate.toString());

            }

        } catch (java.security.cert.CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
