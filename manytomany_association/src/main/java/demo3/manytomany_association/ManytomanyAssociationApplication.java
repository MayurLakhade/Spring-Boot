package demo3.manytomany_association;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/*
 * student-  id name age course
 * course- id courseName fees
 *  one student can enroll for many couses
 * many students can enroll for 1 course
 * many students can enroll for many courses
 * one student can enroll for one course
 * 
 * 
 * 
 * @JoinColumn Annotation
 * In a One-To-Many/Many-to-One relationship, the owning side
 * 
 * mappedBy Attribute
 * 
 * @ManyToMany
 * @
 * 
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ManytomanyAssociationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManytomanyAssociationApplication.class, args);
		
	}

}
