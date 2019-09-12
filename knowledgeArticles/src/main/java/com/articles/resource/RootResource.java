package com.articles.resource;

import io.swagger.annotations.Api;

import javax.ws.rs.Path;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;

import org.springframework.stereotype.Component;

@Component
@Path("/v1")
@Api(value = "KnowledgeBase Article APIs", produces = "application/json")
public class RootResource {

	@Context
	ResourceContext resourceContext;
	
	@Path("/articles")
	public ArticlesBaseResource getArticlesBaseResource() {
		return resourceContext.getResource(ArticlesBaseResource.class);
	}
	
	
}
