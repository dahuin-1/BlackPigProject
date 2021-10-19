package com.huineey.blackpigproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;

@Configuration
public class SocialConfig {

    @Bean
    public GoogleConnectionFactory connectionFactory() {
        return new GoogleConnectionFactory("1005769212578-sagsuujgoisaih1j0c4vrlt3la6dj564.apps.googleusercontent.com",
                "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");
    }

    @Bean
    public OAuth2Parameters auth2Parameters(){
        OAuth2Parameters googleauth2Parameter = new OAuth2Parameters();
        googleauth2Parameter.setRedirectUri("http://localhost:8080/google/callback");
        googleauth2Parameter.setScope("https://www.googleapis.com/auth/plus.login");
        return googleauth2Parameter;
    }

}
