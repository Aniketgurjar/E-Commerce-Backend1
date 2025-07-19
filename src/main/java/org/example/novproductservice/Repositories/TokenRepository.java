package org.example.novproductservice.Repositories;

import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<OAuth2AuthorizationServerProperties.Token, Long> {

    Optional<OAuth2AuthorizationServerProperties.Token> findByValueAndExpiryDateTimeGreaterThan(String tokenValue,
                                                                                                LocalDateTime localDateTime);
}