# To run applicaton
Updated pom.xml with exec maven plugin to run the application

do 'mvn clean package'
then run 'mvn spring-boot::run' from project folder \git\articles\knowledgeArticles\


# To create articles
curl -i -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d  '[{"title":"title","content": "content"}]' http://localhost:8080/cms/v1/articles

# To get all articles
$ curl http://localhost:8080/cms/v1/articles

# To update article
curl -i -X PUT -U admin:password -H "Content-Type: application/json" -H "Accept: application/json" -d  '{"docId": 1,"title":"title","content": "content"}' http://localhost:8080/cms/v1/articles/article

# To detele article by Id
curl -i -X DELETE -U admin:password -H "Content-Type: application/json" -H "Accept: application/json"  http://localhost:8080/cms/v1/articles/Ids/1


Note: Swagger is not yet implemented and currently its not working.
