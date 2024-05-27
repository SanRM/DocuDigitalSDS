<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html data-theme="dark">

<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.11.1/dist/full.min.css" rel="stylesheet" type="text/css" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet"
        type="text/css" />
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet" />

</head>

<body class="bg-base-100 flex flex-col items-center justify-center min-h-screen">

    <!-- Navbar -->
    <div class="w-full navbar bg-base-300 p-7">

        <div class="flex-1 px-2 mx-5 text-3xl font-bold">DocuDigitalSDS</div>

        <div class="flex-3">

            <ul class="menu menu-horizontal items-center">
                <!-- Navbar menu content here -->
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
                
                <button class="btn btn-s h-5 ml-3" onclick="location.href='/docudigitalsds/view/welcome.html';">
                    <span class="material-symbols-outlined">home</span>
                    Página principal
                </button>

            </ul>

        </div>

    </div>

    <div class="hero flex-grow bg-base-200 flex items-center justify-center">
        <div class="card w-full max-w-xl shadow-3xl bg-base-100">
            <div class="card-body p-10">
                <div class="text-left pb-3">
                    <h1 class="text-5xl font-bold pb-4">Iniciar sesión</h1>
                    <p>Introduce tus credenciales de inicio sesión para ingresar a DocuDigitalSDS.</p>
                </div>
                <form action="/docudigitalsds/LoginController" method="post">
                    <div class="form-control pb-2">
                        <label class="label text-white font-bold">
                            <span class="label-text">
                                <i class="fas fa-envelope pr-1 text-accent">
                                </i>
                                Correo electrónico
                            </span>
                        </label>
                        <input type="email" placeholder="Ingresa tu email" class="input input-bordered" id="email"
                            name="email" required />
                    </div>
                    <div class="form-control">
                        <label class="label text-white font-bold">
                            <span class="label-text">
                                <i class="fas fa-lock pr-1 text-accent"></i>
                                Contraseña
                            </span>
                        </label>
                        <input type="password" placeholder="Ingresa tu contraseña" class="input input-bordered"
                            id="password" name="password" required />
                    </div>
                    <div class="form-control pt-6 pb-1">
                        <button class="btn btn-primary btn-accent">Iniciar sesión</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <% String errorMessage=(String) session.getAttribute("errorMessage"); if (errorMessage != null) {
        
        session.removeAttribute("errorMessage"); %>

        <div id="toast" class="toast toast-error">
            <div class="alert alert-error">
                <span>
                    <%= errorMessage %>
                </span>
            </div>
        </div>

        <script>
            setTimeout(
                function () {
                    var toast = document.getElementById("toast");
                    toast.style.display = "none";
                },
                3000
            );
        </script>
        <% } %>

</body>

</html>