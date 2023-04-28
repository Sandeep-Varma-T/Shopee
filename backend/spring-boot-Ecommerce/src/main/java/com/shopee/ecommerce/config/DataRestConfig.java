package com.shopee.ecommerce.config;

import com.shopee.ecommerce.Entity.Country;
import com.shopee.ecommerce.Entity.Product;
import com.shopee.ecommerce.Entity.ProductCategory;
import com.shopee.ecommerce.Entity.State;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Value("${allowed.origins}")
    private String[] allowedOrigins;

    @Autowired
    public DataRestConfig(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config , CorsRegistry cors) {
        HttpMethod[] unSupportedActions = {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE,HttpMethod.PATCH};

        //disabling the HTTP POST, PUT and DELETE methods for products end point
        restrictEndPoints(Product.class, config, unSupportedActions);
        restrictEndPoints(ProductCategory.class,config, unSupportedActions);
        restrictEndPoints(Country.class,config, unSupportedActions);
        restrictEndPoints(State.class, config, unSupportedActions);
        //disabling the HTTP POST, PUT and DELETE methods for product-category end point

        exposeIds(config);

        cors.addMapping(config.getBasePath() + "/**").allowedOrigins(allowedOrigins);
    }

    private static void restrictEndPoints(Class theClass, RepositoryRestConfiguration config, HttpMethod[] unSupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unSupportedActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(unSupportedActions)));
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        List<Class> entityClasses = new ArrayList<>();

        for(EntityType entityType: entities){
            entityClasses.add(entityType.getJavaType());
        }
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);

    }
}
