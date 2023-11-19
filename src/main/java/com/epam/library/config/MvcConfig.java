//package com.epam.library.config;
//
//import com.epam.library.interceptor.AuthorizationInterceptor;
//import com.epam.library.interceptor.PasswordValidationInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class MvcConfig implements WebMvcConfigurer {
//
//    @Bean
//    public PasswordValidationInterceptor passwordValidationInterceptor() {
//        return new PasswordValidationInterceptor();
//    }
//
//    @Bean
//    public AuthorizationInterceptor authorizationInterceptor() {
//        return new AuthorizationInterceptor();
//    }
//
////    @Bean
////    public UsernameValidationInterceptor usernameValidationInterceptor() {
////        return new UsernameValidationInterceptor();
////    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(passwordValidationInterceptor())
//                .addPathPatterns("/my-account/*")
//                .addPathPatterns("/register");
//    }
//}