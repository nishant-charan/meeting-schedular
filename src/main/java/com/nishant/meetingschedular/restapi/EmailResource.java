package com.nishant.meetingschedular.restapi;

import com.nishant.meetingschedular.dto.UserEmailDto;
import com.nishant.meetingschedular.entity.UserEmail;
import com.nishant.meetingschedular.service.EmailService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/email", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmailResource {

  private static final Logger LOG = LoggerFactory.getLogger(EmailResource.class);

  @Autowired
  private EmailService emailService;

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping("test")
  public ResponseEntity<Boolean> test() {
    LOG.info("Testing!!!");
    return ResponseEntity.ok(Boolean.TRUE);
  }

  @GetMapping("validate")
  public ResponseEntity<Boolean> validateEmail(@RequestParam(value = "email") String email) {
    LOG.info("Validating email : {}", email);
    return ResponseEntity.ok(Boolean.TRUE);
  }

  @GetMapping("list")
  public ResponseEntity<List<UserEmailDto>> list() {
    List<UserEmail> userEmails = emailService.getUserEmails();
    List<UserEmailDto> userEmailDtos = userEmails.stream().map(userEmail ->
        modelMapper.map(userEmail, UserEmailDto.class))
        .collect(Collectors.toList());
    return ResponseEntity.ok(userEmailDtos);
  }

}
