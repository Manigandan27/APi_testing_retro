package com.featzsoft.project2.adapter;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user where email LIKE  :email AND password LIKE :password")
    User findByName(String email, String password);


    @Query("SELECT * FROM user where email LIKE  :email")
    User findByEmail(String email);

    @Query("SELECT COUNT(*) from user")
    int countUsers();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}