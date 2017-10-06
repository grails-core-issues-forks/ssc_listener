package demo

import geb.Page

class LoginPage extends Page {

    static content = {
        usernameInput { $('#username', 0) }
        passwordInput { $('#password', 0) }
        submitInput { $('#submit', 0) }
    }

    void login(String username, password) {
        usernameInput = username
        passwordInput = password
        submitInput.click()
    }
}
