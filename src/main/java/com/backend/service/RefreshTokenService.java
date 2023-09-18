package com.backend.service;

import com.backend.entity.RefreshToken;
import com.backend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;

@Service
public class RefreshTokenService {
    
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JwtService jwtService;


//    private static final String REFRESH_TOKEN_COOKIE_NAME = "refreshToken";
//
    private static final int REFRESH_TOKEN_EXPIRATION_TIME_SECONDS = 864000;

    public RefreshToken createRefreshToken(String username,HttpServletResponse response) {
        String refreshToken = jwtService.generateRefreshToken(username);
        Instant expiryDate = Instant.now().plusSeconds(REFRESH_TOKEN_EXPIRATION_TIME_SECONDS);

        setRefreshTokenCookie(refreshToken,response);

        return RefreshToken.builder()
                .token(refreshToken)
                .expiryDate(expiryDate)
                .build();
    }

    private void setRefreshTokenCookie(String refreshToken,HttpServletResponse response) {
        Cookie cookie = new Cookie("refreshToken", refreshToken);
        cookie.setHttpOnly(false);
        cookie.setMaxAge(REFRESH_TOKEN_EXPIRATION_TIME_SECONDS);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    public String getRefreshTokenFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("refreshToken".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

}