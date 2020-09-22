package com.nishant.meetingschedular.dto;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MeetingInviteDto {

  private Long id;
  private String meetingInviteId;
  private String summary;
  private String description;
  private LocalDateTime startDateTime;
  private LocalDateTime endDateTime;
  private String location;
  private String participantEmail;
  private String coachEmail;
  private String inviteId;
  private String iCalender;

}
