package testhql00

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TeamController {

    TeamService teamService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def testa(Person person) {
        //def teamList = Team.executeQuery("from Team team where :p in team.members", [p: person])
        //def teamList = Team.executeQuery("from Team team where team.members.contains(:p)", [p: person])
        //def teamList = Team.executeQuery("from Team team where team.leader=:p", [p: person])    //可以
        def teamList = Team.executeQuery("from Team team join Person person where person=3")    //
        [teamList: teamList]
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond teamService.list(params), model:[teamCount: teamService.count()]
    }

    def show(Long id) {
        respond teamService.get(id)
    }

    def create() {
        respond new Team(params)
    }

    def save(Team team) {
        if (team == null) {
            notFound()
            return
        }

        try {
            teamService.save(team)
        } catch (ValidationException e) {
            respond team.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'team.label', default: 'Team'), team.id])
                redirect team
            }
            '*' { respond team, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond teamService.get(id)
    }

    def update(Team team) {
        if (team == null) {
            notFound()
            return
        }

        try {
            teamService.save(team)
        } catch (ValidationException e) {
            respond team.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'team.label', default: 'Team'), team.id])
                redirect team
            }
            '*'{ respond team, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        teamService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'team.label', default: 'Team'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'team.label', default: 'Team'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
