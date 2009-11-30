import org.zkoss.zkgrails.*
import org.zkoss.zk.ui.Executions

class IndexComposer extends GrailsComposer {

    def lstControllers
    def grailsApplication

    def afterCompose = { comp ->
        lstControllers.append {
            grailsApplication.controllerClasses.each { c ->
                listitem(value:c.logicalPropertyName, label: c.fullName, onClick:{ e ->
                    Executions.current.sendRedirect("/${e.target.value}")
                })
            }
        }
    }
}
