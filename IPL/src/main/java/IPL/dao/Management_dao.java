package IPL.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import IPL.dto.Management;

@Component
public class Management_dao {
	@Autowired
	EntityManager entityManager; //take object from the Em()

	public void Management_save(Management management) 
	{
		// EntityManagerFactory entityManagerFactory=
		// Persistence.createEntityManagerFactory("dev") ;
		// EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(management);
		entityTransaction.commit();
	}
	
	public Management management_Login_fetch(String name) 
	{
		List<Management> list=entityManager.createQuery("select x from Management x where name=?1").setParameter(1, name).getResultList();
		
		if(list.isEmpty())
		{
			return null;
			
		}
		else 
		{
			return list.get(0);
		}
	}

	

}
