package iservices;

import java.util.List;

import javax.ejb.Local;

import entites.Discussion;

@Local
public interface DiscussionServiceLocal {
	void addDiscussion(Discussion discussion);
	  void updateDiscussion(Discussion discussion);
	  void deleteDiscussion(Discussion discussion);
	  Discussion getDiscussion(int id);
	  List<Discussion> getAllDiscussions();
	  List<Discussion> getDiscussionbyForumId(int id);

}
