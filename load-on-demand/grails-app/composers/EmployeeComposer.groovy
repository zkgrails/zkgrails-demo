import org.zkoss.zkgrails.*
import lod.Employee

class EmployeeComposer extends GrailsComposer {
    
    static scaffold = Employee

    def afterCompose = { window ->
        // initialize components here
    }
}
