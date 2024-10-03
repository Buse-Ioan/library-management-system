package com.itschool.library.utils.solid;

public class SRP {
}

//Before: violating SRP (Single responsibility principle)
class UserService {
    void addUser() {
    }

    void sendEmail() {
    }
}

//After: following SRP (Single responsibility principle)
class UserService2 {
    void addUser() {
    }
}

class EmaiService {
        void sendEmail() {}
}