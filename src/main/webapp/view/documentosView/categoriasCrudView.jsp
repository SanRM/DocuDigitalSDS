<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.docudigitalsds.model.entities.gestionDocumento.Categoria" %>
<%@ page import="com.docudigitalsds.model.entities.gestionDocumento.FechaRetencionLegal" %>

<!DOCTYPE html>
<html data-theme="dark">

<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.11.1/dist/full.min.css" rel="stylesheet" type="text/css" />
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet" />
</head>

<body class="bg-base-100 ">

    <div class="drawer drawer-bottom bottom-0">

        <input id="my-drawer-3" type="checkbox" class="drawer-toggle" />
        <div class="drawer-content flex flex-col">

            <div id="navbar"></div>

            <!-- 2. PANEL CATEGORIAS -->
            <div class="bg-base-300 p-5 rounded-lg content-top m-5">

                <h2 class="text-lg font-bold">Categorias</h2>
                <p>En este panel puedes agregar, modificar y eliminar las categorias que se pueden asignar a los documentos.</p>

                <form action="/docudigitalsds/CategoryController" method="post">
                    <div class="join w-full flex mt-5">
                        <div class="flex-grow">
                            <div>
                                <input name="nuevaCategoria" class="input input-bordered join-item w-full" placeholder="Ingresa el nombre de la categoria" />
                                <input type="hidden" name="action" value="create" />
                            </div>
                        </div>
                        <div>
                            <button type="submit" class="btn btn- join-item text-accent">Guardar</button>
                        </div>
                    </div>
                </form>

                <div class="divider"></div>

                <div class="overflow-x-auto">
                    <table class="table">
                        <!-- head -->
                        <thead>
                            <tr class="bg-base-200">
                                <th>Categoria</th>
                                <th></th>
                               
                            </tr>
                        </thead>
                        <tbody>

                            <% 
                            List<Categoria> categories = (List<Categoria>) request.getAttribute("categoryNameList");
                            if (categories != null) {
                                for(Categoria category : categories) {
                            %>

                                    <tr>
                                        <!-- Muestra cada nombre de categoría dentro de la columna correspondiente -->
                                        <td><%= category.getNombre() %></td>
                                        <td class="pr-0">
                                            <div class="flex justify-end gap-4">

                                                <!-- Botón de editar con modal -->
                                                <button class="btn btn-sm text-primary" onclick="openModal('<%= category.getNombre() %>', '<%= category.getIdCategoria() %>')">Editar</button>

                                                <!-- Modal -->
                                                <dialog id="editModal" class="modal">
                                                    <div class="modal-box pb-7">
                                                        <h3 class="font-bold text-lg pb-5">Editar Categoría</h3>

                                                        <form action="/docudigitalsds/CategoryController" method="post">

                                                            <input type="hidden" name="action" value="update" />

                                                            <input type="hidden" name="idCategoria" id="categoryId" />

                                                            <input type="text" name="nombreCategoria" id="editCategoryNameInput" placeholder="Nuevo nombre" class="input input-bordered w-full max-w " />
                                                            
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
                                                

                                                <form action="/docudigitalsds/CategoryController" method="post">
                                                    <input type="hidden" name="action" value="delete" />
                                                    <input type="hidden" name="idCategoria" value="<%= category.getIdCategoria() %>" />
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

    <script>
        document.addEventListener('DOMContentLoaded', function () {
            // Carga la barra de navegación desde el archivo navbar.html
            fetch('view/components/navbar.jsp')
            .then(response => response.text())
            .then(html => {
                document.getElementById('navbar').innerHTML = html;
            });

        });
    </script>

<!-- Script para abrir el modal con el nombre de la categoría -->
<script>
    function openModal(categoryName, categoryId) { 
        var modal = document.getElementById('editModal');
        
        document.getElementById('categoryId').value = categoryId; 
        document.getElementById('editCategoryNameInput').value = categoryName;

        modal.showModal();
    }
</script>

</body>

</html>
