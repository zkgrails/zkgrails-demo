import org.zkoss.zkgrails.*
import org.zkoss.zk.ui.*
import org.zkoss.zk.ui.event.*

class IndexComposer extends GrailsComposer {
	
	def fileUpload
	def gdMain
	def btnHello
	
	def onUpload_fileUpload(UploadEvent event) {
		println event.media
	}
	
	def onClick_btnHello(Event e) {
		gdMain.rows.children.clear()
		gdMain.rows.append {
			row {
				label(value: "test")
			}
		}
	}
	
	def afterCompose = { c ->
	}
	
}