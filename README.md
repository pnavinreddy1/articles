# To run applicaton
From project folder \git\articles\knowledgeArticles\
To build application, run 'mvn clean package'
To run application, run 'java -jar target\articles-0.0.1-SNAPSHOT.jar' 


# To create articles
curl -i -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d  '[{"title":"title","content": "content"}]' http://localhost:8080/cms/v1/articles

# To get all articles
$ curl http://localhost:8080/cms/v1/articles

# To update article ( only put method has security and should pass admin as user )
curl -i -X PUT -U admin:password -H "Content-Type: application/json" -H "Accept: application/json" -d  '[{"title":"title","content": "content"}]' http://localhost:8080/cms/v1/articles/article

# To detele article by Id
curl -i -X DELETE -U admin:password -H "Content-Type: application/json" -H "Accept: application/json"  http://localhost:8080/v1/articles/Ids/1


Note: Swagger is not yet implemented and currently its not working.
