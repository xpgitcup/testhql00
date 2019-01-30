package testhql00

import grails.gorm.services.Service

@Service(PersonTitle)
interface PersonTitleService {

    PersonTitle get(Serializable id)

    List<PersonTitle> list(Map args)

    Long count()

    void delete(Serializable id)

    PersonTitle save(PersonTitle personTitle)

}