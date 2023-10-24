package com.insurance.component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;

@Component
public class EmailComponent {
	
	@Autowired private JavaMailSender javaMailSender;
	
	public void sendContactEmail(JsonNode payload) {
		String name = payload.get("name").asText();
		String email = payload.get("email").asText();
		String subject = payload.get("subject").asText();
		String message = payload.get("message").asText();
		
		String senderInfo = "Sent by " + name + " (" + email + "): " + "\n\n";
		message = senderInfo + message;
		
        SimpleMailMessage myMessage = new SimpleMailMessage();
        myMessage.setTo("GarrickSession55@gmail.com");
        myMessage.setSubject(subject);
        myMessage.setText(message);
        //myMessage.setText("Dear " + booking.get("userName").asText() + ",\n\nYour booking has been confirmed. You can find the details below. We hope you enjoy your stay!\n\n" + "Check-In Date: " + booking.get("checkInDate").asText() + "\nCheck-Out Date: " + booking.get("checkOutDate").asText() + "\nRoom Type: " + booking.get("roomType").asText() + "\nNumber of Rooms: " + booking.get("noRooms").asText() + "\nTotal Cost: " + booking.get("finalCharges").asText() + "\nTotal Savings: " + booking.get("totalSavings") + "\n\nBest Regards,\nTravel Gig");
        
        javaMailSender.send(myMessage);
        
        System.out.println("Email sent!");
	}
	
	public void sendQuoteEmail(JsonNode payload) {
		String name = payload.get("name").asText();
		String email = payload.get("email").asText();
		String phNo = payload.get("phNo").asText();
		String valuation = payload.get("valuation").asText();
		String message = payload.get("message").asText();
		JsonNode plansNode = payload.get("plans");
		
		List<String> plans = new ArrayList<>();
		if (plansNode.isArray()) {
			for (JsonNode planNode : plansNode) {
				plans.add(planNode.asText());
			}
		}
		
        SimpleMailMessage myMessage1 = new SimpleMailMessage();
        myMessage1.setTo("GarrickSession55@gmail.com");
        myMessage1.setSubject("Quote Request");
        String info = "Name: " + name + "\nEmail: " + email + "\nPhone Number: " + phNo + "\nEstimated Vehicle Valuation: " + valuation + "\nCoverages: " + plans.stream().collect(Collectors.joining(", ")) + "\nMessage: " + message;
        myMessage1.setText(info);
        
        SimpleMailMessage myMessage2 = new SimpleMailMessage();
        myMessage2.setTo(email);
        myMessage2.setSubject("Your Auto Insurance Quote Request");
        String body = "Dear " + name + ",\n\nThank you for requesting a free auto insurance quote from Auto Insurance Gig. We appreciate your interest in our services. Your request has been received, and we are processing the information you provided.\n\nQuote Details:\n\nName: " + name + "\nEmail: " + email + "\nPhone Number: " + phNo + "\nEstimated Vehicle Valuation: " + valuation + "\nCoverage Plans Selected: " + plans.stream().collect(Collectors.joining(", ")) + "\n\nOur team will work diligently to prepare your auto insurance quote. We aim to provide you with competitive rates and comprehensive coverage options that align with your preferences. You can expect to receive your personalized quote within the next 24-48 hours.\n\nThank you for choosing Auto Insurance Gig. We look forward to serving your insurance needs and providing you with peace of mind on the road.\n\nBest regards,\nAuto Insurance Gig";
        myMessage2.setText(body);
        
        javaMailSender.send(myMessage1);
        javaMailSender.send(myMessage2);
        
        System.out.println("Emails sent!");
	}
}
