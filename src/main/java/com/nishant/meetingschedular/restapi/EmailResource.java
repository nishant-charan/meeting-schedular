package com.nishant.meetingschedular.restapi;

import com.nishant.meetingschedular.dto.UserEmailDto;
import com.nishant.meetingschedular.entity.UserEmail;
import com.nishant.meetingschedular.service.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.Email;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/email", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Email Authentication APIs")
public class EmailResource {

  private static final Logger LOG = LoggerFactory.getLogger(EmailResource.class);

  @Autowired
  private EmailService emailService;

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping("test")
  @ApiOperation(value = "Email Authentication Test API.")
  public ResponseEntity<Boolean> test() {
    LOG.info("Testing!!!");
    return ResponseEntity.ok(Boolean.TRUE);
  }

  @GetMapping("validate")
  @ApiOperation(value = "Email Authentication Validate API.")
  public ResponseEntity<Boolean> validateEmail(@RequestParam(value = "email") String email) {
    LOG.info("Validating email : {}", email);
    return ResponseEntity.ok(Boolean.TRUE);
  }

  @GetMapping("list")
  @ApiOperation(value = "Email Authentication List API.")
  public ResponseEntity<List<UserEmailDto>> list() {
    List<UserEmail> userEmails = emailService.getUserEmails();
    List<UserEmailDto> userEmailDtos = userEmails.stream().map(userEmail ->
        modelMapper.map(userEmail, UserEmailDto.class))
        .collect(Collectors.toList());
    return ResponseEntity.ok(userEmailDtos);
  }

  @GetMapping("authenticate")
  @ApiOperation(value = "Email Authentication API.")
  public ResponseEntity<Void> authenticate(@Email @RequestParam(value = "email")  String email,
      @RequestParam(value = "password") String password) {
    Boolean authenticatedFlag = emailService.authenticateEmail(email, password);
    if (authenticatedFlag) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
  }

}
