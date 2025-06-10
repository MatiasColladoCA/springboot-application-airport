// Configuración de la API
const API_BASE_URL = 'http://localhost:9000';
const ciudadSelect     = document.getElementById('ciudad');

// Funciones de navegación
function showTab(tabName) {
    document.querySelectorAll('.tab').forEach(tab => tab.classList.remove('active'));
    document.querySelectorAll('.tab-content').forEach(content => content.classList.add('hidden'));

    event.target.classList.add('active');
    document.getElementById(tabName + '-tab').classList.remove('hidden');
}

// Inicialización
document.addEventListener('DOMContentLoaded', function() {
    loadCiudades();
});


async function loadCiudades() {
    try {
        const res = await fetch('http://localhost:9000/ciudades');
        const ciudades = await res.json();
        ciudadSelect.innerHTML = '<option value="">Seleccione una ciudad</option>';
        ciudades.forEach(c => {
            const opt = document.createElement('option');
            opt.value = c.id;
            opt.textContent = c.nombreCiudad;
            ciudadSelect.appendChild(opt);
        });
    } catch (err) {
        console.error('Error cargando ciudades:', err);
    }
}