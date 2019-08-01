package com.brs.oa.comm.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.brs.oa.model.LoginUser;
import com.brs.oa.model.Permission;
import com.brs.oa.util.CommonUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JwtSupport {
    private static final long EXPIRE_TIME = 6*60*1000;

    public static Map<String,String> genereateToken(LoginUser loginUser){
        Map<String,String> map = new HashMap<>(1);
        map.put("token",sign(loginUser));
        return map;
    }
    public static String sign(LoginUser loginUser){
        Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
        List<Permission> permissions = loginUser.getPermissions();

        Algorithm algorithm = Algorithm.HMAC256(getSecret());
        return JWT.create()
                .withClaim("userCode", loginUser.getCode())
                .withArrayClaim("menuURIs", CommonUtil.getPermissionUrI(permissions, "menu"))
                .withArrayClaim("permissionURIs", CommonUtil.getPermissionUrI(permissions,"permission" ))
                .withArrayClaim("permissionCodes", CommonUtil.getPermissionCode(permissions))
                .withExpiresAt(date).sign(algorithm);
    }

    public static Boolean verify(String token,String userCode){
        try {
            Algorithm algorithm = Algorithm.HMAC256(getSecret());
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("userCode", userCode)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            Date date =jwt.getExpiresAt();


            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    //制定秘钥
    public static String  getSecret(){
        return "tiny";
    }



    public static Date getExpireTime(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getExpiresAt();

        } catch (JWTDecodeException e) {
            return null;
        }
    }
    public static String getUserCode(String token,String key) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(key).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
    public static String[] getArray(String token, String key) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(key).asArray(String.class);
        } catch (JWTDecodeException e) {
            return null;
        }
    }

}
