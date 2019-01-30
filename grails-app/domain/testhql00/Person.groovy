package testhql00

class Person {

    String name

    static belongsTo = [personTitle: PersonTitle]
    //static hasMany = [teeam: Team]

    static constraints = {
    }

    String toString() {
        return "${id}.${name}"
    }
}
