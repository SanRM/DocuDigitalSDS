<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<div class="w-full navbar bg-base-300 p-3 pl-7 pb-7 pr-7">


    <div class="flex-1 px-2 mx-5 text-3xl font-bold">
        <a href="https://www.saludcapital.gov.co/Paginas2/Inicio.aspx" target="_blank">
            <img src="/docudigitalsds/view/images/sds_logo.png" class="pr-3"></img>
        </a>
        <div class="divider divider-horizontal items-center pt-6"></div>
        <div class="ml-3 mt-5">Docudigital SDS</div>
    </div>

    <div class="flex-none xl:hidden">
        <label for="my-drawer-3" aria-label="open sidebar" class="btn btn-square btn-neutral w-full p-4">
            Menu de navegación
        </label>
    </div>

    <div class="flex-3 hidden xl:block">

        <ul class="menu menu-horizontal items-center pt-7">
            <!-- Navbar menu content here -->

            <button class="btn btn-s h-5" onclick="location.href='/docudigitalsds/HomeController';">
                <span class="material-symbols-outlined">home</span>
            </button>

            <div id="dropdown" class="dropdown dropdown-hover ml-3 dropdown-end">

                <div role="button" class="btn">
                    <span class="material-symbols-outlined">Palette</span>
                    Tema
                    <svg width="12px" height="12px" class="h-2 w-2 fill-current opacity-60 inline-block"
                        xmlns="http://www.w3.org/2000/svg" viewBox="0 0 2048 2048">
                    <path d="M1799 349l242 241-1017 1017L7 590l242-241 775 775 775-775z"></path>
                </svg>
                </div>

                <ul class="dropdown-content z-[1] menu p-2 shadow bg-base-100 rounded-box">

                    <li>
                        <label>
                            <input type="radio" name="theme-buttons" class="btn theme-controller" aria-label="Modo oscuro" value="night" hidden>
                            <span class="material-symbols-outlined"><span class="material-symbols-outlined">
                                dark_mode
                                </span></span>
                            Intenso
                        </label>
                    </li>

                    <li>
                        <label>
                            <input type="radio" name="theme-buttons" class="btn theme-controller" aria-label="Modo oscuro" value="default" hidden>
                            <span class="material-symbols-outlined">nights_stay</span>
                            Equilibrado
                        </label>
                    </li>
                    
                    <li>
                        <label>
                            <input type="radio" name="theme-buttons" class="btn theme-controller" aria-label="Sunset" value="dim" hidden>
                            <span class="material-symbols-outlined"><span class="material-symbols-outlined">
                                brightness_high
                                </span></span>
                            Tenue
                        </label>
                    </input>
                    </li>


                </ul>

            </div>

            <% if (session.getAttribute("userRole") != null && session.getAttribute("userRole").equals(1)) { %>
                    
                <div id="dropdown" class="dropdown dropdown-hover ml-3">

                    <div role="button" class="btn btn-warning btn-outline" onclick="location.href='/docudigitalsds/DocumentController';">
                        <span class="material-symbols-outlined">Description</span>
                        Documentos
                    </div>

                    <ul tabindex="0" class="dropdown-content z-[1] menu p-2 shadow bg-base-100 rounded-box w-52">
                        <li onclick="location.href='/docudigitalsds/CategoryController';">
                            <a>
                                <span class="material-symbols-outlined text-warning">Bookmark</span>
                                Categorias
                            </a>
                        </li>
                        <li onclick="location.href='/docudigitalsds/LegalRetentionDateController';"> 
                            <a>
                                <span class="material-symbols-outlined text-warning">Event</span>
                                Fechas de retención
                            </a>
                        </li>
                        <li onclick="location.href='/docudigitalsds/PhysicalLocationsController';">
                            <a>
                                <span class="material-symbols-outlined text-warning">Map</span>
                                Ubicaciones fisicas
                            </a class="text-warning">
                        </li>
                    </ul>

                </div>

                <button class="btn btn-s btn-info btn-outline h-5 ml-3">
                    <span class="material-symbols-outlined">Handshake</span>
                    Préstamos
                </button>


                <div id="dropdown" class="dropdown dropdown-hover ml-3">

                    <div role="button" class="btn btn-accent btn-outline">
                        <span class="material-symbols-outlined">Person</span>
                        Usuarios
                    </div>

                    <ul class="dropdown-content z-[1] menu p-2 shadow bg-base-100 rounded-box w-52">
                        <li>
                            <a>
                                <span class="material-symbols-outlined text-accent"> manage_accounts</span>
                                Roles
                            </a>
                        </li>
                    </ul>

                </div>

            <% } %>

            <button class="btn btn-outline btn-error h-5 ml-3" onclick="location.href='/docudigitalsds/LogoutController';">
                <span class="material-symbols-outlined">Logout</span>
                Cerrar sesión
            </button>

        </ul>

    </div>

</div>
