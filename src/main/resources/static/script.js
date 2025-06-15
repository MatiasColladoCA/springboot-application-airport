let selectedFlight = null;
let allFlights = [];

// Navegación entre secciones
function showSection(sectionName) {
    // Ocultar todas las secciones
    document.querySelectorAll('section').forEach(section => {
        section.classList.remove('active');
    });

    // Mostrar la sección seleccionada
    document.getElementById(sectionName + '-section').classList.add('active');

    // Actualizar navegación
    document.querySelectorAll('.nav-link').forEach(link => {
        link.classList.remove('active');
    });
    document.querySelector(`[data-section="${sectionName}"]`).classList.add('active');
}

// Event listeners para navegación
document.querySelectorAll('.nav-link').forEach(link => {
    link.addEventListener('click', (e) => {
        e.preventDefault();
        const section = e.target.getAttribute('data-section');
        showSection(section);
    });
});

// Función para cargar vuelos
async function loadFlights() {
    const flightsSelect = document.getElementById("flights-select");
    const searchBtn = document.querySelector('.search-btn');

    try {
        // Mostrar estado de carga
        searchBtn.textContent = 'Cargando...';
        searchBtn.disabled = true;
        flightsSelect.innerHTML = '<option value="">Cargando vuelos...</option>';

        console.log("Buscando vuelos...");

        // Intentar conectar con reintentos
        let response;
        let attempts = 0;
        const maxAttempts = 3;

        while (attempts < maxAttempts) {
            try {
                response = await fetch("http://localhost:9000/vuelos", {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    timeout: 5000
                });
                break; // Si llegamos aquí, la petición fue exitosa
            } catch (fetchError) {
                attempts++;
                console.log(`Intento ${attempts} fallido:`, fetchError.message);

                if (attempts < maxAttempts) {
                    // Esperar un poco antes del siguiente intento
                    await new Promise(resolve => setTimeout(resolve, 1000));
                } else {
                    throw fetchError;
                }
            }
        }

        if (!response.ok) {
            throw new Error(`Error del servidor: ${response.status} - ${response.statusText}`);
        }

        const vuelos = await response.json();
        allFlights = vuelos;
        console.log("Vuelos obtenidos:", vuelos);

        // Limpiar select
        flightsSelect.innerHTML = '<option value="">Selecciona un vuelo...</option>';

        // Verificar si hay vuelos
        if (!vuelos || vuelos.length === 0) {
            flightsSelect.innerHTML = '<option value="">No hay vuelos disponibles</option>';
            return;
        }

        // Agregar opciones al select
        vuelos.forEach((vuelo, index) => {
            const option = document.createElement('option');
            option.value = index;
            option.textContent = `${vuelo.numeroVuelo || vuelo.id} - ${vuelo.origen || 'N/A'} → ${vuelo.destino || 'N/A'}`;
            flightsSelect.appendChild(option);
        });

    } catch (error) {
        console.error("Error al cargar vuelos:", error);

        // Mostrar error más descriptivo
        let errorMessage = 'Error al cargar vuelos';
        if (error.message.includes('Failed to fetch')) {
            errorMessage = 'No se puede conectar al servidor. ¿Está ejecutándose en localhost:9000?';
        } else if (error.message.includes('ERR_CONNECTION_ABORTED')) {
            errorMessage = 'Conexión interrumpida. Reintentando...';
        }

        flightsSelect.innerHTML = `<option value="">⚠️ ${errorMessage}</option>`;
    } finally {
        // Restaurar botón
        searchBtn.textContent = 'Explorar Vuelos';
        searchBtn.disabled = false;
    }
}

document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("search-form");
    const flightsSelect = document.getElementById("flights-select");
    const flightInfo = document.getElementById("flight-info");
    const flightDetails = document.getElementById("flight-details");
    const reserveBtn = document.getElementById("reserve-btn");

    // Cargar vuelos automáticamente al iniciar
    loadFlights();

    // Manejar envío del formulario de búsqueda
    form.addEventListener("submit", async (e) => {
        e.preventDefault();
        await loadFlights();
    });

    // Manejar selección de vuelo
    flightsSelect.addEventListener('change', (e) => {
        const selectedIndex = e.target.value;

        if (selectedIndex === "") {
            // No hay selección
            flightInfo.style.display = 'none';
            reserveBtn.style.display = 'none';
            selectedFlight = null;
        } else {
            // Hay selección
            selectedFlight = allFlights[selectedIndex];

            // Mostrar información del vuelo
            flightDetails.innerHTML = `
                        <strong>Vuelo:</strong> ${selectedFlight.numeroVuelo || selectedFlight.id}<br>
                        <strong>Origen:</strong> ${selectedFlight.origen || 'N/A'}<br>
                        <strong>Destino:</strong> ${selectedFlight.destino || 'N/A'}<br>
                        <strong>Fecha:</strong> ${selectedFlight.fecha || 'N/A'}<br>
                        <strong>Precio:</strong> ${selectedFlight.precio || 'Consultar'}
                    `;

            flightInfo.style.display = 'block';
            reserveBtn.style.display = 'block';
        }
    });

    // Manejar click en botón de reserva
    reserveBtn.addEventListener('click', () => {
        if (selectedFlight) {
            // Actualizar información en la sección de reserva
            const bookingFlightDetails = document.getElementById('booking-flight-details');
            bookingFlightDetails.innerHTML = `
                        <strong>Vuelo:</strong> ${selectedFlight.numeroVuelo || selectedFlight.id}<br>
                        <strong>Origen:</strong> ${selectedFlight.origen || 'N/A'}<br>
                        <strong>Destino:</strong> ${selectedFlight.destino || 'N/A'}<br>
                        <strong>Fecha:</strong> ${selectedFlight.fecha || 'N/A'}<br>
                        <strong>Precio:</strong> ${selectedFlight.precio || 'Consultar'}
                    `;

            // Cambiar a la pestaña de datos de reserva
            showSection('booking');
        }
    });

    // Manejar envío del formulario de reserva
    const bookingForm = document.getElementById('booking-form');
    bookingForm.addEventListener('submit', async(e) => {
        e.preventDefault();

        // Generar número de reserva único
        const numeroReserva = 'RES-' + Date.now().toString().slice(-6);

        const formData = {
            flight: selectedFlight,
            usuario: {
                id: 13123123,
                dniPersona: document.getElementById('passenger-dni').value,
                nombrePersona: document.getElementById('passenger-name').value,
                apellidoPersona: "apellido_persona", // document.getElementById('passenger-lastname').value,
                numeroUsuario: 123132131312,
                contraseñaUsuario: '1234',
                correoElectronicoUsuario: document.getElementById('passenger-email').value
                // reservas: [
                //     {
                //         id: 1,
                //         numeroReserva: "RES-001",
                //         vuelo: {
                //             id: selectedFlight.id,
                //             numeroVuelo: "AR1134",
                //             salida: selectedFlight.destino,
                //             destino: selectedFlight.destino,
                //             tarifas: [
                //                 {
                //                     id: 1,
                //                     numeroTarifa: "TAR-ECO-001",
                //                     impuestoTarifa: 50.0,
                //                     precioTarifa: "1000",
                //                     claseTarifa: "economy"
                //                 }
                //             ]
                //         },
                //         pago: {
                //             id: 1,
                //             numeroPago: "PAY-20231201-001",
                //             cantidadPago: 299.99
                //         }
                //     }
                // ],
                // consultas: [
                //     {
                //         id: 1,
                //         numeroConsulta: "CON-001",
                //         fecha: "2023-11-01T10:00:00"
                //     }
                // ],
                // tarjetas: []
            }
        };

        console.log('Datos de reserva:', formData);
        alert('Formulario de reserva completado. Datos listos para enviar al servidor.');

        try {
            // Enviar datos al servidor
            const response = await fetch('http://localhost:9000/usuarios', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData)
            });

            if (response.ok) {
                const result = await response.json();
                alert(`¡Reserva confirmada! Número de reserva: ${numeroReserva}`);

                // Limpiar formulario
                bookingForm.reset();

                // Opcional: redirigir a la sección de reservas
                showSection('reservations');
            } else {
                throw new Error('Error al procesar la reserva');
            }
        } catch (error) {
            console.error('Error al enviar reserva:', error);
            alert('Error al procesar la reserva. Por favor, inténtalo nuevamente.');
        }
    });
});

// Función para cargar reservas (placeholder)
function loadReservations() {
    const userId = document.getElementById('usuario-id').value;
    const reservationsList = document.getElementById('reservations-list');

    if (!userId) {
        reservationsList.innerHTML = '<p style="color: red;">Por favor ingresa un ID de usuario.</p>';
        return;
    }

    // Placeholder - aquí iría la lógica para cargar reservas del servidor
    reservationsList.innerHTML = '<p>Cargando reservas...</p>';

    setTimeout(() => {
        reservationsList.innerHTML = '<p>No se encontraron reservas para este usuario.</p>';
    }, 1000);
}
