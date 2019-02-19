# product-service
ECommerce Project

Steps:

1)Created product services with all Rest webservices:

 Product contains product id,product name,product Desc and product price
 
 Swagger UI URl:http://localhost:8080/swagger-ui.html
 
2)After that creating a naming server called eruka server:

Create a component for the naming server with spring initializer and add eureka server , config client , actuator and dev tools:

   * Add annotation @EnableEurekaServer in main class
   
   * Add this in the property file
   
		spring.application.name=eureka-naming-server
		server.port=8761
		eureka.client.register-with-eureka=false
		eureka.client.fetch-registry=false
		
	* Then run the server
	
3)Go to product service 

	* Add the dependency for eureka
	* in the main add the annotation @EnableDiscoveryClient
	* for registering with the naming server use this property file
		eureka.client.service-url.default-zone=http://localhost:8761/eureka
		
	*Eureka UI URL http://localhost:8761/


  
  
