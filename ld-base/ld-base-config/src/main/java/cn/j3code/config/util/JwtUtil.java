package cn.j3code.config.util;

import cn.j3code.config.exception.BldException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-30 17:46
 **/
@Slf4j
public class JwtUtil {

    /**
     * 密钥
     */
    private static final String SECRET = "lyj";

    /**
     * 过期时间 (单位为秒)
     * 2 * 24 * 60 * 60L
     **/
    private static final Long EXPIRATION = 2 * 24 * 60 * 60L;

    /**
     * 生成用户token,设置token超时时间
     */
    public static String createToken(Map<String, Object> data) {
        //过期时间
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRATION * 1000);
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        JWTCreator.Builder builder = JWT.create()
                // 添加头部
                .withHeader(map);
        //可以将基本信息放到claims中
        data.forEach((key, value) -> builder.withClaim(key, value.toString()));

        return builder
                //超时设置,设置过期的日期
                .withExpiresAt(expireDate)
                //签发时间
                .withIssuedAt(new Date())
                //SECRET加密
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 校验token并解析token
     */
    public static Map<String, Object> verifyToken(String token) {
        Map<String, Object> data = new HashMap<>();
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            DecodedJWT jwt = verifier.verify(token);
            jwt.getClaims().forEach((key, value) -> data.put(key, value.asString()));
        } catch (TokenExpiredException e) {
            log.error("token 过期, {}", e.getMessage());
            throw new BldException("token 过期！");
        } catch (Exception e) {
            log.error("token 解码异常:", e);
            throw new BldException("非法 token！");
        }
        return data;
    }


    public static void main(String[] args) {
        String token = JwtUtil.createToken(Map.of("name", "J3"));
        System.out.println(token);
        Map<String, Object> stringObjectMap = JwtUtil.verifyToken(token);
        System.out.println(stringObjectMap);
    }
}