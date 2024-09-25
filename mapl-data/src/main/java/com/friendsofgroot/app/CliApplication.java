package com.friendsofgroot.app;

import java.io.IOException;
import java.sql.SQLException;

import com.friendsofgroot.app.config.logger.LoggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ServletComponentScan("com.friendsofgroot.app")
//@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.friendsofgroot.app.repositories")
@EntityScan("com.friendsofgroot.app.models")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CliApplication {
    private static final Logger log;

    static {
        log = LoggerFactory.getLogger(CliApplication.class);
    }

    public static void main(String[] args) { //throws IOException, SQLException, ClassNotFoundException, InterruptedException {
        log.info("INSIDE ____log.info________CliApplication.main()");
        ApplicationContext ctx = SpringApplication.run(CliApplication.class, args);

        logBeans(ctx);


    }

    @Profile(value = {"!production"})
    private static void logBeans(ApplicationContext ctx) {
        log.info("logbeans ____dev____XXXXXX");
        log.info("****log.info*** Bean Count *******");
        log.info(String.valueOf(ctx.getBeanDefinitionCount()));
        log.info("***log.info**** Class Loader *******");
        log.info(ctx.getClassLoader().toString());
        log.info("***log.info**** Environment *******");
//		log.info(ctx.getEnvironment());
        System.out.println("******* Application Name *******");
        log.info(ctx.getApplicationName());
        LoggerImpl.loggerInstance(new String[]{"CliApplication.main()"});
//		for (String name : ctx.getBeanDefinitionNames()){
//			log.info(name);
//		}
    }


}
