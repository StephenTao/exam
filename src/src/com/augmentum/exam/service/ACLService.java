package com.augmentum.exam.service;

public interface ACLService {

    boolean isAllow(int userId, String privilegeCode);

}
