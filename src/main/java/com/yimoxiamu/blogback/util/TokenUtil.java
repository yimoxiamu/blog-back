package com.yimoxiamu.blogback.util;

import io.jsonwebtoken.*;
import org.slf4j.Logger;

import java.util.Date;
import java.util.Map;

/**
 * @Description:  token工具类
 * @author: paw
 * @date: 2018/8/27 下午4:49
 * @version: V1.0
 */
public class TokenUtil {
    private static final String SECRET = "thisIsSecret";
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(TokenUtil.class);

    public static String getJWTString(String usrId, Map<String, Object> claims) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        String jwtString = Jwts.builder()
                .setSubject(usrId)
                .setClaims(claims)
                .setExpiration(DateUtil.getTokenFailureTime())
                .setIssuedAt(new Date())
                .signWith(signatureAlgorithm, SECRET)
                .compact();
        log.info("-----------------------------token过期时间为：[{}]--------------------------",DateUtil.getTokenFailureTime());
        return jwtString;
    }

    /**
     * 验证token数据是否正确
     *
     * @param token
     * @return
     */
    public static boolean isValid(String token) {
    	if(token != null) {
    		try {
                Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.trim());
                return true;
            }catch (ExpiredJwtException e){
                return false;
            }
            catch (Exception e) {
            	log.error("error:", e);
                return false;
            }
    	}
    	return false;
        
    }

    /**
     * 获取usrId
     * @param
     * @return
     */
    public static String getUserId() {
        String jwToken = RequestContextHolderUtils.getAuthorizationToken();
        if (isValid(jwToken)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwToken);
            String userId = String.valueOf(claimsJws.getBody().get("userid"));
            return userId;
        }
        return null;
    }

    /**
     * 获取userName
     * @param
     * @return
     */
    public static String getUserName() {
        String jwToken=RequestContextHolderUtils.getAuthorizationToken();
        if (isValid(jwToken)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwToken);
            String userName = String.valueOf(claimsJws.getBody().get("username"));
            return userName;
        }
        return null;
    }

    /**
     * 获取companyId
     * @param
     * @return
     */
    public static String getCompanyId() {
        String jwToken=RequestContextHolderUtils.getAuthorizationToken();
        if (isValid(jwToken)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwToken);
            String userName = String.valueOf(claimsJws.getBody().get("companyid"));
            return userName;
        }
        return null;
    }

    /**
     * 获取nickName
     * @param
     * @return
     */
    public static String getNickName() {
        String jwToken=RequestContextHolderUtils.getAuthorizationToken();
        if (isValid(jwToken)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwToken);
            String userName = String.valueOf(claimsJws.getBody().get("nickname"));
            return userName;
        }
        return null;
    }

}
