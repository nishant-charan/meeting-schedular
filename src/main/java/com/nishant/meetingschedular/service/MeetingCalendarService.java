package com.nishant.meetingschedular.service;

import com.nishant.meetingschedular.dto.MeetingInviteDto;
import org.springframework.stereotype.Service;

@Service("meetingCalendarService")
public class MeetingCalendarService {

  public MeetingInviteDto createInvite(MeetingInviteDto meetingInviteDto) {
    return new MeetingInviteDto();
  }

  public MeetingInviteDto updateInvite(MeetingInviteDto meetingInviteDto) {
    return new MeetingInviteDto();
  }

  public MeetingInviteDto cancelInvite(MeetingInviteDto meetingInviteDto) {
    return new MeetingInviteDto();
  }
}
