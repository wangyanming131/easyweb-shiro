package com.wf.ew;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * war包方式部署,修改4:修改启动类，并重写初始化方法
 * 我们需要类似于web.xml的配置方式来启动spring上下文了,在Application类的同级添加一个SpringBootStartApplication类
 * 打成war包方式部署,需要创建当前类
 * 修改启动类,继承 SpringBootServletInitializer 并重写 configure 方法
 */
public class EasyWebWarStartApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(EasyWebApplication.class);
    }
}
