<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'team.label', default: 'Team')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-team" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                           default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
        <li><a href="team/testa">测试1</a></li>
    </ul>
</div>

<div id="list-team" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
<!--f:table collection="${teamList}" /-->
    <table>
        <thead>
        <th>事儿</th>
        <th>队长</th>
        <th>队员</th>
        </thead>
        <tbody>
        <g:each in="${teamList}" var="item" status="i">
            <tr class="${(i % 2 == 0) ? 'even' : 'odd'}">
                <td>${item.thing}</td>
                <td>
                    ${item.leader}
                    <a href="testa/${item.leader.id}">参与的</a>
                </td>
                <td>${item.members}</td>
            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${teamCount ?: 0}"/>
    </div>
</div>
</body>
</html>