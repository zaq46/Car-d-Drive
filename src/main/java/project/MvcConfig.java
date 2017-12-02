package project;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/signup").setViewName("customerSignup");
        registry.addViewController("/employeeSignup").setViewName("employeeSignup");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("index");
        registry.addViewController("/bam").setViewName("bam");
        registry.addViewController("/search").setViewName("search");
        registry.addViewController("/main").setViewName("main");
    }

}