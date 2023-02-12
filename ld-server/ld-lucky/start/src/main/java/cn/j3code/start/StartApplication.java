package cn.j3code.start;

import cn.j3code.config.util.FileLoad;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("cn.j3code")
@EnableScheduling
@EnableTransactionManagement
@MapperScan(basePackages = "cn.j3code.luckyinfrastructure.gateway.impl.mapper")
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
        System.out.println(FileLoad.read("lua\\stock_deduction.lua"));
    }

}
