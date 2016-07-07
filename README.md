#menuRestful

A menu restful WS. 

##Technologies:

1. Spring mvc
2. Tomcat
3. Maven
4. Git

Additional features:

* Spring MVC Test: the API Rest is fully tested
* JUnit framework: the business logic is fully tested
* Spring AOP framework: to log the execution time of service methods
* Project Design: Controller -> ServiceImpl -> DAO
* Interfaces
* Exception Handling

Considerations:

* The database is mocked
* Java 8
* IDE: Eclipse Mars

Additional tools to test the application:

* Json online viewer: [http://jsonviewer.stack.hu/](http://jsonviewer.stack.hu/)

##Methods:

1. **Get list of menus. HTTP Method: GET**
```
http://localhost:8080/menuRestfulWS/menu/list
```

2. **Get a menu items ordered by price or ranking. HTTP Method: GET**
```
http://localhost:8080/menuRestful/menu/1/items?orderby=price&asc=true
```

3. **Get a menu. HTTP Method: GET**
```
http://localhost:8080/menuRestful/menu/1
```

##Specific Business Logic:

1. **Sum of prices of items of a menu**
```
public double sumPricesOfItems(final Menu menu){ ... }
```

2. **Get quantity of active submenus of a menu**
```
public int getQtyActiveSubmenus(final Menu menu) { ... }
```
