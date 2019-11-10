package com.telusko.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })

@ComponentScan({"com.telusko.service","com.telusko.dao","com.telusko.model","com.telusko.demo"})//to scan repository files

@EntityScan({"com.telusko.dao.UserDao","com.telusko.dao.MemberDao","com.telusko.model.Member","com.telusko.dao.AuthenticateDao","com.telusko.model.Authenticate","com.telusko.dao.BookDao"
	,"com.telusko.model.Book","com.telusko.dao.BookInfoDao","com.telusko.model.BookInfo","com.telusko.model.Issue","com.telusko.model.Reserve","com.telusko.model.Return","com.telusko.dao.ReserveDao"
	,"com.telusko.dao.ReturnDao","com.telusko.dao.IssueDao"})

//@EnableJpaRepositories("com.example.repositories")
public class MyWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyWebAppApplication.class, args);
	}

}
