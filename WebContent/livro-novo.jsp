<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>IFSP Admin</title>
        <link href="/admin/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
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
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts"
                                ><div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Livro
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div
                            ></a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
									<a class="nav-link" href="/admin/livro/lista">Lista</a>
									<a class="nav-link" href="/admin/livro/novo">Novo</a></nav>
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
								<a href="/admin/livro/lista"  class="btn btn-outline-primary">Lista de Livros</a>
							</div>
                        </div>
                        
                        <c:forEach items = "${mensagens}" var="mensagem">
                        	<div class="alert alert-warning alert-dismissible fade show" role="alert">
	                        	${mensagem}
	                        	<button type= "button" class="close" data-dismiss="alert" aria-label="Close">
	                        	</button>
                        	</div>
                        </c:forEach>
                        
                        <c:if test = "${ not empty sucess}">
                        	<div class="alert alert-success alert-dismissible fade show" role="alert">
                        	${sucess}
                        	<button type= "button" class="close" data-dismiss="alert" aria-label="Close">
                        		<span arua-hidden = "true">&times;</span>
                        	</button>
                        	</div>
                        </c:if>
                        
                        <div class="card mb-4">
                            <div class="card-header"><i class="fas fa-table mr-1"></i>Novo Livro</div>
                            <div class="card-body">
                                <form method= "post" action = "/admin/livro/novo">
                                
                                	<input type="hidden" name ="id" value= "${id}">
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
														<label class="small mb-1" for="titulo">Título</label>
														<input class="form-control" id="nome" name = "titulo" value="${titulo}" type="text" placeholder="Título do Livro" />
													</div>
                                                </div>
   
                                            </div>
                                            <div class="form-group">
												<label class="small mb-1" for="autor">Autor</label>
												<input class="form-control" id="autor" name="autor" value="${autor}"  type="text"  placeholder="Informe o Autor" /></div>
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
													<label class="small mb-1" for="isbn">ISBN</label>
													<input class="form-control" id="isbn" name="isbn" value="${isbn}" type="text" placeholder="Informe o ISBN" /></div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
													<label class="small mb-1" for="preco">Preço</label>
													<input class="form-control" id="preco" name= "preco" value="${preco}" type="text" placeholder="Informe o Preço" /></div>
                                                </div>
                                            </div>
                                            <div class="form-group mt-4 mb-0">
													<input class="btn btn-primary btn-block" type="submit" value="Salvar">
											</div>
                                        </form>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Prof. Aldo Paim</div>
                            <div>
                                VersÃ£o 1.0
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
        <script src="/admin/assets/demo/datatables-demo.js"></script>
    </body>
</html>
