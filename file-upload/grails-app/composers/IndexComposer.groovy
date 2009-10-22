import org.zkoss.zkgrails.*
import org.zkoss.zk.ui.event.UploadEvent

class IndexComposer extends GrailsComposer {
    
    def uploader
    def img
    
    def onUpload_uploader(UploadEvent e) {
        img.content = e.media
    }

    def afterCompose = { window ->
        // initialize components here
    }
}
