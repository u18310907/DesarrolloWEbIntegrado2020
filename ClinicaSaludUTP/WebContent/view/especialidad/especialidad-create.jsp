

<div class="breadcrumbs">
	<div class="breadcrumbs-inner">
		<div class="row m-0">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>Registro de Especialidades</h1>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="page-header float-right">
					<div class="page-title">
						<ol class="breadcrumb text-right">
							<li><a href="#">Menu</a></li>
							<li><a href="#">Registro</a></li>
							<li class="active">Especialidad</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div v-if="showModal">
<div class="alert alert-success alert-dismissible " role="alert" id="alertsuccess">
	<strong>Exito!</strong> El Registro se proceso correctamente
	<button type="button" class="close" data-dismiss="alert" aria-label="Close"  @click="showModal = false">
		<span aria-hidden="true"></span>
	</button>
</div>
</div>
<div class="content">
	<div class="animated fadeIn">
		<div class="row">
			<div class="col-xs-8 col-sm-8 col-md-8">
				<div class="card">

					<div class="card-body">
						<!-- Credit Card -->
						<div id="pay-invoice">
							<div class="card-body">

								<div class="form">

									<div class="form-group">
										<label for="Cod_Rol" class="control-label mb-1">Codigo</label>
										<input id="Cod_Rol" name="Cod_Rol" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" v-model="Rol.Cod_Rol">
									</div>
									<div class="form-group ">
										<label for="nom_Rol" class="control-label mb-1">Nombre</label>
										<input id="nom_Rol" name="nom_Rol" type="text"
											class="form-control nom_Rol valid" data-val="true"
											data-val-required="El campo no puede estar vacio"
											autocomplete="nom_Rol" aria-required="true"
											aria-invalid="false" aria-describedby="nom_Rol"
											v-model="Rol.nom_Rol">
									</div>
									<div class="form-group">
										<label for="descr_Rol" class="control-label mb-1">Descripcion</label>
										<input id="descr_Rol" name="descr_Rol" type="tel"
											class="form-control descr_Rol valid" value="" data-val="true"
											data-val-required="El campo no puede estar vacio"
											data-val-descr_Rol="El campo no puede estar vacio"
											v-model="Rol.descr_Rol">
									</div>

									<div>
										<button id="btn_Rol" type="submit"
											class="btn btn-lg btn-info btn-block"
											@click="RegistrarEspecialidad">
											<i class="fa fa-paper-plane fa-lg"></i>&nbsp; <span
												id="payment-button-amount">Registrar</span>
										</button>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
				<!-- .card -->
			</div>
		</div>
	</div>
	<!-- .animated -->
</div>
<!-- .content -->
