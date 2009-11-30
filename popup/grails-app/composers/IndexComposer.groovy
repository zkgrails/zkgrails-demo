import org.zkoss.zkgrails.*

class IndexComposer extends GrailsComposer {
    
    def txtName
    def btnHello
    def lstResult
    
    def indexFacade
    
    def wndTest
    
    def onClick_wndTest() {
        // supported the build property, issue 73
        def popup = build.popup(parent: wndTest.root) { // NPE here
            label(value: "email")
        }
        println "wndTest.root: $wndTest.root"        
    }
    
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
