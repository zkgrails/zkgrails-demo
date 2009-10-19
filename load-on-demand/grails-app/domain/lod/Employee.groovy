package lod

class Employee {
    
    String firstName
    String lastName

    static constraints = {
        firstName()
        lastName()
    }
}
