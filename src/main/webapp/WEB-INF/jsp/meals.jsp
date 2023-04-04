<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/topjava.meals.js" defer></script>
<script type="text/javascript" src="resources/js/topjava.common.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <h3><spring:message code="meal.title"/></h3>

        <form method="get" action="meals/filter">
            <div class="form-group col-4">
                <label for="startDateInput"><spring:message code="meal.startDate"/>:</label>
                <input class="form-control" type="date" id="startDateInput" name="startDate" value="${param.startDate}">
            </div>

            <div class="form-group col-4">
                <label for="endDateInput"><spring:message code="meal.endDate"/>:</label>
                <input class="form-control" type="date" id="endDateInput" name="endDate" value="${param.endDate}">
            </div>
            <div class="form-group col-4">
                <label for="startTimeInput"><spring:message code="meal.startTime"/>:</label>
                <input class="form-control" type="time" id="startTimeInput" name="startTime" value="${param.startTime}">
            </div>
            <div class="form-group col-4">
                <label for="endTimeInput"><spring:message code="meal.endTime"/>:</label>
                <input class="form-control" type="time" id="endTimeInput" name="endTime" value="${param.endTime}">
            </div>
            <button class="btn btn-primary" type="submit">
                <span class="fa fa-filter"></span>
                <spring:message code="meal.filter"/>
            </button>
        </form>
        <hr>
        <%--    <a href="meals/create"><spring:message code="meal.add"/></a>--%>
        <button class="btn btn-primary" onclick="add()">
            <span class="fa fa-plus"></span>
            <spring:message code="meal.add"/>
        </button>

        <hr>
        <table class="table table-striped" id="datatable">
            <thead>
            <tr>
                <th><spring:message code="meal.dateTime"/></th>
                <th><spring:message code="meal.description"/></th>
                <th><spring:message code="meal.calories"/></th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${meals}" var="meal">
                <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.to.MealTo"/>
                <tr data-mealExcess="${meal.excess}">
                    <td>
                            <%--${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}--%>
                            <%--<%=TimeUtil.toString(meal.getDateTime())%>--%>
                            <%--${fn:replace(meal.dateTime, 'T', ' ')}--%>
                            ${fn:formatDateTime(meal.dateTime)}
                    </td>
                    <td>${meal.description}</td>
                    <td>${meal.calories}</td>
                        <%--                <td><a href="meals/update?id=${meal.id}"><spring:message code="common.update"/></a></td>--%>
                    <td><a><span class="fa fa-pencil"></span></a></td>
                    <td><a class="delete" id="${meal.id}"><span class="fa fa-remove"></span></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<div class="modal" tabindex="-1" role="dialog" id="editRow">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"><spring:message code="meal.add"/></h4>
                <button type="button" class="close" data-dismiss="modal" onclick="closeNoty()">&times;</button>
            </div>
            <div class="modal-body">
                <form id="detailsForm">
                    <input type="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="dateTime" class="col-form-label"><spring:message code="meal.dateTime"/></label>
                        <input type="datetime-local" class="form-control" id="dateTime" name="dateTime"
                               placeholder="<spring:message code="meal.dateTime"/>">
                    </div>

                    <div class="form-group">
                        <label for="description" class="col-form-label"><spring:message code="meal.description"/></label>
                        <input type="text" class="form-control" id="description" name="description"
                               placeholder="<spring:message code="meal.description"/>">
                    </div>

                    <div class="form-group">
                        <label for="calories" class="col-form-label"><spring:message code="meal.calories"/></label>
                        <input type="number" class="form-control" id="calories" name="calories"
                               placeholder="<spring:message code="meal.calories"/>">
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="closeNoty()">
                    <span class="fa fa-close"></span>
                    <spring:message code="common.cancel"/>
                </button>
                <button type="button" class="btn btn-primary" onclick="save()">
                    <span class="fa fa-check"></span>
                    <spring:message code="common.save"/>
                </button>
            </div>
        </div>
    </div>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>