package service;

import java.sql.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entites.Donation;
import entites.Event;
import iservices.IDonationService;

@LocalBean
@Stateless
public class DonationService implements IDonationService {

	@PersistenceContext(name="piac-ejb")
	private EntityManager em ;
	@Override
	public List<Donation> getDonations() {
		return em.createQuery("select d from Donation d" ).getResultList();
	}
	@Override
	public void AddDonation(Donation donation) {

		em.persist(donation);
	}
	@Override
	public void EditDonation(Donation donation) {

		em.merge(donation);
	}
	@Override
	public Donation ShowDonation(int id) {
		return em.find(Donation.class, id);
	}
	@Override
	public void DeletDonation(Donation donation) {
		em.remove(em.merge(donation));
		
	}
	@Override
	public float giftStatistic() {
		 float x=(em.createQuery("select d from Donation d where d.type='gift' " ).getResultList().size());
		 float y=(em.createQuery("select d from Donation d  " ).getResultList().size());
		 return (x/y)*100;
	}
	
	@Override
	public float demandStatistic() {
		 float x=(em.createQuery("select d from Donation d where d.type='demand' " ).getResultList().size());
		 float y=(em.createQuery("select d from Donation d  " ).getResultList().size());
		 return (x/y)*100;	}
	@Override
	public float fundRaisingStatistic() {
		 return em.createQuery("select d from Donation d where d.type='fundrasing' " ).getResultList().size();
	}
	@Override
	public List<Donation> searchDonation(String tag, String type) {
		return em.createQuery("select d from Donation d where d.nom like :n AND d.type = :t" ).setParameter("n","%"+ tag+"%").setParameter("t",type).getResultList();		
	}
	@Override
	public List<Donation> serachDonationByDate(Date date) {
		return em.createQuery("SELECT d FROM Donation d WHERE d.date = :date ")
				.setParameter("date", date).getResultList();	
		}
	
	@Override
	public int[] donationStatisticByYear(String year) {
		
		int List[]=new int[13];
		for (int i=0;i<=11;i++)
		List[i]= em.createQuery("SELECT d FROM Donation d WHERE month(d.date) = :i AND year(d.date) =:y ")
				.setParameter("i", i+1).setParameter("y",2017).getResultList().size();
	
	return List;
	}

	
	

}
