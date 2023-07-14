<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="es_AR"/>

<section id="juegos">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                         <h4>Juegos en stock</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Género</th>
                                <th>Plataforma</th>
                                <th>Unidades</th>
                                <th>Precio</th>
                                <th>-</th>
                            </tr>
                        </thead>

                     
                        <tbody>   
                            <c:forEach var="juegos" items="${juegos}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${juegos.nombre}</td>
                                    <td>${juegos.genero}</td>
                                    <td>${juegos.plataforma}</td>
                                    <td>${juegos.unidades}</td>
                                    <td>
                                        <fmt:formatNumber value="${juegos.precio}" type="currency"/>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&idjuego=${juegos.idjuego}" class="btn btn-secondary">
                                            <i class=" fas fa-angle-double-right"></i>
                                            Editar
                                        </a>
                                    </td>
                                    </tr> 
                            </c:forEach>
                        </tbody>                
                    </table>
                </div>
            </div>
            
            
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3"> 
                    <div class="card-body">
                        <h3>Cantidad en stock</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i>
                            ${cantidadJuegos}
                        </h4>
                    </div>
                </div>
                
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Precio total</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i>
                            <fmt:formatNumber value="${precioTotal}" type="currency"/>
                        </h4>
                    </div>
                </div>
            </div>
            
        </div>
    </div>
</section>
<jsp:include page="agregarJuego.jsp"/>