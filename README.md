# mssc-beer-service
Microservice - beer service

Externalice the Host path

## MVC Rest Docs

### Configuration

This artifact ids maintained by spring framwork, so inherit the version number of this from the parent pom.

Steps:

__1__

~~~markdown
        <dependency>
            <groupId>org.springframework.restdocs</groupId>
            <artifactId>spring-restdocs-mockmvc</artifactId>
            <scope>test</scope>
        </dependency>
~~~

__2__

Plus. Bring asciidoctor maven plugin. And specify that this plugin should run in a specific phase, and a articular dependency.

~~~markdown
            <plugin>
                <groupId>org.asciidoctor</groupId>
                <artifactId>asciidoctor-maven-plugin</artifactId>
                <version>2.2.2</version>
                <executions>
                    <execution>
                        <id>generate-docs</id>
                        <phase>prepare-package</phase>
                        <goals>
                            <goal>process-asciidoc</goal>
                        </goals>
                        <configuration>
                            <backend>html</backend>
                            <doctype>book</doctype>
                        </configuration>
                    </execution>
                </executions>
                <dependencies>
                    <dependency>
                        <groupId>org.springframework.restdocs</groupId>
                        <artifactId>spring-restdocs-asciidoctor</artifactId>
                        <version>${spring-restdocs.version}</version>
                    </dependency>
                </dependencies>
            </plugin>
~~~

__3__
Also see a new folder: `src/main/asciidoc`, this is the default location  that is going to be looked for by the asciidoc plugin.

__4__
    
Add a file: `index.adoc`. An asciidoc document contsining a basic template.




