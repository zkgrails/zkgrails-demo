import com.zkgrails.Event

class BootStrap {

     def init = { servletContext ->
         new Event(name:"event 1", priority: 1, date: new Date()).save()
         new Event(name:"event 2", priority: 2, date: new Date()).save()
         new Event(name:"event 3", priority: 1, date: new Date()).save()
         new Event(name:"event 4", priority: 2, date: new Date()).save()
         println "Created four events"
     }
     def destroy = {
     }
} 