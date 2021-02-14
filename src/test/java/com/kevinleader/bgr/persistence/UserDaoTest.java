package com.kevinleader.bgr.persistence;

import com.kevinleader.bgr.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;

    @BeforeEach
    void setUp() {
        dao = new UserDao();
    }

    @Test
    void getAllUsersSuccess() {
        List<User> users = dao.getAllUsers();
        assertEquals(7, users.size());
    }

    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(1);
        assertEquals("jdoe", retrievedUser.getUserName());
        assertEquals("jollydoe@gmail.com", retrievedUser.getEmail());
        assertEquals("supersecret1", retrievedUser.getPassword());
    }

    @Test
    void getByUsernameSuccess() {
        String userName = "j";
        List<User> users = dao.getByUsername(userName);
        assertEquals(2, users.size());
    }

    @Test
    void getByEmailSuccess() {
        String email = "mcgur";
        List<User> users = dao.getByEmail(email);
        assertEquals(1, users.size());
    }


}