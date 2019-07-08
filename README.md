# springboot学习之旅

###### 了解并使用第一个springboot程序（2017.04.23）

一般将SpringbootApplication(articalID + Application)启动程序和其他包放在同一路径下，例如controller、dao层的包，以便启动程序的时候扫描其他注解。

---

###### 如何创建 war 文件（2019.07.08）

1. The first step in producing a deployable war file is to provide a SpringBootServletInitializer subclass and override its configure method. Doing so makes use of Spring Framework’s Servlet 3.0 support and lets you configure your application when it is launched by the servlet container. Typically, you should update your application’s main class to extend SpringBootServletInitializer, as shown in the following example:
```
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Application.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
```
2.The next step is to update your build configuration such that your project produces a war file rather than a jar file. If you use Maven and spring-boot-starter-parent (which configures Maven’s war plugin for you), all you need to do is to modify pom.xml to change the packaging to war, as follows:
```
<packaging>war</packaging>
```
3.The final step in the process is to ensure that the embedded servlet container does not interfere with the servlet container to which the war file is deployed. To do so, you need to mark the embedded servlet container dependency as being provided.

If you use Maven, the following example marks the servlet container (Tomcat, in this case) as being provided:
```
<dependencies>
	<!-- … -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-tomcat</artifactId>
		<scope>provided</scope>
	</dependency>
	<!-- … -->
</dependencies>
```
