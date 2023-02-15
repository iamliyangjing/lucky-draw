package cn.j3code.ldwallet;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "cn.j3code.ldwallet.mapper")
public class LdWalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(LdWalletApplication.class, args);
    }

}
