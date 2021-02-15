package com.kevinleader.bgr.persistence;

import com.kevinleader.bgr.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;

    @BeforeEach
    void setUp() {
        dao = new UserDao();
    }

//    @Test
//    void insertSuccess() {
//        User newUser = new User(0, "rphilman", "rphilman@yahoo.com", "finalanswer1mil");
//        int id = dao.insert(newUser);
//        assertNotEquals(0, id);
//        User insertedUser = dao.getById(id);
//        assertEquals("rphilman", insertedUser.getUserName());
//        assertEquals("rphilman@yahoo.com", insertedUser.getEmail());
//        assertEquals("finalanswer1mil", insertedUser.getPassword());
//    }

    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(6, users.size());
    }

    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(1);
        assertEquals("jcoyne", retrievedUser.getUserName());
        assertEquals("coynemcgoin@hotmail.com", retrievedUser.getEmail());
        assertEquals("supersecret1", retrievedUser.getPassword());
    }

    @Test
    void getByUsernameSuccess() {
        String userName = "d";
        List<User> users = dao.getByUsername(userName);
        assertEquals(2, users.size());
    }

    @Test
    void getByEmailSuccess() {
        String email = "bacon";
        List<User> users = dao.getByEmail(email);
        assertEquals(1, users.size());
    }

    @Test
    void saveOrUpdate() {
    }
//
//    @Test
//    void deleteSuccess() {
//        dao.delete(dao.getById(3));
//        assertNull(dao.getById(3));
//    }


}