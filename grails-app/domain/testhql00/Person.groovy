package testhql00

class Person {

    String name

    static belongsTo = [personTitle: PersonTitle]

    static constraints = {
    }

    String toString() {
        return name
    }
}
