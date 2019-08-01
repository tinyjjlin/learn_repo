package com.brs.oa.comm.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.brs.oa.model.LoginUser;
import com.brs.oa.model.Permission;
import com.brs.oa.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JWTUtil {
    static final Logger LOG = LoggerFactory.getLogger(JWTUtil.class);

    private static final long EXPIRE_TIME = 6*60*1000;

    public static boolean verify(String token, String username, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
           
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    public static String sign(String username, String secret) {
        Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        // 附带username信息
        return JWT.create()
                .withClaim("username", username)
                .withExpiresAt(date)
                .sign(algorithm);
    }


    public static Map<String,String> genereateToken(LoginUser loginUser){
        Map<String,String> map = new HashMap <>(1);
        map.put("token",sign2(loginUser));
        return map;
    }
    public static String sign2(LoginUser loginUser){
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





    /**
     * generate jwt token
     * @param tokenClaim
     * @return
     */
    public static String sign(TokenClaim tokenClaim){
        Algorithm algorithm = Algorithm.HMAC256(getSecret());
        return JWT.create()
                .withClaim("userId", tokenClaim.getUserId())
                .withArrayClaim("userRoles", tokenClaim.getUserRoles())
                .withArrayClaim("userPermissions", tokenClaim.getUserPermissions())
                .withExpiresAt(tokenClaim.getExpireTime()).sign(algorithm);
    }

    //制定秘钥
    public static String  getSecret(){
        return "tiny";
    }


    /**
     * 验证token 是否合法
     * @param token
     * @param userId
     * @return
     */
    public static Boolean verify(String token,Integer userId){
        try {
            Algorithm algorithm = Algorithm.HMAC256(getSecret());
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("userId", userId)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            Date date =jwt.getExpiresAt();


            return true;
        } catch (Exception exception) {
            return false;
        }
    }



    public static Date getExpireTime(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getExpiresAt();

        } catch (JWTDecodeException e) {
            return null;
        }
    }
    public static Integer getUserId(String token,String key) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(key).asInt();
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

    public static void main(String[]args){
        TokenClaim tokenClaim = new TokenClaim();
        tokenClaim.setUserId(100057);

         tokenClaim.setUserRoles(new String[]{"admin", "IT manager"});
         tokenClaim.setUserPermissions(new String[]{"view","edit","add"});

        Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
        tokenClaim.setExpireTime(date);

        String token =sign(tokenClaim);
        LOG.info("token------>"+token);
        Integer userId = getUserId(token,"userId");
        String[] userRoles = getArray(token,"userRoles" );
        String[] userPermissions = getArray(token,"userPermissions" );
        LOG.info("token claim-->"+userId+"==="+userRoles.length+"======="+userPermissions.length+"=="+getExpireTime(token));
        boolean result = verify(token,100057);
        LOG.info("result===>"+result);
    }




}
