import org.zkoss.zkgrails.*
import org.zkoss.zk.ui.*
import org.zkoss.zk.ui.event.*

class RegisterComposer extends GrailsComposer {

    def txtUser
    def txtFullname
    def txtPassword
    def txtPassword2
    def txtEmail
    def txtCode
    
    def onClick_btnCreate(Event e) {
        println e
    }

}
