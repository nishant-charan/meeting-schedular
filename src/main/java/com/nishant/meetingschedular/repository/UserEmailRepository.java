package com.nishant.meetingschedular.repository;

import com.nishant.meetingschedular.entity.UserEmail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEmailRepository extends JpaRepository<UserEmail, Long> {

}
