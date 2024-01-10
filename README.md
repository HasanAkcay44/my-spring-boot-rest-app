# my-spring-boot-rest-app
Eine keine Spring Boot RESTful App

### Generierung der Projektstruktur
Bei [start.spring](https://start.spring.io/) habe ich die Projektstruktur erstellt.

### System Vorbereiten
Installiere [JDK](https://www.oracle.com/de/java/technologies/downloads/#jdk21-windows) und [Downloading Apache Maven](https://maven.apache.org/download.cgi) und füge sie in Systemvariabeln ein.
- Bei `JAVA_Home` füge JDK-Verzeichnis hinzu
- Bei `path` bin-verzeichnis von Apache Maven hinzufügen

### Projekt Bauen
Im Terminal `./mvnw spring-boot:run` eingeben, um das Projekt zu bauen und zu starten.

### Postman
Mit der Postman Anwendung können einfache http API anfragen an den lokal laufenden Server gesendet werden.
- Beispiel: `localhost:8080/greet` 
  - Ergebnis: `Hello World`

### JAR Datei erstellen und ausführen
In Terminal `./mvnw clean package` eingeben. Die JAR Datei landet im Porjekt Ordner im Verzeichnis `target`.
Um die JAR Datei zu starten gebe in das Terminal `java -jar target/my-spring-boot-rest-app-0.0.1-SNAPSHOT.jar`, dabei startet startet der Tomcat Server und es können http Anfragen an den Server versendet werden.

### http request mit Parameter
`localhost:8080/greet?name=Max`
- `name` ist in diesem Fall der Key
-  `Max` ist der Wert(value)

-  Code Beispiel:
```java
 @GetMapping("/greet")
    public String hello(@RequestParam(value = "name") String name){
        return "Hello World " + name;
    }
```

### JSON in Body
```java
 @PostMapping("/todo")
    public ResponseEntity<Todo> create(@RequestBody Todo newTodo){
        // save todo in db
        return new ResponseEntity<Todo>(newTodo, HttpStatus.OK);
    }
```
![PostMapping-Body](https://github.com/HasanAkcay44/my-spring-boot-rest-app/assets/122037183/0c3089ef-0158-411c-8071-5299076aea23)



