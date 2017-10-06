package com.nationwide.workspace

import demo.User
import grails.transaction.Transactional

@Transactional
class WorkspaceService {

    void setupSessionAfterLogin(String username) {
        User u = User.findByUsername(username)
    }
}