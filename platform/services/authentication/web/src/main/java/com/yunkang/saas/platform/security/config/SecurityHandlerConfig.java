package com.yunkang.saas.platform.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunkang.saas.platform.security.config.oauth2.RestAuthenticationFailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.exceptions.*;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author owen 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51
 */
@Configuration
public class SecurityHandlerConfig {

    /**
     * springmvc启动时自动装配json处理类
     */
    @Resource
    private ObjectMapper objectMapper;

    /**
     * 登陆成功，返回Token 装配此bean不支持授权码模式
     *
     * @return
     */
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication) throws IOException, ServletException {
                super.onAuthenticationSuccess(request, response, authentication);
            }
        };
    }

    /**
     * 登陆失败
     *
     * @return
     */
    @Bean
    public AuthenticationFailureHandler loginFailureHandler() {
//        return new AuthenticationFailureHandler() {
//
//            @Override
//            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//                                                AuthenticationException exception) throws IOException, ServletException {
//                String msg;
//                if (exception instanceof BadCredentialsException) {
//                    msg = "密码错误";
//                } else {
//                    msg = exception.getMessage();
//                }
//
//                Map<String, String> rsp = new HashMap<>();
//
//                response.setStatus(HttpStatus.UNAUTHORIZED.value());
//
//                rsp.put("resp_code", HttpStatus.UNAUTHORIZED.value() + "");
//                rsp.put("rsp_msg", msg);
//
//                response.setContentType("application/json;charset=UTF-8");
//                response.getWriter().write(objectMapper.writeValueAsString(rsp));
//                response.getWriter().flush();
//                response.getWriter().close();
//
//            }
//        };
        return new RestAuthenticationFailureHandler();

    }


    @Bean
    public WebResponseExceptionTranslator webResponseExceptionTranslator() {
        return new DefaultWebResponseExceptionTranslator() {

            public static final String BAD_MSG = "Bad credentials";

            @Override
            public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
                OAuth2Exception oAuth2Exception;
                if (e.getMessage() != null && e.getMessage().equals(BAD_MSG)) {
                    oAuth2Exception = new InvalidGrantException("用户名或密码错误", e);
                } else if (e instanceof InternalAuthenticationServiceException) {
                    oAuth2Exception = new InvalidGrantException(e.getMessage(), e);
                } else if (e instanceof RedirectMismatchException) {
                    oAuth2Exception = new InvalidGrantException(e.getMessage(), e);
                } else if (e instanceof InvalidScopeException) {
                    oAuth2Exception = new InvalidGrantException(e.getMessage(), e);
                } else {
                    oAuth2Exception = new UnsupportedResponseTypeException("服务内部错误", e);
                }

                ResponseEntity<OAuth2Exception> response = super.translate(oAuth2Exception);
                ResponseEntity.status(oAuth2Exception.getHttpErrorCode());
                response.getBody().addAdditionalInformation("resp_code", oAuth2Exception.getHttpErrorCode() + "");
                response.getBody().addAdditionalInformation("resp_msg", oAuth2Exception.getMessage());

                return response;
            }
        };
    }

}
