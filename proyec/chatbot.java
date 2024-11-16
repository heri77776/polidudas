

        const chatbox = document.getElementById('chatbox');
        const userInput = document.getElementById('user-input');

        function sendMessage() {
            const message = userInput.value.trim();
            if (message) {
                appendMessage(message, 'user-message');
                userInput.value = '';
                const response = getBotResponse(message);
                setTimeout(() => {
                    appendMessage(response, 'bot-message');
                    chatbox.scrollTop = chatbox.scrollHeight;
                }, 500);
            }
        }

        function appendMessage(message, className) {
            const div = document.createElement('div');
            div.textContent = message;
            div.className = `message ${className}`;
            chatbox.appendChild(div);
        }

        function setUserInput(value) {
            userInput.value = value;
            userInput.focus();
        }

        const responses = {
            'como tramitar el certificado de egresado': 'Debes ingresar a la página de la Escuela Politécnica de Guadalajara con el siguiente link: http://politecnica.sems.udg.mx\nDa click en “Servicios” y luego en “Formatos Aranceles”. Descarga “Certificado Total 2024”, imprímelo, y llénalo con tus datos. Paga en el banco y conserva el comprobante. Entrega el formato, comprobante y 2 fotos en ventanilla de control escolar. El trámite tarda unos 90 días hábiles.',
            'informacion de los tramites para las practicas profesionales': 'Las prácticas profesionales requieren 200-240 horas. Para comenzar: selecciona una empresa, recibe tu carta de asignación, y realiza las actividades en Moodle hasta finalizar las horas. Solicita la carta de término y evalúa tu desempeño.',
            'como iniciar el tramite para mis practicas profesionales': 'Define la empresa para tus prácticas, entrega tu hoja de datos y espera autorización. Lleva tu carta de asignación a la empresa y carga la información en Moodle hasta completar tus actividades.',
            'como tramitar una beca': 'La Escuela Politécnica cuenta con varias becas para estudiantes. Puedes solicitar la Beca Benito Juárez y becas para estudiantes con discapacidad o buen desempeño.',
            'como tramitar el seguro social por parte de la escuela': 'Envía tus datos al correo imssudg@redudg.udg.mx. Revisa tu vigencia en la app IMSS Digital y elige tu unidad de medicina familiar.',
            'como tramitar mi constancia de estudios': 'Descarga el formato adecuado, llénalo, realiza el pago, y entrega la documentación en control escolar. El trámite se completa en 24 horas.',
            'donde obtener las hojas para las horas del servicio social': 'Obtén el formato de servicio social en http://politecnica.sems.udg.mx/servicio-social-0.',
            'como tramitar el duplicado de credencial': 'Para duplicado, genera tu UUID, realiza una denuncia en línea y solicita el duplicado en SIIAU después de 15 días. Consulta el estatus hasta su entrega.'
        };

        function getBotResponse(message) {
            message = message.toLowerCase();
            return responses[message] || 'Lo siento, no entiendo esa pregunta. ¿Podrías reformularla?';
        }
 