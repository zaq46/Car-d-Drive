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
        registry.addViewController("/homepage").setViewName("homepage");
        registry.addViewController("/vehicleEntry").setViewName("vehicleEntry");
        registry.addViewController("/carEntry").setViewName("carEntry");
        registry.addViewController("/truckEntry").setViewName("truckEntry");
        registry.addViewController("/motorcycleEntry").setViewName("motorcycleEntry");
        registry.addViewController("/evEntry").setViewName("evEntry");
    }

}