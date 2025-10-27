// Register form
const registerForm = document.getElementById("registerForm");
if(registerForm){
    registerForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        try {
            const res = await fetch("http://localhost:8080/api/users/register", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ username, password })
            });
            const result = await res.text();
            document.getElementById("message").innerText = result;
        } catch (err) {
            console.error(err);
            document.getElementById("message").innerText = "Registration failed";
        }
    });
}

// Login form
const loginForm = document.getElementById("loginForm");
if(loginForm){
    loginForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        const username = document.getElementById("loginUsername").value;
        const password = document.getElementById("loginPassword").value;

        try {
            const res = await fetch("http://localhost:8080/api/users/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ username, password })
            });
            const result = await res.text();
            document.getElementById("loginMessage").innerText = result;
        } catch (err) {
            console.error(err);
            document.getElementById("loginMessage").innerText = "Login failed";
        }
    });
}

// Signup form (if separate)
const signupForm = document.getElementById("signupForm");
if(signupForm){
    signupForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        const username = document.getElementById("signupUsername").value;
        const password = document.getElementById("signupPassword").value;

        try {
            const res = await fetch("http://localhost:8080/api/users/register", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ username, password })
            });
            const result = await res.text();
            document.getElementById("signupMessage").innerText = result;
        } catch (err) {
            console.error(err);
            document.getElementById("signupMessage").innerText = "Signup failed";
        }
    });
}
