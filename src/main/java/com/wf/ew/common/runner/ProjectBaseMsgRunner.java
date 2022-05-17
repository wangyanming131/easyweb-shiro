package com.wf.ew.common.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 系统启动完成,自动执行run方法
 */
@Component
@Order(1)
public class ProjectBaseMsgRunner implements ApplicationRunner {

    @Value("${server.servlet.context-path}")
    private String contextPath;

    /**
     * 端口
     */
    @Value("${server.port}")
    private String port;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 项目启动后执行该方法
        try {
            //系统启动时获取数据库数据，设置到公用静态集合sysSettingMap
            String ip = InetAddress.getLocalHost().getHostAddress();
            if (ip.equals("127.0.0.1") == false) {
                ip = "127.0.0.1";
            }
            //获取本机内网IP
            String address = "http://" + ip + ":" + port + contextPath;
            System.out.println("启动成功：" + address);
        } catch (UnknownHostException e) {
            //输出到日志文件中
        }
    }
}
