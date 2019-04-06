package me.study.silang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter {

    @Value("${project-path}")
    public String projectPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry){
//        resourceHandlerRegistry.addResourceHandler("**/**/default.jpg").addResourceLocations("classpath:/static/");
//        resourceHandlerRegistry.addResourceHandler("img/**/default.jpg").addResourceLocations("classpath:/static/");

        resourceHandlerRegistry.addResourceHandler("**/**.mp4").addResourceLocations("file:"+projectPath+"mp4\\");
        resourceHandlerRegistry.addResourceHandler("**/**.jpg").addResourceLocations("file:"+projectPath+"jpg\\");

    }
}
