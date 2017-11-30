package com.gome.lark.role.auth;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by liuhui-ds9 on 2017/11/30.
 */
public class JwtToken implements AuthenticationToken {
    private String token;

    public JwtToken(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
