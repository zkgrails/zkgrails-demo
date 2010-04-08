import org.zkoss.zkgrails.*
import org.zkoss.zkplus.databind.BindingListModelList
import com.zkgrails.Event
import com.zkgrails.EventService

class TodoFacade {

    static scope = 'session'

    def eventService

    Event selected
    boolean saveButtonState

    List<Event> getEvents() {
        new BindingListModelList(Event.list(), false)
    }

}
