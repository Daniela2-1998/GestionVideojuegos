<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styless.css">
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/382381b436.js" crossorigin="anonymous"></script>
        
        <title>Editar juego</title>
    </head>
    <body>
        <jsp:include page="../seccioncomun/cabecera.jsp"/>
        
         <form action="${pageContext.request.contextPath}/servletControlador?accion=modificar&idjuego=${juegos.idjuego}" method="POST" class="was-validated">
            <jsp:include page="../seccioncomun/botonesNavegacionEditar.jsp"/>
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar juego</h4>
                                </div>
                                
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre:</label>
                                        <input type="text" class="form-control" name="nombre" value="${juegos.nombre}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="genero">Género:</label>
                                        <input type="text" class="form-control" name="genero" value="${juegos.genero}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="plataforma">Plataforma:</label>
                                        <input type="text" class="form-control" name="plataforma" value="${juegos.plataforma}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="unidades">Unidades:</label>
                                        <input type="number" class="form-control" name="unidades" value="${juegos.unidades}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="precio">Precio:</label>
                                        <input type="number" class="form-control" name="precio" value="${juegos.precio}" required/>
                                    </div>
                                </div>
                            </div>
                        </div> 
                    </div>
                </div>
            </section>
        </form>
        
        
        <jsp:include page="../seccioncomun/pieDePagina.jsp"/>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
</html>  