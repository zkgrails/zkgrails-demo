package com.zkgrails

import com.zkgrails.Event

class EventService {

    boolean transactional = true

    def getAllEvents() {
        Event.list()
    }
    
    def update(Event ev) {
        return ev.merge()
    }
    
}
