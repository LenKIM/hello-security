import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class MainTest {

    //TODO java-jwt 랑 jjwt 의 차이점은 뭐지??
    //TODO  JSON Web Algorithms (JWA) specification (RFC7518)
    //TODO For example, when using HMAC256, the secret key length must be a minimum of 256 bits.
    @Test
    void name() {

        //HMAC
        Algorithm algorithmHS = Algorithm.HMAC256("secret");

        //RSA
//        RSAPublicKey publicKey = null;
//        RSAPrivateKey privateKey = //Get the key instance
//        Algorithm algorithmRS = Algorithm.RSA256(publicKey, privateKey);

    }

    @Test
    void createAndSignAToken() {
        // HS256
        final Algorithm algorithm = Algorithm.HMAC256("secret");
        String token = JWT.create()
                .withIssuer("autoO")
                .withAudience("AAA")
                .sign(algorithm);

        System.out.println(token);

        final DecodedJWT decode = JWT.decode(token);
        decode.getHeader();
    }
}
