package testhql00

class BootStrap {

    def init = { servletContext ->
        for (int i = 0; i < 5; i++) {
            def nt = new PersonTitle(name: "职称${i}")
            nt.save()
            for (int j = 0; j < i + 1; j++) {
                def np = new Person(name: "张${i}.${j}", personTitle: nt)
                np.save()
                def nte = new Team(thing: "${np}的事儿", leader: np)
                if (j>1) {
                    def zcn = "职称${j-1}"
                    def zc = PersonTitle.findByName(zcn)
                    def ms = Person.findAllByPersonTitle(zc)
                    println("${ms}")
                    nte.members = []
                    nte.members.addAll(ms)
                }
                nte.save()
            }
        }
    }
    def destroy = {
    }
}
