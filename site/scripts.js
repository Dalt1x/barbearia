function openBooking() {
    document.getElementById('tela').style.display = 'flex';
}

function closetela() {
    document.getElementById('tela').style.display = 'none';
}

function toggleDarkMode() {
    document.body.classList.toggle('dark-mode');

    const btn = document.querySelector('.dark-mode-toggle');
    if (document.body.classList.contains('dark-mode')) {
        btn.textContent = '☀️ Modo Claro';
    } else {
        btn.textContent = '🌙 Modo Escuro';
    }
}

document.getElementById('bookingForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const formData = new FormData();
    formData.append('servico', document.getElementById('service').value);
    formData.append('data', document.getElementById('date').value);
    formData.append('horario', document.getElementById('time').value);
    formData.append('nome', document.getElementById('name').value);
    formData.append('telefone', document.getElementById('phone').value);

    fetch('agendar.php', {
        method: 'POST',
        body: formData
    })
    .then(response => response.text())
    .then(responseText => {
        console.log(responseText);
        alert(responseText);
        document.getElementById('tela').style.display = 'none';
    })
    .catch(error => {
        console.error("Erro ao agendar:", error);
    });
});