package com.exhk.robot.order.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@Profile({"dev","test"})//只在开发和测试环境开启
public class SwaggerConfiguration extends WebMvcConfigurerAdapter implements EnvironmentAware {

	@Value("net.bit1.api.controller")
	private String basePackage;

	/**
	 * 这个地方要重新注入一下资源文件，不然不会注入资源的，也没有注入requestHandlerMappping,相当于xml配置的
	 *  <!--swagger资源配置-->
	 *  <mvc:resources location="classpath:/META-INF/resources/" mapping="swagger-ui.html"/>
	 *  <mvc:resources location="classpath:/META-INF/resources/webjars/" mapping="/webjars/**"/>
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars*")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}


	
	@Bean
	public Docket createRestApi() {
        List<Parameter> pars = new ArrayList<Parameter>();
        ParameterBuilder authorization = new ParameterBuilder().name("Authorization");

        authorization.modelRef(new ModelRef("string")).parameterType("header").required(false).build();

		pars.add(authorization.build());

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(basePackage))
				.paths(PathSelectors.any()).build().globalOperationParameters(pars);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("bit1 java API")
				.description("在必须要登录的接口中需增加Authorization参数。")
				.contact("bit1技术部").version("1.0").build();
	}

	@Override
	public void setEnvironment(Environment environment) {

	}
}
