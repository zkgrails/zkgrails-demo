class BootStrap {

     def init = { servletContext ->
         new Event(name:"event 1", priority: 1, date: new Date()).save()
         new Event(name:"event 2", priority: 2, date: new Date()).save()
     }
     def destroy = {
     }
} 