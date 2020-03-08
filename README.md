## SpringBoot与Maven多配置组合
#### 1. pom中添加配置<br>
`由于springboot,默认使用<resource.delimiter>@</resource.delimiter>进行占位，
     这里有两种方式将其替换为${}方式占位`
```xml
    <properties>
        <java.version>1.8</java.version>
        <!--这里将springboot默认的替换掉 <resource.delimiter>@</resource.delimiter> -->
        <!-- 方式一：将@替换为${} -->
        <!--<resource.delimiter>${}</resource.delimiter>-->
    </properties>
    
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-resources-plugin</artifactId>
        <version>2.7</version>
        <!-- 方式二：将@替换为${} -->
        <configuration>
            <useDefaultDelimiters>false</useDefaultDelimiters>
            <delimiters>
                <delimiter>${*}</delimiter>
            </delimiters>
            <encoding>UTF-8</encoding>
        </configuration>
    </plugin>
```
添加profiles配置
```xml
    <profiles>
        <profile>
            <id>dev</id>
            <activation>
                <!--activeByDefault 为true表示，默认激活id为dev的profile-->
                <activeByDefault>true</activeByDefault>
            </activation>
            <!-- properties 里面可以添加自定义节点，如下添加了一个env节点 -->
            <properties>
                <!-- 这个节点的值可以在maven的其他地方引用，可以简单理解为定义了一个叫env的变量 -->
                <env>dev</env>
            </properties>
        </profile>

        <profile>
            <id>test</id>
            <properties>
                <env>test</env>
            </properties>
        </profile>

        <profile>
            <id>prod</id>
            <properties>
                <env>prod</env>
            </properties>
        </profile>
    </profiles>
```
bulild标签中添加要替换的文件配置，及去除那些位置不替换
```xml
    <build>
        <filters>
            <filter>src/main/resources/maven_build/${env}.properties</filter>
        </filters>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <filtering>true</filtering>
                <excludes>
                    <exclude>maven_build/**/*</exclude>
                </excludes>
            </resource>
        </resources>
        ...
    </build>
```
yml文件配置举例
```yaml
spring:
  profiles:
    active: ${spring.profiles.active}
```
properties文件举例
```yaml
spring.profiles.active=base
```

#### 2.使用springboot多yml进行分开配置
```yaml
spring:
  profiles:
    include: mybatis,mysql
```

#### 3.使用多环境打包
```
clean package -DskipTests -Pdev 开发包
clean package -DskipTests -Ptest 测试包
clean package -DskipTests -Pprod 生产包
```
_不理解的可以down项目跑一跑_
