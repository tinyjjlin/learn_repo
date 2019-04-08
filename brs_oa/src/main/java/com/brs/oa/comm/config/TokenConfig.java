package com.brs.oa.comm.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


/**
 * @author tiny lin
 * @date 2018/12/5
 */
@Configuration
@Data
public class TokenConfig {

    @Value("${token.secret}")
    private String secret;

    @Value("${token.request-header}")
    private String headerKey;

    @Value("${token.claim.login-name}")
    private String loginNameKey;
    @Value("${token.claim.emp-no}")
    private String empNoKey;

    @Value("${token.expire-time-minute}")
    private int expireTimeKey;

}
