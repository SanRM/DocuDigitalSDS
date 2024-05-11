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
                        <!-- Navbar menu content here -->
                        <button class="btn btn-s h-5" onclick="location.href='/docudigitalsds/view/adminView.jsp'">
                            <span class="material-symbols-outlined">home</span>
                        </button>

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

            <div class="grid grid-cols-3 gap-5 mt-5 ml-5 mr-5">

                <div class="bg-base-300 p-5 rounded-lg content-center">

                    <h2 class="text-lg font-bold">Categorias</h2>
                    <p>En este panel puedes agregar, modificar y eliminar categorias</p>

                        <div class="join w-full flex mt-5">
                            <div class="flex-grow">
                                <div>
                                    <input class="input input-bordered join-item w-full" placeholder="Ingresa el nombre de la categoria"/>
                                </div>
                            </div>
                            <div>
                                <button class="btn btn- join-item text-error">Eliminar</button>
                            </div>
                            <div>
                                <button class="btn btn- join-item text-accent">Guardar</button>
                            </div>
                        </div>

                    <div class="divider"></div>
                    
                    <button id="openModal" onclick="my_modal_2.showModal()" class="btn btn-sm btn-success w-full" onclick="my_modal_2.showModal()">
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0 0v6m0-6h6m-6 0H6" />
                        </svg>
                        Agregar ubicación
                    </button>
                    
                    <dialog id="my_modal_2" class="modal">
                        <div class="modal-box pb-7">
                            <h3 class="font-bold text-lg pb-5">Agregar nueva ubicación</h3>
                            <form method="post" action="/docudigitalsds/AdminController"> <!-- Reemplaza esto con la ruta a tu AdminController -->
                                <input type="text" name="nombre" placeholder="Type here" class="input input-bordered w-full max-w " />
                                <div class="card-actions justify-end pt-7">
                                    <button type="submit" class="btn ml-5 btn-sm btn-success">
                                        Enviar
                                    </button>
                                </div>
                            </form>
                        </div>
                        <form method="dialog" class="modal-backdrop">
                            <button>close</button>
                        </form>
                    </dialog>
                    
                </div>
                
                <div class="bg-base-300 p-5 rounded-lg">
                    <h2 class="text-lg font-bold">Panel 2</h2>
                    <p>Contenido del panel 2</p>
                </div>

                <div class="bg-base-300 p-5 rounded-lg">
                    <h2 class="text-lg font-bold">Panel 3</h2>
                    <p>Contenido del panel 3</p>
                </div>
                
            </div>

            <div class="bg-base-300 p-5 mt-5 ml-5 mr-5 rounded-lg">
                <h2 class="text-lg font-bold">Crear documento</h2>
                <p>Contenido del panel 1</p>
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