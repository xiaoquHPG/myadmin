package com.quruiqi.myadmin.core.rest;

import com.quruiqi.myadmin.common.aop.log.Log;
import com.quruiqi.myadmin.core.security.AuthenticationToken;
import com.quruiqi.myadmin.core.security.AuthenticationUser;
import com.quruiqi.myadmin.core.security.JwtUser;
import com.quruiqi.myadmin.core.service.JwtUserDetailService;
import com.quruiqi.myadmin.core.util.EncryptUtils;
import com.quruiqi.myadmin.core.util.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * @Author Lenovo
 * @Date 2023/9/28 9:56
 **/
@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final JwtTokenUtils jwtTokenUtils;

    private final UserDetailsService userDetailsService;

    /**
     * 身份校验
     * @param authenticationUser
     * @return
     */
    @Log(description = "身份校验")
    @PostMapping(value = "${jwt.auth.path}")
    public ResponseEntity authenticationLogin(@RequestBody AuthenticationUser authenticationUser) {

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationUser.getUsername());

        if (!userDetails.getPassword().equals(EncryptUtils.encryptPassword(authenticationUser.getPassword()))) {
            throw new AccountExpiredException("密码错误");
        }

        if (!userDetails.isEnabled()) {
            throw new AccountExpiredException("账号已停用， 请联系管理员");
        }

        String token = jwtTokenUtils.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationToken(token));
    }

    @GetMapping(value = "${jwt.auth.account}")
    public ResponseEntity getUserInfo(HttpServletRequest request) {
        JwtUser jwtUser = (JwtUser) userDetailsService.loadUserByUsername(jwtTokenUtils.getUserName(request));
        return ResponseEntity.ok(jwtUser);
    }

}
