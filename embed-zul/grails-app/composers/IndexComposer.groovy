import org.zkoss.zkgrails.*

class IndexComposer extends GrailsComposer {
    
    def txtName
    def btnHello
    def lstResult
    
    def onClick_btnHello() {
        lstResult.clear()
        lstResult.append {
            listitem { listcell { label(value: "Hello, ${txtName.value} !") } }
        }
    }
    
    def afterCompose = { c ->
        // initialize component here
    }
}
