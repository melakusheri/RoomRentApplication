package com.seb.roomrentapplication.repository;

import com.seb.roomrentapplication.model.AppUser;
import com.seb.roomrentapplication.model.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room,Long> {
Iterable<Room> findAllByAppUser(AppUser appUser);
}
