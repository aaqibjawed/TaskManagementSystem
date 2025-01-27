/**
 * 
 */
function showFullComment(button) {
    const fullComment = button.getAttribute("data-comment"); // Get the full comment from data attribute
    document.getElementById("full-comment").textContent = fullComment; // Set the comment in the modal
    document.getElementById("comment-modal").style.display = "block"; // Show the modal
}

function closeModal() {
    document.getElementById("comment-modal").style.display = "none"; // Hide the modal
}
