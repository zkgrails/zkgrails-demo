import org.zkoss.zkgrails.*;
import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.event.*;
import org.springframework.security.annotation.Secured;
//import org.codehaus.groovy.grails.plugins.springsecurity.Secured;

class RegisterComposer extends GrailsComposer {
    
    // injected from Spring Security
    def authenticateService

    def txtUser
    def txtFullname
    def txtPassword
    def txtPassword2
    def txtEmail
    def txtCode
    
    // this should be automatic
    @Secured(["ROLE_SUPERVISOR"])
    def onClick_btnCreate(Event e) {        
        println authenticateService.principal()
        // todo
    }

}
