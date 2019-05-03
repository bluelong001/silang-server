package me.study.silang.config;

import me.study.silang.filter.JWTFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;

@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter {

    @Value("${project-path}")
    public String projectPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
//        resourceHandlerRegistry.addResourceHandler("**/**/default.jpg").addResourceLocations("classpath:/static/");
//        resourceHandlerRegistry.addResourceHandler("img/**/default.jpg").addResourceLocations("classpath:/static/");

        resourceHandlerRegistry.addResourceHandler("**/**.mp4").addResourceLocations("file:" + projectPath + File.separator + "mp4" + File.separator);

        resourceHandlerRegistry.addResourceHandler("**/**.jpg").addResourceLocations("file:" + projectPath + File.separator + "jpg" + File.separator)
                .addResourceLocations("file:" + projectPath + File.separator + "mp4" + File.separator);

    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authenticationInterceptor())
//                .addPathPatterns("/**").excludePathPatterns("**/**.mp4").excludePathPatterns("**/**.jpg").excludePathPatterns("api/user/add").excludePathPatterns("api/login");
//    }
//
//    @Bean
//    public JWTFilter authenticationInterceptor() {
//        return new JWTFilter();
//    }
}
