/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package com.articles.config;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
public class SwaggerConfiguration implements SwaggerResourcesProvider {

    @Resource
    private InMemorySwaggerResourcesProvider inMemorySwaggerResourcesProvider;

    public List<SwaggerResource> get() {

        SwaggerResource jerseySwaggerResource = new SwaggerResource();
        jerseySwaggerResource.setLocation("/cms/swagger.json");
        jerseySwaggerResource.setSwaggerVersion("2.0");
        jerseySwaggerResource.setName("Articles");

        return Stream.concat(Stream.of(jerseySwaggerResource),
                inMemorySwaggerResourcesProvider.get().stream()).collect(Collectors.toList());
    }

}