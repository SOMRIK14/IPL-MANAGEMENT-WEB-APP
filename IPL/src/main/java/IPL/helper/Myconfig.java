package IPL.helper;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "IPL")
public class Myconfig
{
  @Bean //mainly used to create ref varoiable for interface and return it
   public EntityManager getEM()
   {
	EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("dev") ;
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	return entityManager;
   }
}
