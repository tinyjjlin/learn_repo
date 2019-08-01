package com.beruosi.oav1.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.beruosi.oav1.exception.CustomException;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;


@Component
public class JwtSupport {

    public final static String ACCOUNT = "account";
    private static long accessTokenExpireTime=5 * 60 * 1000;
    private static String encryptJWTKey="U0JBUElKV1RkV2FuZzkyNjQ1NA==";
//    @Value("${accessTokenExpireTime}")
//    private static   String accessTokenExpireTime;
//    @Value("${encryptJWTKey}")
//    private static String encryptJWTKey;

    public static boolean verify(String token) {
        try {
            // 帐号加JWT私钥解密
            String secret = getClaim(token, ACCOUNT) + Base64ConvertUtil.decode(encryptJWTKey);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new CustomException("JWTToken认证解密出现UnsupportedEncodingException异常");
        }
    }


    public static String getClaim(String token, String claim) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            // 只能输出String类型，如果是其他类型返回null
            return jwt.getClaim(claim).asString();
        } catch (JWTDecodeException e) {
            e.printStackTrace();
            throw new CustomException("解密Token中的公共信息出现JWTDecodeException异常");
        }
    }
    public static String sign(String account, String currentTimeMillis) {

            // 帐号加JWT私钥加密
        String secret ;
        try {
            secret = account + Base64ConvertUtil.decode(encryptJWTKey);
            Date date = new Date(System.currentTimeMillis() + accessTokenExpireTime);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带account帐号信息
            return JWT.create()
                    .withClaim("account", account)
                    .withClaim("currentTimeMillis", currentTimeMillis)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            throw new CustomException("JWTToken加密出现UnsupportedEncodingException异常");
        }
    }
}
