package sakilaspring.dao;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sakilaspring.domain.Actor;

@Repository
public class ActorDAO {

	@PersistenceContext
	EntityManager em;
	
	public List<Actor> list(){
		TypedQuery<Actor> q = em.createNamedQuery("Actor.findAll", Actor.class);
		List<Actor> l = q.getResultList();
		return l;
	}
	
	public Actor byId(int id){
		return em.find(Actor.class, id);
	}
	
	@Transactional
	public void delete(int id){
		Actor a = em.find(Actor.class, id);
		em.remove(a);
	}
	
	@Transactional
	public void update(Actor a){
		Actor a1 = em.find(Actor.class, a.getActorId());
		a1.setFirstName(a.getFirstName());
		a1.setLastName(a.getLastName());
		a1.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		em.persist(a1);
	}

	@Transactional
	public void save(Actor a) {
	    if(a.getLastUpdate()==null){
			a.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		}
		em.persist(a);
	}
	
}
