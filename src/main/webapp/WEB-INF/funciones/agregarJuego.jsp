<div class="modal fade" id="agregarJuegoModal" tabindex="-1" aria-labelledby="agregarJuegoModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar juego a stock</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" name="nombre" required/>
                    </div>
                     <div class="form-group">
                        <label for="genero">Género:</label>
                        <input type="text" class="form-control" name="genero" required/>
                    </div>
                     <div class="form-group">
                        <label for="plataforma">Plataforma:</label>
                        <input type="text" class="form-control" name="plataforma" required/>
                     </div>
                     <div class="form-group">
                        <label for="unidades">Unidades:</label>
                        <input type="number" class="form-control" name="unidades" required/>
                    </div>
                     <div class="form-group">
                        <label for="precio">Precio:</label>
                        <input type="number" class="form-control" name="precio" required/>
                    </div>
                     <div class="modal-footer">
                        <button class="btn btn-primary" type="submit">Cargar a stock</button>
                    </div>
                </div>
            </form> 
        </div>
    </div>
</div>
