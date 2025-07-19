package org.example.novproductservice.Service;

import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerProperties;

public interface UserService {
    public OAuth2AuthorizationServerProperties.Token login(String email, String password);

    public User signUp(String name, String email, String password);

    public User validateToken(String tokenValue);

    public void logout(String tokenValue);
}