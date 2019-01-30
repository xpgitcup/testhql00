package testhql00

class PersonTitle {

    String name

    static hasMany = [persons: Person]

    static constraints = {
    }

    String toString() {
        return name
    }
}
