import org.zkoss.zkgrails.*
import org.zkoss.zk.ui.*
import org.zkoss.zk.ui.event.*

class TestComposer extends GrailsComposer {
    
    def lblTest
    def session
    
    def afterCompose = { comp ->
        if(session.getAttribute("user") == "admin") {
            lblTest.value = "logged"
        } else {
            lblTest.value = "not"
        }
    }
}
