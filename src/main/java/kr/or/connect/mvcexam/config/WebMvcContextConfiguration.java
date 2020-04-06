package kr.or.connect.mvcexam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "kr.or.connect.mvcexam.controller" })

//이 클래스는 디스패처 서블릿이 실행될때 읽어드리는 설정 파일이라고 보면 된다. 디스패처 서블릿을 설정하는 것
//디스패처 서블릿을 설정하는 클래스다!
// WebMvcConfigurerAdapter를 상속함
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter { 
  
    //css파일, img 파일, js 파일 등 스태틱 소스에 대한 요청 처리. 이 부분이 없으면 컨트롤러를 통해 해야함..
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) { 
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }
 
    // 매핑정보가 없는 url요청은  스프링의 default sevlet http request handler가 처리하도록 해준다. 
    // 스프링의 default servlet http request handler는 was의 defalut servlet에게 해당일을 넘긴다. 
    // was는 defalut servelt이 스태틱한 자원을 읽어서 보여주게 한다.

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
   
    // 특정 URL에 대한 처리를 Controller 클래스를 작성하지 않고 매핑할 수 있도록 해준다.
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
            System.out.println("addViewControllers가 호출됩니다. ");
        // "/" 라는 URL을 main.jsp로 매핑해준다.
        // main이라는 viewName은  아래의 viewResolver 라는 객체를 통해서 찾는다.
        // Prefix + "main" + Suffix -> /WEB-INF/views/main.jsp (아래 InternalResourceViewResolve 메서드를 보자)
        registry.addViewController("/").setViewName("main"); 
    }
    
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/"); 
        resolver.setSuffix(".jsp"); 
        return resolver;
    }
}