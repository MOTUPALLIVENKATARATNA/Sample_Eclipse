import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class TextEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String to = "rani.b@datamedu.com";            // sender email
	        String from = "Venkat.r@datamedu.com";       // receiver email
	        String host = "smtp.diplemailsrvr.com";                   // mail server host
	        String pw="Motupalli.00333";

	       Properties props = System.getProperties();
	       props.put("mail.smtp.starttls.enable", "true");
	       props.setProperty("mail.smtp.host", host);
	       props.setProperty("mail.smtp.user",from);
	       props.setProperty("mail.smtp.password",pw);
	       props.setProperty("mail.smtp.port", "587");
	       props.setProperty("mail.smtp.auth", "true");

	        Session session = Session.getDefaultInstance(props); // default session

	        try {
	            MimeMessage message = new MimeMessage(session);        // email message
	            message.setFrom(new InternetAddress(from));                    // setting header fields
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            message.setSubject("Test Mail from Java Program"); // subject line

	            // actual mail body
	            message.setText("You can send mail from Java program by using mail API");

	            // Send message
	            Transport tr = session.getTransport("smtp");
	            tr.connect(host, from, pw);
	            message.saveChanges();      // don't forget this
	            tr.sendMessage(message, message.getAllRecipients());
	            tr.close();
	            System.out.println("Email Sent successfully....");
	        } catch (MessagingException mex) {
	            mex.printStackTrace();
	        }
		}

}
