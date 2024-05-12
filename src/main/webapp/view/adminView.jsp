<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.docudigitalsds.model.entities.gestionDocumento.Documento" %>

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

            <!-- Navbar -->
            <div class="w-full navbar bg-base-300 p-7">


                <div class="flex-1 px-2 mx-5 text-3xl font-bold">DocuDigitalSDS</div>

                <div class="flex-none xl:hidden">
                    <label for="my-drawer-3" aria-label="open sidebar" class="btn btn-square btn-neutral w-full p-4">
                        Menu de navegación
                    </label>
                </div>

                <div class="flex-3 hidden xl:block">

                    <ul class="menu menu-horizontal items-center">

                        <div class="dropdown dropdown-end ml-3">
                            <div tabindex="0" role="button" class="btn btn-n">
                                <span class="material-symbols-outlined">Palette</span>
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
                                        aria-label="Modo claro" value="cupcake" /></li>
                            </ul>
                        </div>
                        
                        <button class="btn btn-s btn-warning btn-outline h-5 ml-3" onclick="location.href='/docudigitalsds/CategoryController';">
                            <span class="material-symbols-outlined">Description</span>
                            Documentos
                        </button>

                        <button class="btn btn-s btn-info btn-outline h-5 ml-3">
                            <span class="material-symbols-outlined">Event</span>
                            Fechas retención
                        </button>

                        <button class="btn btn-s btn-accent btn-outline h-5 ml-3">
                            <span class="material-symbols-outlined">Person</span>
                            Usuarios
                        </button>
                        

                        <button class="btn btn-outline btn-error h-5 ml-3">
                            <span class="material-symbols-outlined">Logout</span>
                            Cerrar sesión
                        </button>

                    </ul>

                </div>

            </div>


            <div class="flex">

                <div class="w-full mt-5 ml-5 mr-5">
                    <div role="tablist" class="tabs tabs-boxed w-full menu-lg tabs-lg bg-base-300">
                        
                        
                        <% 
                        Map<String, Map<String, List<Documento>>> documentosPorUbicacionYCategoria = (Map<String, Map<String, List<Documento>>>)session.getAttribute("documentosPorUbicacionYCategoria");
                        if (documentosPorUbicacionYCategoria != null) {
                            int i = 0;
                            for(Map.Entry<String, Map<String, List<Documento>>> entryUbicacion : documentosPorUbicacionYCategoria.entrySet()) {
                                String ubicacion = entryUbicacion.getKey();
                                Map<String, List<Documento>> documentosPorCategoria = entryUbicacion.getValue();
                        %>


                                <input type="radio" name="my_tabs_2" role="tab" class="tab font-bold" aria-label="<%=ubicacion%>" <%= i == 0 ? "checked" : "" %> />

                                <div role="tabpanel" class="tab-content bg-base-300 border-base-300 rounded-box">

                                    <ul class="menu bg-base-200 rounded-lg  w-full">
                                        <% for(Map.Entry<String, List<Documento>> entryCategoria : documentosPorCategoria.entrySet()) {
                                            String categoria = entryCategoria.getKey();
                                            List<Documento> documentos = entryCategoria.getValue();
                                        %>
                                            <li>
                                                <details open>
                                                    <summary>
                                                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-4 h-4"><path stroke-linecap="round" stroke-linejoin="round" d="M2.25 12.75V12A2.25 2.25 0 014.5 9.75h15A2.25 2.25 0 0121.75 12v.75m-8.69-6.44l-2.12-2.12a1.5 1.5 0 00-1.061-.44H4.5A2.25 2.25 0 002.25 6v12a2.25 2.25 0 002.25 2.25h15A2.25 2.25 0 0021.75 18V9a2.25 2.25 0 00-2.25-2.25h-5.379a1.5 1.5 0 01-1.06-.44z" /></svg>
                                                        <%=categoria%>
                                                    </summary>
                                                    <ul>
                                                        <% for(Documento documento : documentos) { %>
                                                            <li><a>
                                                                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-4 h-4"><path stroke-linecap="round" stroke-linejoin="round" d="M19.5 14.25v-2.625a3.375 3.375 0 00-3.375-3.375h-1.5A1.125 1.125 0 0113.5 7.125v-1.5a3.375 3.375 0 00-3.375-3.375H8.25m2.25 0H5.625c-.621 0-1.125.504-1.125 1.125v17.25c0 .621.504 1.125 1.125 1.125h12.75c.621 0 1.125-.504 1.125-1.125V11.25a9 9 0 00-9-9z" /></svg>
                                                                <%=documento.getTitulo()%>
                                                            </a></li>
                                                        <% } %>
                                                    </ul>
                                                </details>
                                            </li>
                                        <% } %>
                                    </ul>
                                </div>
                        <% 
                                i++;
                            }
                        }
                        %>

                    </div>
                </div>

                <!-- <label class="input input-bordered flex items-center gap-2 m-5">
                    <input type="text" class="grow" placeholder="Buscar" />
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" fill="currentColor" class="w-4 h-4 opacity-70"><path fill-rule="evenodd" d="M9.965 11.026a5 5 0 1 1 1.06-1.06l2.755 2.754a.75.75 0 1 1-1.06 1.06l-2.755-2.754ZM10.5 7a3.5 3.5 0 1 1-7 0 3.5 3.5 0 0 1 7 0Z" clip-rule="evenodd" /></svg>
                </label> -->

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

</body>

</html>