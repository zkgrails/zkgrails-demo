import org.zkoss.zkgrails.*

class IndexComposer extends GrailsComposer {
    
    def txtName
    def btnHello
    def lstResult
    
    def indexFacade
    
    def wndTest
    
    def onClick_wndTest() {
        def zk = new ZkBuilder(parent: wndTest.root)
        println "wndTest.root: $wndTest.root"
        def popup = zk.popup() { // NPE here
            label(value: "email")
        }
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
