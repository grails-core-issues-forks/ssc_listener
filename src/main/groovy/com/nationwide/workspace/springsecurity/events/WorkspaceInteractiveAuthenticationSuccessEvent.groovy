package com.nationwide.workspace.springsecurity.events

import com.nationwide.workspace.WorkspaceService
import grails.transaction.Transactional
import grails.util.Holders
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent

@Slf4j
@CompileStatic
class WorkspaceInteractiveAuthenticationSuccessEvent implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

    @Autowired
    WorkspaceService workspaceService

    @CompileDynamic
    @Override
    void onApplicationEvent(InteractiveAuthenticationSuccessEvent e) {

        String userName = e?.getAuthentication()?.getPrincipal()?.username
        log.debug 'Username: {}', userName
        if ( !userName ) {
            log.warn 'Unable to retrieve username from InteractiveAuthenticationSuccessEvent'
            return
        }
        handleInteractiveAuthenticationWithUsername(userName)

    }

    @Transactional
    void handleInteractiveAuthenticationWithUsername(String userName) {
        workspaceService.setupSessionAfterLogin(userName)
    }
}
