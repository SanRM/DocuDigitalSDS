<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.docudigitalsds.model.entities.gestionDocumento.Documento" %>

<%@ page import="com.docudigitalsds.model.entities.gestionDocumento.Categoria" %>
<%@ page import="com.docudigitalsds.model.entities.gestionDocumento.FechaRetencionLegal" %>
<%@ page import="com.docudigitalsds.model.entities.gestionDocumento.UbicacionFisica" %>

<!DOCTYPE html>
<html data-theme="dark">

<head>
    <meta charset="UTF-8">
    <title>Documentos</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.11.1/dist/full.min.css" rel="stylesheet" type="text/css" />
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet" />
</head>

<body class="bg-base-100 ">

    <div class="drawer drawer-bottom bottom-0">

        <input id="my-drawer-3" type="checkbox" class="drawer-toggle" />
        <div class="drawer-content flex flex-col">

            <div id="navbar"></div>

            <!-- PANEL DOCUMENTOS -->
            <div class="bg-base-300 p-5 rounded-lg content-top m-5">

                <h2 class="text-lg font-bold">Documentos</h2>
                <p>En este panel puedes agregar, modificar y eliminar documentos.</p>

                <!-- 1. Formulario crear documento -->
                <form action="/docudigitalsds/DocumentController" method="post" enctype="multipart/form-data">
                
                    <div class="join w-full flex mt-5">
                
                        <div class="flex-grow">
                            <div>
                                <input name="titulo" class="input input-bordered join-item w-full" placeholder="Título" required/>
                            </div>
                        </div>
                
                        <div class="flex-grow">
                            <div>
                                <input name="descripcion" class="input input-bordered join-item w-full" placeholder="Ingresa la descripción" required/>
                            </div>
                        </div>
                
                        <select name="categoria" class="select select-bordered join-item" required>
                            <option disabled selected hidden value="">Categoría</option>
                            <% 
                            List<Categoria> categories = (List<Categoria>) request.getAttribute("categoryNameList");
                            if (categories != null) {
                                for(Categoria category : categories) {
                            %>
                                <option value="<%= category.getIdCategoria() %>"> <%= category.getNombre() %></option>
                            <% 
                                }
                            }
                            %>
                        </select>
                
                        <select name="fechaRetencionLegal" class="select select-bordered join-item" required>
                            <option disabled selected hidden value="">Fecha de retención legal</option>
                            <% 
                            List<FechaRetencionLegal> fechasRetencionLegales = (List<FechaRetencionLegal>) request.getAttribute("fechasRetencionLegales");
                            if (fechasRetencionLegales != null) {
                                for(FechaRetencionLegal fechaRetencionLegal : fechasRetencionLegales) {
                            %>
                                <option value="<%= fechaRetencionLegal.getIdRetencionLegal() %>"><%= fechaRetencionLegal.getFormattedFechaRetencionFinal().toString() %></option>
                            <% 
                                }
                            }
                            %>
                        </select>
                
                        <select name="ubicacionFisica" class="select select-bordered join-item" required>
                            <option disabled selected hidden value="">Ubicación fisica</option>
                            <% 
                            List<UbicacionFisica> physicalLocations = (List<UbicacionFisica>) request.getAttribute("physicalLocationList");
                            if (physicalLocations != null) {
                                for(UbicacionFisica location : physicalLocations) {
                            %>
                                <option value="<%= location.getIdUbicacionFisica() %>"> <%= location.getNombre() %></option>
                            <% 
                                }
                            }
                            %>
                        </select>
                
                        <div class="flex-grow">
                            <div>
                                <input id="archivo" name="archivo" type="file" class="file-input file-input-bordered join-item w-full file-input-default" required/>                            
                            </div>
                        </div>

                        <script>
                            // Obtener el elemento de entrada de archivo
                            const fileInput = document.getElementById('archivo');
                            // Escuchar el evento change en el input de archivo
                            fileInput.addEventListener('change', function() {
                                const file = fileInput.files[0];
                                if (file) {
                                    const extension = file.name.split('.').pop().toLowerCase();
                        
                                    // Verificar si la extensión del archivo es PDF
                                    if (extension != 'pdf') {
                                        fileInput.value = null;
                                        const modal = document.getElementById('errorModal');
                                        modal.showModal();
                                    }
                                } 
                            });

                        </script>
                        
                        <!-- Modal -->
                        <dialog id="errorModal" class="modal">
                            <div class="modal-box card w-96 bg-error p-0 text-primary-content">
                                <form>
                                    <div class="card-body">
                                        <h2 class="card-title text-3xl">Error</h2>
                                        <p>Debes subir un archivo tipo PDF</p>
                                        <div class="card-actions justify-end">
                                            <button class="btn" onclick="document.getElementById('errorModal').close();">Cerrar</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <form method="dialog" class="modal-backdrop">
                                <button>close</button>
                            </form>
                        </dialog>
                
                        <div>
                            <input type="hidden" name="action" value="create" />
                            <button type="submit" class="btn join-item text-accent border-l-default">Guardar</button>
                        </div>
                
                    </div>
                </form>
                
                <div class="divider"></div>

                <div class="overflow-x-auto">
                    <table class="table">
                        <!-- head -->
                        <thead>
                            <tr class="bg-base-200">
                                <th>Id</th>
                                <th>Título</th>
                                <th>Descripción</th>
                                <th>Fecha de creación</th>
                                <th>Última edición</th>
                                <th>Tamaño del documento</th>
                                <th>Núm. Páginas</th>
                                <th>Categoría</th>
                                <th>Fecha retención legal</th>
                                <th>Ubicación</th>
                                <th>Documento</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>

                            <% 
                            List<Documento> documents = (List<Documento>) request.getAttribute("documentList");
                            if (documents != null) {
                                for(Documento document : documents) {
                            %>

                                    <tr class="bg-base-100">
                                        <!-- Muestra el id y el título del documento -->
                                        <td><%= document.getIdDocumento() %></td>
                                        <td><%= document.getTitulo() %></td>
                                        <td><%= document.getDescripcion() %></td>
                                        <td><%= document.getFechaCreacion() %></td>
                                        <td><%= document.getFechaUltimaEdicion() %></td>
                                        <td><%= document.getTamañoFormateado() %></td>
                                        <td><%= document.getNumeroDeFolios() %></td>
                                        <td><%= document.getNombreCategoria() %></td>
                                        <td><%= document.getNombreFechaRetencion() %></td>
                                        <td><%= document.getNombreUbicacionFisica() %></td>
                                        <td>
                                            
                                            <a href="data:application/pdf;base64, <%= document.getArchivoBase64() %>" download="<%= document.getTitulo() %>">
                                                <button class="btn btn-s h-5 text-success">
                                                    <span class="material-symbols-outlined">description</span>
                                                </button>
                                            </a>
                                            
                                        </td>
                                        
                                        <td class="pr-0">
                                            <div class="flex justify-end gap-4">

                                                <!-- Botón de editar con modal -->
                                                <button class="btn btn-sm text-primary" onclick="openModal('<%= document.getTitulo() %>', '<%= document.getIdDocumento() %>')">Editar</button>

                                                <!-- Modal -->
                                                <dialog id="editModal" class="modal">
                                                    <div class="modal-box pb-7">
                                                        <h3 class="font-bold text-lg pb-5">Editar Documento</h3>

                                                        <form action="/docudigitalsds/DocumentController" method="post">

                                                            <input type="hidden" name="action" value="update" />

                                                            <input type="hidden" name="idDocumento" id="documentId" />

                                                            <input type="text" name="tituloDocumento" id="editDocumentTitleInput" placeholder="Nuevo título" class="input input-bordered w-full max-w " />
                                                        
                                                            <div class="card-actions justify-end pt-7">
                                                                <button type="submit" class="btn ml-5 btn-sm btn-success">
                                                                    Guardar
                                                                </button>
                                                            </div>

                                                        </form>

                                                    </div>
                                                    <form method="dialog" class="modal-backdrop">
                                                        <button>close</button>
                                                    </form>
                                                </dialog>

                                                <!-- Botón de eliminar -->
                                                <form action="/docudigitalsds/DocumentController" method="post">
                                                    <input type="hidden" name="action" value="delete" />
                                                    <input type="hidden" name="idDocumento" value="<%= document.getIdDocumento() %>" />
                                                    <button type="submit" class="btn btn-sm text-error mr-5">Eliminar</button>
                                                </form>

                                            </div>
                                        </td>
                                    </tr>

                            <% 
                                }
                            }
                            %>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="drawer-side">
            <label for="my-drawer-3" aria-label="close sidebar" class="drawer-overlay"></label>
            <ul class="menu p- w-80 min-h-full bg-base-200">
                <!-- Sidebar content here -->
                <div class="dropdown mr-3 dropdown-end">

                    <div tabindex="0" role="button" class="btn">
                        Cambiar tema

                        <svg width="12px" height="12px" class="h-2 w-2 fill-current opacity-60 inline-block"
                            xmlns="http://www.w3.org/2000/svg" viewBox="0 0 2048 2048">
                            <path d="M1799 349l242 241-1017 1017L7 590l242-241 775 775 775-775z"></path>
                        </svg>

                    </div>
                    <ul tabindex="0" class="dropdown-content z-[1] p-2 shadow-2xl bg-base-300 rounded-box w-52">
                        <li><input type="radio" name="theme-dropdown"
                                class="theme-controller btn btn-sm btn-block btn-ghost justify-start"
                                aria-label="Modo oscuro" value="default" /></li>
                        <li><input type="radio" name="theme-dropdown"
                                class="theme-controller btn btn-sm btn-block btn-ghost justify-start"
                                aria-label="Modo claro" value="light" /></li>
                    </ul>
                </div>

                <button class="btn btn-s btn-accent h-5 w-[30%]">Página principal</button>
                <button class="btn btn-error h-5 w-[30%] ml-3">Cerrar sesión</button>
            </ul>
        </div>
    </div>

    <script src="https://cdn.tailwindcss.com"></script>
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            // Carga la barra de navegación desde el archivo navbar.html
            fetch('view/components/navbar.jsp')
            .then(response => response.text())
            .then(html => {
                document.getElementById('navbar').innerHTML = html;
            });
        });

        // Script para abrir el modal con el título del documento
        function openModal(documentTitle, documentId) { 
            var modal = document.getElementById('editModal');
            document.getElementById('documentId').value = documentId; 
            document.getElementById('editDocumentTitleInput').value = documentTitle;
            modal.showModal();
        }

    </script>

</body>

</html>
