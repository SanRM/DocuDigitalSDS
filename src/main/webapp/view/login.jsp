<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-theme="dark">

<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.11.1/dist/full.min.css" rel="stylesheet" type="text/css" />
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-base-100 flex flex-col items-center justify-center min-h-screen">

    <nav class="bg-accent p-4 w-full">
        <div class="container mx-auto flex items-center justify-between">
            <a href="#" class="text-lg font-bold btn-accent">DocuDigitalSDS</a>
            <div class="flex items-center">
                <div class="tooltip tooltip tooltip-left tooltip-info" data-tip="Cambiar tema">
                    <input type="checkbox" value="light" class="toggle theme-controller ml-4" />
                </div>

            </div>
        </div>
    </nav>

    <div class="hero flex-grow bg-base-200 flex items-center justify-center">
        <div class="card w-full max-w-xl shadow-3xl bg-base-100">
            <div class="card-body p-10">
                <div class="text-left pb-3">
                    <h1 class="text-5xl font-bold pb-4">Iniciar sesión</h1>
                    <p>Introduce tus credenciales para iniciar sesión para ingresar a DocuDigitalSDS.</p>
                </div>
                
                <form action="/docudigitalsds/LoginController" method="get">

                    <div class="form-control pb-2">
                        <label class="label text-white font-bold">
                            <span class="label-text">Correo electrónico</span>
                        </label>
                        <input type="email" placeholder="Ingresa tu email" class="input input-bordered" id="email"
                            name="email" required />
                    </div>
                    <div class="form-control">
                        <label class="label text-white font-bold">
                            <span class="label-text">Contraseña</span>
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
</body>

</html>