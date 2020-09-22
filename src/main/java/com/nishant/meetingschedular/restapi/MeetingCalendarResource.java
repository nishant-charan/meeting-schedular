package com.nishant.meetingschedular.restapi;

import com.nishant.meetingschedular.dto.MeetingInviteDto;
import com.nishant.meetingschedular.service.MeetingCalendarService;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/meeting-calendar-invite", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiOperation(value = "Meeting Calendar APIs")
public class MeetingCalendarResource {

  private static final Logger LOG = LoggerFactory.getLogger(MeetingCalendarResource.class);

  @Autowired
  private MeetingCalendarService meetingCalendarService;

  @PostMapping
  @ApiOperation(value = "Meeting Calendar invite create API.")
  public ResponseEntity<MeetingInviteDto> createCalendarInvite(@Valid @RequestBody MeetingInviteDto meetingInviteDto) {
    LOG.info("Creating invite for : {}", meetingInviteDto.getInviteId());
    MeetingInviteDto savedMeetingInviteDto = meetingCalendarService.createInvite(meetingInviteDto);
    return ResponseEntity.ok(savedMeetingInviteDto);
  }

  @PutMapping
  @ApiOperation(value = "Meeting Calendar invite update API.")
  public ResponseEntity<MeetingInviteDto> updateCalendarInvite(@Valid @RequestBody MeetingInviteDto meetingInviteDto) {
    LOG.info("Updating invite for : {}", meetingInviteDto.getInviteId());
    MeetingInviteDto savedMeetingInviteDto = meetingCalendarService.updateInvite(meetingInviteDto);
    return ResponseEntity.ok(savedMeetingInviteDto);
  }

  @DeleteMapping
  @ApiOperation(value = "Meeting Calendar invite cancel API.")
  public ResponseEntity<MeetingInviteDto> cancelCalendarInvite(@Valid @RequestBody MeetingInviteDto meetingInviteDto) {
    LOG.info("Canceling invite for : {}", meetingInviteDto.getInviteId());
    MeetingInviteDto savedMeetingInviteDto = meetingCalendarService.cancelInvite(meetingInviteDto);
    return ResponseEntity.ok(savedMeetingInviteDto);
  }

}
