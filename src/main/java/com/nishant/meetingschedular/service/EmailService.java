package com.nishant.meetingschedular.service;

import com.nishant.meetingschedular.entity.UserEmail;
import com.nishant.meetingschedular.repository.UserEmailRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {

  @Autowired
  private UserEmailRepository userEmailRepository;

  public List<UserEmail> getUserEmails() {
    return userEmailRepository.findAll();
  }
}
