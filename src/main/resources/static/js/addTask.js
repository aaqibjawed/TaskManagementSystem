    function validateDuration() {
        const durationInput = document.getElementById('duration');
        if (!durationInput.value || parseInt(durationInput.value) <= 0) {
            alert("Duration must be greater than 0.");
            return false; // Prevent form submission
        }
        return true; // Allow form submission
    }

