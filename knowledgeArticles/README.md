# To run applicaton
Type "mvn exec:java" to run application
To package and run the application, type "mvn package"

# Swagger Link 
http://localhost:8080/

# To create articles
curl -i -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d  '[{"title":"title","content": "content"}]' http://localhost:8080/cms/v1/articles

# To get all articles
$ curl http://localhost:8080/cms/v1/articles

# To update article
curl -i -X PUT -U role:ADMIN -H "Content-Type: application/json" -H "Accept: application/json" -d  '{"docId": 1,"title":"title","content": "content"}' http://localhost:8080/cms/v1/articles/article

# To detele article by Id
curl -i -X DELETE -U role:ADMIN -H "Content-Type: application/json" -H "Accept: application/json"  http://localhost:8080/cms/v1/articles/Ids/1

Note: Will refactor the code and will try with oAuth2 implementation too.
