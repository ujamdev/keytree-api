package io.devlabs.keytree.domains.schedule.application;

import io.devlabs.keytree.domains.schedule.application.dto.CreateScheduleRequest;
import io.devlabs.keytree.domains.schedule.application.dto.CreateScheduleResponse;
import io.devlabs.keytree.domains.schedule.domain.Schedule;
import io.devlabs.keytree.domains.schedule.domain.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

  private final ScheduleRepository scheduleRepository;

  @Transactional
  public CreateScheduleResponse createSchedule(CreateScheduleRequest request) {
    Schedule schedule =
        Schedule.builder()
            .startedAt(request.getStartedAt())
            .finishedAt(request.getFinishedAt())
            .title(request.getTitle())
            .contents(request.getContents())
            .build();

    Schedule savedSchedule = scheduleRepository.save(schedule);

    return CreateScheduleResponse.builder()
        .id(savedSchedule.getId())
        .startedAt(savedSchedule.getStartedAt())
        .finishedAt(savedSchedule.getFinishedAt())
        .title(savedSchedule.getTitle())
        .contents(savedSchedule.getContents())
        .build();
  }
}
