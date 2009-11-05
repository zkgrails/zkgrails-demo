import org.zkoss.zkgrails.*

class IndexComposer extends GrailsComposer {

    def page
    def todoFacade

    // components
    def lstTodo
    def fdName
    def fdPriority
    def fdDate

    /*
    static aspect = {
        after(calls:['onClick_btnAdd',
                    'onClick_btnDelete',
                    'onClick_btnRefresh']) { context ->
            def binder = page.getVariable("binder")
            binder.loadComponent(fdName)
            binder.loadComponent(fdPriority)
            binder.loadComponent(fdDate)
        }        
    }
    */

    def afterCompose = { c ->
        // initialize component here
    }

    def onClick_btnAdd() {
        def event = new Event()

        lstTodo.model.add(event)
        todoFacade.selected = event
        lstTodo.setSelectedIndex(lstTodo.model.size()-1)
        
        update_ui()
    }

    def onClick_btnUpdate() {
        todoFacade.selected = todoFacade.selected.merge()
        if(!todoFacade.selected) {
            out.println("object cannot update")
        }
        
        update_ui()
    }

    def onClick_btnDelete() {
        if(!todoFacade.selected) {
            out.println("object not found")
            return
        }

        int index = lstTodo.model.indexOf(todoFacade.selected)
        try {
            todoFacade.selected?.delete()
        } catch (e){
            out.println("Someone else has already deleted this item.")
            return
        }

        lstTodo.model.remove(todoFacade.selected)
        if( index >= lstTodo.model.size() ){
            index = lstTodo.model.size() - 1
        }
        if( lstTodo.model.size() > 0 ){
            todoFacade.selected = lstTodo.model.get(index)
            lstTodo.selectedIndex = index
        } else {
            todoFacade.selected = null;
            lstTodo.selectedIndex = -1
        }
        
        update_ui()
    }

    def onClick_btnRefresh() {
        lstTodo.model = todoFacade.events
        todoFacade.selected = null
        
        update_ui()
    }
    
    def update_ui() {
        def binder = page.getVariable("binder")
        binder.loadComponent(fdName)
        binder.loadComponent(fdPriority)
        binder.loadComponent(fdDate)
    }
    
}
