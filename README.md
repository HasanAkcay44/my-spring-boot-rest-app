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

![PostMapping-Body](https://github.com/HasanAkcay44/my-spring-boot-rest-app/assets/122037183/f863c040-0054-4e24-be06-f4999cb4b87d)

### lokale mysql Server & Dependencies
1. Installiere [MySQL & Workbench](https://dev.mysql.com/downloads/installer/)
2. Erstelle in MySQL Workbench die Datenbank `todoapp`
3. Gehe auf [start.spring](https://start.spring.io/) wähle Project `Maven` aus und füge bei Dependencies `Spring Web`, `Spring Data JPA` und `MySQL Driver` ein.
4. Klicke auf EXPLORE und gehe in `pom.xml` und kopiere die nötigen dependencys in dein Projekt rein.

### GET-Request Resolutat aus MySQL
```java
  @GetMapping("/todo")
    public ResponseEntity<Todo> get(@RequestParam(value = "id") int id){
        // get todo from db by id
        Optional<Todo> todoInDb = todoRepository.findById(id);

        if(todoInDb.isPresent()){
            return new ResponseEntity<Todo>(todoInDb.get(), HttpStatus.OK);
        }

        return new ResponseEntity("No todo found with id " + id, HttpStatus.NOT_FOUND);
    }
```
![GetId1](https://github.com/HasanAkcay44/my-spring-boot-rest-app/assets/122037183/13d554c9-8cae-4717-9702-7640fbefca82)

### User speichern

![CreateUserwithouttodos](https://github.com/HasanAkcay44/my-spring-boot-rest-app/assets/122037183/b7b9bfd3-bcc0-4294-b9b3-a524ac76c54a)

### Todos von User

![getUsertodos](https://github.com/HasanAkcay44/my-spring-boot-rest-app/assets/122037183/16083e41-19ba-4992-9b7d-f62a0c4f5021)
