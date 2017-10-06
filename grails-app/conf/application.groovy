import com.nationwide.workspace.springsecurity.events.WorkspaceInteractiveAuthenticationSuccessEvent

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'demo.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'demo.UserRole'
grails.plugin.springsecurity.authority.className = 'demo.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.useSecurityEventListener = true

grails.plugin.springsecurity.onInteractiveAuthenticationSuccessEvent = { e, appCtx ->
	WorkspaceInteractiveAuthenticationSuccessEvent.onInteractiveAuthenticationSuccessEvent(e, appCtx)
}

grails.plugin.springsecurity.onAbstractAuthenticationFailureEvent = { e, appCtx ->
	// handle AbstractAuthenticationFailureEvent
}

grails.plugin.springsecurity.onAuthenticationSuccessEvent = { e, appCtx ->
	// handle AuthenticationSuccessEvent
}

grails.plugin.springsecurity.onAuthenticationSwitchUserEvent = { e, appCtx ->
	// handle AuthenticationSwitchUserEvent
}

grails.plugin.springsecurity.onAuthorizationEvent = { e, appCtx ->
	// handle AuthorizationEvent
}
