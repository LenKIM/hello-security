import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {


    public static void main(String[] args) {

    }

    @BeforeAll
    static void beforeAll() throws NoSuchAlgorithmException, InvalidKeySpecException {
        final KeyFactory keyPairGenerator = KeyFactory.getInstance("EC");
        ECPublicKey EC_PUBLIC_KEY = (ECPublicKey) keyPairGenerator.generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE45iEJwi+OH+2VSqCiPPVdhiTfc9C57M4OL6cozZ5WMBSZD+2xYjE7Swt5OWuX08gS6xoyVdad5V5X3+ctpzP2Q==")));
        ECPrivateKey EC_PRIVATE_KEY = (ECPrivateKey) keyPairGenerator.generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode("MEECAQAwEwYHKoZIzj0CAQYIKoZIzj0DAQcEJzAlAgEBBCBKPHtVAMBu83pWcWsXfdq3ysEuB8GRG3oUSCqWUTgikA==")));;
    }

    @Test
    void pure_java_generateKeyPair() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        final KeyPairGenerator generator = KeyPairGenerator.getInstance("EC");
        generator.initialize(new ECGenParameterSpec("secp256r1"));

        final KeyPair keyPair = generator.generateKeyPair();
//        String s = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
//        System.out.println("keyPair.getPublic().getEncoded() | " + s);
//
//        String ss = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
//        System.out.println("keyPair.getPrivate().getEncoded() | " + ss);


    }
}
