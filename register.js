/*document.getElementById("registerForm").addEventListener("submit", async function(e) {
    e.preventDefault(); // Prevent page reload

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    try {
        const response = await fetch("http://localhost:8080/api/users/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ username: username, password: password })
        });

        const result = await response.text();
        document.getElementById("message").innerText = result;
        console.log("Response:", result);
    } catch (error) {
        console.error("Error:", error);
        document.getElementById("message").innerText = "Failed to register";
    }
});*/
