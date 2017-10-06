package com.nationwide.workspace

import demo.User
import grails.transaction.Transactional
import groovy.util.logging.Slf4j

@Slf4j
@Transactional
class WorkspaceService {

    void setupSessionAfterLogin(String username) {
        User u = User.findByUsername(username)
        log.debug ( 'Username retrieved from database: {}', u.username)
    }
}