package yb.upc.edu.cn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.FileSystemUtils;
import yb.upc.edu.cn.controller.PublishController;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class SecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondApplication.class, args);
	}
}
