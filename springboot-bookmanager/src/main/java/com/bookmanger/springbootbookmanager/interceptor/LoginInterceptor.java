package com.bookmanger.springbootbookmanager.interceptor;

import com.bookmanger.springbootbookmanager.common.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("Authorization");

        if(token!=null && token.startsWith("Bearer ")){
            token=token.substring(7);
        }

        if(token==null || token.isEmpty()){
            response.setStatus(401);
            return false;
        }

        Claims claims= JwtUtil.parseToken(token);
        if(claims==null){
            response.setStatus(401);
            return false;
        }

        Integer userId=claims.get("userId",Integer.class);
        request.setAttribute("userId",userId);

        return true;

    }
}
