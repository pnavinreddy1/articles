# To run applicaton
Updated pom.xml with exec maven plugin so to run the application, type mvn package

# Swagger Link 
http://localhost:8080/ or http://localhost:8080/swagger-ui.html

# To create articles
curl -i -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d  '[{"title":"title","content": "content"}]' http://localhost:8080/cms/v1/articles

# To get all articles
$ curl http://localhost:8080/cms/v1/articles

# To update article
curl -i -X PUT -U admin:password -H "Content-Type: application/json" -H "Accept: application/json" -d  '{"docId": 1,"title":"title","content": "content"}' http://localhost:8080/cms/v1/articles/article

# To detele article by Id
curl -i -X DELETE -U admin:password -H "Content-Type: application/json" -H "Accept: application/json"  http://localhost:8080/cms/v1/articles/Ids/1


Note: Removed basic security feature. Will update with oAuth2 implementation and refactor.
