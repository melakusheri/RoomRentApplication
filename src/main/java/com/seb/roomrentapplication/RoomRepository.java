package com.seb.roomrentapplication;

import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room,Long> {
Iterable<Room> findAllByAppUser(AppUser appUser);
}
