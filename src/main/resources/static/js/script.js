document.addEventListener('DOMContentLoaded', () => {

    const authContainer = document.getElementById('auth-container');
    const loginForm = document.getElementById('login-form');
    const signupForm = document.getElementById('signup-form');

    const showSignupLink = document.getElementById('show-signup');
    const showLoginLink = document.getElementById('show-login');

    // Al inicio, mostramos el formulario de login.
    authContainer.classList.remove('hidden');

    function toggleForms() {
        loginForm.classList.toggle('hidden');
        signupForm.classList.toggle('hidden');
    }

    // Asignamos los eventos a los nuevos IDs
    showSignupLink.addEventListener('click', toggleForms);
    showLoginLink.addEventListener('click', toggleForms);

});