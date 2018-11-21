package iservices;

import java.sql.Date;
import java.util.List;

import javax.ejb.Local;

import entites.Donation;

@Local
public interface IDonationService {
	public  List<Donation> getDonations() ;
	public void AddDonation (Donation donation) ;
	public void EditDonation(Donation donation);
	public Donation ShowDonation(int id);
	public void DeletDonation(Donation donation);
	public float giftStatistic ();
	public float demandStatistic();
	public float fundRaisingStatistic();
	public int[] donationStatisticByYear(String year);
	public List<Donation> searchDonation(String tag,String type);
	public List<Donation> serachDonationByDate(Date date);
	
	
	
}
