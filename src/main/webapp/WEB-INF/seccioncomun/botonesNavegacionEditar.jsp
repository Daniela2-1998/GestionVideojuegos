<section id="actions" class="py-4 mb-4">
        <div class="contenedor-botones">
            <div>
                <a href="index.jsp" class="btn boton-volver btn-block">
                    <i class="fas fa-arrow-left"></i>
                    Regresar al inicio
                </a>
            </div>
            <div class="espacio-botones">
                <div class="col-md-3">
                    <button type="submit" class="btn btn-success">
                        <i class="fas fa-check"></i>
                        Guardar modificación
                    </button>
                </div>

                <div class="col-md-3">
                    <a href="${pageContext.request.contextPath}/servletControlador?accion=eliminar&idjuego=${juegos.idjuego}" 
                       class="btn btn-danger btn-block">
                        <i class="fas fa-trash"></i>
                        Eliminar de stock
                    </a>
                </div>
            </div>
        </div>
    </section>