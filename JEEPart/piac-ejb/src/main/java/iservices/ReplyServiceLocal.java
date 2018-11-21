package iservices;

import java.util.List;

import javax.ejb.Local;

import entites.Respond;

@Local
public interface ReplyServiceLocal {
	 void addRespond(Respond respond);
	  void updateRespond(Respond respond);
	  void deleteRespond(Respond respond);
	  Respond getRespond(int id);
	  List<Respond> getAllResponds();
	  List<Respond> getRespondbyDiscussionId(int id);

}
