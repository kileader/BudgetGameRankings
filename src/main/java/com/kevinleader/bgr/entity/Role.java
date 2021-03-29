//package com.kevinleader.bgr.entity;
//
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//
///**
// * A javabean class to represent a role.
// *
// * @author Kevin Leader
// */
//@Entity(name = "Role")
//@Table(name = "role")
//public class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
//    @GenericGenerator(name = "native", strategy = "native")
//    private int id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id_fk"))
//    private User user;
//
//    @Column(name = "role_name")
//    private String roleName;
//
//}
