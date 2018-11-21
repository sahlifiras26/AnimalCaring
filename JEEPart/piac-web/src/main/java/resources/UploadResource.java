package resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Path("/validate")
public class UploadResource {

	private final String UPLOADED_FILE_PATH = "C:\\Users\\Omar\\Desktop\\vets\\";

	@POST
	@Path("/form")
	@Consumes("multipart/form-data")
	public Response uploadFile(MultipartFormDataInput input) {
		
		String fileName = "";
		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		List<InputPart> inputParts = uploadForm.get("uploadedFile");
		for (InputPart inputPart : inputParts) {

		 try {

			MultivaluedMap<String, String> header = inputPart.getHeaders();
			System.out.println(header);
			fileName = getFileName(header);
			System.out.println(fileName);

			//convert the uploaded file to inputstream
			InputStream inputStream = inputPart.getBody(InputStream.class,null);

			byte [] bytes = IOUtils.toByteArray(inputStream);

			//constructs upload file path
			
			String filepath = UPLOADED_FILE_PATH + fileName;

			writeFile(bytes,filepath);

			System.out.println("pdf uploaded!!!");
			//get the mailto
			String mailto = input.getFormDataPart("mailTo", String.class, null);
			System.out.println("le mail "+mailto);
			//call the sendmail function
			sendmail(mailto,fileName,filepath);

		  } catch (IOException e) {
			e.printStackTrace();
		  }

		}
		return Response.status(200)
		    .entity("uploadFile is called, Uploaded file name : " + fileName).build();

	}

	
	private String getFileName(MultivaluedMap<String, String> header) {

		String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

		for (String filename : contentDisposition) {
			if ((filename.trim().startsWith("filename"))) {

				String[] name = filename.split("=");

				String finalFileName = name[1].trim().replaceAll("\"", "");
				return finalFileName;
			}
		}
		return "unknown";
	}

	//save to somewhere
	private void writeFile(byte[] content, String filename) throws IOException {

		File file = new File(filename);

		if (!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fop = new FileOutputStream(file);

		fop.write(content);
		fop.flush();
		fop.close();

	}
	private void sendmail(String mailto,String filename,String filepath){

		final String username = "ragroug11@gmail.com";
		final String password = "assassinomar";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		sendAttachmentEmail(session, mailto, "Credentials validation", filename,filepath);
		
	}
	public void sendAttachmentEmail(Session session, String mailto, String subject, String filename,String filepath){
		try{
	         MimeMessage msg = new MimeMessage(session);
	         msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
		     msg.addHeader("format", "flowed");
		     msg.addHeader("Content-Transfer-Encoding", "8bit");
		     msg.setFrom(new InternetAddress("ragroug11@gmail.com"));
		     msg.setSubject(subject, "UTF-8");

		     msg.setSentDate(new Date());

		     msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailto, false));
		      
	         // Create the message body part
	         BodyPart messageBodyPart = new MimeBodyPart();
	         // Fill the message
	         String message ="<body>";
	         message+="<style type=\"text/css\">";
	         message+="@media only screen and (max-width:480px) {";
	         message+="@-ms-viewport { width:320px; }";
	         message+="@viewport { width:320px; }";
	         message+="}";
	         message+="</style>";
	         message+="<style type=\"text/css\">";
	         message+="@media only screen and (min-width:480px) {.mj-column-per-100, * [aria-labelledby=\"mj-column-per-100\"] { width:100%!important; }}";
	         message+="</style>";
             message+="<div style=\"background-color:#F9F9F9;\">";
             message+="<div style=\"max-width:640px;margin:0 auto;box-shadow:0px 1px 5px rgba(0,0,0,0.1);border-radius:4px;overflow:hidden\">";
             message+="<div style=\"margin:0px auto;max-width:640px;background:#7289DA top center / cover no-repeat;\">";
             message+="<table  align=\"center\" border=\"0\" >";
             message+="<tbody><tr>";
             message+="<td style=\"text-align:center;vertical-align:top;direction:ltr;font-size:0px;padding:57px;\">";
             message+="<div style=\"cursor:auto;color:white;font-family:Whitney, Helvetica Neue, Helvetica, Arial, Lucida Grande, sans-serif;font-size:36px;font-weight:600;line-height:36px;text-align:center;\">Credentials Validation</div></td></tr></tbody></table></div>";
             message+="<div style=\"margin:0px auto;max-width:640px;background:#ffffff;\"><table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;background:#ffffff;\" align=\"center\" border=\"0\"><tbody><tr><td style=\"text-align:center;vertical-align:top;direction:ltr;font-size:0px;padding:40px 70px;\">";
             message+="<div aria-labelledby=\"mj-column-per-100\" class=\"mj-column-per-100 outlook-group-fix\" style=\"vertical-align:top;display:inline-block;direction:ltr;font-size:13px;text-align:justify;width:100%;\"><table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"><tbody><tr><td style=\"word-break:break-word;font-size:0px;padding:0px 0px 20px;\" align=\"left\"><div style=\"cursor:auto;color:#737F8D;font-family:Whitney, Helvetica Neue, Helvetica, Arial, Lucida Grande, sans-serif;font-size:16px;line-height:24px;text-align:left;\">";
             message+="<h2 style=\"font-family: Whitney, Helvetica Neue, Helvetica, Arial, Lucida Grande, sans-serif;font-weight: 500;font-size: 20px;color: #4F545C;letter-spacing: 0.27px;\">Dear Sir/Madam,</h2>";
             message+="<p  style=\"text-align: justify;\"><b style=\"color: red\">Animal Caring</b> is a platform that gathers people in pupose of helping animals and ensuring their welfare.</p><p style=\"text-align: justify;\">Mr <b>test</b>, a subscriber in our platform, claims that he is a member of your order and down below you can check the diploma he gave us.So could you please help us verify his credentials?</p>";
             message+="</div></td></tr><tr><td style=\"word-break:break-word;font-size:0px;padding:10px 25px;\" align=\"center\">";
             message+="<table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:separate;\" align=\"center\" border=\"0\"><tbody><tr>";
             message+="<td style=\"border:none;border-radius:3px;color:white;cursor:auto;\" align=\"center\" valign=\"middle\" bgcolor=\"lightseagreen\" width=\"56px\" height=\"35px\"><a href=\"http://reallygoodemails.com/wp-content/uploads/verify-email.html#\" style=\"text-decoration:none;line-height:100%;background:lightseagreen;color:white;font-family:Ubuntu, Helvetica, Arial, sans-serif;font-size:15px;font-weight:normal;text-transform:none;margin:0px;\" target=\"_blank\">Validate</a></td>";
             message+="<td style=\"width:15px;\"></td>";
             message+="<td style=\"border:none;border-radius:3px;color:white;cursor:auto;\" align=\"center\" valign=\"middle\" bgcolor=\"indianred\" width=\"56px\" height=\"35px\"><a href=\"http://reallygoodemails.com/wp-content/uploads/verify-email.html#\" style=\"text-decoration:none;line-height:100%;background:indianred;color:white;font-family:Ubuntu, Helvetica, Arial, sans-serif;font-size:15px;font-weight:normal;text-transform:none;margin:0px;\" target=\"_blank\">Reject</a></td>";
             message+="</tr></tbody></table></td></tr></tbody></table></div>";
             message+="</td></tr></tbody></table></div></div>";
             message+="</body>";
	         messageBodyPart.setContent(message, "text/html");
	         
	         // Create a multipart message for attachment
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Second part is attachment
	         messageBodyPart = new MimeBodyPart();
	         DataSource source = new FileDataSource(filepath);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         msg.setContent(multipart);

	         // Send message
	         Transport.send(msg);
	         System.out.println("EMail Sent Successfully with attachment!!");
	      }catch (MessagingException e) {
	         e.printStackTrace();
	      } 
	}
}
