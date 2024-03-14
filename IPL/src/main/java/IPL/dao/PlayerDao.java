package IPL.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import IPL.dto.Players;

@Component
public class PlayerDao
{
	@Autowired
	EntityManager entityManager;
 public void playerSignUpDao( Players  players) 
  {
	 EntityTransaction  entityTransaction=entityManager.getTransaction();
	 entityTransaction.begin();
	 entityManager.persist(players);
	 entityTransaction.commit();
	
  }
 
  public Players playerLoginCheck(String username) 
  {
	List<Players> list=entityManager.createQuery("select x from Players x where username=?1").setParameter(1, username).getResultList();
	
	if(list.isEmpty())
	{
		return null;
	}
	else 
	{
		return list.get(0);
	}
  }
  
  public void updateDetails(Players players) 
  {
	  EntityTransaction  entityTransaction=entityManager.getTransaction();
		 entityTransaction.begin();
		 entityManager.merge(players);
		 entityTransaction.commit();
  }
  
  public List<Players> fetchAllPlayers() 
  {
		List<Players> players=entityManager.createQuery("select x from Players x").getResultList();
		if(players.isEmpty())
		{
			return null;
		}
		else 
		{
			return players;
		}  
  }

   public Players findFetch(int id) 
   {
	
	Players players=entityManager.find(Players.class, id);
	
	if(players==null)
	{
		return null;
	}
	else
	{
		return players;
	}
  }
   
   
   public List<Players> viewPlayerDao() 
   {
	   List<Players> players=entityManager.createQuery("select x from Players x where status='available'").getResultList();
	   return players;
   }


}
