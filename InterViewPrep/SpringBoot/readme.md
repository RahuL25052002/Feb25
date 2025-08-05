
# Spring Boot Interview Q&A

## Basic Spring Boot Interview Questions (1–5)

1.  **What is Spring Boot and how is it different from the Spring Framework?**  
    Spring Boot is an extension of the Spring Framework that simplifies bootstrapping and development of new Spring applications. It adopts “convention over configuration” and provides embedded servers (Tomcat/Jetty), auto-configuration, and starter dependencies, so you rarely need to write XML or boilerplate setup. In contrast, vanilla Spring requires you to manually configure components and servers. For example, Spring Boot auto-configures beans based on classpath contents, whereas plain Spring needs explicit bean definitions[codecademy.com](https://www.codecademy.com/learn/learn-spring-building-an-app/modules/boots-and-beans/cheatsheet#:~:text=Spring%20Boot)[pwskills.com](https://pwskills.com/blog/spring-boot-tutorial/#:~:text=1,different%20from%20the%20Spring%20Framework).
    
    java
    
    CopyEdit
    
    `@SpringBootApplication  public  class  MyApp { public  static  void  main(String[] args) {
            SpringApplication.run(MyApp.class, args);
        }
    }` 
    
    _Spring Boot’s `@SpringBootApplication` (which combines @Configuration, @EnableAutoConfiguration, @ComponentScan) makes an app ready to run with minimal setup[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/spring-boot-interview-questions-and-answers/#:~:text=,generic%20annotation%20for%20any%20Spring)[codeinterview.io](https://codeinterview.io/interview-questions/spring-boot-questions-answers#:~:text=import%20org)._
    
2.  **What are the main features of Spring Boot?**  
    Spring Boot’s key features include:
    
    -   **Auto-configuration**: Automatically configures beans based on classpath dependencies, so many components (data sources, MVC, etc.) work out-of-the-box[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/spring-boot-interview-questions-and-answers/#:~:text=There%20are%20many%20useful%20features,of%20them%20are%20mentioned%20below)[geeksforgeeks.org](https://www.geeksforgeeks.org/java/spring-boot-auto-configuration/#:~:text=,components%20and%20registering%20the%20beans).
        
    -   **Starter dependencies**: Convenient “starter” POMs (like _spring-boot-starter-web_, _-data-jpa_, _-security_, etc.) that pull in a set of related libraries[pwskills.com](https://pwskills.com/blog/spring-boot-tutorial/#:~:text=Spring%20Boot%20starters%20are%20pre,web%20development%20in%20Spring%20Boot)[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/spring-boot-interview-questions-and-answers/#:~:text=There%20are%20many%20useful%20features,of%20them%20are%20mentioned%20below).
        
    -   **Embedded servers**: Bundled Tomcat/Jetty, letting you run applications as standalone jars without deploying to an external container.
        
    -   **Spring Boot CLI**: A command-line tool (Groovy-based) to quickly prototype Spring Boot apps.
        
    -   **Actuator**: Provides production-ready monitoring endpoints (health, metrics, info, etc.).
        
    -   **DevTools**: Auto-restart and live reload for faster development.
        
    
    These opinionated features dramatically reduce boilerplate and speed up development[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/spring-boot-interview-questions-and-answers/#:~:text=There%20are%20many%20useful%20features,of%20them%20are%20mentioned%20below).
    
3.  **What is the purpose of `application.properties` or `application.yml` in Spring Boot?**  
    These files externalize configuration settings for a Spring Boot app (server port, database URLs, logging levels, etc.). Instead of hard-coding settings, you specify them in `src/main/resources/application.properties` (or `.yml`). For example:
    
    properties
    
    CopyEdit
    
    `server.port=8081
    spring.datasource.url=jdbc:mysql://localhost:3306/mydb
    spring.datasource.username=root
    spring.datasource.password=pass
    logging.level.org.springframework=DEBUG` 
    
    This tells Spring Boot to run on port 8081 and connect to the given MySQL DB. Spring Boot will automatically bind these properties to the corresponding beans[codeinterview.io](https://codeinterview.io/interview-questions/spring-boot-questions-answers#:~:text=Question%2006%3A%20What%20is%20the,in%20a%20Spring%20Boot%20application)[geeksforgeeks.org](https://www.geeksforgeeks.org/advance-java/convert-application-properties-to-application-yml-in-spring-boot/#:~:text=Spring%20Boot%20allows%20us%20to,better%20support%20for%20complex%20configurations). You can also have profile-specific files (e.g. `application-dev.properties`) that activate only under a named profile.
    
4.  **How does Spring Boot auto-configuration work?**  
    Spring Boot’s auto-configuration scans the classpath and environment to configure beans automatically. It is enabled by `@EnableAutoConfiguration` (included in `@SpringBootApplication`). Based on what libraries are present (e.g. Spring MVC, H2, JPA), it will create and configure beans (datasources, MVC components, etc.) by default. Under the hood, it uses conditional annotations (like `@ConditionalOnClass`, `@ConditionalOnMissingBean`) and `spring.factories` metadata to apply configuration classes[geeksforgeeks.org](https://www.geeksforgeeks.org/java/spring-boot-auto-configuration/#:~:text=,components%20and%20registering%20the%20beans)[pwskills.com](https://pwskills.com/blog/spring-boot-tutorial/#:~:text=Auto,streamlined%20and%20efficient%20development%20process). For example, if `spring-boot-starter-data-jpa` is on the classpath, Spring Boot auto-configures an `EntityManagerFactory` and `DataSource` if none is defined. You can override or disable specific auto-configs via properties or exclude filters.
    
5.  **What is a starter dependency in Spring Boot? Give examples.**  
    A _starter_ is a convenient set of dependencies that you add to your project’s build file to get a particular functionality. Starters bundle all the commonly-used libraries for a feature. For example, **spring-boot-starter-web** pulls in Spring MVC, Tomcat, Jackson, etc. for building web (REST) applications[pwskills.com](https://pwskills.com/blog/spring-boot-tutorial/#:~:text=Spring%20Boot%20starters%20are%20pre,web%20development%20in%20Spring%20Boot)[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/spring-boot-interview-questions-and-answers/#:~:text=%2A%20Auto,database%2C%20security%2C%20maven%20configuration%20etc). **spring-boot-starter-data-jpa** includes Spring Data JPA and Hibernate for database access. **spring-boot-starter-security** brings in Spring Security. You simply add them to your `pom.xml` or `build.gradle`. For example:
    
    xml
    
    CopyEdit
    
    `<dependency> <groupId>org.springframework.boot</groupId> <artifactId>spring-boot-starter-web</artifactId> </dependency>` 
    
    This starter includes Spring MVC, the embedded Tomcat, JSON processing, etc., so you can start writing controllers immediately[pwskills.com](https://pwskills.com/blog/spring-boot-tutorial/#:~:text=Spring%20Boot%20starters%20are%20pre,web%20development%20in%20Spring%20Boot).
    

## Intermediate Spring Boot Interview Questions (6–15)

6.  **What is the Spring Boot Initializr? How do you use it?**  
    Spring Initializr is a web-based project generator (start.spring.io) that bootstraps a Spring Boot project for you. You select the project type (Maven/Gradle), language, Spring Boot version, and dependencies via a simple UI, and it generates a pre-configured ZIP project. This skeleton includes the `pom.xml` (or `build.gradle`) and main class. For example, you can go to start.spring.io, choose “Web” and “JPA”, and download the project, which you then import into your IDE. Initializr saves time on setup by creating the basic structure and dependency list[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/spring-boot-interview-questions-and-answers/#:~:text=Spring%20Initializer%20%20is%20a,up%20the%20framework%20from%20scratch).
    
7.  **What are annotations like `@SpringBootApplication`, `@RestController`, and `@RequestMapping` used for?**
    
    -   `@SpringBootApplication`: Placed on the main application class. It’s a convenience annotation that combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`, thus bootstrapping the Spring context and auto-configurations[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/spring-boot-interview-questions-and-answers/#:~:text=,generic%20annotation%20for%20any%20Spring).
        
    -   `@RestController`: A specialization of `@Controller` that adds `@ResponseBody` to every method. Use this on a class to expose RESTful HTTP endpoints. Spring will serialize return values (objects) as JSON/XML in the response[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/spring-boot-interview-questions-and-answers/#:~:text=,specify%20a%20specific%20URL%20mapping).
        
    -   `@RequestMapping` (and its variants like `@GetMapping`, `@PostMapping`): Map HTTP requests to controller methods. You can put it at class-level (to set a base path) or method-level to handle specific paths/HTTP methods. For example, `@GetMapping("/items/{id}")` on a method means it will be invoked for GET requests to `/items/123` (with the path variable bound to a method parameter)[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/spring-boot-interview-questions-and-answers/#:~:text=,specify%20a%20specific%20URL%20mapping).
        
    
    Together, these annotations define the entry point and request handling of a Spring Boot web app. For example:
    
    java
    
    CopyEdit
    
    `@SpringBootApplication  public  class  MyApplication { public  static  void  main(String[] args) {
            SpringApplication.run(MyApplication.class, args);
        }
    } @RestController  @RequestMapping("/api")  public  class  ApiController { @GetMapping("/hello")  public String hello() { return  "Hello"; }
    }` 
    
8.  **How does dependency injection work in Spring Boot?**  
    Spring Boot (like Spring) uses the **IoC container** to manage object creation and dependency wiring. Beans are created automatically for classes annotated with `@Component`, `@Service`, `@Repository`, etc. You inject these beans into other beans by constructor, setter, or field injection (often with `@Autowired`). For example:
    
    java
    
    CopyEdit
    
    `@Service  public  class  MyService { private  final MyRepository repo; public  MyService(MyRepository repo) { // constructor injection  this.repo = repo;
        }
    }` 
    
    Here, Spring will automatically supply a `MyRepository` bean when creating `MyService`. This is standard Spring DI – Spring Boot just makes configuration easier. In fact, **“Spring Boot supports several DI techniques, including constructor, setter, and field injection via `@Autowired`”**[codeinterview.io](https://codeinterview.io/interview-questions/spring-boot-questions-answers#:~:text=Question%2010%3A%20Explain%20the%20concept,dependency%20injection%20in%20Spring%20Boot). The container resolves bean dependencies by type (and qualifier) at startup.
    
9.  **What is the difference between `@Component`, `@Service`, `@Repository`, and `@Controller`?**  
    These are all stereotypes that tell Spring to treat the class as a bean, but they signal different roles:
    
    -   `@Component`: A generic stereotype for any Spring-managed component. Use it when no other more specific annotation fits.
        
    -   `@Service`: A specialized `@Component` for the _service_ (business logic) layer. It makes your intent clear and can also carry extra semantics in future frameworks[geeksforgeeks.org](https://www.geeksforgeeks.org/java/difference-between-component-repository-service-and-controller-annotations-in-spring/#:~:text=In%20an%20application%2C%20the%20business,and%20classpath%20scanning%20is%20used).
        
    -   `@Repository`: A specialized `@Component` for the _data access_ layer (DAOs). It also enables exception translation, turning JPA exceptions into Spring’s `DataAccessException` hierarchy[geeksforgeeks.org](https://www.geeksforgeeks.org/java/difference-between-component-repository-service-and-controller-annotations-in-spring/#:~:text=B).
        
    -   `@Controller` / `@RestController`: Specialized for the _presentation_ layer. `@Controller` is for MVC controllers (views), while `@RestController` (which combines `@Controller` and `@ResponseBody`) is for REST APIs. They tell Spring to scan these classes for request-handling methods[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/spring-boot-interview-questions-and-answers/#:~:text=,specify%20a%20specific%20URL%20mapping)[geeksforgeeks.org](https://www.geeksforgeeks.org/java/difference-between-component-repository-service-and-controller-annotations-in-spring/#:~:text=C).
        
    
    All of these are picked up by component scanning and registered as beans in the context, but using the right stereotype clarifies each class’s role[geeksforgeeks.org](https://www.geeksforgeeks.org/java/difference-between-component-repository-service-and-controller-annotations-in-spring/#:~:text=In%20an%20application%2C%20the%20business,and%20classpath%20scanning%20is%20used)[geeksforgeeks.org](https://www.geeksforgeeks.org/java/difference-between-component-repository-service-and-controller-annotations-in-spring/#:~:text=B).
    
10.  **What is the Spring Boot Actuator? What are some common endpoints?**  
    Spring Boot Actuator is a dependency (`spring-boot-starter-actuator`) that adds _production-ready_ endpoints to your app for monitoring and management. It exposes operational info (health checks, metrics, environment, mappings, etc.) via REST or JMX. For example, after adding the Actuator, you might see endpoints like `/actuator/health` (shows up/down status), `/actuator/metrics`, `/actuator/info`, `/actuator/env`, `/actuator/loggers`, etc. Actuator endpoints are automatically added when on the classpath[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/spring-boot-interview-questions-and-answers/#:~:text=applications.%20%2A%20Actuator%20,It%20also%20simplifies%20the%20troubleshooting)[baeldung.com](https://www.baeldung.com/spring-boot-actuators#:~:text=The%20actuator%20mainly%20exposes%C2%A0operational%20information,us%20to%20interact%20with%20it). These endpoints help monitor the application: e.g., `/actuator/health` returns JSON indicating if dependencies (DB, disk, etc.) are healthy[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/spring-boot-interview-questions-and-answers/#:~:text=applications.%20%2A%20Actuator%20,It%20also%20simplifies%20the%20troubleshooting).
    
11.  **How does Spring Boot handle exception handling globally?**  
    Spring Boot by default provides basic error responses (via a `BasicErrorController`). For custom handling, you can use `@ControllerAdvice` to define a global exception handler. A class annotated with `@ControllerAdvice` can contain `@ExceptionHandler` methods to catch exceptions thrown by any controller. For example:
    
    java
    
    CopyEdit
    
    `@ControllerAdvice  public  class  GlobalExceptionHandler { @ExceptionHandler(NoSuchCustomerExistsException.class)  @ResponseStatus(HttpStatus.NOT_FOUND)  public  @ResponseBody ErrorResponse handleException(NoSuchCustomerExistsException ex) { return  new  ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        }
    }` 
    
    Here, any `NoSuchCustomerExistsException` thrown by a controller will be caught and translated into a 404 response. This global handler pattern is the recommended way to provide consistent error responses across the app[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/exception-handling-in-spring-boot/#:~:text=In%20the%20previous%20approach%2C%20the,into%20a%20single%20global%20unit).
    
12.  **What is the difference between `@RequestParam`, `@PathVariable`, and `@RequestBody`?**  
    These annotations bind incoming HTTP request data to controller method parameters:
    
    -   `@PathVariable` binds a URI template variable. E.g. with `@GetMapping("/users/{id}")`, you can use `@PathVariable("id") Long id` to extract the value from the URL path (`/users/123` → `id=123`)[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/spring-boot-pathvariable-and-requestparam-annotations/#:~:text=,With%20%40RequestParam%2C%20you%20can).
        
    -   `@RequestParam` extracts a query parameter or form data. For example, `@GetMapping("/users/search")` with `public List<User> find(@RequestParam("name") String name)` will bind `name` from a request like `/users/search?name=John`[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/spring-boot-pathvariable-and-requestparam-annotations/#:~:text=,With%20%40RequestParam%2C%20you%20can).
        
    -   `@RequestBody` binds the HTTP request _body_ (typically JSON or XML) to a Java object. Spring uses message converters (like Jackson) to deserialize the JSON into your object. For example, `@PostMapping("/users") public User create(@RequestBody User user)` means the JSON in the POST body is mapped to the `user` parameter[springframework.guru](https://springframework.guru/requestbody-annotation/#:~:text=The%20,as%20a%20handler%20method%20parameter).
        
    
    Example:
    
    java
    
    CopyEdit
    
    `@GetMapping("/items/{id}")  public Item getById(@PathVariable Long id) { ... } @GetMapping("/items")  public List<Item> find(@RequestParam("q") String query) { ... } @PostMapping("/items")  public Item create(@RequestBody Item item) { ... }` 
    
    Here, `{id}` comes from the URL path, `q` comes from a query parameter, and the POST body is read as an `Item` object[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/spring-boot-pathvariable-and-requestparam-annotations/#:~:text=,With%20%40RequestParam%2C%20you%20can)[springframework.guru](https://springframework.guru/requestbody-annotation/#:~:text=The%20,as%20a%20handler%20method%20parameter).
    
13.  **How do you connect Spring Boot to a database like MySQL?**  
    You add the appropriate dependencies (e.g. `spring-boot-starter-data-jpa` and the MySQL JDBC driver:
    
    xml
    
    CopyEdit
    
    `<dependency> <groupId>org.springframework.boot</groupId> <artifactId>spring-boot-starter-data-jpa</artifactId> </dependency> <dependency> <groupId>mysql</groupId> <artifactId>mysql-connector-java</artifactId> <scope>runtime</scope> </dependency>` 
    
    Then configure the connection in `application.properties` or `application.yml`. For example:
    
    properties
    
    CopyEdit
    
    `spring.datasource.url=jdbc:mysql://localhost:3306/mydb
    spring.datasource.username=dbuser
    spring.datasource.password=dbpass
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update` 
    
    Spring Boot will auto-configure a DataSource and `EntityManager` using these settings[geeksforgeeks.org](https://www.geeksforgeeks.org/advance-java/convert-application-properties-to-application-yml-in-spring-boot/#:~:text=Spring%20Boot%20uses%20configuration%20files,based%20configuration). You can then use Spring Data JPA or JDBC templates to interact with MySQL. (Spring Boot picks up `spring.datasource.*` properties automatically to set up the database connection[geeksforgeeks.org](https://www.geeksforgeeks.org/advance-java/convert-application-properties-to-application-yml-in-spring-boot/#:~:text=Spring%20Boot%20uses%20configuration%20files,based%20configuration).)
    
14.  **What is JPA and how do you use Spring Data JPA in Spring Boot?**  
    JPA (Java Persistence API) is the standard Java specification for ORM (mapping Java objects to database tables). Spring Data JPA is Spring’s library that implements JPA and provides repository abstractions. In Spring Boot, you use it by: adding the `spring-boot-starter-data-jpa` dependency, annotating your domain classes with `@Entity` (and `@Id`, etc.), and defining a repository interface that extends `JpaRepository<Entity,ID>`. For example:
    
    java
    
    CopyEdit
    
    `@Entity  public  class  Customer { @Id  @GeneratedValue Long id; private String name; // getters/setters... } @Repository  public  interface  CustomerRepository  extends  JpaRepository<Customer, Long> {
        Optional<Customer> findByEmail(String email);
    }` 
    
    Spring Data JPA will automatically provide implementations for basic CRUD and finder methods[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/exception-handling-in-spring-boot/#:~:text=Note%3A%20The%20CustomerRepository%20interface%20is,Spring%20Data%20JPA). Spring Boot then auto-configures Hibernate as the JPA provider. Using Spring Data JPA removes most boilerplate for data access; you just define entities and repository interfaces[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/exception-handling-in-spring-boot/#:~:text=Note%3A%20The%20CustomerRepository%20interface%20is,Spring%20Data%20JPA).
    
15.  **What are the lifecycle phases of a Spring Boot application?**  
    A Spring Boot app goes through several phases:
    
    -   **Bootstrap/Startup**: The `main()` method calls `SpringApplication.run()`, which initializes the Spring context[dev.to](https://dev.to/hunor85/spring-013-20n1#:~:text=1%EF%B8%8F%E2%83%A3%20Bootstrapping%20Phase%20,Spring%20Boot%20Startup). This loads environment properties (including `application.properties`), determines active profiles, and sets up SpringApplication listeners and context type (web or non-web).
        
    -   **Auto-configuration & Bean Loading**: Spring scans for components/config classes, creates the `ApplicationContext`, and registers bean definitions. It applies auto-configuration classes based on conditions[dev.to](https://dev.to/hunor85/spring-013-20n1#:~:text=5.%20AutoConfiguration%20%26%20SpringFactoriesLoader%3A%20,environmentPrepared).
        
    -   **Bean Instantiation and Initialization**: All singleton beans are instantiated (calling constructors), and dependency injection occurs. BeanPostProcessors and `@PostConstruct` methods are invoked[dev.to](https://dev.to/hunor85/spring-013-20n1#:~:text=2%EF%B8%8F%E2%83%A3%20Context%20Initialization%20%26%20Bean,Lifecycle).
        
    -   **Context Refreshed**: The context is fully set up, and events like `ApplicationReadyEvent` are published. If there are `CommandLineRunner` or `ApplicationRunner` beans, they run now.
        
    -   **Running**: The application is now running and serving requests (if a web app).
        
    -   **Shutdown**: When the app stops, the context is closed, calling any `@PreDestroy` on beans and releasing resources.
        
    
    In summary, Spring Boot’s `SpringApplication` bootstraps the app, configures beans, and fires lifecycle events (starting, environment prepared, context refreshed, ready)[dev.to](https://dev.to/hunor85/spring-013-20n1#:~:text=1%EF%B8%8F%E2%83%A3%20Bootstrapping%20Phase%20,Spring%20Boot%20Startup)[dev.to](https://dev.to/hunor85/spring-013-20n1#:~:text=2%EF%B8%8F%E2%83%A3%20Context%20Initialization%20%26%20Bean,Lifecycle).
    

## Advanced Spring Boot Interview Questions (16–20)

16.  **What is the difference between `CrudRepository`, `JpaRepository`, and `PagingAndSortingRepository`?**  
    These interfaces are part of Spring Data JPA and define repository behaviors:
    
    -   **`CrudRepository`**: The base interface for CRUD operations. It provides methods like `save()`, `findById()`, `findAll()`, `delete()`, etc. It deals in generic `Iterable<T>` return types[stackoverflow.com](https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring#:~:text=).
        
    -   **`PagingAndSortingRepository`**: Extends `CrudRepository` and adds methods for pagination and sorting, such as `findAll(Pageable pageable)` and `findAll(Sort sort)`. Use it when you need to retrieve entities in pages or sorted order[stackoverflow.com](https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring#:~:text=The%20PagingAndSortingRepository%20provides%20additional%20methods,entities%20using%20pagination%20and%20sorting)[stackoverflow.com](https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring#:~:text=).
        
    -   **`JpaRepository`**: Extends `PagingAndSortingRepository`. It adds JPA-specific operations like `flush()`, `saveAndFlush()`, `deleteInBatch()`, and changes some return types to `List<T>` instead of `Iterable`. It inherits all CRUD, paging, and sorting methods[stackoverflow.com](https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring#:~:text=)[stackoverflow.com](https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring#:~:text=The%20PagingAndSortingRepository%20provides%20additional%20methods,entities%20using%20pagination%20and%20sorting).
        
    
    In short, `PagingAndSortingRepository` gives you paging/sorting on top of `CrudRepository`, and `JpaRepository` gives you even more JPA-related functionality. You choose `CrudRepository` for basic needs, add paging/sorting if needed, or use `JpaRepository` for full JPA capabilities[stackoverflow.com](https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring#:~:text=The%20PagingAndSortingRepository%20provides%20additional%20methods,entities%20using%20pagination%20and%20sorting)[stackoverflow.com](https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring#:~:text=).
    
17.  **How do you secure a Spring Boot application? (e.g., using Spring Security)**  
    To secure a Spring Boot app, you typically add the Spring Security starter (`spring-boot-starter-security`) to your project. By default, this secures all endpoints with basic authentication. You then configure security rules, for example by extending `WebSecurityConfigurerAdapter` (Spring Boot 2) or defining a `SecurityFilterChain` bean:
    
    java
    
    CopyEdit
    
    `@EnableWebSecurity  @Configuration  public  class  SecurityConfig  extends  WebSecurityConfigurerAdapter { @Override  protected  void  configure(HttpSecurity http)  throws Exception {
            http.authorizeRequests()
                .antMatchers("/public/**").permitAll() // public endpoints .anyRequest().authenticated()
                .and()
                .formLogin(); // or http.httpBasic() }
    }` 
    
    This setup locks down all other URLs and provides a login page or Basic auth. You also configure users/roles (in memory or via a `UserDetailsService`). For example, you can annotate methods with `@Secured("ROLE_USER")` or use `@EnableGlobalMethodSecurity` for finer control[geeksforgeeks.org](https://www.geeksforgeeks.org/advance-java/spring-security-interview-questions/#:~:text=%3E%20%20%20,). Spring Security integrates deeply, adding a filter chain under the covers. In summary: **include the `spring-boot-starter-security` dependency and define a security configuration**, then secure endpoints and user authentication as needed[geeksforgeeks.org](https://www.geeksforgeeks.org/advance-java/spring-security-interview-questions/#:~:text=%3E%20%20%20,).
    
18.  **What is a filter and how is it different from an interceptor in Spring Boot?**  
    Both can intercept requests, but at different points:
    
    -   A **Filter** is a servlet filter (from the Java EE Servlet API). It is managed by the web container (or Spring’s `DelegatingFilterProxy`) and runs _before_ Spring’s `DispatcherServlet`. Filters can modify request/response globally (e.g. logging, compression, CORS, security). They operate outside of Spring MVC. For example, Spring Security’s `DelegatingFilterProxy` is a Filter that intercepts _all_ requests for authentication/authorization[baeldung.com](https://www.baeldung.com/spring-mvc-handlerinterceptor-vs-filter#:~:text=Filters%20are%20part%20of%20the,responses%20from%20reaching%20the%20client).
        
    -   A **HandlerInterceptor** is part of Spring MVC. It intercepts requests _after_ the `DispatcherServlet` has routed to a specific controller but _before_ and _after_ the controller method execution. Interceptors can manipulate the `ModelAndView` or perform pre/post-processing of a request within the Spring framework.
        
    
    In short, Filters are servlet-level and run before Spring MVC (ideal for cross-cutting concerns independent of controllers), whereas HandlerInterceptors run within Spring MVC around controller handling (fine-grained tasks like modifying model data)[baeldung.com](https://www.baeldung.com/spring-mvc-handlerinterceptor-vs-filter#:~:text=Filters%20intercept%20requests%20before%20they,grained%20tasks%20such%20as).
    
19.  **How does Spring Boot support microservices architecture?**  
    Spring Boot is a popular framework for building microservices because it makes each service small, standalone, and easy to run. Features include embedded servers and self-contained packaging, so each microservice can start on its own. More importantly, Spring Boot works seamlessly with **Spring Cloud**, which provides building blocks for microservices: service discovery (Eureka), distributed configuration (Config Server), circuit breakers (Hystrix/Resilience4J), API gateway (Spring Cloud Gateway), distributed tracing (Spring Cloud Sleuth), etc. The official Spring site notes that Spring Boot’s “purpose-built features make it easy to build and run your microservices in production at scale,” and that Spring Cloud is used for patterns like discovery, load balancing, fault tolerance, and monitoring[spring.io](https://spring.io/microservices/#:~:text=Microservice%20architectures%20are%20the%20%E2%80%98new,tolerance). Essentially, Spring Boot handles the core app development, and Spring Cloud adds the microservices infrastructure.
    
20.  **How would you handle configuration for multiple environments (dev, prod, staging) in Spring Boot?**  
    Spring Boot supports **profiles** to separate environment configs. You can create multiple property (or YAML) files like `application-dev.properties`, `application-prod.properties`, etc. By default, `application.properties` applies to all. You activate a profile by setting `spring.profiles.active=dev` (e.g. in an environment variable or the default properties). Beans or config classes can be annotated with `@Profile("dev")` to load only in that profile[codeinterview.io](https://codeinterview.io/interview-questions/spring-boot-questions-answers#:~:text=Answer%3A%20%20Spring%20Boot%20handles,For%20example). For example, you might have:
    
    properties
    
    CopyEdit
    
    `# application-dev.properties
    spring.datasource.url=jdbc:mysql://localhost:3306/dev_db` 
    
    properties
    
    CopyEdit
    
    `# application-prod.properties
    spring.datasource.url=jdbc:mysql://prod-db-server:3306/prod_db` 
    
    And then in `application.properties`: `spring.profiles.active=dev` (or set at runtime). Spring Boot will automatically load the profile-specific file. You can also use `@Profile` on `@Configuration` classes or `@Bean` methods to include beans only for certain environments. In short, use **Spring Profiles** and profile-named property files to manage environment-specific configuration[codeinterview.io](https://codeinterview.io/interview-questions/spring-boot-questions-answers#:~:text=Answer%3A%20%20Spring%20Boot%20handles,For%20example).
    

## Common Spring Boot Annotations & Concepts

-   **Entities (`@Entity`)**: In the persistence (data) layer, classes representing database tables are annotated with `@Entity` (and fields with `@Id`, `@Column`, etc.). For example:
    
    java
    
    CopyEdit
    
    `@Entity  public  class  Customer { @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)  private Long id; private String name; // ... }` 
    
    This tells JPA/Hibernate to map `Customer` to a DB table[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/exception-handling-in-spring-boot/#:~:text=%40Entity%20%40Data%20%40AllArgsConstructor%20%40NoArgsConstructor%20public,String%20name%3B%20private%20String%20address).
    
-   **Repositories (`@Repository`)**: DAO interfaces extend Spring Data interfaces (e.g. `JpaRepository`) and are annotated with `@Repository`. Spring will create an implementation at runtime. For example:
    
    java
    
    CopyEdit
    
    `@Repository  public  interface  CustomerRepository  extends  JpaRepository<Customer, Long> { }` 
    
    This provides CRUD methods for `Customer` entities[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/exception-handling-in-spring-boot/#:~:text=Note%3A%20The%20CustomerRepository%20interface%20is,Spring%20Data%20JPA).
    
-   **Services (`@Service`)**: Classes containing business logic are annotated with `@Service` (a specialization of `@Component`). This marks them as beans and makes the code more readable[geeksforgeeks.org](https://www.geeksforgeeks.org/java/difference-between-component-repository-service-and-controller-annotations-in-spring/#:~:text=In%20an%20application%2C%20the%20business,and%20classpath%20scanning%20is%20used).
    
    java
    
    CopyEdit
    
    `@Service  public  class  OrderService { // business methods }` 
    
-   **Controllers (`@Controller`/`@RestController`)**: The web layer uses `@Controller` for MVC or `@RestController` for REST APIs. `@RestController` implicitly adds `@ResponseBody` so that return values are serialized to JSON[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/spring-boot-interview-questions-and-answers/#:~:text=,specify%20a%20specific%20URL%20mapping).
    
    java
    
    CopyEdit
    
    `@RestController  public  class  HelloController { @GetMapping("/hello")  public String sayHello() { return  "Hello!"; }
    }` 
    
-   **Components (`@Component`)**: The generic stereotype for any Spring-managed bean. Use it for classes that don’t fit other stereotypes.
    
-   **Dependency Injection (`@Autowired`)**: You can inject beans into other beans using `@Autowired` (or via constructor injection without annotation in recent Spring). For example:
    
    java
    
    CopyEdit
    
    `@RestController  public  class  BookController { @Autowired  private BookService bookService; // ... }` 
    
-   **Bean definitions (`@Configuration` & `@Bean`)**: Use `@Configuration` on a class to define bean-creating methods. Annotate a method with `@Bean` to register its return value as a bean in the context. For example:
    
    java
    
    CopyEdit
    
    `@Configuration  public  class  AppConfig { @Bean  public MyService myService() { return  new  MyServiceImpl();
        }
    }` 
    
    Spring Boot auto-configuration also registers beans for you (via component scanning and `@Bean` methods)[geeksforgeeks.org](https://www.geeksforgeeks.org/java/spring-boot-auto-configuration/#:~:text=,components%20and%20registering%20the%20beans).
    
-   **Global Exception Handling**: Use `@ControllerAdvice` and `@ExceptionHandler` to handle exceptions across controllers (as shown above)[geeksforgeeks.org](https://www.geeksforgeeks.org/springboot/exception-handling-in-spring-boot/#:~:text=In%20the%20previous%20approach%2C%20the,into%20a%20single%20global%20unit).
    
-   **CORS (`@CrossOrigin`)**: To allow cross-origin requests in REST controllers, you can use `@CrossOrigin` on a controller or method. For example:
    
    java
    
    CopyEdit
    
    `@RestController  @RequestMapping("/api")  public  class  ApiController { @CrossOrigin(origins = "http://localhost:3000")  @GetMapping("/data")  public Data getData() { ... }
    }` 
    
    This enables CORS for that endpoint (allowing requests from `http://localhost:3000`) [spring.io](https://spring.io/guides/gs/rest-service-cors/#:~:text=%40CrossOrigin%28origins%20%3D%20,format%28template%2C%20name). By default it allows all origins and headers for the annotated method.
    
-   **Spring Bean**: In Spring, a _bean_ is any object managed by the IoC container. Beans are created via component scanning (`@Component`, `@Service`, etc.), `@Bean` methods, or auto-configuration. Spring Boot will automatically register beans it finds (e.g. annotated classes)[geeksforgeeks.org](https://www.geeksforgeeks.org/java/spring-boot-auto-configuration/#:~:text=,components%20and%20registering%20the%20beans).
    

Each of the above annotations and features helps structure a Spring Boot application into well-defined layers (entity/repository, service, controller) and handle cross-cutting concerns (security, CORS, error handling, etc.) in a standardized way.
