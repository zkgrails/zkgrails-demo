import org.zkoss.zkgrails.*
import org.zkoss.zk.ui.*
import org.zkoss.zk.ui.event.*

class LoginComposer extends GrailsComposer {

    def txtUser
    def txtPassword
    
    def btnLogin
    
    def session
    
    def onClick_btnLogin(Event e) {
        println "txtUser.value"
        println "login"
        session.setAttribute("user", null)
        if(txtUser.value == "admin") {
            session.setAttribute("user", "admin")
            Executions.sendRedirect("/test.zul")
        } else {
            session.setAttribute("user", txtUser.value)
            Executions.sendRedirect("/test.zul")                    
        }
    }

    def afterCompose = { comp ->
        
    }

}
