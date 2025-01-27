    // Toggle password visibility
    const togglePassword = document.getElementById('togglePassword');
    const passwordField = document.getElementById('password');
    
    togglePassword.addEventListener('click', () => {
        if (passwordField.type === 'password') {
            passwordField.type = 'text';
            togglePassword.textContent = '🙈'; // Change icon to indicate visibility
        } else {
            passwordField.type = 'password';
            togglePassword.textContent = '👁️'; // Change icon to indicate hidden
        }
    });

    const confirmPasswordField = document.getElementById('confirmPassword');
    const confirmTogglePassword = document.getElementById('confirmTogglePassword');
    confirmTogglePassword.addEventListener('click', () => {
        if (confirmPasswordField.type === 'password') {
            confirmPasswordField.type = 'text';
            confirmTogglePassword.textContent = '🙈'; // Change icon to indicate visibility
        } else {
            confirmPasswordField.type = 'password';
            confirmTogglePassword.textContent = '👁️'; // Change icon to indicate hidden
        }
    });


const errorElement = document.getElementById('passwordError');
confirmPasswordField.addEventListener('input', () => {
    if (passwordField.value !== confirmPasswordField.value) {
        errorElement.textContent = 'Passwords do not match!';
    } else {
        errorElement.textContent = '';
    }
});

function validatePassword() {
    if (passwordField.value !== confirmPasswordField.value) {
        errorElement.textContent = 'Passwords do not match!';
        return false; // Prevent form submission
    } else {
        errorElement.textContent = ''; // Clear the error
        return true; // Allow form submission
    }
}

    function validateDuration() {
        const durationInput = document.getElementById('duration');
        if (!durationInput.value || parseInt(durationInput.value) <= 0) {
            alert("Duration must be greater than 0.");
            return false; // Prevent form submission
        }
        return true; // Allow form submission
    }