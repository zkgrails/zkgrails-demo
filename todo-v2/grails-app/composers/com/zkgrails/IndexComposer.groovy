package com.zkgrails

import com.zkgrails.Event
import org.zkoss.zkgrails.*

class IndexComposer extends GrailsComposer {
    // matches 'arg0' in .zul file; 
    def page
    // tracks selected Event and contains getter methods  (i.e. Event.listAll())
    def todoFacade
    
    // injected
    def eventService

    // components
    def lstTodo  // zul listbox
    def fdName   // zul textbox on form
    def fdPriority
    def fdDate
    def lblMessage
    def btnSave

    def onClick_btnSave() {
        Event event = new Event(
            name:fdName.value, 
            priority:fdPriority.value, 
            date:fdDate.value
        )
        if (event.validate()) {
            event.save()
            lblMessage.value = "Event ${event.name} saved"
            todoFacade.saveButtonState=false
        } else {
            lblMessage.value = "Unable to save event"
        }
        update_ui()
    }

    def afterCompose = { c ->
        // initialize component here
    }

    // insert new Event instance into listbox.model
    def onClick_btnAdd() {
        def event = new Event()
        lstTodo.model.add(event) // <-- why isn't facade used here?
        todoFacade.selected = event
        // set current item 'selected'
        lstTodo.setSelectedIndex(lstTodo.model.size()-1)
        lblMessage.value = 'Add New Event'
        todoFacade.saveButtonState = true
        update_ui()
    }

    def onClick_btnUpdate() {
        // what does this do?
        Event.withTransaction {
            todoFacade.selected = todoFacade.selected.merge()
        }
        if(!todoFacade.selected) {
            lblMessage.value = 'Update failed'
            out.println("object cannot update")
        } else {
            lblMessage.value = "Updated event ${todoFacade.selected.id}"
            todoFacade.saveButtonState = false
        }
        update_ui()
    }

    //
    // remove selected first from facade then from model
    // aren't model and facade connected already?  why is this necessasary?
    // if not, am still unsure what's the use of the facade
    //
    def onClick_btnDelete() {
        if(!todoFacade.selected) {
         lblMessage.value = 'No Item Selected'
            out.println("object not found")
            return
        }

        int index = lstTodo.model.indexOf(todoFacade.selected)
        try {
            todoFacade.selected?.delete()
        } catch (e){
            lblMessage.value = 'Already deleted'
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
        lblMessage.value = 'Deleted'
        update_ui()
    }

    //
    // unselect any selected then re-assign binding vars 
    //
    def onClick_btnRefresh() {
        lstTodo.model = todoFacade.events
        todoFacade.selected = null
        lblMessage.value = 'Refreshed'
        
        update_ui()
    }
    
    //
    // using default variable 'page' (from where?) call getVariable for default
    // variable named 'binder'. 
    // Is there one binder per 'page'?  If I have multiple windows each with their
    // own 'apply=someComposer' then would I have 
    // def winbinder1 = win1.getVariable("binder")
    // def winbinder2 = win2.getVariable("binder")
    // etc?
    //
    def update_ui() {
        def binder = page.getVariable("binder")
        // Why do I have to keep assigning this in each call to update_ui?  Don't I connect them once and then 
        // just update the facade?  Still unclear on facade's use in binding.
        binder.loadComponent(fdName)
        binder.loadComponent(fdPriority)
        binder.loadComponent(fdDate)
        btnSave.visible = todoFacade.saveButtonState
        //
        // in the spirit of keeping code out of the UI, could I do model assignments
        // here?  Or should I put them in 'afterCompose'?        
        // i.e.     
        // lstTodo.model="todoFacade.events"
        // lstTodo.selectedItem="todoFacade.selected"
        //
    }
    
}
