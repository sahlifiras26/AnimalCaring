package iservices;

import java.util.List;

import javax.ejb.Local;

import entites.Forum;

@Local
public interface ForumServiceLocal {

	 void addForum(Forum forum);
	  void updateForum(Forum forum);
	  void deleteForum(Forum forum);
	  Forum getForum(int id);
	  List<Forum> getAllForums();
	  List<Forum> getForumbyid(int id);
}
