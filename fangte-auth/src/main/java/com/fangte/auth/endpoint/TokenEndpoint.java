package com.fangte.auth.endpoint;
/**
 * @ProjectName: fangte-cloud
 * @Package: com.fangte.auth.endpoint
 * @ClassName: TokenEndpoint
 * @Author: xuchao
 * @Description:
 * @Date: 2020/1/8 15:07
 * @Version: 1.0
 */

import com.fangte.fangte.common.constant.enums.CommonEnums;
import com.fangte.fangte.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @updateRemark
 * @author xuchao
 * @updateUser
 * @createDate 2020/1/8 15:07
 * @updateDate 2020/1/8 15:07     
 * @version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/token")
public class TokenEndpoint {

    @Autowired
    private TokenStore tokenStore;

    @DeleteMapping("/logout")
    public Result logout(@RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authHeader) {
        log.info("Logout  >>  ....");
        if (StringUtils.isBlank(authHeader)) {
            return new Result(CommonEnums.LOGOUT_ERROR);
        }
        String tokenValue = authHeader.replace(OAuth2AccessToken.BEARER_TYPE.toLowerCase(), "").trim();
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(tokenValue);
        if (oAuth2AccessToken == null || StringUtils.isBlank(oAuth2AccessToken.getValue())) {
            return new Result(CommonEnums.LOGOUT_ERROR);
        }
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return new Result();
    }
}
