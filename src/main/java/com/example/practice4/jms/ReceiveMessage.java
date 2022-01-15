package com.example.practice4.jms;

import com.example.practice4.model.EmailNotification;
import com.example.practice4.model.LogData;
import com.example.practice4.repository.EmailNotificationRepository;
import com.example.practice4.repository.LogDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

import static com.example.practice4.jms.SenderMessage.generateAndSendEmail;

@Component
public class ReceiveMessage {

    private final LogDataRepository logDataRepository;
    private final EmailNotificationRepository notificationEmailRepository;

    @Autowired
    public ReceiveMessage(LogDataRepository logDataRepository, EmailNotificationRepository notificationEmailRepository) {
        this.logDataRepository = logDataRepository;
        this.notificationEmailRepository = notificationEmailRepository;
    }

    @JmsListener(destination = "sampleQueue")
    public void receiveMessage(String massage) {
        String[] words = massage.split("\\s");
        LogData data = new LogData();
        data.setClassname(words[1]);
        data.setTypechange(words[0]);
        data.setValue(massage);
        logDataRepository.save(data);
        for ( EmailNotification m:notificationEmailRepository.findAll()) {
            if(words[0].equals(m.getCondition())) {
                sendEmail(massage,m.getEmail());
                System.out.println("Email :" + m.getEmail());
            }
        }

        System.out.println("Received :" + massage);
    }

    private void sendEmail(String massage, String email) {
        try {
            generateAndSendEmail(massage, email);
        } catch (MessagingException e) {
            System.out.println("Error - generateAndSendEmail");
        }
    }

}
