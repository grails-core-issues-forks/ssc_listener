import com.nationwide.workspace.springsecurity.events.WorkspaceInteractiveAuthenticationSuccessEvent
import demo.UserPasswordEncoderListener
// Place your Spring DSL code here

beans = {
    mySecurityEventListener(WorkspaceInteractiveAuthenticationSuccessEvent)
    userPasswordEncoderListener(UserPasswordEncoderListener, ref('hibernateDatastore'))
}
