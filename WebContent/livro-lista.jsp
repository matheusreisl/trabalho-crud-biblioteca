<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Sebo</title>
        <link href="/sebo/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="index.html">IFSP</a>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Menu Principal</div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Livro
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
									<a class="nav-link" href="/sebo/livro/lista">Lista</a>
									<a class="nav-link" href="/sebo/livro/novo">Novo</a></nav>
                            </div>
                            <!--
							<a class="nav-link" href="#"
                                ><div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Novo link
							</a> -->
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Disciplina:</div>
                        LP2A4
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Livro</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Livro</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
								<a href="/sebo/livro/novo" class="btn btn-outline-primary">+ Livro</a>
							</div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header"><i class="fa fa-list-ul"></i> Lista de Livros</div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Código</th>
                                                <th>Título</th>
                                                <th>Autor</th>
                                                <th>ISBN</th>
                                                <th>Preço</th>
                                                <th>Ações</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Código</th>
                                                <th>Título</th>
                                                <th>Autor</th>
                                                <th>ISBN</th>
                                                <th>Preço</th>
                                                <th>Ações</th>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <c:forEach items="${livros}" var="liv" varStatus="loopStatus">
												<tr>
												
												<td>${liv.id}</td>
												<td>${liv.titulo}</td>
												<td>${liv.autor}</td>
												
												<td>${liv.isbn}</td>
												
												<td>${liv.preco}</td>
												<td>
													<a href="/sebo/livro/editar?id=${liv.id}">
														<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
													</a>
													
													<a href="#" class="deleta" id="${liv.id}">
													<i class="fa fa-trash" aria-hidden="true"></i>
													</a>
												</td>
												
												</tr>
											</c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Matheus Reis e Renan Tiengo</div>
                            <div>
                                Trabalho Semestral
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="/sebo/assets/demo/datatables-demo.js"></script>
       	<script>
       	
       		$('.deleta').bind('click',function(){
       			var id = this.id;
       			if(confirm("Deseja deletar o livro de código " + id + "?")){
       				$.ajax({
       					url: "/sebo/livro/deletar",
       					type: "post",
       					data: {
       						id: id,
       					},
       					success: function(data){
       						alert('Livro deletado com sucesso!');
       						location.reload();
       					}
       				});
       			}
       		});
       	
       	</script>
    </body>
</html>
