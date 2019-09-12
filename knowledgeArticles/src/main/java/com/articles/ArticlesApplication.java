package com.articles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ArticlesApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ArticlesApplication.class, args);
	}

	@Bean
	public Docket documentation() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())
				.build().enable(true).apiInfo(metadata());
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("KnowledgeBase Articles Center") //$NON-NLS-1$
				.description("CMS system") //$NON-NLS-1$
				.version("1.1.6") //$NON-NLS-1$
				.build();
	}

}
