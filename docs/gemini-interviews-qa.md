# Java Backend Interview Questions & Answers

This repository contains a curated list of interview questions for seasoned Java backend engineers, along with detailed answers and explanations from the perspective of an expert at a Fortune 500 company. The questions cover a wide range of topics, from core Java concepts to microservices, system design, and DevOps.

## Tech Stack

The answers and examples in this repository are based on the following tech stack:

- **Languages:** Java
- **Frameworks:** Spring, Spring Boot
- **Databases & Caching:** OpenSearch, Redis
- **DevOps & Containerization:** Jenkins, Docker, Kubernetes
- **Cloud:** Microsoft Azure

---

## Interview Questions and Answers

### Core Java

#### Q: What are some of the key features of Java 8 that you use frequently?

**A:** In my day-to-day work, I heavily leverage Java 8 features for writing more concise and expressive code. **Lambda expressions** and **Streams** are at the top of the list. For instance, I use the Stream API for processing collections of data, which makes the code more readable and often more performant, especially with parallel streams. **Optional** is another feature I use extensively to handle null values gracefully, avoiding `NullPointerExceptions` and making the code more robust. I also use **functional interfaces** and **method references** to write more functional-style code.

#### Q: Explain the difference between `HashMap` and `ConcurrentHashMap`.

**A:** Both are key-value stores, but the main difference is thread-safety. `HashMap` is not thread-safe. If multiple threads access a `HashMap` concurrently and at least one of them modifies it structurally, it will likely result in incorrect outcomes. `ConcurrentHashMap`, on the other hand, is thread-safe and designed for high concurrency. It achieves this through a technique called lock striping, where the map is divided into segments, and each segment has its own lock. This allows multiple threads to access different segments of the map concurrently, leading to better performance than a `Collections.synchronizedMap(new HashMap<>())`, which locks the entire map for every operation.

#### Q: What is a memory leak in Java, and how would you detect and prevent it?

**A:** A memory leak in Java occurs when objects are no longer needed by the application but are still being referenced, preventing the garbage collector from reclaiming their memory. A common cause is long-lived objects holding references to short-lived ones, like a static collection that is never cleared.

To detect memory leaks, I use profiling tools like **VisualVM** or **YourKit**. These tools allow me to inspect the heap, look for objects that are growing in number unexpectedly, and analyze their references.

To prevent them, I follow best practices like being mindful of static references, closing resources properly (using try-with-resources), and being careful with object scopes.

---

### Spring Framework

#### Q: What is the purpose of the `@ControllerAdvice` annotation in Spring?

**A:** `@ControllerAdvice` is a powerful annotation that allows you to handle exceptions across the whole application in one global component. It's a specialization of the `@Component` annotation, so it gets registered as a Spring bean. I use it to implement global exception handling, so I don't have to put try-catch blocks in every controller method. This keeps my controllers clean and focused on their primary responsibility. I can create methods annotated with `@ExceptionHandler` within a `@ControllerAdvice` class to handle specific exceptions and return custom error responses.

#### Q: What is the difference between `@Component`, `@Service`, `@Repository`, and `@Controller` annotations in Spring?

**A:** These are all stereotype annotations that mark a class as a Spring bean.
*   `@Component` is a generic stereotype for any Spring-managed component.
*   `@Service` is used to indicate that a class is a service, typically where the business logic resides.
*   `@Repository` is for classes that access the database. It also enables the translation of persistence-related exceptions into Spring's `DataAccessException` hierarchy.
*   `@Controller` (or `@RestController` for RESTful services) is for classes that handle incoming web requests.

While they all behave similarly in terms of bean creation, using the specific annotations helps in conveying the intent of the class and allows for more specific processing by the framework or other tools.

#### Q: How does the `@RefreshScope` work in Spring Cloud?

**A:** In a microservices architecture, it's often necessary to update configuration without restarting the service. `@RefreshScope` is a Spring Cloud annotation that allows for exactly that. When a bean is annotated with `@RefreshScope`, it gets wrapped in a proxy. When a configuration change is triggered (e.g., via a `/actuator/refresh` endpoint call), the bean's internal state is cleared, and it's re-initialized on the next method call, picking up the new configuration values. This is extremely useful for dynamically changing feature flags or other properties in a running application.

---

### Microservices & System Design

#### Q: What is an API Gateway and why is it important in a microservices architecture?

**A:** An API Gateway is a server that acts as a single entry point for all client requests to the backend microservices. It's a critical component in a microservices architecture for several reasons:

*   **Encapsulation:** It hides the internal structure of the microservices from the clients.
*   **Cross-cutting Concerns:** It can handle cross-cutting concerns like authentication, SSL termination, rate limiting, and logging in a centralized place.
*   **Request Routing:** It routes incoming requests to the appropriate microservices.
*   **Protocol Translation:** It can translate between different protocols if needed.

In our projects, we use API Gateways to simplify the client-side code and to provide a single, secure entry point to our backend services.

#### Q: How do you handle fault tolerance in a microservices architecture?

**A:** Fault tolerance is crucial in a distributed system. We use several patterns to achieve it:

*   **Circuit Breaker:** We use libraries like **Resilience4j** to implement the Circuit Breaker pattern. If a service is down, the circuit breaker opens and fails fast, preventing the application from waiting for a response and consuming resources.
*   **Retries:** For transient failures, we implement automatic retries with exponential backoff.
*   **Timeouts:** We configure timeouts for all network calls to prevent long-running requests from blocking threads.
*   **Bulkheads:** We use the Bulkhead pattern to isolate failures in one part of the system from affecting others.

#### Q: What is the CAP theorem, and how does it apply to the databases you use?

**A:** The CAP theorem states that a distributed data store can only provide two of the following three guarantees: **Consistency**, **Availability**, and **Partition Tolerance**.

*   **Consistency:** Every read receives the most recent write or an error.
*   **Availability:** Every request receives a (non-error) response, without the guarantee that it contains the most recent write.
*   **Partition Tolerance:** The system continues to operate despite an arbitrary number of messages being dropped (or delayed) by the network between nodes.

In a microservices architecture, we have to assume that network partitions can happen, so we must choose between consistency and availability. For our **OpenSearch** clusters, we typically favor consistency, ensuring that our search results are accurate. For a caching layer with **Redis**, we might lean more towards availability, where it's acceptable to have slightly stale data in the cache in exchange for faster response times.

---

### DevOps & Cloud

#### Q: Can you explain your CI/CD process, including Helm configs for different environments?

**A:** Our CI/CD process is built around **Jenkins**, **Docker**, **Kubernetes**, and **Helm**. This combination allows us to automate the entire process from code commit to deployment, ensuring that our releases are fast, reliable, and consistent.

Here's a breakdown of our CI/CD pipeline:

**1. Continuous Integration (CI):**

The CI part of our pipeline is triggered whenever a developer pushes code to a feature branch in our Git repository. The pipeline performs the following steps:

*   **Build:** The code is compiled and packaged into a JAR file using Maven or Gradle.
*   **Test:** Unit and integration tests are run to ensure that the new code doesn't break any existing functionality.
*   **Code Analysis:** Static code analysis tools like SonarQube are used to check for code quality and security vulnerabilities.
*   **Build Docker Image:** A Docker image is built from the JAR file using a `Dockerfile`.
*   **Push to Registry:** The Docker image is tagged with the build number and pushed to our **Azure Container Registry**.

**2. Continuous Deployment (CD):**

The CD part of our pipeline is triggered after the CI pipeline has successfully completed and the code has been merged into the main branch. The pipeline performs the following steps:

*   **Package Helm Chart:** The application is packaged into a Helm chart, which is a collection of files that describe a related set of Kubernetes resources.
*   **Deploy to Staging:** The Helm chart is deployed to our staging environment, which is a replica of our production environment.
*   **Run End-to-End Tests:** Automated end-to-end tests are run against the staging environment to ensure that the application is working as expected.
*   **Manual Approval:** Before deploying to production, a manual approval step is required. This allows us to perform any final checks and ensure that we are ready to release.
*   **Deploy to Production:** After the manual approval, the Helm chart is deployed to our production environment using a rolling update strategy to ensure zero downtime.

**Helm Configurations for Different Environments:**

We use Helm to manage our Kubernetes applications. Helm allows us to define our applications as charts, which can be easily configured for different environments.

We have a base `values.yaml` file that contains the default configuration for our application. We then have separate `values.yaml` files for each environment (e.g., `values-staging.yaml`, `values-production.yaml`) that override the default values.

Here's an example of how we might structure our Helm chart:

```
my-app/
  ├── Chart.yaml
  ├── templates/
  │   ├── deployment.yaml
  │   ├── service.yaml
  │   └── ...
  ├── values.yaml
  ├── values-staging.yaml
  └── values-production.yaml
```

**`values.yaml` (default values):**

```yaml
replicaCount: 1

image:
  repository: my-app
  tag: latest

service:
  type: ClusterIP
  port: 8080

ingress:
  enabled: false
```

**`values-staging.yaml` (staging overrides):**

```yaml
replicaCount: 2

image:
  tag: staging

ingress:
  enabled: true
  hosts:
    - my-app.staging.example.com
```

**`values-production.yaml` (production overrides):**

```yaml
replicaCount: 4

image:
  tag: production

ingress:
  enabled: true
  hosts:
    - my-app.example.com
```

When we deploy our application, we specify which `values.yaml` file to use. For example, to deploy to staging, we would use the following command:

```bash
helm install my-app ./my-app -f values-staging.yaml
```

This allows us to easily manage the configuration for our application in different environments and ensure that our deployments are consistent and repeatable.

**A:** Our CI/CD process is fully automated using **Jenkins**. Here's a typical workflow:

1.  A developer pushes code to a feature branch in our Git repository.
2.  This triggers a Jenkins pipeline that builds the code, runs unit and integration tests.
3.  If the tests pass, the code is merged into the main branch.
4.  Another Jenkins pipeline is triggered, which builds a **Docker** image of the application.
5.  The Docker image is pushed to our **Azure Container Registry**.
6.  Finally, the pipeline deploys the new image to our **Kubernetes** cluster (AKS) using a rolling update strategy to ensure zero downtime.

This process allows us to release new features and bug fixes to production quickly and reliably.

#### Q: How do you use Docker and Kubernetes in your projects?

**A:** We use **Docker** to containerize our microservices. This means that each service is packaged with all its dependencies into a lightweight, portable container. This ensures that the application runs the same way in every environment, from local development to production.

We use **Kubernetes** to orchestrate and manage our Docker containers at scale. Kubernetes handles tasks like:

*   **Deployment:** Rolling out new versions of our services.
*   **Scaling:** Automatically scaling our services up or down based on load.
*   **Service Discovery and Load Balancing:** Allowing our services to communicate with each other.
*   **Self-healing:** Restarting containers that fail.

Using Docker and Kubernetes together allows us to build a resilient, scalable, and portable microservices platform on **Azure**.

#### Q: How would you scale a database?

**A:** Scaling a database depends on the specific bottleneck. Here are a few strategies:

*   **Vertical Scaling:** This involves adding more resources (CPU, RAM) to the existing database server. It's the simplest approach but has its limits.
*   **Horizontal Scaling (Sharding):** This involves partitioning the data across multiple database servers. This is a more complex but also more scalable approach.
*   **Read Replicas:** For read-heavy workloads, we can create read replicas of the database. All write operations go to the primary database, and the data is replicated to the read replicas. Read operations can then be distributed across the replicas, reducing the load on the primary.
*   **Caching:** We use **Redis** as a distributed cache to store frequently accessed data. This reduces the number of requests that hit the database, significantly improving performance.

---

## Additional Interview Questions

This section contains more questions sourced from the interview document, which will be answered sequentially.

*   **Q: How do you implement custom validations in Spring Boot?**

    **A:** In Spring Boot, you can implement custom validations by creating your own custom annotation and a corresponding validator class. This is a clean and reusable way to enforce specific validation rules that are not covered by the standard validation annotations.

    Here's how you can do it:

    **1. Create a custom annotation:**

    First, you define a new annotation. This annotation will be used to mark the fields that need to be validated.

    ```java
    import jakarta.validation.Constraint;
    import jakarta.validation.Payload;
    import java.lang.annotation.*;

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = ContactNumberValidator.class)
    @Documented
    public @interface ContactNumberConstraint {
        String message() default "Invalid phone number";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }
    ```

    **2. Create a validator class:**

    Next, you create a class that implements the `ConstraintValidator` interface. This class will contain the actual validation logic.

    ```java
    import jakarta.validation.ConstraintValidator;
    import jakarta.validation.ConstraintValidatorContext;

    public class ContactNumberValidator implements ConstraintValidator<ContactNumberConstraint, String> {

        @Override
        public void initialize(ContactNumberConstraint constraintAnnotation) {
        }

        @Override
        public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
            return contactField != null && contactField.matches("[0-9]+")
              && (contactField.length() > 8) && (contactField.length() < 14);
        }

    }
    ```

    **3. Apply the custom annotation:**

    Finally, you can use your new custom annotation on the fields of your request objects.

    ```java
    public class Customer {

        @ContactNumberConstraint
        private String contactNumber;

        // getters and setters
    }
    ```

    When a request with a `Customer` object is received, Spring will automatically trigger the `ContactNumberValidator` to validate the `contactNumber` field. If the validation fails, it will throw a `MethodArgumentNotValidException`, which you can handle globally using a `@ControllerAdvice`.
*   **Q: What is the difference between `ArrayList` and `LinkedList`? When would you use one over the other?**

    **A:** `ArrayList` and `LinkedList` are both implementations of the `List` interface, but they have different underlying data structures, which leads to different performance characteristics.

    *   **`ArrayList`** is backed by a dynamic array. This means that it stores elements in a contiguous block of memory.
        *   **Pros:** Fast random access. Getting an element at a specific index (`get(index)`) is an O(1) operation.
        *   **Cons:** Slow insertions and deletions from the middle of the list. When an element is added or removed, all the subsequent elements need to be shifted, which is an O(n) operation.

    *   **`LinkedList`** is backed by a doubly-linked list. Each element in the list is a node that holds a reference to the previous and next nodes.
        *   **Pros:** Fast insertions and deletions. Adding or removing an element from the beginning, middle, or end of the list is an O(1) operation (if you have a reference to the node).
        *   **Cons:** Slow random access. To get an element at a specific index, you have to traverse the list from the beginning or the end, which is an O(n) operation.

    **When to use which:**

    *   Use **`ArrayList`** when you have a read-heavy workload, where you need to access elements by their index frequently.
    *   Use **`LinkedList`** when you have a write-heavy workload, where you need to add and remove elements from the list frequently, especially from the beginning or middle.

    **Example:**

    ```java
    import java.util.ArrayList;
    import java.util.LinkedList;
    import java.util.List;

    public class ListExample {

        public static void main(String[] args) {
            // Use ArrayList when you need fast random access
            List<String> arrayList = new ArrayList<>();
            arrayList.add("apple");
            arrayList.add("banana");
            arrayList.add("cherry");
            System.out.println("Element at index 1 in ArrayList: " + arrayList.get(1)); // Fast

            // Use LinkedList when you need fast insertions and deletions
            List<String> linkedList = new LinkedList<>();
            linkedList.add("dog");
            linkedList.add("cat");
            linkedList.add(0, "bird"); // Fast insertion at the beginning
            System.out.println("LinkedList after insertion: " + linkedList);
        }
    }
    ```
*   **Q: What is the difference between `Comparator` and `Comparable` interfaces?**

    **A:** Both `Comparator` and `Comparable` are interfaces used for sorting collections of objects in Java. However, they are used in different scenarios.

    *   **`Comparable`** is used to define the *natural ordering* of a class. A class that implements `Comparable` can be sorted by its own `compareTo()` method. This is useful when you have a clear, single way of sorting the objects of a class.

    *   **`Comparator`** is used to define an *external ordering* for a class. You can create multiple `Comparator` implementations for a class, each defining a different way of sorting the objects. This is useful when you want to sort objects based on different criteria, or when you cannot modify the source code of the class you want to sort.

    **Key Differences:**

| Feature      | `Comparable`                                       | `Comparator`                                        |
| :----------- | :------------------------------------------------- | :-------------------------------------------------- |
| **Package**  | `java.lang`                                        | `java.util`                                         |
| **Method**   | `compareTo(Object obj)`                            | `compare(Object obj1, Object obj2)`                 |
| **Use Case** | Defines the natural ordering of a class.           | Defines an external, custom ordering for a class.   |
| **Flexibility**| Only one sorting sequence can be defined.          | Multiple sorting sequences can be defined.          |
| **Modification**| Requires modification of the class being sorted. | Does not require modification of the class being sorted. |

    **Example:**

    Let's say we have a `Player` class and we want to sort a list of players by their score.

    **Using `Comparable`:**

    ```java
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;

    class Player implements Comparable<Player> {
        private String name;
        private int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        // getters and setters

        @Override
        public int compareTo(Player other) {
            return Integer.compare(this.score, other.score);
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

    public class ComparableExample {
        public static void main(String[] args) {
            List<Player> players = new ArrayList<>();
            players.add(new Player("Alice", 95));
            players.add(new Player("Bob", 80));
            players.add(new Player("Charlie", 90));

            Collections.sort(players); // Sorts using the compareTo() method

            System.out.println(players);
        }
    }
    ```

    **Using `Comparator`:**

    Now, let's say we want to sort the players by their name as well. We can create a `Comparator` for that.

    ```java
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.Comparator;
    import java.util.List;

    class PlayerNameComparator implements Comparator<Player> {
        @Override
        public int compare(Player p1, Player p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }

    public class ComparatorExample {
        public static void main(String[] args) {
            List<Player> players = new ArrayList<>();
            players.add(new Player("Charlie", 90));
            players.add(new Player("Alice", 95));
            players.add(new Player("Bob", 80));

            // Sort by score (using Comparable)
            Collections.sort(players);
            System.out.println("Sorted by score: " + players);

            // Sort by name (using Comparator)
            Collections.sort(players, new PlayerNameComparator());
            System.out.println("Sorted by name: " + players);
        }
    }
    ```
*   **Q: How do you implement security in a Spring Boot application?**

    **A:** In Spring Boot, security is primarily handled by the **Spring Security** framework. It provides a comprehensive set of features for securing applications, including authentication, authorization, and protection against common vulnerabilities.

    Here's a basic overview of how to implement security in a Spring Boot application:

    **1. Add the Spring Security dependency:**

    First, you need to add the `spring-boot-starter-security` dependency to your `pom.xml` or `build.gradle` file.

    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    ```

    **2. Configure Spring Security:**

    By default, Spring Security enables basic authentication for all endpoints. You can customize this behavior by creating a `SecurityFilterChain` bean in a configuration class.

    ```java
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.core.userdetails.User;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.provisioning.InMemoryUserDetailsManager;
    import org.springframework.security.web.SecurityFilterChain;

    @Configuration
    @EnableWebSecurity
    public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers("/api/public").permitAll()
                    .anyRequest().authenticated()
                )
                .formLogin(form -> form
                    .loginPage("/login")
                    .permitAll()
                )
                .logout(logout -> logout
                    .permitAll());
            return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService() {
            UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
            return new InMemoryUserDetailsManager(user);
        }
    }
    ```

    In this example, we have:

    *   Configured a `SecurityFilterChain` bean to define our security rules.
    *   Allowed public access to the `/api/public` endpoint.
    *   Required authentication for all other endpoints.
    *   Configured a form-based login page.
    *   Configured a `UserDetailsService` bean to create an in-memory user with the username "user" and password "password".

    **3. Secure your endpoints:**

    You can also use method-level security to secure your service methods.

    ```java
    import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.stereotype.Service;

    @Service
    public class MyService {

        @PreAuthorize("hasRole('ADMIN')")
        public String getAdminData() {
            return "This is admin data";
        }

        @PreAuthorize("hasRole('USER')")
        public String getUserData() {
            return "This is user data";
        }
    }
    ```

    In this example, the `getAdminData()` method can only be accessed by users with the "ADMIN" role, and the `getUserData()` method can only be accessed by users with the "USER" role.

    This is just a basic overview of Spring Security. It provides many more features for securing your application, such as OAuth2, JWT, and LDAP integration.
*   **Q: What is the Builder design pattern and why would you use it?**

    **A:** The Builder pattern is a creational design pattern that is used to construct complex objects step by step. It separates the construction of a complex object from its representation, so that the same construction process can create different representations.

    **Why use the Builder pattern?**

    *   **Improves readability:** It makes the code more readable and easier to understand, especially when you have a large number of optional parameters.
    *   **Avoids telescoping constructors:** It helps to avoid the "telescoping constructor" anti-pattern, where you have a large number of constructors with different combinations of parameters.
    *   **Enforces immutability:** It can be used to create immutable objects, which are objects whose state cannot be changed after they are created. This is important for writing thread-safe code.
    *   **Provides flexibility:** It provides more flexibility in creating objects. You can create different representations of the same object by using different builder configurations.

    **Example:**

    Let's say we have a `User` class with a large number of optional parameters.

    **Without the Builder pattern:**

    ```java
    public class User {
        private final String firstName;
        private final String lastName;
        private final int age;
        private final String phone;
        private final String address;

        public User(String firstName, String lastName) {
            this(firstName, lastName, 0, null, null);
        }

        public User(String firstName, String lastName, int age) {
            this(firstName, lastName, age, null, null);
        }

        public User(String firstName, String lastName, int age, String phone) {
            this(firstName, lastName, age, phone, null);
        }

        public User(String firstName, String lastName, int age, String phone, String address) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.phone = phone;
            this.address = address;
        }
    }
    ```

    As you can see, the telescoping constructor pattern makes the code difficult to read and maintain.

    **With the Builder pattern:**

    ```java
    public class User {
        private final String firstName;
        private final String lastName;
        private final int age;
        private final String phone;
        private final String address;

        private User(UserBuilder builder) {
            this.firstName = builder.firstName;
            this.lastName = builder.lastName;
            this.age = builder.age;
            this.phone = builder.phone;
            this.address = builder.address;
        }

        public static class UserBuilder {
            private final String firstName;
            private final String lastName;
            private int age;
            private String phone;
            private String address;

            public UserBuilder(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            public UserBuilder age(int age) {
                this.age = age;
                return this;
            }

            public UserBuilder phone(String phone) {
                this.phone = phone;
                return this;
            }

            public UserBuilder address(String address) {
                this.address = address;
                return this;
            }

            public User build() {
                return new User(this);
            }
        }
    }
    ```

    Now, you can create a `User` object like this:

    ```java
    User user = new User.UserBuilder("John", "Doe")
        .age(30)
        .phone("123-456-7890")
        .address("123 Main St")
        .build();
    ```

    This code is much more readable and easier to maintain.
*   **Q: What is the difference between `Mono` and `Flux` in Spring WebFlux?**

    **A:** `Mono` and `Flux` are the two main publisher types in Project Reactor, which is the reactive library that powers Spring WebFlux. They both represent a stream of asynchronous data, but they have a key difference:

    *   **`Mono`** represents a stream of **0 or 1** elements. It is used when you expect a single result or no result at all. For example, a `Mono<User>` would be used to represent a method that returns a single user from a database.

    *   **`Flux`** represents a stream of **0 to N** elements. It is used when you expect multiple results. For example, a `Flux<User>` would be used to represent a method that returns all the users from a database.

    **Key Differences:**

| Feature      | `Mono`                               | `Flux`                               |
| :----------- | :----------------------------------- | :----------------------------------- |
| **Cardinality**| 0 or 1                               | 0 to N                               |
| **Use Case** | When you expect a single or no result. | When you expect multiple results.    |
| **Example**  | `Mono<User>`                         | `Flux<User>`                         |

    **Example:**

    Let's say we have a `UserService` that has methods for getting a single user and all users.

    ```java
    import org.springframework.stereotype.Service;
    import reactor.core.publisher.Flux;
    import reactor.core.publisher.Mono;

    @Service
    public class UserService {

        private final UserRepository userRepository;

        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public Mono<User> getUserById(String id) {
            return userRepository.findById(id);
        }

        public Flux<User> getAllUsers() {
            return userRepository.findAll();
        }
    }
    ```
*   How do you test a REST Controller in Spring Boot?
*   What are the bean scopes in Spring?
*   How do you make a class immutable in Java?
*   What is the difference between `equals()` and `==`?
*   How do you handle connection and read timeouts for REST calls in Spring?
*   What are records in Java 17 and what are their benefits?
*   What is the purpose of a discovery service like Eureka in a microservices architecture?
*   How would you implement a thread-safe Singleton pattern in Java?

---

## Contributing

Contributions are welcome! If you have any questions or suggestions, please feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License.
