package iservices;

import javax.ejb.Local;

import entites.TokenS;
import entites.User;

@Local
public interface TokenServiceRemote {
	public void setToken(String tokenValue, User user);
	public User getUser(String tokenValue);
	public TokenS find(String tokenValue);
	public TokenS find(User u);
	public void save(TokenS token);
	public User getuserbytoken(String token);

}
