package iservices;

import javax.ejb.Local;

import entites.User;

@Local
public interface IUserService {

	public boolean login(User us);
	public void signup(User us);
	public void EditProfile(User us);
	public User ShowProfile(int id);
	User findUser(User user);
	public User findUserByMail(String mail);
}
