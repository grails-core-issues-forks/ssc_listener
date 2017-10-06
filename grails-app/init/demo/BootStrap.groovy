package demo

import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {

    def init = { servletContext ->
            User user = new User(username: 'sherlock', password: 'secret')
            user.save()
            Role role = new Role(authority: 'USER_ROLE')
            role.save()
            UserRole userRole = new UserRole(user: user, role: role)
            userRole.save()
    }
    def destroy = {
    }
}
