//package com.example.looseCoupling;
//
//public class UserService {
//    public NotificationService notificationService;
//
//    public UserService(NotificationService notificationService) {
//        this.notificationService = notificationService;
//    }
//
//    public void notifyUser(String message) {
//        notificationService.send("Notification hello");
//    }
//
//    public void setNotificationService(NotificationService notificationService) {
//        this.notificationService = notificationService;
//    }
//}

package com.example.looseCoupling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private NotificationService notificationService;

    @Autowired
    public UserService(@Qualifier("emailService") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyUser(String message) {
        notificationService.send(message);
    }
}