package com.nishant.meetingschedular.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class AvailableSlotDto {

  private LocalDateTime availabeSlotStartTime;

  private LocalDateTime availabeSlotEndTime;

}
