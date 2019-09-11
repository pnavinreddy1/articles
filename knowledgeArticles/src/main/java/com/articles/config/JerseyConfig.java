package com.articles.config;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.articles.resource.RootResource;

@Component
@ApplicationPath("/cms")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
    	registerEndpoints();
//        BeanConfig swaggerConfig = new BeanConfig();
//        swaggerConfig.setSchemes(new String[]{"http"});
//        swaggerConfig.setHost("localhost:8080");
//        swaggerConfig.setBasePath("/cms");
//        
//        swaggerConfig.setResourcePackage(RootResource.class.getPackage().getName());
//        SwaggerConfigLocator.getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);
//                  
//        packages(getClass().getPackage().getName(),
//                ApiListingResource.class.getPackage().getName());
    }
    private void registerEndpoints() {
    	register(SecurityFilter.class);
//    	register(SwaggerConfiguration.class);
        register(RootResource.class);
        
    }
}