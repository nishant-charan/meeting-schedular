package com.nishant.meetingschedular.restapi;

import com.nishant.meetingschedular.dto.AvailableSlotDto;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/meeting-slots", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiOperation(value = "Meeting Resource APIs")
public class MeetingResource {

  private static final Logger LOG = LoggerFactory.getLogger(MeetingResource.class);

  @GetMapping
  @ApiOperation(value = "Meeting Resource Available Slot API.")
  public ResponseEntity<List<AvailableSlotDto>> getAvailableSlot(@Valid @RequestParam(value = "email") String email,
      @RequestParam(value = "selectedDate") LocalDate selectedDate) {
    LOG.info("Getting available meeting slots for email : {} on {}", email, selectedDate);
    List<AvailableSlotDto> availableSlotDtos = new ArrayList<>();
    return ResponseEntity.ok(availableSlotDtos);
  }

}
