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

        // Generar números únicos
        const numeroUsuario = 'USR' + Date.now().toString().slice(-6);
        const numeroReserva = 'RES-' + Date.now().toString().slice(-6);

        // Crear objeto usuario según la estructura esperada por el backend
        const usuarioData = {
            dniPersona: document.getElementById('passenger-dni').value,
            nombrePersona: document.getElementById('passenger-name').value,
            apellidoPersona: document.getElementById('passenger-lastname').value, // Asegúrate de que este campo exista en tu HTML
            numeroUsuario: numeroUsuario, // Debe ser string
            contraseñaUsuario: '1234', // Considera generar una contraseña más segura
            correoElectronicoUsuario: document.getElementById('passenger-email').value,
            reservas: [], // Array vacío por ahora
            consultas: [], // Array vacío por ahora
            tarjetas: [] // Array vacío por ahora
        };

        console.log('Datos de usuario a enviar:', usuarioData);

        try {
            // Enviar datos al servidor
            const response = await fetch('http://localhost:9000/usuarios', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(usuarioData) // Enviar directamente usuarioData
            });

            if (response.ok) {
                const result = await response.json();
                console.log('Usuario creado:', result);

                // Si necesitas crear la reserva después, hazlo aquí con el ID del usuario creado
                // await crearReserva(result.id, selectedFlight, numeroReserva);

                alert(`¡Usuario creado exitosamente! Número de usuario: ${numeroUsuario}`);

                // Limpiar formulario
                bookingForm.reset();

                // Opcional: redirigir a la sección de reservas
                showSection('reservations');
            } else {
                const errorData = await response.text();
                console.error('Error del servidor:', errorData);
                throw new Error('Error al procesar la reserva');
            }
        } catch (error) {
            console.error('Error al enviar reserva:', error);
            alert('Error al procesar la reserva. Por favor, inténtalo nuevamente.');
        }
    });
});

// Función para cargar reservas
async function loadReservations() {
    const userId = document.getElementById('usuario-id').value;
    const reservationsList = document.getElementById('reservations-list');

    if (!userId) {
        reservationsList.innerHTML = '<p style="color: red;">Por favor ingresa un ID de usuario.</p>';
        return;
    }

    // Mostrar mensaje de carga
    reservationsList.innerHTML = '<p>Cargando reservas...</p>';

    try {
        // Obtener datos del usuario
        const response = await fetch(`http://localhost:9000/usuarios/${userId}`);

        if (!response.ok) {
            throw new Error('Usuario no encontrado');
        }

        const usuario = await response.json();

        // Verificar si hay reservas
        if (!usuario.reservas || usuario.reservas.length === 0) {
            reservationsList.innerHTML = '<p>No se encontraron reservas para este usuario.</p>';
            return;
        }

        // Crear el HTML para mostrar las reservas
        reservationsList.innerHTML = `
            <div class="reservations-container">
                <h3>Reservas de ${usuario.nombrePersona} ${usuario.apellidoPersona}</h3>
                
                <label for="reservations-select">Reservas disponibles</label>
                <select id="reservations-select" class="flights-select">
                    <option value="">Selecciona una reserva...</option>
                    ${usuario.reservas.map(reserva => `
                        <option value="${reserva.id}">
                            ${reserva.numeroReserva} - Vuelo ${reserva.vuelo.numeroVuelo}
                        </option>
                    `).join('')}
                </select>

                <div id="reservation-info" class="flight-info" style="display: none;">
                    <h4>Detalles de la reserva</h4>
                    <div id="reservation-details"></div>
                </div>

                <button type="button" id="cancel-reservation-btn" class="reserve-btn" style="display: none; background-color: #dc3545;">
                    CANCELAR RESERVA
                </button>
            </div>
        `;

        // Agregar event listener al select
        const reservationsSelect = document.getElementById('reservations-select');
        const reservationInfo = document.getElementById('reservation-info');
        const cancelBtn = document.getElementById('cancel-reservation-btn');
        const reservationDetails = document.getElementById('reservation-details');

        reservationsSelect.addEventListener('change', (e) => {
            const selectedReservaId = parseInt(e.target.value);

            if (!selectedReservaId) {
                reservationInfo.style.display = 'none';
                cancelBtn.style.display = 'none';
                return;
            }

            // Encontrar la reserva seleccionada
            const reserva = usuario.reservas.find(r => r.id === selectedReservaId);

            if (reserva) {
                // Formatear fechas
                const salida = new Date(reserva.vuelo.salida);
                const destino = new Date(reserva.vuelo.destino);

                // Mostrar detalles
                reservationDetails.innerHTML = `
                    <p><strong>Número de Reserva:</strong> ${reserva.numeroReserva}</p>
                    <p><strong>Vuelo:</strong> ${reserva.vuelo.numeroVuelo}</p>
                    <p><strong>Salida:</strong> ${salida.toLocaleString('es-AR')}</p>
                    <p><strong>Llegada:</strong> ${destino.toLocaleString('es-AR')}</p>
                    ${reserva.vuelo.tarifas && reserva.vuelo.tarifas.length > 0 ? `
                        <p><strong>Clase:</strong> ${reserva.vuelo.tarifas[0].claseTarifa}</p>
                        <p><strong>Precio tarifa:</strong> $${reserva.vuelo.tarifas[0].precioTarifa}</p>
                        <p><strong>Impuestos:</strong> $${reserva.vuelo.tarifas[0].impuestoTarifa}</p>
                    ` : ''}
                    ${reserva.pago ? `
                        <p><strong>Total pagado:</strong> $${reserva.pago.cantidadPago}</p>
                        <p><strong>Número de pago:</strong> ${reserva.pago.numeroPago}</p>
                    ` : ''}
                `;

                reservationInfo.style.display = 'block';
                cancelBtn.style.display = 'block';

                // Guardar ID de reserva en el botón para uso posterior
                cancelBtn.dataset.reservaId = reserva.id;
            }
        });

        // Agregar funcionalidad al botón de cancelar (opcional)
        cancelBtn.addEventListener('click', async () => {
            const reservaId = cancelBtn.dataset.reservaId;

            if (confirm('¿Estás seguro de que deseas cancelar esta reserva?')) {
                try {
                    // Aquí iría la lógica para cancelar la reserva
                    // const response = await fetch(`http://localhost:9000/reservas/${reservaId}`, {
                    //     method: 'DELETE'
                    // });

                    alert('Funcionalidad de cancelación no implementada aún');
                    // Recargar las reservas
                    // loadReservations();
                } catch (error) {
                    console.error('Error al cancelar reserva:', error);
                    alert('Error al cancelar la reserva');
                }
            }
        });

    } catch (error) {
        console.error('Error al cargar reservas:', error);
        reservationsList.innerHTML = `<p style="color: red;">Error al cargar reservas: ${error.message}</p>`;
    }
}