package com.nationwide.workspace.springsecurity.events

import com.nationwide.workspace.WorkspaceService
import grails.transaction.Transactional
import grails.util.Holders
import groovy.transform.CompileDynamic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationListener
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent

@Slf4j
@CompileDynamic
class WorkspaceInteractiveAuthenticationSuccessEvent implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

    @Autowired
    WorkspaceService workspaceService

    @Transactional
    @Override
    void onApplicationEvent(InteractiveAuthenticationSuccessEvent e) {

        String userName = e?.getAuthentication()?.getPrincipal()?.username
        log.info 'Username: {}', userName
        workspaceService.setupSessionAfterLogin(userName)
    }
}
