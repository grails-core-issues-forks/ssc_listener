package com.nationwide.workspace.springsecurity.events

import com.nationwide.workspace.WorkspaceService
import demo.User
import grails.util.Holders
import groovy.transform.CompileDynamic
import groovy.util.logging.Slf4j
import org.springframework.context.ApplicationContext
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent

@Slf4j
@CompileDynamic
class WorkspaceInteractiveAuthenticationSuccessEvent {

    @CompileDynamic
    static void onInteractiveAuthenticationSuccessEvent(InteractiveAuthenticationSuccessEvent e, ApplicationContext appCtx) {
        User.withTransaction {
            WorkspaceService workspaceService = Holders.grailsApplication.mainContext.getBean("workspaceService")
            String userName = e?.getAuthentication()?.getPrincipal()?.username
            log.info 'Username: {}', userName
            workspaceService.setupSessionAfterLogin(userName)
        }
    }
}
