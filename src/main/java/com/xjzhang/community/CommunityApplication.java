package com.xjzhang.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author xjzhang
 */
@SpringBootApplication
public class CommunityApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
    }

    //这里配置静态资源文件的路径导包都是默认的直接导入就可以
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
        super.addResourceHandlers(registry);
    }
}
