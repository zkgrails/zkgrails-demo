import org.zkoss.zkgrails.*
import org.zkoss.zkplus.databind.BindingListModelList

class TodoFacade {

    static scope = 'session'

    Event selected

    List<Event> getEvents() {
        new BindingListModelList(Event.list(), false)
    }

}
