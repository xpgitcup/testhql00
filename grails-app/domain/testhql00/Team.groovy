package testhql00

class Team {

    String thing
    Person leader

    static hasMany = [members: Person]

    static constraints = {
    }

    String toString() {
        return "${thing}"
    }
}
