package com.articles.resource;

import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.articles.domain.Article;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes({MediaType.APPLICATION_JSON})
public class ArticlesBaseResource {

	@Autowired
	private ArticleDataService dataService;
	
	@GET
	@PermitAll
	@ApiOperation(value = "To get all articles", produces = "application/json")
	public Response getAllArticles() {
		List<Article> getAllArticles = dataService.getAtricles();
		if(getAllArticles.isEmpty()) {
			return Response.status(Status.NOT_FOUND).entity("No Data exists").build();
		}
		GenericEntity<List<Article>> entity= new GenericEntity<List<Article>>(getAllArticles) {};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	@POST
	@PermitAll
	@ApiOperation(value = "To create list of articles", consumes = "application/json")
	public Response createArticles(@Valid @NotNull List<Article> articles ) {
		 List<Article> storedarticles = articles.stream()
				 .map(article->dataService.saveArticle(article))
				 .collect(Collectors.toList());
		GenericEntity<List<Article>> entity= new GenericEntity<List<Article>>(storedarticles) {};
		return Response.status(Status.CREATED).entity(entity).build();
	}
	
	@GET
	@Path("/Ids/{id:[0-9][0-9]*}")
	@PermitAll
	@ApiOperation(value = "To get specific article by Id", produces = "application/json")
	public Response getArticleById(@NotNull @PathParam("id") String id) {
		Article article = dataService.findAtricleById(Integer.parseInt(id));
		if(article.getTitle()==null || article.getTitle().isEmpty()) {
			return Response.status(Status.NOT_FOUND)
					.entity(String.format("Id: {%s} does not exists", id)).build();
		}
		GenericEntity<Article> entity= new GenericEntity<Article>(article) {};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	@PUT
	@Path("/article")
	@ApiOperation(value = "To update specific article", consumes = "application/json")
	@RolesAllowed("ADMIN")
	public Response updateArticle(@NotNull Article article) {
		Article updatedArticle = dataService.updateAtricle(article);
		if(updatedArticle.getTitle()==null || updatedArticle.getTitle().isEmpty()) {
			return Response.status(Status.BAD_REQUEST)
					.entity(String.format("Id: {%s} does not exists", article.getDocId())).build();
		}
		GenericEntity<Article> entity= new GenericEntity<Article>(updatedArticle) {};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	@DELETE
	@Path("/Ids/{id:[0-9][0-9]*}")
    @ApiOperation(value = "To delete article by Id", produces = "application/json")
	@RolesAllowed("ADMIN")
	public Response deleteArticleById(@NotNull @PathParam("id") String id) {
		boolean isDeleted = dataService.deleteAtricleById(Integer.parseInt(id));
		if(!isDeleted) {
			return Response.status(Status.BAD_REQUEST)
					.entity(String.format("Id: {%s} not deleted", id)).build();
		}
		GenericEntity<String> entity= new GenericEntity<String>(String.format("Id: {%s} deleted", id)) {};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	
	
}
