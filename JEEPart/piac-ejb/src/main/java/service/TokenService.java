package service;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.NotAuthorizedException;

import entites.TokenS;
import entites.User;
import iservices.IUserService;
import iservices.TokenServiceRemote;

@Stateless
public class TokenService implements TokenServiceRemote{
	
	@PersistenceContext(name="wediscus-ejb") 
	EntityManager em;
	
	@EJB
	IUserService userService;
	
	
	@Override
	public void setToken(String tokenValue, User user) {
		// TODO Auto-generated method stub
		TokenS token = new TokenS();
		token.setValue(tokenValue);
		
		TokenS queryToken = this.find(user);
		if(queryToken == null){
			token.setUser(user);
			Date expires = new Date();
	        expires.setTime(expires.getTime() + 1000 * 60 * 60 * 24);
			token.setExpiration(expires);
			this.save(token);
		}else{
			Date expires = new Date();
	        expires.setTime(expires.getTime() + 1000 * 60 * 60 * 24);
	        queryToken.setExpiration(expires);
	        queryToken.setValue(tokenValue);
	        em.merge(queryToken);
		}
		
	}

	@Override
	public User getUser(String tokenValue) throws NotAuthorizedException{
		TokenS token = this.find(tokenValue);
		
		if (token == null) {
            throw new NotAuthorizedException("Token unknown");
        }
        if (token.getExpiration().before(new Date())) {
            throw new NotAuthorizedException("Token expires");
        }
        Date expires = new Date();
        expires.setTime(expires.getTime() + 1000 * 60 * 60 * 24);
        token.setExpiration(expires);
        this.save(token);
		return token.getUser();
	}

	@Override
	public TokenS find(String tokenValue) {
		Query query = em.createQuery("SELECT t from TokenS t where t.value = :value");
		query.setParameter("value", tokenValue);
		return (TokenS) query.getSingleResult();
	}

	@Override
	public void save(TokenS token) {
		em.persist(token);	
	}

	@Override
	public TokenS find(User u) {
		Query query = em.createQuery("SELECT t from TokenS t where t.user = :id");
		query.setParameter("id", u);
		TokenS retToken = null;
		try{
			retToken = (TokenS) query.getSingleResult();
		}catch(Exception e){
			return null;
		}
		return retToken;
	}
	@Override
	public User getuserbytoken(String token){
		Query query = em.createQuery("SELECT t.user from TokenS t where t.value = :id");
		return (User) query.setParameter("id", token).getSingleResult();

	}
	
}