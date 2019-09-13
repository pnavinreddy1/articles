# To run applicaton
Type "mvn exec:java" to run application.
To package and run the application, type "mvn package"

# Swagger Link 
http://localhost:8080/

# To create articles
curl -X POST "http://localhost:8080/cms/v1/articles" -H "accept: application/json" -H "Authorization: adsds" -H "Content-Type: application/json" -d "[ { \"docId\": \"string\", \"title\": \"string\", \"content\": \"string\" }]"

# To get all articles
$ curl -X GET "http://localhost:8080/cms/v1/articles" -H "accept: application/json" -H "Authorization: ewrfd34"

# To update article
curl -X PUT "http://localhost:8080/cms/v1/articles/article" -H "accept: application/json" -H "Authorization: sadsa" -H "role: ADMIN" -H "Content-Type: application/json" -d "{ \"docId\": \"string\", \"title\": \"string\", \"content\": \"string\"}"

# To get article by Title
curl -X GET "http://localhost:8080/cms/v1/articles/Titles/title" -H "accept: application/json" -H "Authorization: asdas"

# To detele article by Title
curl -X DELETE "http://localhost:8080/cms/v1/articles/Titles/title" -H "accept: application/json" -H "Authorization: adsas" -H "role: ADMIN"

# To get Token
curl -X POST "http://localhost:8080/cms/v1/token" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"userName\": \"string\", \"id\": 0, \"role\": \"string\"}"

Note: Will refactor the code and will try with oAuth2 implementation too.
