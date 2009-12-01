import org.zkoss.zkgrails.*
import org.zkoss.zk.ui.*
import org.zkoss.zk.ui.event.*

class ForgotPasswordComposer extends GrailsComposer {
    
    def txtUsername
    def txtEmail
    
    def onClick_btnReset(Event e) {
        def person = null
        if(txtUserId.value != "") {
            person = Person.findByUsername(txtUsername.value)            
        } else if (txtEmail.value != "") {
            person = Person.findByEmail(txtEmail.value)
        }

        if(person) {
            // send email to user
        } else {
            // show message "No input"
        }
    }
    
    def afterCompose = { comp ->
        
    }
    
}