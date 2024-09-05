function logout() {
    sessionStorage.removeItem("token");
    window.location.href = "/login";
}

export default logout;