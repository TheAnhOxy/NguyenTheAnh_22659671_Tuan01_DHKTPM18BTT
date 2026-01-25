package com.shop.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailWorker {
    private final JavaMailSender mailSender;

    @RabbitListener(queues = "emailQueue")
    public void handleEmailJob(Map<String, String> job) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(job.get("email"));
        message.setSubject("Xác nhận đặt vé thành công");
        message.setText(job.get("content"));

        mailSender.send(message);
        System.out.println("Worker: Đã gửi email thành công cho " + job.get("email"));
    }
}